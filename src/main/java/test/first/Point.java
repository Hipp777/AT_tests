package test.first;

/**
 * Created by 1 on 16.06.2020.
 */
public class Point {
    private int x;
    private int y;

    public Point() {

    }

    public double distance(Point p1, Point p2) {
        double rez;
        double x;
        double y;
        x = p1.getX()-p2.getX();
        y = p1.getY()-p2.getY();
        rez = Math.sqrt(x*x+y*y);
        return rez;
    };
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
