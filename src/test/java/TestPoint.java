import org.testng.Assert;
import org.testng.annotations.Test;
import test.first.Point;

/**
 * Created by 1 on 16.06.2020.
 */
public class TestPoint {
    @Test
    public void testPoint(){
        Point first = new Point(5, 5);
        Point second = new Point(1, 5);
        Point rez = new Point();
        Double out = rez.distance(first,second);
        Assert.assertEquals(out,4.0);
    };
    @Test
    public void testPoint2(){
        Point first = new Point(1, 5);
        Point second = new Point(5, 5);
        Point rez = new Point();
        Double out = rez.distance(first,second);
        Assert.assertEquals(out,4.0);
    };
}
