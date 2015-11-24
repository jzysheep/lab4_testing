import junit.framework.TestCase;

public class RationalTest extends TestCase {

    protected Rational HALF;

    protected void setUp() {
      HALF = new Rational( 1, 2 );
    }

    // Create new test
    public RationalTest (String name) {
        super(name);
    }

    public void testEquality() {
        assertEquals(new Rational(1,3), new Rational(1,3));
        assertEquals(new Rational(1,3), new Rational(2,6));
        assertEquals(new Rational(3,3), new Rational(1,1));
    }

    // Test for nonequality
    public void testNonEquality() {
        assertFalse(new Rational(2,3).equals(
            new Rational(1,3)));
    }

    public void testAccessors() {
    	assertEquals(new Rational(2,3).numerator(), 2);
    	assertEquals(new Rational(2,3).denominator(), 3);
    }

    public void testRoot() {
        Rational s = new Rational( 1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) ) 
                        && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }

    public void testDenominatorEqual0()
    {    
        try
        {
        Rational x = new Rational (1,0);
        Rational y = new Rational (3,4);
        Rational z = x.plus(y); 
        fail("Fail: should throw exception on denominator = 0.");
        }
        catch(Exception ex)
        {
            assertTrue(true);
        }
    }


// fail
    public void testPlus() {
        Rational a = new Rational (-1,-2);
        Rational b = new Rational (3,4);
        Rational c = a.plus(b);
        System.out.println("Test negative numbers: -1/-2 + 3/4 = "+ c.toString());
        assertEquals(c.numerator(), 5);
        assertEquals(c.denominator(), 4); 
    }

// fail
    public void testMinus() {
        Rational a = new Rational (-1, -4);   
        Rational b = new Rational (3, 4);
        Rational c = a.minus(b);
        System.out.println("Test Minus: 1/4 - 3/4 = "+ c.toString());
        assertEquals(c.numerator(), -1);
        assertEquals(c.denominator(), 2);
    }
    public void testIsLessThan() {
        Rational a = new Rational(1, 5);
        Rational b = new Rational(3, 4);
        assertTrue(a.isLessThan(b));
    }

    public void testTimes() {
        Rational a = new Rational(3, 4);
        Rational b = new Rational(2, 7);
        Rational c = a.times(b);

        System.out.println("Test times 3/4 * 2/7 = " + c.toString());
        assertEquals(c.numerator(), 3);
        assertEquals(c.denominator(), 14);

    }

    public void testDivides() {
        Rational a = new Rational(3, 4);
        Rational b = new Rational(2, 7);
        Rational c = a.divides(b);

        System.out.println("Test divides 3/4 / 2/7 = " + c.toString());
        assertEquals(c.numerator(), 21);
        assertEquals(c.denominator(), 8);

    }

    public void testAbs1() {
        Rational a = new Rational(-1, -2);
        Rational c = a.abs();
        System.out.println("Abs of -1/-2 is "+ c.toString());
        assertEquals(c.numerator(), 1);
        assertEquals(c.denominator(), 2);

    }

    public static void testAbs2()
    {
        Rational x = new Rational (1,-2);
        Rational z = x.abs();
        System.out.println("Abs of 1/-2 is "+ z.toString());
        assertEquals(z.numerator(), 1);
        assertEquals(z.denominator(), 2);
    }

    public void testTolerance() {
        Rational a = new Rational(1, 300);
        Rational.setTolerance(a);
        assertEquals(Rational.getTolerance().numerator(), 1);
        assertEquals(Rational.getTolerance().denominator(), 300);
    }


    public void testToString() {
        Rational a = new Rational(1, 300);
        assertEquals("1/300", a.toString());
    }

    public static void testIllegalArgumentToSquareRootException()
    {
        Rational s = new Rational( 1, Integer.MAX_VALUE );
        Rational sRoot = null;
        try {
            sRoot = s.root();
            fail("Fail: should throw IllegalArgumentToSquareRootException.");
        } catch (IllegalArgumentToSquareRootException e) {
            assertTrue(true);
        }
        catch(Exception e)
        {
            assertTrue(false);
        }
    }

    public static void main(String args[]) {
        String[] testCaseName = 
            { RationalTest.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }
}