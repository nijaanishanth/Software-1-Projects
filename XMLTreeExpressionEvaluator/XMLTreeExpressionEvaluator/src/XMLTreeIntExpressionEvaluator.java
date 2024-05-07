import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Nijaa Nishanth
 *
 */
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
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
    private static int evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        // declare variables
        int num0, num1, expression = 0;
        XMLTree child0 = exp.child(0);
        XMLTree child1 = exp.child(1);

        // check children
        if (child0.label().equals("number")) {
            num0 = Integer.parseInt(child0.attributeValue("value"));
        } else {
            num0 = evaluate(child0);
        }
        if (child1.label().equals("number")) {
            num1 = Integer.parseInt(child1.attributeValue("value"));
        } else {
            num1 = evaluate(child1);
        }

        // perform operation
        if (exp.label().equals("plus")) {
            expression = num0 + num1;
        } else if (exp.label().equals("divide")) {
            expression = num0 / num1;
        } else if (exp.label().equals("times")) {
            expression = num0 * num1;
        } else {
            expression = num0 - num1;
        }
        return expression;

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
