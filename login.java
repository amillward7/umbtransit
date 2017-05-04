//package parkinglots;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class login extends JFrame {
  /*private JLabel messageLabel;
  private JLabel usernameLabel;
  private JLabel passwordLabel;
  private JLabel logo;
  private TextField usernameText;
  private TextField passwordText;
  private JButton submit;
  private JPanel logoPanel;
  private JPanel buttonPanel;
  private JPanel textPanel;
  private JPanel messagePanel;
  private JFrame frame;*/

 public static void main(String[] args) {
  JFrame frame = new JFrame("Login");
  frame.setBounds(300, 150, 450, 750);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setPreferredSize(new Dimension(400, 500));
  
  //frame.setLayout(new GridBagLayout());
  frame.setLocationRelativeTo(null);
  Container co = frame.getContentPane();
  co.setLayout(new GridBagLayout());
  GridBagConstraints c = new GridBagConstraints();
  c.anchor = GridBagConstraints.CENTER;
  
  JLabel messageLabel = new JLabel();
  JLabel usernameLabel = new JLabel("<html>Username:  <br></html>");
  JLabel passwordLabel = new JLabel("<html>Password:  <br></html>");
  JTextField usernameText = new JTextField(20);
  JTextField passwordText = new JTextField(20);
  JButton submit = new JButton("Log in");
  submit.setPreferredSize(new Dimension(30, 30));

  JPanel messagePanel = new JPanel(new BorderLayout());
  messagePanel.add(messageLabel);

  JPanel usernamePanel = new JPanel(new FlowLayout());
  usernamePanel.add(usernameLabel);
  usernamePanel.add(usernameText);
  JPanel passwordPanel = new JPanel(new FlowLayout());
  passwordPanel.add(passwordLabel);
  passwordPanel.add(passwordText);
  JPanel textPanel = new JPanel();
  textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
  textPanel.add(usernamePanel);
  textPanel.add(passwordPanel);

  JPanel logoPanel = new JPanel();
  JLabel logo = new JLabel("UMBTRANSIT", JLabel.CENTER);
  logo.setFont(new Font("Franklin gothic book heavy", Font.BOLD, 24));
  logo.setForeground(Color.WHITE);
  logoPanel.add(logo);
  logoPanel.setBackground(new Color(0, 90, 139));
  logoPanel.setPreferredSize(new Dimension(100, 15));

  submit.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      String username = usernameText.getText();
      String password = passwordText.getText();
      usernameText.setText("");
      passwordText.setText("");
      messageLabel.setText("Please wait...");
      try {
        if(LoginHandler.checkLogin(username, password)) {
          ParkingInfoPage p = new ParkingInfoPage();
          frame.dispose();
        } else {
          messageLabel.setText("Incorrect username and/or password.");
        }
      } catch(Exception exception) {
        
      }
    }
  });
  JButton register = new JButton("Register");
  register.setPreferredSize(new Dimension(30, 30));
  register.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      new RegisterPage();
      frame.dispose();
    }
  });
  JButton forgetpw = new JButton("Forget Password");
  forgetpw.setPreferredSize(new Dimension(30, 30));
  forgetpw.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      new ResetPasswordFrame();
      frame.dispose();
    }
  });


  //GridBagConstraints c = new
  c.gridx = 0;
  c.gridy = 0;
  //c.weightx = 0.0;
  c.weighty = 0.1;
  c.anchor = GridBagConstraints.CENTER;
  c.fill = GridBagConstraints.BOTH;

  JPanel buttonPanel = new JPanel(new GridBagLayout());
  buttonPanel.add(submit, c);
  c.gridx = 1;
  buttonPanel.add(register, c);
  c.gridx = 2;
  buttonPanel.add(forgetpw, c);
  c.gridx = 0;

  co.add(logoPanel, c);
  c.gridy = 1;
  c.weightx = 0.2;
  c.weighty = 0.2;
  //c.gridheight = 2;
  co.add(messagePanel, c);
  c.gridy = 2;
  co.add(textPanel, c);
  c.gridy = 3;
  c.weightx = 0.2;
  c.weighty = 0.0;
  co.add(buttonPanel, c);
  frame.pack();
  //frame.setVisible(true);




  /*add(frame, logoPanel, c, 0, 0, 0, 0);
  add(frame, messageLabel, c, 0, 1, 4, 2);
  add(frame, usernameLabel, c, 0, 2, 1, 1);
  add(frame, passwordLabel, c, 0, 4, 1, 1);
  add(frame, usernameText, c, 2, 2, 1, 1);
  add(frame, passwordText, c, 2, 4, 1, 1);
  add(frame, submit, c, 0, 6, 1, 1);
  add(frame, forgetpw, c, 2, 6, 1, 1);
  add(frame, register, c, 0, 8, 1, 1);*/
  
        frame.setVisible(true);
 }
 
 public static void add(JFrame frame, Component label, GridBagConstraints c, int x, int y, int w, int h){
  c.gridx = x;
  c.gridy = y;
  c.weightx = 0.1;
  c.weighty = 0.1;
  frame.add(label, c);
 }

}