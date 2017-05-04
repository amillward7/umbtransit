import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.mail.*;
import javax.mail.internet.*;

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
    setBackground(UI.WARM_GRAY);
    
    jLabel1 = new JLabel("Please enter the email address associated with your account, then press enter:");
    jLabel1.setForeground(UI.WHITE);
    jLabel1.setFont(UI.FG_TEXT);
    
    banner = new JLabel("UMass Boston", SwingConstants.CENTER);
    banner.setFont(UI.FG_BANNER);
    banner.setBackground(UI.BLUE);
    banner.setForeground(UI.WHITE);
    banner.setOpaque(true);
    
    //display waiting screen while sending email
    emailField = new JTextField(50);
    emailField.setFont(UI.FG_TEXT);
    emailField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String emailAddress = emailField.getText();
        remove(emailField);
        jLabel1.setText("Please wait.");
        repaint();
        
        
        
        //threading so that panel displays correctly while email is being sent
        new Thread(createRunnable(emailAddress)).start();
      }
    });
    
    //button to return to login page
    button = new JButton("Back");
    button.setBackground(UI.BLUE);
    button.setForeground(UI.WHITE);
    button.setFont(UI.FG_BUTTON);
    button.setOpaque(true);
    button.setContentAreaFilled(true);
    button.setBorderPainted(false);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        login.main(new String[0]);
        frame.dispose();
      }
    });
    
    
    
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
    button.setBackground(UI.BLUE);
    //button.setForeground(UI.WHITE);
    
    setBorder(BorderFactory.createMatteBorder(6,6,6,6, Color.BLACK));
  }
  
  private Runnable createRunnable(final String toAddress) {
    return new Runnable() {
      public void run() {
        // Try to send an email to the specified address; display a positive message for success and negative for failure.
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
  
  private void createAndShowGUI() {
    frame = new JFrame("Reset Password");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.add(this);
    
    frame.pack();
    frame.setBounds(300, 150, 450, 750);
    frame.setVisible(true);
  }
  
  private static class SMTPAuthenticator extends Authenticator {
    private PasswordAuthentication authentication;
    public SMTPAuthenticator(String login, String password) {
      authentication = new PasswordAuthentication(login, password);
    }
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
      return authentication;
    }
  }
  
  private static void sendResetEmailTo(String toAddress) throws MessagingException {
    String fromAddress = "umb.transit.app@gmail.com";
    Properties props = System.getProperties();
    props.setProperty("mail.host", "smtp.gmail.com");
    props.setProperty("mail.smtp.port", "587");
    props.setProperty("mail.smtp.auth", "true");
    props.setProperty("mail.smtp.starttls.enable", "true");
    
    Authenticator auth = new SMTPAuthenticator("umb.transit.app@gmail.com", "TheSevenDwarves");
    
    Session session = Session.getDefaultInstance(props, auth);
    
    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(fromAddress));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
      message.setSubject("Reset Password");
      message.setText("In a final version of the app, this email would contain a temporary password for you to use.");
      
      Transport.send(message);
    } catch(MessagingException mex) {
      mex.printStackTrace();
      throw(mex);
    }
  }
}