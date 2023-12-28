package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Dopsi {
    private static Dopsi app = null;
    private static ArrayList<Driver> drivers;
    private ArrayList<Passenger> passengers;
    private  HashMap<Driver, >
    public static Dopsi getInstance() {
        if (app == null) {
            app = new Dopsi();
        }
        return app;
    }

    public Dopsi() {
        drivers = new ArrayList<>();
        passengers = new ArrayList<>();
    }


    static void applyATrip(Passenger passenger) {
        //TODO trip.setDriver()
    }
    ArrayList<Driver> sortedDrivers();
    void finBestDriver(){
        HashMap<Driver, Integer> driverScores = new HashMap<>();
        Point.getDistance(first,second);

    }
    Driver findMinDis(Point point){
        int indexMin =0;
        int min=10000000;
        Driver chosenDriver;
        Date date = new Date();
        for(Driver driver : drivers){
            if(driver.location<min){
            chosenDriver = driver;
            min = driver.location;
             }
        }
        chosenDriver
    }
    void
    Driver

    //Register a Driver to out App(Dopsi)
    private void registerDriver(Driver driver) {
        //check that driver is already register or not (unique rule in Driver Table DB)
        if (!drivers.contains(driver)) {
            System.out.println("You have already been added to th list");
            return;
        }
        drivers.add(driver);
        System.out.println("Added successfully");
    }

    //Register a Passenger to out App(Dopsi)
    private void registerPassenger(Passenger passenger) {
        //check that passenger is already register or not (unique rule in Passenger Table DB)
        if (passengers.contains(passenger)) {
            passenger.messageFromDoopsi("You have already been added to th list");
            return;
        }
        passengers.add(passenger);
        passenger.messageFromDoopsi("Added successfully");
    }

    void allertPassangersWithNoTrips() {
        for (Passenger passenger : passengers) {
            if (!passenger.isOnATrip()) {
                passenger.messageFromDoopsi("You have not been in a trip yet today");
                System.out.printf(passenger.toString());
            }
        }
    }

    //Show all the Drivers in the app
    public void printDrivers() {
        int index = 0;
        for (Driver driver : drivers) {
            System.out.printf(index + ".\n");
            System.out.printf(driver.toString());
        }
    }
    //Show all the Passenger in the app
    public void printPassenger() {
        int index = 0;
        for (Passenger passenger : passengers) {
            System.out.printf(index + ".\n");
            System.out.printf(passenger.toString());
        }
    }
    //Show Drivers and All the Trips they have
    public void driversTrips() {
        for (Driver driver : drivers) {
            System.out.println(driver);
            for (Date date : driver.getAcceptedTrips().keySet()) {
                System.out.println(driver.getAcceptedTrips().get(date).toString());
            }
        }
    }
    //Getter and Setter
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        Dopsi.drivers = drivers;
    }

}
