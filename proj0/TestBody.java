public class TestBody{
    /**
     *  Tests body.
     */

    public static void main(String[] args) {
        checkBody();
    }

    /**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     *  @param  eps         Tolerance for the double comparison.
     */
    private static void checkEquals(double expected, double actual, String label, double eps) {
        if (Double.isNaN(actual) || Double.isInfinite(actual)) {
            System.out.println("FAIL: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        } else if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        }
    }


    /**
     *  Checks the Body class to make sure update works.
     */
    private static void checkBody() {
        System.out.println("Checking Body...");

        Body b1 = new Body(1.0, 2.0, 3.0, 4.0, 2.0e5, "jupiter.gif");
        Body b2 = new Body(2.0, 3.0, 3.0, 4.0, 6.0e6, "jupiter.gif");

        double force=b1.calcForceExertedBy(b2);

        checkEquals(40.02, force, "force between two bodies", 0.01);
    }
}