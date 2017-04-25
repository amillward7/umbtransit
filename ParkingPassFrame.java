//yuxuan
//package parkingpassframe;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author yuxua
 */
public class ParkingPassFrame {

    public static void main(String[] args) {
      Runnable r = new Runnable() {
            public void run() {
                String Title = "<html><body width=''><h1>Pakring pass info</h1>";
                String Label1 = "<p>Name:   ";
                String Label2 =
                    "<p> ID:   " +
                    "";
                String Label3 = "<p> Expired: ";

                JPanel p = new JPanel( new BorderLayout() );
                
                String name = "XXX";
                int id = 12345678;
                String Expired = "20XX/XX/XX";
                
                String out = Title + Label1+ name + Label2 + id + Label3 + Expired;

                JOptionPane.showMessageDialog(null, out);
                
            }
        };
        SwingUtilities.invokeLater(r);
    }
}