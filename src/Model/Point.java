package Model;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static double getDistance(Point first,Point second) {
        int dX = ((second.getX() - first.getX()) *(second.getX() - first.getX()));
        int dY = ((second.getY() - first.getY()) *(second.getY() - first.getY()));
        return Math.sqrt(dX + dY);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
