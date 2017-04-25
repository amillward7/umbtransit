//alex
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class NextFrame extends JFrame {

public static void main(String[] args) {
NextFrame frame = new NextFrame();
}

JLabel newWindow = new JLabel("New Window");
JPanel panel = new JPanel();

NextFrame(){
super("New Window");
setSize(300,200);
setLocation(500,280);
panel.setLayout (null); 

newWindow.setBounds(70,50,150,60);

panel.add(newWindow);

getContentPane().add(panel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}