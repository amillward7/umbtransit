package project;

import java.util.*;
import java.io.*;
import java.time.*;
import java.awt.Graphics;
import java.awt.Color;

public class parkinglot {
    public ArrayList<String> myConditions;
    public String name;
    public String hours;
    public int capacity;
    public int currentFill;
    public int numHandicapSpots;
    public boolean full;
    public boolean requiresParkingPass;
    public boolean hasHandicapSpots;
    public boolean isOpen;
    public Graphics visualizer;

    public parkinglot() {
        this.name = "EMPTY PARKING LOT";
        this.hours = "CLOSED";
        this.capacity = 0;
        this.currentFill = 0;
        this.numHandicapSpots = 0;
        this.full = false;
        this.requiresParkingPass = false;
        this.hasHandicapSpots = false;
        this.isOpen = false;;
        this.myConditions = new ArrayList<String>();
    }
    
    
    public parkinglot(String name, String hours, int capacity, int currentFill, int numHandicapSpots,
                      boolean full, boolean requiresParkingPass, boolean hasHandicapSpots, boolean isOpen) {
        this.name = name;
        this.hours = hours;
        this.capacity = capacity;
        this.currentFill = currentFill;
        this.numHandicapSpots = numHandicapSpots;
        this.full = full;
        this.requiresParkingPass = requiresParkingPass;
        this.hasHandicapSpots = hasHandicapSpots;
        this.isOpen = isOpen;
        this.myConditions = new ArrayList<String>();
    }

    public parkinglot(String name, String hours, int capacity, int currentFill, int numHandicapSpots, 
                      boolean full, boolean requiresParkingPass, boolean hasHandicapSpots,
                      boolean isOpen, ArrayList<String> myConditions) {
        this.name = name;
        this.hours = hours;
        this.capacity = capacity;
        this.currentFill = currentFill;
        this.numHandicapSpots = numHandicapSpots;
        this.full = full;
        this.requiresParkingPass = requiresParkingPass;
        this.hasHandicapSpots =hasHandicapSpots;
        this.isOpen = isOpen;
        this.myConditions = myConditions;
    }
    
    public String getParkingPassInfo() {
        if (this.requiresParkingPass) {
            return "Parking pass required.";
        } else { return "No parking pass required."; }
    }
    
    public String getHandicapInformation() {
        if (this.hasHandicapSpots) {
            return this.numHandicapSpots + " handicap spots available in this parking lot.";
        } else {
            return "No handicap spots available for this parking lot.";
        }
    }

    public double getPercentFill() {
        //System.out.println((double)(capacity / currentFill * 100) + "");
        //return (double)(currentFill / capacity * 100);
        return findPercentFill();
    }

    public double findPercentFill() {
        double a = (double) capacity;
        double b = (double) currentFill;
        double c = b / a;
        return c;
    }
    
    public String toString() {
        String x = "";
        if (isOpen) { x = "Lot is currently open."; }
        else { x = "Lot is not currently open."; }
        String lot = name + " :: " + capacity + " / " + currentFill + " | " + x;
        return lot;
    }
    
    public String conditionsAsString() {
        String x = "";
        if (this.myConditions.isEmpty()) {
            return "No conditions specified for this parking lot.";
        }else {
            //x = "Conditions are: ";
            for (int i = 0; i < this.myConditions.size(); i++) {
                if (i == this.myConditions.size() - 1) {
                    x += (this.myConditions.get(i));
                } else {
                    x += (myConditions.get(i) + ", ");   
                }
            }
            return x;
        }
    }

    /*public static void main(String[] args) {
        ArrayList<String> y = new ArrayList<String>();
        y.add("Puddles");
        y.add("Potholes");
        y.add("Construction");
        parkinglot p = new parkinglot("Campus Center Garage",
         "6:30am - 11:00pm", 140, 75, 34, false, false, true, true, y);
        System.out.println(p.getPercentFill());
        /*javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    //MyGui myGUI = new MyGui();
                    //myGUI.createGUI();
                    infoFrame bayside1 = new infoFrame();
                }
            });
        //infoFrame bayside1 = new infoFrame();
        //bayside1.repaint();
        }
    }*/
}



/*class DisplayVisualizer extends Canvas {
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillArc(0, 0, 20, 20, 0, 0);
        g.drawArc(0, 0, 100, 100, 0, 0);
        g.drawString((Integer)currentFill.toString(), 0, 0);
    }
    }*/