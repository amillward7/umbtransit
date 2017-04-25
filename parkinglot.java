//alex
import java.util.*;
import java.io.*;
import java.time.*;

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
            x = "Conditions are: ";
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
}