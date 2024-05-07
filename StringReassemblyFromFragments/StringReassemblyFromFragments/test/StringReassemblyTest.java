import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Test String Reassembly Methods
 *
 * @author Nijaa Nishanth
 *
 **/

public class StringReassemblyTest {

    // combination tests
    // boundary
    @Test
    public void testCombination_maxOverlap() {
        String combo = StringReassembly.combination("HHHHHH", "HHHHHH", 6);
        assertEquals("HHHHHH", combo);

    }

    // routine
    @Test
    public void testCombination_3() {
        String combo = StringReassembly.combination("ABCDEF", "DEFGHIJ", 3);
        assertEquals("ABCDEFGHIJ", combo);

    }

    // routine
    @Test
    public void testCombination_2() {
        String combo = StringReassembly.combination("HSJD", "JDSHDJ", 2);
        assertEquals("HSJDSHDJ", combo);

    }

    // challenging
    @Test
    public void testCombination_spaces() {
        String combo = StringReassembly.combination("Hello I am Nijaa",
                "I am Nijaa, Hi", 10);
        assertEquals("Hello I am Nijaa, Hi", combo);

    }

    // add To Set Avoiding Substrings tests
    // boundary
    @Test
    public void testAddToSetAvoidingSubstrings_1() {
        Set<String> s = new Set2<>();
        s.add("often");
        String str = "ten";
        Set<String> expected = new Set2<>();
        expected.add("often");
        StringReassembly.addToSetAvoidingSubstrings(s, str);
        assertEquals(expected, s);

    }

    // boundary
    @Test
    public void testAddToSetAvoidingSubstrings_2() {
        Set<String> s = new Set2<>();
        s.add("tick");
        String str = "ticket";
        Set<String> expected = new Set2<>();
        expected.add("ticket");
        StringReassembly.addToSetAvoidingSubstrings(s, str);
        assertEquals(expected, s);

    }

    // routine
    @Test
    public void testAddToSetAvoidingSubstrings_3() {
        Set<String> s = new Set2<>();
        s.add("yay");
        s.add("cure");
        s.add("lift");
        s.add("thrifty");
        String str = "obscure";
        Set<String> expected = new Set2<>();
        expected.add("yay");
        expected.add("lift");
        expected.add("obscure");
        expected.add("thrifty");
        StringReassembly.addToSetAvoidingSubstrings(s, str);
        assertEquals(expected, s);

    }

    // routine
    @Test
    public void testAddToSetAvoidingSubstrings_4() {
        Set<String> s = new Set2<>();
        s.add("life");
        s.add("takeout");
        s.add("food");
        String str = "marinara";
        Set<String> expected = new Set2<>();
        expected.add("life");
        expected.add("takeout");
        expected.add("food");
        expected.add("marinara");
        StringReassembly.addToSetAvoidingSubstrings(s, str);
        assertEquals(expected, s);
    }

    // challenging
    @Test
    public void testAddToSetAvoidingSubstrings_5() {
        Set<String> s = new Set2<>();
        s.add("stop");
        s.add("self made");
        s.add("turnip");
        String str = "stop it";
        Set<String> expected = new Set2<>();
        expected.add("stop it");
        expected.add("self made");
        expected.add("turnip");
        StringReassembly.addToSetAvoidingSubstrings(s, str);
        assertEquals(expected, s);
    }

    // lines from input tests
    // boundary
    @Test
    public void testLinesFromInput_1() {
        SimpleWriter out = new SimpleWriter1L("testLinesFromInput_1.txt");
        SimpleReader in = new SimpleReader1L("testLinesfromInput_1.txt");
        out.println("Clarify");
        Set<String> set = new Set2<String>();
        Set<String> expected = new Set2<String>();
        set = StringReassembly.linesFromInput(in);
        expected.add("Clarify");
        assertEquals(set, expected);
        out.close();

    }

    // routine
    @Test
    public void testLinesFromInput_2() {
        SimpleReader in = new SimpleReader1L("cheer-8-2.txt");
        Set<String> set = new Set2<String>();
        Set<String> expected = new Set2<String>();
        set = StringReassembly.linesFromInput(in);
        expected.add("Bucks -- Beat");
        expected.add("Go Bucks");
        expected.add("o Bucks -- B");
        expected.add("Beat Mich");
        expected.add("Michigan~");
        assertEquals(set, expected);

    }

