//package project;

import project.parkinglot;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import java.util.*;


public class infoFrame extends JFrame {
    private JFrame iFrame;
    private JPanel iPanel;
    private JLabel logo;
    private JPanel logoPanel;
    private JPanel topPanel;
    private JPanel graphicsPanel;
    private JPanel bottomPanel;
    private JLabel parkingLotName;
    private JLabel parkingLotConditions;
    private JLabel handicapSpots;
    private JLabel hours;
    private JLabel parkingPassReq;
    private double fill;
    
    public infoFrame() {
        ArrayList<String> y = new ArrayList<String>();
        y.add("Puddles");
        y.add("Potholes");
        y.add("Construction");
        parkinglot p = new parkinglot("Campus Center Garage", "6:30am - 11:00pm", 140, 75, 34, 
                                      false, false, true, true, y);
        String pname = p.name;
        fill = ((double)p.currentFill / p.capacity);
        iFrame = new JFrame("More Information about " + pname);
        logoPanel = new JPanel();
        topPanel = new JPanel();
        graphicsPanel = new JPanel();
        bottomPanel = new JPanel();
        iFrame.setPreferredSize(new Dimension(400, 500));
        iFrame.setLocationRelativeTo(null);
        iFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container c = iFrame.getContentPane();
        c.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbc2 = new GridBagConstraints();

        logo                 = new JLabel("UMBTRANSIT", JLabel.CENTER);
        logo.setForeground(Color.BLUE);
        logoPanel.add(logo);
        logoPanel.setBackground(Color.GRAY);
        logoPanel.setPreferredSize(new Dimension(100, 15));

        JButton back = new JButton("Back");
        //iFrame.add(back);
        // back.setBounds(280,40,80,20);
        //back.setText("back");
        back.addActionListener(new 
            java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    button3ActionPerformed(  );
                }
            }
        );
        back.setForeground(Color.BLUE);
        back.setBackground(Color.LIGHT_GRAY);
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setPreferredSize(new Dimension(30, 30));
        topPanel.setLayout(new GridBagLayout());
        
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.weightx = 0.5;
        gbc2.weighty = 0.7;
        gbc2.anchor = GridBagConstraints.NORTHWEST;
        gbc2.fill = GridBagConstraints.BOTH;
        topPanel.add(back, gbc2);
        topPanel.setBackground(Color.LIGHT_GRAY);

        parkingLotName       = new JLabel(pname, JLabel.CENTER);
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.weightx = 0.5;
        gbc2.weighty = 0.7;
        gbc2.anchor = GridBagConstraints.CENTER;
        gbc2.fill = GridBagConstraints.BOTH;
        topPanel.add(parkingLotName, gbc2);

        parkingLotConditions = new JLabel(p.conditionsAsString(), JLabel.CENTER);
        handicapSpots        = new JLabel(p.getHandicapInformation(), JLabel.CENTER);
        hours                = new JLabel(p.hours, JLabel.CENTER);
        parkingPassReq       = new JLabel(p.getParkingPassInfo(), JLabel.CENTER);

        bottomPanel.setLayout(new GridBagLayout());
        gbc2.gridx = 0;
        gbc2.gridy = 0;

        gbc2.weightx = 0.5;
        gbc2.weighty = 0.7;
        gbc2.anchor = GridBagConstraints.CENTER;
        gbc2.fill = GridBagConstraints.BOTH;
        bottomPanel.add(hours, gbc2);
        gbc2.gridy = 1;
        bottomPanel.add(parkingPassReq, gbc2);
        gbc2.gridy = 2;
        bottomPanel.add(handicapSpots, gbc2);
        gbc2.gridy = 3;
        bottomPanel.add(parkingLotConditions, gbc2);
        bottomPanel.setBackground(Color.LIGHT_GRAY);

        LotVisualizer l = new LotVisualizer(fill);
        iPanel = new JPanel();
        gbc2.gridx = 0;
        gbc2.gridy = 0;

        gbc2.weightx = 0.1;
        gbc2.weighty = 0.1;
        gbc2.anchor = GridBagConstraints.CENTER;
        gbc2.fill = GridBagConstraints.BOTH;
        iPanel.add(l, gbc2);
        iPanel.setBackground(Color.LIGHT_GRAY);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.7;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        c.add(logoPanel, gbc);
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.gridy = 1;
        c.add(topPanel, gbc);
        gbc.weightx = 0.5;
        gbc.weighty = 0.7;
        gbc.gridy = 3;
        c.add(iPanel, gbc);
        gbc.gridy = 5;
        c.add(bottomPanel, gbc);

        iFrame.pack();
        iFrame.setVisible(true);   
    }

    class LotVisualizer extends JComponent {
        double fill;
        private static final long serialVersionUID = 1L;

        public LotVisualizer (double fill) {
           this.fill = fill;
           setPreferredSize(new Dimension(200, 200));
        }

        public void paintComponent(Graphics g) {       
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g2d);
         
        int innerRad, outerRad, innerX, outerX, innerY, outerY;
        outerX = 0;
        outerY = 0;
        outerRad = 200;
        double iRad = (outerRad * fill);
        innerRad = (int) iRad;
        double ix =  100 - (innerRad/2.0);
        double iy = 100 - (innerRad/2.0);
        innerX = (int)ix;
        innerY = (int)iy;
        g2d.setColor(Color.GREEN);
        g2d.fillArc(outerX, outerY, outerRad, outerRad, 0, 360);
        g2d.setColor(Color.RED);
        g2d.fillArc(innerX, innerY, innerRad, innerRad, 0, 360);
        String x = (int)(fill*100) + "%";
        g2d.setColor(Color.BLACK);
        g2d.drawString(x, 80, 100);
        }
    }

    private  void button3ActionPerformed() {
        //ParkingInfoPage k= new ParkingInfoPage();
          //dummyFrame x = new dummyFrame(); 
          dispose(); 
      }      
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
            new Runnable() {
                public void run() {
                    //MyGui myGUI = new MyGui();
                    //myGUI.createGUI();
                    infoFrame bayside1 = new infoFrame();
                }
            }
        );
    }
}






