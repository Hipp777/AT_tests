package test.first;

/**
 * Created by 1 on 16.06.2020.
 */

public class Main {
    public static void main(String[] args) {
        Point first = new Point(1, 6);
        Point second = new Point(3, 8);
        Point rez = new Point();
        Double out = rez.distance(first,second);
        System.out.print(out);
    }
}
