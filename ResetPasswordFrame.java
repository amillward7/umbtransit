import javax.swing.JFrame;
import javax.swing.JPanel;

/* This class is just a JFrame to contain ResetPassword, which is a JPanel. */

public class ResetPasswordFrame extends JFrame {
  private JPanel p;
  
  public ResetPasswordFrame() {
    super();
    //setUndecorated(true);
    p = new ResetPassword(this);
    add(p);
    pack();
    setBounds(300, 150, 450, 750);
    setVisible(true);
  }
}