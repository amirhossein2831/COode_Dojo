package Model;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Driver extends Person{
    private String carModel;
    private String numberplate;
    private HashMap<Date, ArrayList<Trip>> allTrips;
    private HashMap<Date, Trip> acceptedTrips;
    public Driver(
            String firstName,
            String lastName,
            String phoneNumber,
            String carModel,
            String numberplate
    ) {
        super(firstName, lastName, phoneNumber);
        this.carModel = carModel;
        this.numberplate=numberplate;
        allTrips = new HashMap<>();
        acceptedTrips = new HashMap<>();
    }

    //TODO accept Trip

    public void  addTrip(Trip trip){
    }
   public void addATrip(Passenger passenger,Driver driver)
    {

    }

    //Getter ans Setter
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public HashMap<Date, ArrayList<Trip>> getAllTrips() {
        return allTrips;
    }

    public void setAllTrips(HashMap<Date, ArrayList<Trip>> allTrips) {
        this.allTrips = allTrips;
    }

    public HashMap<Date, Trip> getAcceptedTrips() {
        return acceptedTrips;
    }

    public void setAcceptedTrips(HashMap<Date, Trip> acceptedTrips) {
        this.acceptedTrips = acceptedTrips;
    }

    //To String
    @Override
    public String toString() {
        return "Driver{" +
                "driverFirstName:" + getFirstName()+ "\n"+
                "driverLastName:" + getLastName()+ "\n"+
                "driverPhoneNumber:" + getPhoneNumber()+ "\n"+
                "carModel='" + carModel + '\'' +
                ", numberplate='" + numberplate + '\'' +
                '}';
    }
}
