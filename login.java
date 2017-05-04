package sevendwarves;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login {

 public static void main(String[] args) {
    JLabel banner = new JLabel("<html><font color = white>UMass Boston</font>");
  final JFrame frame = new JFrame("Login");
  JLabel extra = new JLabel();
  frame.getRootPane().setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.BLACK));
  frame.setUndecorated(true);
  frame.getContentPane().setBackground(UI.WARM_GRAY);
  frame.setBounds(500, 170, 450, 550);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
 // banner.setBounds(0,0,400,40);
  frame.getContentPane().setLayout(new GridBagLayout());
  GridBagConstraints c = new GridBagConstraints();
 
  
  JLabel usernameLabel = new JLabel("<html>Username:  <br></html>");
  JLabel passwordLabel = new JLabel("<html>Password:  <br></html>");
  JTextField usernameText = new JTextField(15);
  JTextField passwordText = new JTextField(15);
  JButton submit = new JButton("Log in");
  submit.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      new ParkingInfoPage();
      frame.dispose();
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
   c.anchor=GridBagConstraints.CENTER;
   //c.insets = new Insets(0,0,0,0) ;
  banner.setOpaque(true);
 banner.setBackground(UI.BLUE);
 banner.setForeground(UI.WHITE);
   add(frame, banner,c,0,1,4,1);
    c.anchor = GridBagConstraints.WEST;
    frame.add( new JLabel(""),c);
  add(frame, usernameLabel, c, 0, 0, 1, 1);//(0,2,1,1)
  add(frame, passwordLabel, c, 0, 9, 1, 1);
  add(frame, usernameText, c, 1, 8, 1, 1);
  add(frame, passwordText, c, 1, 9, 1, 1);
  add(frame, submit, c, 1, 10, 1, 1);
  add(frame, forgetpw, c, 1, 11, 1, 1);
  add(frame, register, c, 0, 12, 1, 1);
  c.weightx=1;
  c.weighty = 1;
  frame.add(new JLabel(""),c);
//
 //banner.setSize(40,40);
  
 // add(frame,banner,c,2,8,1,1);
        frame.setVisible(true);
 }

 public static void add(JFrame frame, Component label, GridBagConstraints c, int x, int y, int w, int h){
  c.gridx = x;
  c.gridy = y;
  c.weighty = 0.5;
  c.weightx = 0.7;
  c.gridwidth = w;
  c.gridheight = h;
  frame.add(label, c);
 }
}