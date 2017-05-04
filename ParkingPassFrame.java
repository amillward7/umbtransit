package sevendwarves;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.*;

/**
 *
 * @author yuxua
 */
    class ParkingPassFrame extends JFrame{
    public JFrame frame;
    private JLabel title;
    private String name;
    private int id;
    private LocalDate  date;
    private SimpleDateFormat df ;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel expiredLabel;
    private JLabel banner;
    private JButton btnCancel;
    
     Font font;
    
     public ParkingPassFrame(String n,int i,int y, int d){
        banner = new JLabel("<html><font color = white>UMass Boston</font>", SwingConstants.CENTER);
        banner.setOpaque(true);
        banner.setBackground(UI.BLUE);
        banner.setFont(new Font("Franklin gothic book heavy", Font.BOLD, 24));
        banner.setBounds(0, 0, 300, 40);
         
        name = n;
        id = i;
        font = new Font("franklin gothic book", Font.BOLD, 12);
        
         
        frame = new JFrame();
        frame.setBounds(0,0,300,300);
        frame.setTitle("Parking Pass");
        frame.setUndecorated(true);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.BLACK));
        frame.getContentPane().setBackground(UI.WARM_GRAY);

        Font f=new Font("Arial",Font.BOLD,30);
        Font f1 = new Font("Arial",Font.BOLD,14); 
        title = new JLabel("Parking pass info");
        title.setBounds(20, 30, 300, 100);
        title.setFont(f);
        date = LocalDate.ofYearDay(y,d);
        //df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        nameLabel = new JLabel("Name: " + name);
        nameLabel.setBounds(20, 70, 300, 100);
        nameLabel.setFont(f1);
        
        idLabel = new JLabel("Id: " + Integer.toString(id));
        idLabel.setBounds(20, 90, 300, 100);
        idLabel.setFont(f1);
        
        expiredLabel = new JLabel("Expired: " + date);
        expiredLabel.setBounds(20, 110, 300, 100);
        expiredLabel.setFont(f1);
        
        btnCancel = new JButton("Back");
        btnCancel.setBounds(20, 250, 160, 30);
        btnCancel.setFont(f1);
        
         btnCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                 //pnlMain.setVisible(false);
                frame.setVisible(false);
                new ParkingInfoPage().setVisible(true);
                
            }
        });
        
        frame.setDefaultLookAndFeelDecorated(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ParkingPassFrame f = new ParkingPassFrame("Yuxan He",12345678,2017,200);
        additems();
     }
     
     public void additems(){
         Container c=frame.getContentPane();
         c.setLayout(null);
         c.add(banner);
         c.add(title);
         c.add(nameLabel);
         c.add(idLabel);
        c.add(expiredLabel);
        c.add(btnCancel);
     }
       
    }
    
    /*class MainClass{
        public static void main(String[] args) {
            ParkingPassFrame f = new ParkingPassFrame("Yuxan He",12345678,2017,200);
            f.additems();
        }*/

