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
public final class ABCDGuesser1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ABCDGuesser1() {
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
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        // declare variables
        double oneThird = 1 / 3;
        double negOneThird = -1 / 3;
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
        int i = 0, j, k, l;
        while (i < len) {
            j = 0;
            while (j < len) {
                k = 0;
                while (k < len) {
                    l = 0;
                    while (l < len) {
                        // calculate jager value and determine if it is close to mu
                        formula = Math.pow(w, jagerNums[i])
                                * Math.pow(x, jagerNums[j])
                                * Math.pow(y, jagerNums[k])
                                * Math.pow(z, jagerNums[l]);
                        percError = Math.abs(formula - mu);
                        if (percError < lowestPercError) {
                            closest = formula;
                            lowestPercError = percError;
                            a = jagerNums[i];
                            b = jagerNums[j];
                            c = jagerNums[k];
                            d = jagerNums[l];

                        }
                        l++;
                    }
                    k++;
                }
                j++;
            }
            i++;
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
        out.print(lowestPercError, 2, false);
        out.println("%");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
