package sevendwarves;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.lang.Object;
public class Phone extends JFrame {

public static void main(String[] args) {

 
Phone frame = new Phone();

}



JPanel panel = new JPanel();
JLabel label = new JLabel();///
JButton app = new JButton();
 ImageIcon img4 = new ImageIcon("umassIcon.png"); 
        



Phone(){
super("Phone");

      
 
//Frame size and title 

setSize(400,550);
setLocation(500,175);
 
      setUndecorated(true);///get rid of top buttons
      getRootPane().setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.BLACK));//make nice border
      //ImageIcon u =  createImageIcon("IMG_1613.PNG","");
        ImageIcon stars = new ImageIcon("IMG_1613.PNG"); //vreate background icon
         ImageIcon logo = new ImageIcon("umassIcon.png"); //vreate background icon
      //  setIcon(img4);}
    //  label.setIcon( Toolkit.getDefaultToolkit().getImage("IMG_1613.PNG"));   
    //  label.setIcon(background2);///
    ///  label.setLayout(new BorderLayout());///
      //setContentPane(label);///
  //    panel.setLayout (null); 
    //  Image background = Toolkit.getDefaultToolkit().createImage("umassIcon.png");//create button icon    
     panel.setBackground(new Color(0,0,45));
 

      
//app.setOpaque(true);
app.setBounds(25,30,60,60);//set positio for button
app.setIcon(logo);//set image on button

//set starry image to label
label.setIcon(stars);
//set button on label
  label.add(app);
//set label to pane
  panel.add(label);
  
//set pane to frame
getContentPane().add(panel);//add panel to frame


//panel.add(app);//add button to panel

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

//text boxes


  app.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      button3ActionPerformed(  );
      }});   


}
  private  void button3ActionPerformed() {
          LoginTest h = new LoginTest();
      
          dispose(); 
      }
  




}



