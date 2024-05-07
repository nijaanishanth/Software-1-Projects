import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Put your name here
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    // boundary test case
    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    // routine test case
    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(21);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    // routine test case
    @Test
    public void testReduceToGCD_60_42() {
        NaturalNumber n = new NaturalNumber2(60);
        NaturalNumber nExpected = new NaturalNumber2(6);
        NaturalNumber m = new NaturalNumber2(42);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    // challenging test case
    @Test
    public void testReduceToGCD_7_42() {
        NaturalNumber n = new NaturalNumber2(7);
        NaturalNumber nExpected = new NaturalNumber2(7);
        NaturalNumber m = new NaturalNumber2(42);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isEven
     */

    // boundary
    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    // routine
    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    // routine
    @Test
    public void testIsEven_72() {
        NaturalNumber n = new NaturalNumber2(72);
        NaturalNumber nExpected = new NaturalNumber2(72);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    // challenging?
    @Test
    public void testIsEven_10000() {
        NaturalNumber n = new NaturalNumber2(10000);
        NaturalNumber nExpected = new NaturalNumber2(10000);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    // challenging?

    /*
     * Tests of powerMod
     */

    // boundary
    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    // routine
    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber pExpected = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    // challenging
    @Test
    public void testPowerMod_max() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(1);
        NaturalNumber pExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(Integer.MAX_VALUE);
        NaturalNumber mExpected = new NaturalNumber2(Integer.MAX_VALUE);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of IsWitnessToCompositeness
     */

    // boundary
    @Test
    public void testIsWitnessToCompositeness_10_5() {
        NaturalNumber n = new NaturalNumber2(10);
        NaturalNumber w = new NaturalNumber2(5);
        boolean expected = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(true, expected);
    }

    // routine
    @Test
    public void testIsWitnessToCompositeness_17_8() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber w = new NaturalNumber2(8);
        boolean expected = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(false, expected);
    }

    // routine
    @Test
    public void testIsWitnessToCompositeness_20_4() {
        NaturalNumber n = new NaturalNumber2(20);
        NaturalNumber w = new NaturalNumber2(4);
        boolean expected = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(true, expected);
    }

    // challenging
    @Test
    public void testIsWitnessToCompositeness_700000_7() {
        NaturalNumber n = new NaturalNumber2(700000);
        NaturalNumber w = new NaturalNumber2(7);
        boolean expected = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(true, expected);
    }

    /*
     * Tests of IsPrime2
     */

    // boundary
    @Test
    public void testIsPrime2_2() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(2);
        boolean expected = CryptoUtilities.isPrime2(n);
        assertEquals(true, expected);
        assertEquals(n, nExpected);
    }

    // routine
    @Test
    public void testIsPrime2_13() {
        NaturalNumber n = new NaturalNumber2(13);
        NaturalNumber nExpected = new NaturalNumber2(13);
        boolean expected = CryptoUtilities.isPrime2(n);
        assertEquals(true, expected);
        assertEquals(n, nExpected);
    }

    // routine
    @Test
    public void testIsPrime2_32() {
        NaturalNumber n = new NaturalNumber2(32);
        NaturalNumber nExpected = new NaturalNumber2(32);
        boolean expected = CryptoUtilities.isPrime2(n);
        assertEquals(false, expected);
        assertEquals(n, nExpected);
    }

    // challenging
    @Test
    public void testIsPrime2_max() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE);
        NaturalNumber nExpected = new NaturalNumber2(Integer.MAX_VALUE);
        boolean expected = CryptoUtilities.isPrime2(n);
        assertEquals(true, expected);
        assertEquals(n, nExpected);
    }

    /*
     * Tests of testGenerateNextLikelyPrime
     */

    // boundary
    @Test
    public void testGenerateNextLikelyPrime_2() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(3);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(n, nExpected);
    }

    // routine
    @Test
    public void testGenerateNextLikelyPrime_34() {
        NaturalNumber n = new NaturalNumber2(34);
        NaturalNumber nExpected = new NaturalNumber2(37);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(n, nExpected);
    }

    // routine
    @Test
    public void testGenerateNextLikelyPrime_21() {
        NaturalNumber n = new NaturalNumber2(21);
        NaturalNumber nExpected = new NaturalNumber2(23);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(n, nExpected);
    }

    // challenging
    public void testGenerateNextLikelyPrime_7() {
        NaturalNumber n = new NaturalNumber2(7);
        NaturalNumber nExpected = new NaturalNumber2(7);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(n, nExpected);
    }

}
