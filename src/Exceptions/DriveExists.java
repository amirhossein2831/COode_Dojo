package Exceptions;

public class DriveExists extends Exception{

    public DriveExists() {
    }

    public DriveExists(String message) {
        super(message);
    }
}
