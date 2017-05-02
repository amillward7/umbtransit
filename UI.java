import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

final class UI {
  static final Color BLUE       = new Color(  0,  90, 139),
                     WHITE      = Color.WHITE,
                     LIGHT_BLUE = new Color(160, 207, 235),
                     RED        = new Color(163,  63,  31),
                     GOLD       = new Color(197, 146,  23),
                     WARM_GRAY  = new Color(152, 143, 134),
                     ORANGE     = new Color(212, 118,   0),
                     BEIGE      = new Color(167, 158, 112);
  
  static final Font FG_TEXT   = new Font("Franklin Gothic Book", Font.PLAIN, 12),
                    FG_BUTTON = FG_TEXT,
                    FG_BANNER = new Font("Franklin Gothic Book Heavy", Font.BOLD, 24);
  
  static final Dimension SIZE = new Dimension(250, 400);
  
  static final Point LOCATION = new Point(500, 280);
}