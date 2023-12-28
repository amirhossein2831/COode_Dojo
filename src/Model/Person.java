package Model;

import java.util.Random;

abstract public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Point myLocation;


    public Person(String firstName, String lastName, String phoneNumber) {
        Random ran = new Random();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        //Generate Random Number for the location any Person
        this.myLocation = new Point(ran.nextInt(0, 100), ran.nextInt(0, 100));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Point getMyLocation() {
        return myLocation;
    }

    public void setMyLocation(Point myLocation) {
        this.myLocation = myLocation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
