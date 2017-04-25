import javax.swing.*;
import java.awt.*;

class ShuttleInfo { 
  
  public static void main(String[] args) {

    JFrame frame = new JFrame("Shuttle Info");
     ImageIcon icon=new ImageIcon("umass_logo_white_200px.jpg");
     ImageIcon icon1=new ImageIcon("map2.jpg");
     JLabel label = new JLabel("Route Map:");
     JLabel label2 = new JLabel(icon1);
     JLabel label3 = new JLabel("Schedule:");
     JLabel label4 = new JLabel("<html>Monday-Thursday<br>1-6.30 am-9.30 pm (every 5-7 minutes)<br><html> &nbsp;&nbsp;&nbsp;&nbsp;9:30-10:30pm (every10-12 minutes) <br>2-8:00am - 5:45pm (every10-12minutes)&nbsp;&nbsp;&nbsp;&nbsp;<br>3-6:30am - 10:30pm (every 5-7minutes)<br></html>");
     JLabel label5 = new JLabel("<html>Friday<br>1-6:30am-6:40pm (every 5-7 minutes)<br><html> &nbsp;&nbsp;&nbsp;&nbsp;6:40-10:00pm (every10-12 minutes) <br>2-8:00am - 5:45pm (every10-12minutes)&nbsp;&nbsp;&nbsp;&nbsp;<br>3-6:30am - 10:30pm (every 5-7minutes)<br></html>");
     JLabel label6 =  new JLabel("<html>Weekends<br>Saturday:7:30am-7:00pm<br><html> &nbsp;&nbsp;&nbsp;&nbsp;Sunday:8:00am-5:45pm (every 20 minutes)");
     JButton back = new JButton();
     back.setText("Back");
     back.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(java.awt.event.ActionEvent evt) {
     button1ActionPerformed(frame  );
     
      }});   
   
   frame.add(back);
   back.setBounds(280,40,80,20);
     //   frame = new JFrame();
        frame.setBounds(500,100,400,630);
        frame.setTitle("Shuttle Schedule");
  
  ImageIcon icon2=new ImageIcon("umass_logo_white_200px.png");
  
  frame.setIconImage(icon2.getImage());
  Container c=frame.getContentPane();
  c.setLayout(null);
        

        label.setText("Route Map:");
        label.setBounds(10,50,200,30);
        Font f=new Font("Arial",Font.BOLD,30);
        label.setFont(f);
        

        label2.setBounds(10,0,350,400);
        

        label3.setText("Schedule:");
        label3.setBounds(10,300,200,30);
        Font f1=new Font("Arial",Font.BOLD,30);
        label3.setFont(f1);
        

        label4.setBounds(10,245,500,250);
        label5.setBounds(10,340,500,250);
        label6.setBounds(10,415,500,250);
        

        frame.setDefaultLookAndFeelDecorated(true);
        frame.setVisible(true);
      //  frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        additems(frame,label,label2,label3,label4,label5,label6);
    }
    
    public static void additems(JFrame frame, JLabel label,JLabel label2,JLabel label3, JLabel label4, JLabel label5,JLabel label6){
        Container c=frame.getContentPane();
        c.setLayout(null);
        c.add(label);
        c.add(label2);
        c.add(label3);
        c.add(label4);
  c.add(label5);
  c.add(label6);
    }
    
   private  static void button1ActionPerformed(JFrame frame) {
          ParkingInfoPage k = new ParkingInfoPage();
          //dummyFrame x = new dummyFrame(); 
          frame.dispose(); 
      }  
     
}



/*
class MainClass{
public static void main(String[] args){ 
    ShuttleInfo obj = new ShuttleInfo();
    obj.additems();

    } */   
