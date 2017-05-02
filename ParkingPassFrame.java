import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.*;

/**
 *
 * @author yuxua
 */
    class ParkingPassFrame{
    public JFrame frame;
    private JLabel title;
    private String name;
    private int id;
    private LocalDate  date;
    private SimpleDateFormat df ;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel expiredLabel;
    
     public ParkingPassFrame(String n,int i,int y, int d){
        name = n;
        id = i;
         
        frame = new JFrame();
        frame.setBounds(0,0,300,300);
        frame.setTitle("Parking Pass");

        Font f=new Font("Arial",Font.BOLD,30);
        Font f1 = new Font("Arial",Font.BOLD,14); 
        title = new JLabel("Pakring pass info");
        title.setBounds(20, 0, 300, 100);
        title.setFont(f);
        date = LocalDate.ofYearDay(y,d);
        //df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        nameLabel = new JLabel("Name: " + name);
        nameLabel.setBounds(20, 50, 300, 100);
        nameLabel.setFont(f1);
        
        idLabel = new JLabel("Id: " + Integer.toString(id));
        idLabel.setBounds(20, 70, 300, 100);
        idLabel.setFont(f1);
        
        expiredLabel = new JLabel("Expired: " + date);
        expiredLabel.setBounds(20, 90, 300, 100);
        expiredLabel.setFont(f1);
        
        frame.setDefaultLookAndFeelDecorated(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     
     public void additems(){
         Container c=frame.getContentPane();
         c.setLayout(null);
         c.add(title);
         c.add(nameLabel);
         c.add(idLabel);
        c.add(expiredLabel);
     }
       
    }
    
    class MainClass{
        public static void main(String[] args) {
            ParkingPassFrame f = new ParkingPassFrame("Yuxan He",12345678,2017,200);
            f.additems();
        }
}

