package Model;

import java.util.ArrayList;

enum TripOption {
    Song,
    Cooler,
    internationalDegree,
    vielcerAvailibility
}

public class Trip {
    private Point origin;
    private Point destination;

    private double finalPrice;
    private Passenger passengers;
    private Driver driver;
    private ArrayList<TripOption> options;

    public Trip(Point origin, Point destination, Passenger passenger) {
        this.origin = origin;
        this.destination = destination;
        this.finalPrice = finalPrice();
        this.options = new ArrayList<>();
        this.passengers = passenger;
        this.driver = null;
    }

    void setOptions(int[] demanded) {
        for (int temp : demanded) {
            if (temp == 0) {
                options.add(TripOption.Song);
            } else if (temp == 1) {
                options.add(TripOption.Cooler);
            } else if (temp == 2) {
                options.add(TripOption.internationalDegree);
            } else if (temp == 3) {
                options.add(TripOption.vielcerAvailibility);
            }
        }
    }

    void applyOptionPrice() {
        for (TripOption option :this.options) {
            if (options.contains(TripOption.Song))
                this.finalPrice += this.finalPrice * (0.05);
            else if (options.contains(TripOption.Cooler))
                this.finalPrice += this.finalPrice * (0.15);
            else if (options.contains(TripOption.internationalDegree))
                this.finalPrice += this.finalPrice * (0.1);
            else if (options.contains(TripOption.vielcerAvailibility))
                this.finalPrice += this.finalPrice * (0.2);
        }
    }

    public Driver getDriver() {
        return driver;
    }

    //passenger
    public void setDriver(Driver driver) {
        this.driver = driver;
    }


    //calculate the Final Price of the Trio
    public double finalPrice() {
        double addPrice = 10 * Point.getDistance(origin, destination);
        return addPrice;
    }

    //Getter and Setter

    public Passenger getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger passengers) {
        this.passengers = passengers;
    }

    public Point getDestination() {
        return destination;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    //To String
    @Override
    public String toString() {
        return "Trip{" +
                "origin=" + origin +
                ", destination=" + destination +
                '}';
    }

}
