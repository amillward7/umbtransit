//Mark
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.time.*;
import java.time.temporal.*;
import java.lang.Math;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.applet.Applet;
import java.awt.geom.Rectangle2D;
import javax.swing.BorderFactory;
public class ParkingInfoPage extends JFrame {
  
   final static int MAX_CAPACITY_A = 1000;
   final static int MAX_CAPACITY_B = 800;
   final static int MAX_CAPACITY_C = 500;
   final static int MAX_CAPACITY_D = 200;
      
   static int spacesAvailableLotA = MAX_CAPACITY_A - (int)parkingLotA(time());
   static int spacesAvailableLotB = MAX_CAPACITY_B - (int)(parkingLotB(time()));
   static int spacesAvailableLotC = MAX_CAPACITY_C - (int)(parkingLotC(time()));
   static int spacesAvailableLotD = MAX_CAPACITY_D - (int)(parkingLotD(time()));
       
   public ParkingInfoPage () {
      
      createAndShowGUI();
   }
   
   public void createAndShowGUI() {
       
      JPanel panel = new JPanel();   
      Font font = new Font("franklin gothic book", Font.BOLD, 12);
      JLabel banner = new JLabel("<html><font color = white>UMass Boston</font>", SwingConstants.CENTER);
       
      setUndecorated(true);
      getRootPane().setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.BLACK));
      font(banner, font); 
    
      setSize(400,550);
      setLocation(500,175);
      panel.setLayout(null); 
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      panel.setBackground(new Color(167,158,112));
    
      JButton a = new JButton();
      JButton b = new JButton();
      JButton c = new JButton();
      JButton d = new JButton(); 
      JButton e = new JButton();
      JButton back = new JButton();
       
      setbutton(a,"<html><center>"+ "Lot A" +"<br/>"+ spacesAvailableLotA + " Spaces available",spacesAvailableLotA, MAX_CAPACITY_A);
      setbutton(b,"<html><center>"+ "Lot B" +"<br/>"+ spacesAvailableLotB + " Spaces available",spacesAvailableLotB, MAX_CAPACITY_B); 
      setbutton(c,"<html><center>"+ "Lot C" +"<br/>"+ spacesAvailableLotC + " Spaces available",spacesAvailableLotC, MAX_CAPACITY_C); 
      setbutton(d,"<html><center>"+ "Lot D" +"<br/>"+ spacesAvailableLotD + " Spaces available",spacesAvailableLotD, MAX_CAPACITY_D); 
       a.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      buttonLotAActionPerformed(  );
      }});   
         b.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      buttonLotBActionPerformed(  );
      }}); 
          c.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      buttonLotCActionPerformed(  );
      }});  
          d.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      buttonLotDActionPerformed(  );
      }});     
       e.setText("Shutle bus Info");
       back.setText("Log Out");
        e.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      button2ActionPerformed(  );
      }});  
        back.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      button3ActionPerformed(  );
      }});   
      positionLabel(banner, panel);
      addComponentsToPane(panel,a);  
      addComponentsToPane(panel,b); 
      addComponentsToPane(panel,c); 
      addComponentsToPane(panel,d); 
      addComponentsToPane(panel,e);
      addComponentsToPane(panel,back);
      
      banner.setOpaque(true);
      banner.setBackground(new Color(0,90,139));
   
      getContentPane().add(panel);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      setVisible(true); 
   }  
        
   public static void main(String[] args) {
       
        new  ParkingInfoPage ();
     }
     private  void setbutton( JButton a,String s,int p, final int q){
      Font font = new Font("franklin gothic book", Font.BOLD, 12);
      a.setFocusPainted(false);
      a.setForeground(new Color(0,90,139));
      a.setText(s);
      a.setFont(font);
      a.setBackground(Color.WHITE);
      a.setBorderPainted(false); 
      setParkingIcon(a,p,q);
 
    
     } 
    private static void setParkingIcon(JButton b,double x,final int y){
        
     if(x ==  y){
        ImageIcon img4 = new ImageIcon("100%.png"); 
        b.setIcon(img4);}
     if(x  > (.875)*y && x < y){
        ImageIcon img4 = new ImageIcon("90%.png"); 
        b.setIcon(img4);}
     if(x  > (.625)*y && x <= (.875)*y){
        ImageIcon img4 = new ImageIcon("75%.png"); 
        b.setIcon(img4);}
     if(x >(.375)* y && x <= (.625)*y){
        ImageIcon img4 = new ImageIcon("50%.png"); 
        b.setIcon(img4);}
     if(x > (.125)*y && x <= (.375)*y){
        ImageIcon img4 = new ImageIcon("25%.png"); 
        b.setIcon(img4);}
     if(x > 0 && x <= (.125)*y){
        ImageIcon img4 = new ImageIcon("10%.png");       
        b.setIcon(img4);}
     if(x ==  0){
        ImageIcon img4 = new ImageIcon("0%.png"); 
        b.setIcon(img4); }
     }
      private static void positionLabel(JLabel  label, Container container) {
        
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(label);
      }
         
      private static void centerButton(JButton button, Container container) {
     
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        container.add(Box.createRigidArea(new Dimension(5,30)));
        container.add(button);
      }
     
     
       private static void addComponentsToPane(Container pane, JButton a) {
     
          pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
          centerButton(a, pane);     
      }    
      public  void font(JLabel banner, Font f){
          
          banner.setFont(new Font("Franklin gothic book heavy", Font.BOLD, 24));
      }   
      private  void buttonLotAActionPerformed() {
           new infoFrame();
          //dummyFrame x = new dummyFrame(); 
          dispose(); 
      }
       private  void buttonLotBActionPerformed() {
           new infoFrame2();
          //dummyFrame x = new dummyFrame(); 
          dispose(); 
      }
       private  void buttonLotCActionPerformed() {
           new infoFrame3();
          //dummyFrame x = new dummyFrame(); 
          dispose(); 
      }
        private  void buttonLotDActionPerformed() {
           new infoFrame4();
          //dummyFrame x = new dummyFrame(); 
          dispose(); 
      }
   private  void button2ActionPerformed() {
         ShuttleInfo.main(new String[0]);//.main(new String[0]);
          dispose(); 
      } 
   private  void button3ActionPerformed() {
          login.main(new String[0]);
          //dummyFrame x = new dummyFrame(); 
          dispose(); 
      }
  static double time(){
      LocalDateTime now = LocalDateTime.now();
      double hour = now.get(ChronoField.HOUR_OF_DAY);
      double minute = now.get(ChronoField.MINUTE_OF_DAY);
   
      return (hour +  (minute - hour*60)/60 ) ;
  }
  
     static double parkingLotA(double x){
  
    double a = 200*Math.pow(x-8, 2)/Math.pow(1 + Math.pow(.25*(x-8),3),2);
    double b = 100*Math.pow(x-16, 2)/Math.pow(1 + Math.pow(.29*(x-16),3),2);
             
    if(x<=17 && x>=8)
        return a;
    if(x > 17 && x < 22 )
        return b;
    if(x < 8 || x>22)
        return 35;
    return 0;
  }
    
    static double parkingLotB(double x){
  
    double a = 170*Math.pow(x-8, 2)/Math.pow(1 + Math.pow(.33*(x-8),3),2);
    double b = 40*Math.pow(x-16, 2)/Math.pow(1 + Math.pow(.29*(x-16),3),2);
             
    if(x<=17 && x>=8)
        return a;
    if(x > 17 && x < 22 )
        return b;
    if(x < 8 || x>22)
        return 35;
    return 0;
  } 
    
    static double parkingLotC(double x){
  
    double a = 60*Math.pow(x-8, 2)/Math.pow(1 + Math.pow(.33*(x-8),3),2);
    double b = 60*Math.pow(x-16, 2)/Math.pow(1 + Math.pow(.29*(x-16),3),2);
             
    if(x<=17 && x>=8)
        return a;
    if(x > 17 && x < 22 )
        return b;
    if(x < 8 || x>22)
        return 35;
    return 0;
  } 
    static double parkingLotD(double x){
  
       double a = 40*Math.pow(x-8, 2)/Math.pow(1 + Math.pow(.29*(x-8),2),1.5);
               
       if(x<=17 && x>=8)
          return a;
       if(x > 17 && x < 22 )
          return a;
       if(x < 8 || x>22)
          return 35;
       
        return 0;
    } 
  }
  

