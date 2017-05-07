import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * In order for this document to compile properly, you must have Oracle's JavaMail package in your classpath.
 * This package can be found at <https://java.net/projects/javamail/pages/Home#Download_JavaMail_Release>.
 */
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ResetPassword extends JPanel {
  
  private JFrame frame;
  private JLabel jLabel1;
  private JLabel banner;
  private JTextField emailField;
  private GridBagConstraints c;
  private JButton button;
  
  public ResetPassword() { //if no JFrame is specified
    this(new JFrame());
  }
  
  public ResetPassword(JFrame f) { //preferred constructor
    super(new GridBagLayout());
    
    frame = f;
    
    jLabel1 = new JLabel("Please enter the email address associated with your account:");
    jLabel1.setForeground(UI.WHITE);
    jLabel1.setFont(UI.FG_TEXT);
    
    banner = new JLabel("UMass Boston", SwingConstants.CENTER);
    banner.setFont(UI.FG_BANNER);
    banner.setBackground(UI.BLUE);
    banner.setForeground(UI.WHITE);
    banner.setOpaque(true);
    
    //display waiting screen while sending email
    emailField = new JTextField(20);
    emailField.setFont(UI.FG_TEXT);
    emailField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        remove(emailField);
        jLabel1.setText("Please wait.");
        repaint();
        
        String emailAddress = emailField.getText();
        
        //threading so that waiting screen displays correctly while email is being sent
        new Thread(createRunnable(emailAddress)).start();
      }
    });
    
    //button to return to login page
    button = new JButton("Back");
    button.setBackground(UI.BLUE);
    button.setForeground(UI.WHITE);
    button.setFont(UI.FG_BUTTON);
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        login.main(new String[0]);
        frame.dispose();
      }
    });
    
    setBackground(UI.WARM_GRAY);
    
    c = new GridBagConstraints();
    
    c.anchor = GridBagConstraints.PAGE_START;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridwidth = GridBagConstraints.REMAINDER;
    c.weightx = 0.1;
    c.weighty = 0.1;
    add(banner, c);
    
    c.anchor = GridBagConstraints.PAGE_END;
    c.insets = new Insets(6,6,6,6);
    c.weighty = 1;
    add(jLabel1, c);
    
    c.anchor = GridBagConstraints.CENTER;
    c.weighty = 0;
    add(emailField, c);
    
    c.anchor = GridBagConstraints.PAGE_START;
    c.fill = GridBagConstraints.NONE;
    c.weighty = 1;
    add(button, c);
    
    setBorder(BorderFactory.createMatteBorder(6,6,6,6, UI.BLACK));
  }
  
  //this method allows the actual sending of the email to be threaded
  private Runnable createRunnable(final String toAddress) {
    return new Runnable() {
      public void run() {
        // Try to send an email to the specified address;
        // display a positive message for success and negative for failure.
        try {
          if(LoginHandler.isInDatabase(toAddress)) {
            sendResetEmailTo(toAddress);
            jLabel1.setText("<html>An email with a temporary password has been sent to \"" + toAddress + "\"</html>");
          } else {
            jLabel1.setText("<html>Sorry, there is no account under that email address.</html>");
          }
        } catch(IOException e) {
          jLabel1.setText("<html>Sorry, there was a problem accessing our database.</html>");
        } catch(MessagingException e) {
          jLabel1.setText("<html>Sorry, there was a problem sending an email to \"" + toAddress + "\".</html>");
        }
      }
    };
  }
  
  //this class allows emails to be sent through the umb.transit.app@gmail.com address
  private static class EmailAuthenticator extends Authenticator {
    private PasswordAuthentication authentication;
    public EmailAuthenticator(String login, String password) {
      authentication = new PasswordAuthentication(login, password);
    }
    protected PasswordAuthentication getPasswordAuthentication() {
      return authentication;
    }
  }
  
  private static void sendResetEmailTo(String toAddress) throws MessagingException {
    String fromAddress = "umb.transit.app@gmail.com";
    
    //SMTP properties for GMail
    Properties props = System.getProperties();
    props.setProperty("mail.host", "smtp.gmail.com");
    props.setProperty("mail.smtp.port", "587");
    props.setProperty("mail.smtp.auth", "true");
    props.setProperty("mail.smtp.starttls.enable", "true");
    
    Authenticator auth = new EmailAuthenticator("umb.transit.app@gmail.com", "TheSevenDwarves");
    
    Session session = Session.getDefaultInstance(props, auth);
    
    try {
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(fromAddress));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
      message.setSubject("Reset Password");
      message.setText("In a final version of the app, this email would contain a temporary password for you to use.");
      
      Transport.send(message);
    } catch(MessagingException mex) {
      throw(mex);
    }
  }
}
