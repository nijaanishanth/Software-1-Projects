import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Nijaa Nishanth
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        // declare variables
        NaturalNumber num0 = new NaturalNumber2();
        NaturalNumber num1 = new NaturalNumber2();
        NaturalNumber eval = new NaturalNumber2();
        NaturalNumber zero = new NaturalNumber2();
        XMLTree child0 = exp.child(0);
        XMLTree child1 = exp.child(1);

        // check children
        if (child0.label().equals("number")) {
            num0 = new NaturalNumber2(child0.attributeValue("value"));
        } else {
            eval.copyFrom(evaluate(child0));
            num0.transferFrom(eval);
        }
        if (child1.label().equals("number")) {
            num1 = new NaturalNumber2(child1.attributeValue("value"));
        } else {
            eval.copyFrom(evaluate(child1));
            num1.transferFrom(eval);
        }

        // perform operation
        if (exp.label().equals("plus")) {
            num0.add(num1);
        } else if (exp.label().equals("divide")) {
            if (num1.compareTo(zero) == 0) {
                Reporter.fatalErrorToConsole("Error - 0 division");
            }
            num0.divide(num1);
        } else if (exp.label().equals("times")) {
            num0.multiply(num1);
        } else {
            if (num0.compareTo(num1) < 0) {
                Reporter.fatalErrorToConsole("Error - negative subtraction");
            }
            num0.subtract(num1);
        }
        return num0;

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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
