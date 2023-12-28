package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Dopsi {
    private static Dopsi app = null;
    private static ArrayList<Driver> drivers;
    private ArrayList<Passenger> passengers;
    private HashMap<Driver, Integer> driversScors;
    private HashMap<Driver, Integer> distanceScores;
    private HashMap<Driver, Integer> distanceTemp;
    private HashMap<Driver, Integer> optionTempScores;
    private Point location;
    private HashMap<Driver, Integer> OptionScores;

    public Dopsi() {
        drivers = new ArrayList<>();
        passengers = new ArrayList<>();
    }

    public static Dopsi getInstance() {
        if (app == null) {
            app = new Dopsi();
        }
        return app;
    }

    static void applyATrip(Passenger passenger) {
        //TODO trip.setDriver()
    }

    int calOption(ArrayList<TripOption> options, Driver driver) {
        int score = 0;

        ArrayList<TripOption> driveOptions = driver.getOptions();
        for (TripOption options1 : options) {
            if (driveOptions.contains(options1)) {
                score++;
            } else score--;
        }

        return score;
    }

    void finBestDriver(Point passengerLoc, ArrayList<TripOption> options) {
        HashMap<Driver, Double> distanceScores = new HashMap<>();
        HashMap<Driver, Double> distanceTemp = new HashMap<>();
        HashMap<Driver, Double> driverScores = new HashMap<>();

        for (Driver driver : drivers) {
            Double dis = Point.getDistance(passengerLoc, driver.location);
            distanceTemp.put(driver, dis);
        }
        int i = 0;
        for (Driver driver : distanceTemp.keySet()) {
            for (Driver driver1 : driverScores.keySet()) {
                if (driver.getLastName().equals(driver1.getLastName()) && driver1.getFirstName().equals(driver.getFirstName())) {
                    Double score = distanceScores.get(driver1);
                    score -= i;
                    driverScores.put(driver1, score + calOption(options, driver));
                }
                i++;
            }
        }
        for (Driver driver : distanceTemp.keySet()) {
            for (Driver driver1 : driverScores.keySet()) {
                if (driver.getLastName().equals(driver1.getLastName()) && driver1.getFirstName().equals(driver.getFirstName())) {
                    Double score = distanceScores.get(driver1);
                    score -= i;
                    driverScores.put(driver1, score);
                }
                i++;
            }
        }

    }

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
