import Model.Dopsi;
import Model.Point;
import Model.Trip;

public class Main {
    public static void main(String[] args) {
        //Dopsi is a singleTone class
        Dopsi app = Dopsi.getInstance();

        Trip trip = new Trip(new Point(0, 0), new Point(2, 2), "12:33 PM");
    }
}


