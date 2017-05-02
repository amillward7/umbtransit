//package parkinglots;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login {

 public static void main(String[] args) {
  final JFrame frame = new JFrame("Login");
  frame.setUndecorated(true);
  frame.setSize(UI.SIZE);
  frame.setLocation(UI.LOCATION);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.getContentPane().setBackground(UI.WARM_GRAY);
  
  JLabel banner = new JLabel("UMass Boston", SwingConstants.CENTER);
  banner.setFont(UI.FG_BANNER);
  banner.setBackground(UI.BLUE);
  banner.setForeground(UI.WHITE);
  banner.setOpaque(true);
  
  frame.setLayout(new GridBagLayout());
  GridBagConstraints c = new GridBagConstraints();
  c.anchor = GridBagConstraints.LINE_START;
  
  final JLabel messageLabel = new JLabel();
  messageLabel.setForeground(UI.WHITE);
  messageLabel.setFont(UI.FG_TEXT);
  
  final JLabel usernameLabel = new JLabel("<html>Username:  <br></html>");
  usernameLabel.setForeground(UI.WHITE);
  usernameLabel.setFont(UI.FG_TEXT);
  
  final JLabel passwordLabel = new JLabel("<html>Password:  <br></html>");
  passwordLabel.setForeground(UI.WHITE);
  passwordLabel.setFont(UI.FG_TEXT);
  
  final JTextField usernameText = new JTextField(15);
  usernameText.setFont(UI.FG_TEXT);
  
  //convert this to password field
  final JTextField passwordText = new JTextField(15);
  
  final JButton submit = new JButton("Log in");
  submit.setBackground(UI.BLUE);
  submit.setForeground(UI.WHITE);
  submit.setFont(UI.FG_BUTTON);
  submit.setHorizontalAlignment(SwingConstants.CENTER);
  submit.setVerticalAlignment(SwingConstants.CENTER);
  submit.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      String username = usernameText.getText();
      String password = passwordText.getText();
      usernameText.setText("");
      passwordText.setText("");
      messageLabel.setText("Please wait...");
      try {
        if(LoginHandler.checkLogin(username, password)) {
          new ParkingInfoPage();
          frame.dispose();
        } else {
          messageLabel.setText("<html>Incorrect username and/or password.</html>");
        }
      } catch(Exception exception) {
        
      }
    }
  });
  
  JButton register = new JButton("Register");
  register.setBackground(UI.BLUE);
  register.setForeground(UI.WHITE);
  register.setFont(UI.FG_BUTTON);
  register.setHorizontalAlignment(SwingConstants.CENTER);
  register.setVerticalAlignment(SwingConstants.CENTER);
  register.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      new RegisterPage();
      frame.dispose();
    }
  });
  
  JButton forgetpw = new JButton("<html><center>Forgot Password</center></html>");
  forgetpw.setBackground(UI.BLUE);
  forgetpw.setForeground(UI.WHITE);
  forgetpw.setFont(UI.FG_BUTTON);
  forgetpw.setHorizontalAlignment(SwingConstants.CENTER);
  forgetpw.setVerticalAlignment(SwingConstants.CENTER);
  forgetpw.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      new ResetPasswordFrame();
      frame.dispose();
    }
  });
  
  c.anchor = GridBagConstraints.PAGE_START;
  c.fill = GridBagConstraints.HORIZONTAL;
  c.gridwidth = GridBagConstraints.REMAINDER;
  c.weightx = 0.1;
  c.weighty = 0.1;
  frame.add(banner, c);
  
  c.anchor = GridBagConstraints.PAGE_END;
  c.insets = new Insets(3,3,3,3);
  c.weighty = 1;
  frame.add(messageLabel, c);
  
  c.anchor = GridBagConstraints.CENTER;
  c.gridwidth = 1;
  c.weightx = 0;
  c.weighty = 0;
  frame.add(usernameLabel, c);
  c.gridwidth = GridBagConstraints.REMAINDER;
  frame.add(usernameText, c);
  c.gridwidth = 1;
  frame.add(passwordLabel, c);
  c.gridwidth = GridBagConstraints.REMAINDER;
  frame.add(passwordText, c);
  
  JPanel buttons = new JPanel(new GridBagLayout());
  buttons.setBackground(UI.WARM_GRAY);
  c.fill = GridBagConstraints.BOTH;
  c.gridwidth = 1;
  buttons.add(submit, c);
  buttons.add(forgetpw, c);
  buttons.add(register, c);
  
  c.anchor = GridBagConstraints.PAGE_START;
  c.fill = GridBagConstraints.NONE;
  c.gridheight = 2;
  c.gridwidth = 2;
  c.weighty = 1;
  /*frame.add(submit, c);
  frame.add(forgetpw, c);
  frame.add(register, c);*/
  frame.add(buttons, c);
  frame.setVisible(true);
 }
 
 public static void add(JFrame frame, Component label, GridBagConstraints c, int x, int y, int w, int h){
  c.gridx = x;
  c.gridy = y;
  c.gridwidth = w;
  c.gridheight = h;
  frame.add(label, c);
 }

}
