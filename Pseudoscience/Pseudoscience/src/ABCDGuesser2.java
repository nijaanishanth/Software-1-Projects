import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Uses Jager Formula to approximate a value.
 *
 * @author Nijaa Nishanth
 *
 */
public final class ABCDGuesser2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ABCDGuesser2() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        boolean posnum = false;
        String numString;
        double numDouble = 0;
        while (!posnum) {
            out.println("Please enter a positive real number: ");
            numString = in.nextLine();
            if (FormatChecker.canParseDouble(numString)) {
                numDouble = Double.parseDouble(numString);
                if (numDouble > 0) {
                    posnum = true;
                }
            }
        }
        return numDouble;

    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        boolean posnum = false;
        String numString;
        double numDouble = 0;
        while (!posnum) {
            out.println(
                    "Please enter a positive real number not equal to 1.0: ");
            numString = in.nextLine();
            if (FormatChecker.canParseDouble(numString)
                    && !numString.equals("1.0")) {
                numDouble = Double.parseDouble(numString);
                if (numDouble > 0) {
                    posnum = true;
                }
            }
        }
        return numDouble;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param w
     *            value of w in the Jager formula
     * @param x
     *            value of x in the Jager formula
     * @param y
     *            value of y in the Jager formula
     * @param z
     *            value of z in the Jager formula
     * @param a
     *            value of a in the Jager formula
     * @param b
     *            value of b in the Jager formula
     * @param c
     *            value of c in the Jager formula
     * @param d
     *            value of d in the Jager formula
     * @return the value calculated by the Jager formula
     */
    private static double calcJagerFormula(double w, double x, double y,
            double z, double a, double b, double c, double d) {
        double formula = Math.pow(w, a) * Math.pow(x, b) * Math.pow(y, c)
                * Math.pow(z, d);
        return formula;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        // declare variables
        final double oneThird = 1 / 3;
        final double negOneThird = -1 / 3;
        final double[] jagerNums = { -5, -4, -3, -2, -1, -0.5, negOneThird,
                -0.25, 0, 0.25, oneThird, 0.5, 1, 2, 3, 4, 5 };
        final int percent = 100;
        double w, x, y, z, mu;

        // ask user for values
        mu = getPositiveDouble(in, out);
        w = getPositiveDoubleNotOne(in, out);
        x = getPositiveDoubleNotOne(in, out);
        y = getPositiveDoubleNotOne(in, out);
        z = getPositiveDoubleNotOne(in, out);

        // while loops to check for the closest value to mu
        double a = 0, b = 0, c = 0, d = 0;
        double percError = 0, lowestPercError = Double.MAX_VALUE, closest = 0;
        double formula = 0;
        int len = jagerNums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    for (int l = 0; l < len; l++) {
                        // calculate and find lowest percent error
                        formula = calcJagerFormula(w, x, y, z, jagerNums[i],
                                jagerNums[j], jagerNums[k], jagerNums[l]);
                        percError = Math.abs(formula - mu);
                        if (percError < lowestPercError) {
                            closest = formula;
                            lowestPercError = percError;
                            a = jagerNums[i];
                            b = jagerNums[j];
                            c = jagerNums[k];
                            d = jagerNums[l];
                        }

                    }
                }
            }
        }

        // print statements
        lowestPercError = (lowestPercError / mu) * percent;
        out.println("a = " + a);
        out.println("b = " + b);
        out.println("c = " + c);
        out.println("d = " + d);
        out.print("Approximation = ");
        out.println(closest, 2, false);
        out.print("Percent Error = ");
        out.println(lowestPercError, 2, false);
        out.println("%");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
