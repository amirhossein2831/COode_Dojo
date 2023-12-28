package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Passenger extends Person {
    private HashMap<Date, Trip> trips;
    private boolean isOnATrip;

    public Passenger(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber);
        this.trips = new HashMap<>();
    }

    public void messageFromDoopsi(String message) {
        System.out.printf(message);
    }

    void RegisterTrip(Point destination, int[] options) {
        if (!this.isOnATrip) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date today = new Date();
            for (Date date : trips.keySet()) {
                if (sdf.format(today).equals(sdf.format(date))) {
                    System.out.println("You had a Trip already today");
                    return;
                }
            }
            Trip trip = new Trip(this.getMyLocation(), destination, this);
            trip.setOptions(options);
            trip.applyOptionPrice();
            this.trips.put(today, trip);
            this.isOnATrip = true;
            return;
        }
        System.out.println("You had a Trip already today");
    }

    void addTrip(Trip trip) {
    }

    private void showAllTrip(Date start, Date end) {
        ArrayList<Trip> acceptedTrips = new ArrayList<>();
        for (Map.Entry<Date, Trip> entry : trips.entrySet()) {
            Date key = entry.getKey();
            if (key.before(end) && key.after(start)) {
                System.out.println(entry.getValue());
            }
        }
    }

    public boolean isOnATrip() {
        return isOnATrip;
    }

    public void setOnATrip(boolean onATrip) {
        isOnATrip = onATrip;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "firstName=" + getFirstName() + "\n" +
                "lastName=" + getLastName() + "\n" +
                "phoneNumber=" + getPhoneNumber() + "\n" +
                ", isOnATrip=" + isOnATrip +
                '}';
    }
}
