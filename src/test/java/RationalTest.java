import org.junit.Assert;
import org.junit.Test;

public class RationalTest {
    @Test
    public void testAdd() {
        Rational x = new Rational();
        x.numerator = 1;
        x.denominator = 2;
        Rational y = new Rational();
        y.numerator = 1;
        y.denominator = 4;
        x.add(y);
        Assert.assertEquals(3, x.numerator);
    }
    @Test
    public void testSubtract(){
        Rational x = new Rational();
        x.numerator = 5;
        x.denominator = 4;

        Rational y = new Rational();
        y.numerator = 2;
        y.denominator = 4;
        x.subtract(y);
        Assert.assertEquals(3, x.numerator);
        Assert.assertEquals(4, x.denominator);
    }


    @Test
    public void testMultiply(){
        Rational x = new Rational();
        x.numerator = 2;
        x.denominator = 3;

        Rational y = new Rational();
        y.numerator = 9;
        y.denominator = 2;
        x.multiply(y);
        Assert.assertEquals(3, x.numerator);
        Assert.assertEquals(1, x.denominator);
    }

    @Test
    public void testDivision(){
        Rational x = new Rational();
        x.numerator = 12;
        x.denominator = 3;

        Rational y = new Rational();
        y.numerator = 4;
        y.denominator = 1;
        x.divide(y);
        Assert.assertEquals(1, x.numerator);
        Assert.assertEquals(1, x.denominator);
    }

    @Test
    public void testEquals() throws Rational.Illegal {
        Rational x = new Rational(2, 6);
        Rational y = new Rational(4, 12);
        Assert.assertEquals(x, y);
        x = new Rational(1, 2);
        y = new Rational(5, 9);
        Assert.assertNotEquals(x, y);
    }

    @Test
    public void testCompare() throws Rational.Illegal {
        Rational x = new Rational(2, 4);
        Rational y = new Rational(1, 2);
        Assert.assertEquals(0, x.compareTo(y));
        x = new Rational(3, 4);
        y = new Rational(1, 2);
        Assert.assertEquals(1, x.compareTo(y));
        x = new Rational(1,3);
        y = new Rational(1,2);
        Assert.assertEquals(-1, x.compareTo(y));
    }

    @Test
    public void testToString() throws Rational.Illegal {
        Rational x = new Rational(3, 6);
        String val = x.toString();
        Assert.assertEquals("1/2", val);
    }

}
