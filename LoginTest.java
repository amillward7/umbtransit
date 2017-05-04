package sevendwarves;
//dominic
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LoginTest extends JFrame {

public static void main(String[] args) {

 
LoginTest frame = new LoginTest();
}



//instantiation
JLabel userLabel = new JLabel("Username:");
JLabel passLabel = new JLabel("Password:");
JLabel firstLabel = new JLabel("First Name:");
JLabel lastLabel = new JLabel("Last Name:");
JLabel title = new JLabel("<html><font color = white><font size = 5>  &nbsp; &nbsp;       Login Page</font>");
JLabel banner1 = new JLabel("<html><font color = white> &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;  &nbsp; &nbsp;   <b>  UMass Boston</font>");
 Font font = new Font("franklin gothic book", Font.BOLD, 12);
 Font font2 = new Font("franklin gothic book", Font.BOLD, 24);
JTextField user = new JTextField(15);
JPasswordField pass = new JPasswordField(15); //password field creates asterisks
JTextField firstName = new JTextField(15);
JTextField lastName = new JTextField(15);

JButton submit = new JButton("Login");
JButton register= new JButton("Register");
JButton back = new JButton("Back");
JButton forgot = new JButton("Forgot PW");

JPanel panel = new JPanel();
//GridBagConstraints c = new GridBagConstraints();

LoginTest(){
super("Registration Page");

      
 
//Frame size and title 

setSize(400,550);
setLocation(500,175);
 
      setUndecorated(true);
      getRootPane().setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.BLACK));
      panel.setLayout (null); 
  panel.setBackground(UI.WARM_GRAY);
 
//sets coordinate positions of text and text boxes
//(x,y,x1,y1) x,y= position x1,y1=size
//text box positios
// addComponentsToPane(panel,userLabel);  
      
user.setBounds(175,160,150,20);
pass.setBounds(175,195,150,20);
firstName.setBounds(175,235,150,20);
lastName.setBounds(175,270,150,20);

//button positions
submit.setBounds(250,230,80,20);
back.setBounds(160,230,80,20);
forgot.setBounds(160,290,130,20);
register.setBounds(160,260,130,20);
//text positio4
userLabel.setBounds(30,160,80,20);
passLabel.setBounds(30,195,80,20);
firstLabel.setBounds(30,235,80,20);
lastLabel.setBounds(30,270,80,20);
title.setBounds (110,80,250,40);
banner1.setBounds(0,0,650,40);
banner1.setOpaque(true);

banner1.setBackground(UI.BLUE);
banner1.setFont(font2);
title.setBackground(new Color(180,118,112));

//banner.setBounds(0,0,80,20);
//add "parts" to the window
panel.add(submit);   //add the "submit" button
panel.add(back);
panel.add(forgot);
panel.add(register);

//text boxes
panel.add(user);   //add the username text box
panel.add(pass);     //add password text box
//panel.add(firstName); //add first name text box
//panel.add(lastName);  //add last name text box

//labels
panel.add(userLabel);   //add "Username" label
panel.add(passLabel);   //add "Password" label
//panel.add(firstLabel);   //add "First Name" label
//panel.add(lastLabel);   //add "Last Name" label
panel.add(title);
panel.add(banner1);
//frame operations

getContentPane().add(panel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
actionlogin();


  back.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      button3ActionPerformed(  );
      }});   
   forgot.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      button4ActionPerformed(  );
      }}); 
   register.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      button5ActionPerformed(  );
      }}); 


}


private  void button5ActionPerformed() {
          RegisterPage h = new RegisterPage();
          //dummyFrame x = new dummyFrame(); 
          dispose(); 
      }
private  void button4ActionPerformed() {
          ResetPasswordFrame h = new ResetPasswordFrame();
          //dummyFrame x = new dummyFrame(); 
          dispose(); 
      }
  private  void button3ActionPerformed() {
          Phone h = new Phone();
          //dummyFrame x = new dummyFrame(); 
          dispose(); 
      }
  
public void actionlogin(){
  
submit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
String userEntry = user.getText();
ArrayList<String> userNames = new ArrayList<String>();//test username database
String testName = "test"; //test case for user name already in database
userNames.add(testName);
//String pw = pass.getText(); //supposed to use getPassword()?
                                //not sure how to implement this
if(!(userNames.contains(userEntry))) { //if user is in database
  
ParkingInfoPage successWindow = new ParkingInfoPage();
successWindow.setVisible(true);  //go to next frame
dispose();
} 

else {  //else, username taken and reset the form

JOptionPane.showMessageDialog(null,"Username Taken");

//clear all text boxes (reset the form)
user.setText("");  
pass.setText("");
firstName.setText("");
lastName.setText("");
//set cursor at Username
user.requestFocus(); 
}

}
});
}

}