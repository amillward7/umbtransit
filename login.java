//package parkinglots;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login {

 public static void main(String[] args) {
  final JFrame frame = new JFrame("Login");
  frame.setBounds(300, 150, 450, 750);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  frame.setLayout(new GridBagLayout());
  GridBagConstraints c = new GridBagConstraints();
  c.anchor = GridBagConstraints.WEST;
  
  final JLabel messageLabel = new JLabel();
  final JLabel usernameLabel = new JLabel("<html>Username:  <br></html>");
  final JLabel passwordLabel = new JLabel("<html>Password:  <br></html>");
  final JTextField usernameText = new JTextField(15);
  final JTextField passwordText = new JTextField(15);
  final JButton submit = new JButton("Log in");
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
          messageLabel.setText("Incorrect username and/or password.");
        }
      } catch(Exception exception) {
        
      }
    }
  });
  JButton register = new JButton("Register");
  register.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      new RegisterPage();
      frame.dispose();
    }
  });
  JButton forgetpw = new JButton("Forget Password");
  forgetpw.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      new ResetPasswordFrame();
      frame.dispose();
    }
  });
  add(frame, messageLabel, c, 0, 0, 4, 2);
  add(frame, usernameLabel, c, 0, 2, 1, 1);
  add(frame, passwordLabel, c, 0, 4, 1, 1);
  add(frame, usernameText, c, 2, 2, 1, 1);
  add(frame, passwordText, c, 2, 4, 1, 1);
  add(frame, submit, c, 0, 6, 1, 1);
  add(frame, forgetpw, c, 2, 6, 1, 1);
  add(frame, register, c, 0, 8, 1, 1);
  
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
