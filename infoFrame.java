package project;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import java.util.*;


public class infoFrame extends JFrame {
    private JFrame iFrame;
    private JPanel iPanel;
    private JLabel logo;
    private JLabel parkingLotName;
    private JLabel parkingLotConditions;
    private JLabel handicapSpots;
    private JLabel hours;
    private JLabel parkingPassReq;
    //private ImageIcon visualizer; // not created yet
    
    public infoFrame() {
        ArrayList<String> y = new ArrayList<String>();
        y.add("Puddles");
        y.add("Potholes");
        y.add("Construction");
        parkinglot p = new parkinglot("Campus Center Garage", "6:30am - 11:00pm", 140, 75, 34, 
                                      false, false, true, true, y);
        String pname = p.name;

        iFrame = new JFrame("More Information about " + pname);
        iFrame.setSize(400, 400);
        iFrame.setLayout(new GridLayout(7, 1));
        iFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*iFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent) {
                    System.exit(0);
                }
                });*/

        logo                 = new JLabel("UMBTRANSIT", JLabel.CENTER);
        parkingLotName       = new JLabel(pname, JLabel.CENTER);
        parkingLotConditions = new JLabel(p.conditionsAsString(), JLabel.CENTER);
        handicapSpots        = new JLabel(p.getHandicapInformation(), JLabel.CENTER);
        hours                = new JLabel(p.hours, JLabel.CENTER);
        parkingPassReq       = new JLabel(p.getParkingPassInfo(), JLabel.CENTER);
        
        iPanel = new JPanel();
        iPanel.setLayout(new FlowLayout());
        
        iFrame.add(logo);
        iFrame.add(parkingLotName);
        iFrame.add(hours);
        iFrame.add(parkingPassReq);
        iFrame.add(handicapSpots);
        iFrame.add(parkingLotConditions);
        iFrame.setVisible(true);
        
        
        
        
    }
    
    public static void main(String[] args) {
        infoFrame bayside1 = new infoFrame();    
    }
}
