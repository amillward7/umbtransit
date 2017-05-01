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
    private String fill;
    //private DisplayVisualizer visualizer; // not created yet
    
    public infoFrame() {
        ArrayList<String> y = new ArrayList<String>();
        y.add("Puddles");
        y.add("Potholes");
        y.add("Construction");
        parkinglot p = new parkinglot("Campus Center Garage", "6:30am - 11:00pm", 140, 75, 34, 
                                      false, false, true, true, y);
        String pname = p.name;

        /*iFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent) {
                    System.exit(0);
                }
                });*/
        /*Runnable r = new Runnable() {
            public void run() {
                LotVisualizer l = new LotVisualizer(p.getPercentFill());
                l.setLayout(new FlowLayout());
            }
        };*/

        iFrame = new JFrame("More Information about " + pname);
        logoPanel = new JPanel();
        topPanel = new JPanel();
        graphicsPanel = new JPanel();
        bottomPanel = new JPanel();
        iFrame.setPreferredSize(new Dimension(600, 600));
        //iFrame.setLayout(new FlowLayout());
        iFrame.setLocationRelativeTo(null);
        iFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container c = iFrame.getContentPane();
        c.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;

        gbc2.weightx = 0.5;
        gbc2.weighty = 0.1;
        gbc2.anchor = GridBagConstraints.CENTER;
        gbc2.fill = GridBagConstraints.BOTH;
        

        logo                 = new JLabel("UMBTRANSIT", JLabel.CENTER);
        logo.setForeground(Color.BLUE);
        logoPanel.add(logo, gbc2);
        logoPanel.setBackground(Color.GRAY);

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

        LotVisualizer l = new LotVisualizer(p.getPercentFill());
        iPanel = new JPanel();
        gbc2.gridx = 0;
        gbc2.gridy = 0;

        gbc2.weightx = 0.1;
        gbc2.weighty = 0.1;
        gbc2.anchor = GridBagConstraints.CENTER;
        gbc2.fill = GridBagConstraints.BOTH;
        //iPanel.setLayout(new BoxLayout());
        iPanel.add(l, gbc2);
        iPanel.setBackground(Color.LIGHT_GRAY);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.7;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;

        c.add(logoPanel, gbc);
        gbc.gridy = 1;
        c.add(topPanel, gbc);
        gbc.gridy = 3;
        c.add(iPanel, gbc);
        gbc.gridy = 7;
        c.add(bottomPanel, gbc);



        //iPanel.setLayout(new FlowLayout());
        
        //DisplayVisualizer vis = new DisplayVisualizer();
        
        /*iFrame.add(logo);
        iFrame.add(parkingLotName);
        iFrame.add(iPanel);
        iFrame.add(hours);
        iFrame.add(parkingPassReq);
        iFrame.add(handicapSpots);
        iFrame.add(parkingLotConditions);*/
        
        //iFrame.setContentPane(this);
        /*iPanel.add(logo);
        iPanel.add(parkingLotName);
        iPanel.add(l);
        //iFrame.paintComponent
        //iFrame.update();
        //fill = p.getPercentFill();
        //iFrame.repaint();
        //iFrame.paint(this.getGraphics());
        iPanel.add(hours);
        iPanel.add(parkingPassReq);
        iPanel.add(handicapSpots);
        iPanel.add(parkingLotConditions);
        //iPanel.setContentPane(this);
        //iPanel.pack();
        iPanel.setVisible(true); */
        //iFrame.add(iPanel); 
        iFrame.pack();
        iFrame.setVisible(true);   
    }

    /*public void paint(Graphics g2) {
        //this.paint();
      Graphics2D g = (Graphics2D) g2; // cast to Graphics2D
      
      if (fill.equals("100")) { g.setColor(Color.RED);   }
         else             { g.setColor(Color.GREEN); }
         int f = Integer.parseInt(fill);
      g.drawArc(50, 50, 50, 50, 0, 300);
         g.fillArc(50, 50, f, f, 0, 300);
         g.drawString(fill, 100, 100);
         g.drawString("%", 110, 110);

      /*Line2D.Double line = new Line2D.Double(20.0, 50.0, 50.0, 200.0);
      g2d.draw(line);
      Rectangle2D.Double rect = new Rectangle2D.Double(100.0, 50.0, 60.0, 80.0);
      g2d.draw(rect); // also try g2d.fill(rect);
      Ellipse2D.Double circle = new Ellipse2D.Double(200.0, 100.0, 80.0, 80.0);
      g2d.draw(circle); // also try g2d.fill(circle); 
  }*/

    class LotVisualizer extends JComponent {
        String fill;
        private static final long serialVersionUID = 1L;

        public LotVisualizer (String fill) {
           this.fill = fill;
           setPreferredSize(new Dimension(50, 50));
           //super.paintComponent();
        }

        //public Dimension getPreferredSize() {return new Dimension(100, 100);}

        public void paintComponent(Graphics g) {
         
         Graphics2D g2d = (Graphics2D)g;
         super.paintComponent(g2d);
         
        float pix2m = 0.000264583f;
        float m2pix = 3779.527559055f;
        int innerRad, outerRad;
        int innerX, outerX, innerY, outerY;
        double fill = 0.9;
        double dist;
        outerX = 150;
        outerY = 100;
        outerRad = 100;
        //dist = Math.sqrt(outerX*outerX + outerY*outerY);
        //innerX = outerX + (int)dist;
        //innerY = outerY + (int)dist;
        double ix = outerX + (outerX * (1.0 - fill));
        double iy = outerY + (outerY * (1.0 - fill));
        innerX = (int)ix;
        innerY = (int)iy;
        double iRad = outerRad * fill;
        innerRad = (int) iRad;
        //g2d.drawArc(outerX, outerY, outerRad, outerRad, 0, 360);
        //g2d.fillArc(innerX, innerY, innerRad, innerRad, 0, 360);
        g2d.setColor(Color.GREEN);
        g2d.fillArc(0, 0, 50, 50, 0, 360);
        g2d.setColor(Color.RED);
        g2d.fillArc(12, 12, 25, 25, 0, 360);
        String x = (int)(fill*100) + "%";
        g2d.setColor(Color.BLACK);
        g2d.drawString(x, 27, 40);
        }
    }

    private  void button3ActionPerformed() {
        //ParkingInfoPage k= new ParkingInfoPage();
          //dummyFrame x = new dummyFrame(); 
          dispose(); 
      }      
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    //MyGui myGUI = new MyGui();
                    //myGUI.createGUI();
                    infoFrame bayside1 = new infoFrame();
                }
            });
        //infoFrame bayside1 = new infoFrame();
        //bayside1.repaint();
    }
    
    
    /*private class DisplayVisualizer {                                          
        public void paint(Graphics g) {
            g.setColor(Color.RED);
            g.fillArc(0, 0, 20, 20, 0, 0);
            g.drawArc(0, 0, 100, 100, 0, 0);
            g.drawString((Integer)parkinglot.currentFill.toString(), 0, 0);
        }
        }*/
}






