package sevendwarves;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author yuxua
 */
class Comment {
     public JFrame frame;
     public JLabel banner;
     public JLabel lblSubject;
     public JTextField txtSubject;
     public JLabel lblComment;
     public JTextArea txtComment;
     private JButton btnCancel;
     private JButton btnSubmit;
     Font font;
 
     public Comment(){
        frame = new JFrame();
        frame.setBounds(0,0,300,500);
        frame.setTitle("Comment Reply");
        frame.setUndecorated(true);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.BLACK));
        frame.getContentPane().setBackground(UI.WARM_GRAY);
        
        font = new Font("franklin gothic book", Font.BOLD, 12);
         
        banner = new JLabel("<html><font color = white>UMass Boston</font>", SwingConstants.CENTER);
        banner.setOpaque(true);
        banner.setBackground(UI.BLUE);
        banner.setFont(new Font("Franklin gothic book heavy", Font.BOLD, 24));
        banner.setBounds(0, 0, 300, 40); 
        
        lblSubject = new JLabel("Subject");
        lblSubject.setBounds(20,110,80,20);
        
        lblComment = new JLabel("Comment");
        lblComment.setBounds(20,145,80,20);
        
        txtSubject = new JTextField();
        txtSubject.setBounds(90,110,180,20);
        
        txtComment = new JTextArea(10,20);
        txtComment.setBounds(90,145,180,100);;
       
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(20, 300, 120, 30);
        
        btnCancel = new JButton("Back");
        btnCancel.setBounds(160, 300, 120, 30);
        
        btnCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {;
                frame.setVisible(false);
                new ParkingInfoPage().setVisible(true);
                
            }
        });
        
        btnSubmit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                                "Thank your for your replying.",
                                "Replying Successfully",
                                JOptionPane.PLAIN_MESSAGE);
                frame.setVisible(false);
                new ParkingInfoPage().setVisible(true);
                
            }
        });
        
        frame.setDefaultLookAndFeelDecorated(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
     }
     
      public void additems(){
         Container c=frame.getContentPane();
         c.setLayout(null);
         c.add(banner);
         c.add(lblSubject);
         c.add(txtSubject);
         c.add(lblComment);
         c.add(txtComment);
         c.add(btnSubmit);
         c.add(btnCancel);
     }
}

 class MainClassComment{
        public static void main(String[] args) {
            Comment c = new Comment();
            c.additems();
        }
 }