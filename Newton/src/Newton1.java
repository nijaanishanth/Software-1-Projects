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
public final class Newton1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton1() {
    }

    /**
     * @param x
     * @return double function sqrt uses Newton iteration to return the square
     *         root of the argument
     */
    private static double sqrt(double x) {
        // declare variables
        final double percentError = 0.0001;
        double guess = x;
        // checks if guess is below percent error
        while ((Math.abs(Math.pow(guess, 2) - x) / x) >= Math.pow(percentError,
                2)) {
            // creates a new guess
            guess = (guess + (x / guess)) / 2;
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
            // calls sqrt function and prints the square root
            out.println("the square root is " + sqrt(num));
            // asks user to continue
            out.println("Calculate another square root? (y/n): ");
            String calcAgain = in.nextLine();
            if (!(calcAgain.equals("y"))) {
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