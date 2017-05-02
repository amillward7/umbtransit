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
       
 
    public ParkingInfoPage ()
    {
        createAndShowGUI();
    }
   
     public void createAndShowGUI() {
       
      JPanel panel = new JPanel();   
      Font font = new Font("franklin gothic book", Font.BOLD, 12);
      JLabel banner = new JLabel("<html><font color = white>UMass Boston</font>", SwingConstants.CENTER);
       
      setUndecorated(true);
      getRootPane().setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.BLACK));
      font(banner, font); 
    
      setSize(250,400);
      setLocation(500,280);
      //setVisible(true);
      panel.setLayout(null); 
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      //setTitle("UMass Parking app");
      //setIconImage(new ImageIcon("unnamed.png").getImage()); 
    //  setUndecorated(true);
      panel.setBackground(new Color(167,158,112));
      //buttons
      
      JButton a = new JButton();
      a.setFocusPainted(false);
      a.setForeground(new Color(0,90,139));
      a.setText("<html><center>"+ "Lot A" +"<br/>"+ spacesAvailableLotA + " Spaces available");
      a.setFont(font);
      a.setBackground(Color.WHITE);
      a.setBorderPainted(false);
       setParkingIcon(a,spacesAvailableLotA ,MAX_CAPACITY_A);
 
      a.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      button1ActionPerformed(  );
      }}); 
      
      JButton b = new JButton();
      b.setForeground(new Color(0,90,139));
      b.setText("<html><center>"+ "Lot B" +"<br/>"+ spacesAvailableLotB + " Spaces available");
      b.setFont(font);    
      b.setBackground(Color.WHITE);
      b.setBorderPainted(false);
   setParkingIcon(b,spacesAvailableLotB ,MAX_CAPACITY_B);
 
      b.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      button1ActionPerformed(  );
      }}); 
      
      JButton c = new JButton();
      c.setForeground(new Color(0,90,139));
      c.setText("<html><center>"+ "Lot C" +"<br/>"+ spacesAvailableLotC + " Spaces available");
      c.setFont(font);
      c.setBackground(Color.WHITE);
      c.setBorderPainted(false);
       setParkingIcon(c,spacesAvailableLotC ,MAX_CAPACITY_C);
     
      c.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      button1ActionPerformed(  );
      }}); 
      
      JButton d = new JButton();
      d.setForeground(new Color(0,90,139));
      d.setText("<html><center>"+ "Lot D" +"<br/>"+ spacesAvailableLotD + " Spaces available");
      d.setFont(font);
      d.setBackground(Color.WHITE);
      d.setBorderPainted(false); 
      setParkingIcon(d,spacesAvailableLotD,MAX_CAPACITY_D);
 
      d.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      button1ActionPerformed(  );
      }});
          
        
      positionLabel(banner, panel);
      addComponentsToPane(panel,a);  
      addComponentsToPane(panel,b); 
      addComponentsToPane(panel,c); 
      addComponentsToPane(panel,d); 
      banner.setOpaque(true);
      banner.setBackground(new Color(0,90,139));
   
      getContentPane().add(panel);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      setVisible(true); 
      
   }
     public static void main(String[] args) {
       
        new  ParkingInfoPage ();
     }
    
    private static void    setParkingIcon(JButton b,double x,final int y){
     
   
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
      private  void button1ActionPerformed() {
   
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
  

