import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Calculates the square root of a number using Newton iteration.
 *
 * @author Nijaa Nishanth
 *
 */
public final class Newton4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton4() {
    }

    /**
     * @param x
     * @param percentError
     * @return double function sqrt uses Newton iteration to return the square
     *         root of the argument
     */
    private static double sqrt(double x, double percentError) {
        // declare variables
        double guess = x;
        // checks if guess is below percent error
        if (x != 0) {
            while ((Math.abs(Math.pow(guess, 2) - x) / x) >= Math
                    .pow(percentError, 2)) {
                // creates a new guess
                guess = (guess + (x / guess)) / 2;
            }
        }
        return guess;
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
        boolean calc = true;
        // continues the loop until user wants to quit
        while (calc) {
            // asks user for number input
            out.println("Enter a number: ");
            double num = in.nextDouble();
            if (num >= 0) {
                // asks user for the percent error
                out.println("Enter the percent error: ");
                double percentErrorInput = in.nextDouble();
                // calls sqrt function and prints the square root
                out.println(
                        "the square root is " + sqrt(num, percentErrorInput));
            } else {
                calc = false;
            }
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
