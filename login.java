//package parkinglots;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login {

 public static void main(String[] args) {
  final JFrame frame = new JFrame("Login");
  frame.setUndecorated(true);
  frame.getContentPane().setBackground(new Color(152,143,134));
  
  JLabel banner = new JLabel("<html><font color = white>UMass Boston</font>", SwingConstants.CENTER);
  banner.setOpaque(true);
  banner.setBackground(new Color(0,90,139));
  banner.setFont(new Font("Franklin gothic book heavy", Font.BOLD, 24)); 
  banner.setBounds(0, 0, 500, 32);
  
  frame.getRootPane().setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.BLACK));
  
  
  frame.setBounds(500, 100, 400, 550);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  

  
  frame.setLayout(new GridBagLayout());
  //Container co = frame.getContentPane();
  //co.setLayout(new GridBagLayout());
  GridBagConstraints c = new GridBagConstraints();
  c.weighty = 1;
  c.anchor = GridBagConstraints.NORTHWEST;
  
  
  final JLabel blankL = new JLabel("");
  final JLabel blankR = new JLabel("");
  final JLabel messageLabel = new JLabel();
  final JLabel usernameLabel = new JLabel("<html><div style='text-align: center;'><span style='font-size:16px'><font color = white>Username:  </font></span></div></html>");
  final JLabel passwordLabel = new JLabel("<html><div style='text-align: center;'><span style='font-size:16px'><font color = white>Password:  </font></span></div></html>");
  final JTextField usernameText = new JTextField(15);
  final JPasswordField passwordText = new JPasswordField(15);
  final JButton submit = new JButton("Log in");
  submit.setFont(new Font("franklin gothic book", Font.BOLD, 16));
  submit.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      String username = usernameText.getText();
      char[] pw = passwordText.getPassword();
      String password = String.valueOf(pw);
      usernameText.setText("");
      passwordText.setText("");
      messageLabel.setText("Please wait...");
      try {
        if(LoginHandler.checkLogin(username, password)) {
          new ParkingInfoPage();
          frame.dispose();
        } else {
          messageLabel.setText("Incorrect username and/or password.");
        }
      } catch(Exception exception) {
        
      }
    }
  });
  JButton register = new JButton("Register");
  register.setFont(new Font("franklin gothic book", Font.BOLD, 16));
  register.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      new RegisterPage();
      frame.dispose();
    }
  });
  JButton forgetpw = new JButton("Forget Password");
  forgetpw.setFont(new Font("franklin gothic book", Font.BOLD, 16));
  forgetpw.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      new ResetPasswordFrame();
      frame.dispose();
    }
  });
  
  JButton close = new JButton("Close");
  close.setFont(new Font("franklin gothic book", Font.BOLD, 16));
  close.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      System.exit(0);
    }
  });
  
  //banner
  c.fill = GridBagConstraints.BOTH;
  c.ipady = 30;
  c.weightx = 0.0;
  c.gridwidth = 5;
  c.gridx = 0;
  c.gridy = 0;
  c.anchor = GridBagConstraints.PAGE_START;
  frame.add(banner, c);
  
  //messageLabel
  c.fill = GridBagConstraints.HORIZONTAL;
  c.ipady = 20;
  c.weightx = 0.0;
  c.gridwidth = 4;
  c.gridx = 1;
  c.gridy = 2;
  c.insets = new Insets(10,0,0,0);  
  frame.add(messageLabel, c);
  
  //usernameLabel
  c.fill = GridBagConstraints.HORIZONTAL;
  c.ipady = 15;
  c.weightx = 0.5;
  c.gridwidth = 1;
  c.gridx = 1;
  c.gridy = 3;
  c.insets = new Insets(10,0,0,0);  
  frame.add(usernameLabel, c);
  
  //usernameText
  c.fill = GridBagConstraints.HORIZONTAL;
  c.ipady = 20;
  c.weightx = 0.5;
  c.gridwidth = 1;
  c.gridx = 2;
  c.gridy = 3;
  c.insets = new Insets(10,0,0,0);  
  frame.add(usernameText, c);
  
  //passwordLabel
  c.fill = GridBagConstraints.HORIZONTAL;
  c.ipady = 15;
  c.weightx = 0.5;
  c.gridwidth = 1;
  c.gridx = 1;
  c.gridy = 4;
  c.insets = new Insets(10,0,0,0);  
  frame.add(passwordLabel, c);
  
  //passwordText
  c.fill = GridBagConstraints.HORIZONTAL;
  c.ipady = 20;
  c.weightx = 0.5;
  c.gridwidth = 1;
  c.gridx = 2;
  c.gridy = 4;
  c.insets = new Insets(10,0,0,0);  
  frame.add(passwordText, c);
  
  //submit
  c.fill = GridBagConstraints.HORIZONTAL;
  c.ipady = 0;
  c.weightx = 0.0;
  c.gridwidth = 2;
  c.gridx = 1;
  c.gridy = 6;
  c.insets = new Insets(10,0,0,0);  
  frame.add(submit, c);
  
  //register
  c.fill = GridBagConstraints.HORIZONTAL;
  c.ipady = 0;
  c.weightx = 0.0;
  c.gridwidth = 2;
  c.gridx = 1;
  c.gridy = 7;
  c.insets = new Insets(10,0,0,0);  
  frame.add(register, c);
  
  //forgetpw
  c.fill = GridBagConstraints.HORIZONTAL;
  c.ipady = 0;
  c.weightx = 0.0;
  c.gridwidth = 2;
  c.gridx = 1;
  c.gridy = 8;
  c.insets = new Insets(10,0,0,0);  
  frame.add(forgetpw, c);
  
  //close
  c.fill = GridBagConstraints.HORIZONTAL;
  c.ipady = 0;
  c.weightx = 0.0;
  c.gridwidth = 2;
  c.gridx = 1;
  c.gridy = 9;
  c.insets = new Insets(10,0,0,0);  
  frame.add(close, c);
  
  //blankL
  c.fill = GridBagConstraints.HORIZONTAL;
  c.ipady = 20;
  c.weightx = 0.5;
  c.gridwidth = 1;
  c.gridx = 0;
  c.gridy = 3;
  c.insets = new Insets(10,0,0,0);  
  frame.add(blankL, c);
  
  //blankR
  c.fill = GridBagConstraints.HORIZONTAL;
  c.ipady = 20;
  c.weightx = 0.5;
  c.gridwidth = 1;
  c.gridx = 3;
  c.gridy = 3;
  c.insets = new Insets(10,0,0,0);  
  frame.add(blankR, c);
  
  //add(frame, banner, c, 0, 0, 2, 1);
  //add(frame, messageLabel, c, 0, 0, 4, 2);
  //add(frame, usernameLabel, c, 0, 2, 1, 1);
  //add(frame, passwordLabel, c, 0, 4, 1, 1);
  //add(frame, usernameText, c, 2, 2, 1, 1);
  //add(frame, passwordText, c, 2, 4, 1, 1);
  //add(frame, submit, c, 0, 6, 1, 1);
  //add(frame, forgetpw, c, 2, 6, 1, 1);
  //add(frame, register, c, 0, 8, 1, 1);
  
        frame.setVisible(true);
 }
 /*
 public static void add(JFrame frame, Component label, GridBagConstraints c, int x, int y, int w, int h){
  c.gridx = x;
  c.gridy = y;
  c.gridwidth = w;
  c.gridheight = h;
  //c.weightx = wx;
  //c.weighty = wy;
  frame.add(label, c);
 }
*/
}
