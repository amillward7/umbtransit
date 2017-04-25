import javax.swing.JFrame;
import javax.swing.JPanel;

public class ResetPasswordFrame extends JFrame {
  private JPanel p;
  
  public ResetPasswordFrame() {
    super();
    p = new ResetPassword(this);
    add(p);
    pack();
    setBounds(300, 150, 450, 750);
    setVisible(true);
  }
}