    // routine
    @Test
    public void testLinesFromInput_3() {
        SimpleWriter out = new SimpleWriter1L("testLinesFromInput_3.txt");
        SimpleReader in = new SimpleReader1L("testLinesfromInput_3.txt");
        out.println("Hello World");
        out.println("Hello");
        out.println("Goodbye");
        Set<String> set = new Set2<String>();
        Set<String> expected = new Set2<String>();
        set = StringReassembly.linesFromInput(in);
        expected.add("Hello World");
        expected.add("Goodbye");
        assertEquals(set, expected);
        out.close();

    }

    // routine
    @Test
    public void testLinesFromInput_4() {
        SimpleWriter out = new SimpleWriter1L("testLinesFromInput_4.txt");
        SimpleReader in = new SimpleReader1L("testLinesfromInput_4.txt");
        out.println("The world is a big place");
        out.println("With many experiences");
        Set<String> set = new Set2<String>();
        Set<String> expected = new Set2<String>();
        set = StringReassembly.linesFromInput(in);
        expected.add("The world is a big place");
        expected.add("With many experiences");
        assertEquals(set, expected);
        out.close();

    }

    // challenging?
    @Test
    public void testLinesFromInput_5() {
        SimpleWriter out = new SimpleWriter1L("testLinesFromInput_5.txt");
        SimpleReader in = new SimpleReader1L("testLinesfromInput_5.txt");
        out.println("The world is a big place");
        out.println("With many experiences");
        out.println("The world is");
        out.println("Big");
        out.println("many experiences");
        Set<String> set = new Set2<String>();
        Set<String> expected = new Set2<String>();
        set = StringReassembly.linesFromInput(in);
        expected.add("The world is a big place");
        expected.add("With many experiences");
        expected.add("Big");
        assertEquals(set, expected);
        out.close();

    }

    // print with line separators tests
    // boundary
    @Test
    public void testPrintWithLineSeparators_1() {
        String text = "hi~";
        SimpleWriter out = new SimpleWriter1L(
                "testPrintWithLineSeparators_1.txt");
        StringReassembly.printWithLineSeparators(text, out);
        out.close();
        SimpleReader in = new SimpleReader1L(
                "testPrintWithLineSeparators_1.txt");

        assertEquals("hi", in.nextLine());

        in.close();
    }

    // routine
    @Test
    public void testPrintWithLineSeparators_2() {
        String text = "hello~my~name~is~Nijaa~";
        SimpleWriter out = new SimpleWriter1L(
                "testPrintWithLineSeparators_2.txt");
        StringReassembly.printWithLineSeparators(text, out);
        out.close();
        SimpleReader in = new SimpleReader1L(
                "testPrintWithLineSeparators_2.txt");

        assertEquals("hello", in.nextLine());
        assertEquals("my", in.nextLine());
        assertEquals("name", in.nextLine());
        assertEquals("is", in.nextLine());
        assertEquals("Nijaa", in.nextLine());

        in.close();
    }

    // routine
    @Test
    public void testPrintWithLineSeparators_3() {
        String text = "take~a~walk~";
        SimpleWriter out = new SimpleWriter1L(
                "testPrintWithLineSeparators_3.txt");
        StringReassembly.printWithLineSeparators(text, out);
        out.close();
        SimpleReader in = new SimpleReader1L(
                "testPrintWithLineSeparators_3.txt");

        assertEquals("take", in.nextLine());
        assertEquals("a", in.nextLine());
        assertEquals("walk", in.nextLine());

        in.close();
    }

    // challenging
    @Test
    public void testPrintWithLineSeparators_4() {
        String text = "it~is~raining~outside~~look!~";
        SimpleWriter out = new SimpleWriter1L(
                "testPrintWithLineSeparators_4.txt");
        StringReassembly.printWithLineSeparators(text, out);
        out.close();
        SimpleReader in = new SimpleReader1L(
                "testPrintWithLineSeparators_4.txt");

        assertEquals("it", in.nextLine());
        assertEquals("is", in.nextLine());
        assertEquals("raining", in.nextLine());
        assertEquals("outside", in.nextLine());
        assertEquals("", in.nextLine());
        assertEquals("look!", in.nextLine());

        in.close();
    }

}
