package test.rice;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import main.rice.PrimeFactorizer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A JUnit test case class. Every method with the annotation "@Test" will be called when
 * running the test with JUnit.
 */
public class PrimeFactorizerTest {

    /**
     * A prime factorizer with a relatively small upper bound.
     */
    private static PrimeFactorizer factorizer100 = new PrimeFactorizer(100);

    /**
     * A prime factorizer with a larger upper bound.
     */
    private static PrimeFactorizer factorizer500000000 = new PrimeFactorizer(500000000);

    /**
     * Tests that attempting factorization of a negative number rightfully returns null.
     */
    @Test
    @Tag("2.0")
    void testSmallMaxFactorizeNegative() {
        int[] actual = factorizer100.computePrimeFactorization(-1);
        assertNull(actual);
    }

    /**
     * Tests that attempting factorization of 0 rightfully returns null.
     */
    @Test
    @Tag("2.0")
    void testSmallMaxFactorize0() {
        int[] actual = factorizer100.computePrimeFactorization(0);
        assertNull(actual);
    }

    /**
     * Tests that attempting factorization of a prime that's larger than maxNumToFactorize
     * returns null.
     */
    @Test
    @Tag("2.0")
    void testSmallMaxFactorize101() {
        int[] actual = factorizer100.computePrimeFactorization(101);
        assertNull(actual);
    }

    /**
     * Tests that attempting factorization of a composite that's larger than
     * maxNumToFactorize returns null.
     */
    @Test
    @Tag("1.0")
    void testSmallMaxFactorize102() {
        int[] actual = factorizer100.computePrimeFactorization(102);
        assertNull(actual);
    }

    /**
     * Tests that attempting factorization of 1 rightfully returns null.
     */
    @Test
    @Tag("2.0")
    void testSmallMaxFactorize1() {
        int[] actual = factorizer100.computePrimeFactorization(1);
        assertNull(actual);
    }

    /**
     * Tests factorization of a small prime.
     */
    @Test
    @Tag("2.0")
    void testSmallMaxFactorize7() {
        int[] actual = factorizer100.computePrimeFactorization(7);
        int[] expected = new int[]{7};
        assertArrayEquals(expected, actual);
    }

    /**
     * Tests factorization of a prime that's larger than sqrt(maxNumToFactorize).
     */
    @Test
    @Tag("2.0")
    void testSmallMaxFactorize71() {
        int[] actual = factorizer100.computePrimeFactorization(71);
        int[] expected = new int[]{71};
        assertArrayEquals(expected, actual);
    }

    /**
     * Tests factorization of a very large prime (with an even larger factorizer).
     */
    @Test
    @Tag("1.0")
    void testLargeMaxFactorize11777() {
        int[] actual = factorizer500000000.computePrimeFactorization(11777);
        int[] expected = new int[]{11777};
        assertArrayEquals(expected, actual);
    }

    /**
     * Tests factorization of a small composite whose factors are all unique.
     */
    @Test
    @Tag("2.0")
    void testSmallMaxFactorize30() {
        int[] actual = factorizer100.computePrimeFactorization(30);
        int[] expected = new int[]{2, 3, 5};
        assertArrayEquals(expected, actual);
    }

    /**
     * Tests factorization of a larger composite whose factors are all unique.
     */
    @Test
    @Tag("2.0")
    void testLargeMaxFactorize34534() {
        int[] actual = factorizer500000000.computePrimeFactorization(34534);
        int[] expected = new int[]{2, 31, 557};
        assertArrayEquals(expected, actual);
    }

    /**
     * Tests factorization of a small composite whose factors are all repeats of the
     * same single prime.
     */
    @Test
    @Tag("3.0")
    void testSmallMaxFactorize81() {
        int[] actual = factorizer100.computePrimeFactorization(81);
        int[] expected = new int[]{3, 3, 3, 3};
        assertArrayEquals(expected, actual);
    }

    /**
     * Tests factorization of a large composite whose factors are all repeats of the
     * same single prime.
     */
    @Test
    @Tag("2.0")
    void testLargeMaxFactorize65536() {
        int[] actual = factorizer500000000.computePrimeFactorization(65536);
        int[] expected = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        assertArrayEquals(expected, actual);
    }

    /**
     * Tests factorization of a small composite who has more than one unique factor,
     * each of which is repeated.
     */
    @Test
    @Tag("3.0")
    void testSmallMaxFactorize100() {
        int[] actual = factorizer100.computePrimeFactorization(100);
        int[] expected = new int[]{2, 2, 5, 5};
        assertArrayEquals(expected, actual);
    }

    /**
     * Tests factorization of a large composite whose factorization is a combination of
     * unique and repeated primes.
     */
    @Test
    @Tag("4.0")
    void testLargeMaxFactorize42398432() {
        int[] actual = factorizer500000000.computePrimeFactorization(42398432);
        int[] expected = new int[]{2, 2, 2, 2, 2, 1324951};
        assertArrayEquals(expected, actual);
    }

    /**
     //     * Tests that attempting factorization of a negative number rightfully returns null.
     //     */
    @Test
    void testFactorizeNegative() {
        int[] actual = factorizer100.computePrimeFactorization(-1);
        assertNull(actual);
    }

    /**
     * Tests that attempting factorization of 0 rightfully returns null.
     */
    @Test
    void testFactorize0() {
        int[] actual = factorizer100.computePrimeFactorization(0);
        assertNull(actual);
    }

    /**
     * Tests that attempting factorization of 1 rightfully returns null.
     */
    @Test
    void testFactorize1() {
        int[] actual = factorizer100.computePrimeFactorization(1);
        assertNull(actual);
    }

    /**
     * Tests factorization of a prime that can be factorized. 2, 7, 37, 97.
     */
    @Test
    void testFactorize2() {
        int[] actual = factorizer100.computePrimeFactorization(2);
        int[] expected = new int[]{2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFactorize7() {
        int[] actual = factorizer100.computePrimeFactorization(7);
        int[] expected = new int[]{7};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFactorize37() {
        int[] actual = factorizer100.computePrimeFactorization(37);
        int[] expected = new int[]{37};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFactorize97() {
        int[] actual = factorizer100.computePrimeFactorization(97);
        int[] expected = new int[]{97};
        assertArrayEquals(expected, actual);
    }

    /**
     *  Tests factorization of a non-prime that can be factorized.
     */

    @Test
    void testFactorizeComposite4() {
        int[] actual = factorizer100.computePrimeFactorization(4);
        int[] expected = new int[]{2, 2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFactorizeComposite35() {
        int[] actual = factorizer100.computePrimeFactorization(35);
        int[] expected = new int[]{5, 7};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFactorizeComposite84() {
        int[] actual = factorizer100.computePrimeFactorization(84);
        int[] expected = new int[]{2, 2, 3, 7};
        assertArrayEquals(expected, actual);
    }

    /**
     *  Tests factorization that includes more than one distinct prime.
     */

    @Test
    void testFactorizeMultiDistinct14() {
        int[] actual = factorizer100.computePrimeFactorization(14);
        int[] expected = new int[]{2, 7};
        assertArrayEquals(expected, actual);
    }

    /**
     *  Tests factorization that includes repeats.
     */

    @Test
    void testFactorizeRepeats24() {
        int[] actual = factorizer100.computePrimeFactorization(24);
        int[] expected = new int[]{2, 2, 2, 3};
        assertArrayEquals(expected, actual);
    }

    /**
     *  Tests factorization with a prime input too large to be factorized.
     */

    @Test
    void testFactorizePrimeOverMax() {
        int[] actual = factorizer100.computePrimeFactorization(151);
        assertNull(actual);
    }

    /**
     *  Tests factorization with a non-prime input too large to be factorized.
     */

    @Test
    void testFactorizeOverMax() {
        int[] actual = factorizer100.computePrimeFactorization(200);
        assertNull(actual);
    }

    /**
     *  Tests factorization with a prime input too large to be factorized.
     */

    @Test
    void testFactorizePrimeVeryOverMax() {
        int[] actual = factorizer100.computePrimeFactorization(10271);
        assertNull(actual);
    }

    /**
     *  Tests factorization with a non-prime input way too large to be factorized.
     */

    @Test
    void testFactorizeVeryOverMax() {
        int[] actual = factorizer100.computePrimeFactorization(20000);
        assertNull(actual);
    }


    private static PrimeFactorizer factorizer100000 = new PrimeFactorizer(100000);

    /**
     * Tests factorization of a prime that can be factorized.
     */
    @Test
    void testFactorizePrimeVeryLargeNumber() {
        int[] actual = factorizer100000.computePrimeFactorization(1427);
        int[] expected = new int[]{1427};
        assertArrayEquals(expected, actual);
    }

    /**
     * Tests factorization of a composite that can be factorized.
     */
    @Test
    void testFactorizeCompositeVeryLargeNumber() {
        int[] actual = factorizer100000.computePrimeFactorization(1833);
        int[] expected = new int[]{3, 13, 47};
        assertArrayEquals(expected, actual);
    }


}
//package test.rice;
//
//import main.rice.PrimeFactorizer;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
///**
// * A test suite for the PrimeFactorizer class. Every method with the annotation "@Test"
// * will be called when running the test with JUnit.
// */
//public class PrimeFactorizerTest {
//
//    /**
//     * A prime factorizer with an upper bound of 100.
//     */
//    private static PrimeFactorizer factorizer100 = new PrimeFactorizer(100);
//
//    /**
//     * Tests that attempting factorization of a negative number rightfully returns null.
//     */
//    @Test
//    void testFactorizeNegative() {
//        int[] actual = factorizer100.computePrimeFactorization(-1);
//        assertNull(actual);
//    }
//
//    /**
//     * Tests that attempting factorization of 0 rightfully returns null.
//     */
//    @Test
//    void testFactorize0() {
//        int[] actual = factorizer100.computePrimeFactorization(0);
//        assertNull(actual);
//    }
//
//    /**
//     * Tests that attempting factorization of 1 rightfully returns null.
//     */
//    @Test
//    void testFactorize1() {
//        int[] actual = factorizer100.computePrimeFactorization(1);
//        assertNull(actual);
//    }
//
//    /**
//     * Tests factorization of a prime that can be factorized. 2, 7, 37, 97.
//     */
//    @Test
//    void testFactorize2() {
//        int[] actual = factorizer100.computePrimeFactorization(2);
//        int[] expected = new int[]{2};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testFactorize7() {
//        int[] actual = factorizer100.computePrimeFactorization(7);
//        int[] expected = new int[]{7};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testFactorize37() {
//        int[] actual = factorizer100.computePrimeFactorization(37);
//        int[] expected = new int[]{37};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testFactorize97() {
//        int[] actual = factorizer100.computePrimeFactorization(97);
//        int[] expected = new int[]{97};
//        assertArrayEquals(expected, actual);
//    }
//
//    /**
//     *  Tests factorization of a non-prime that can be factorized.
//     */
//
//    @Test
//    void testFactorizeComposite4() {
//        int[] actual = factorizer100.computePrimeFactorization(4);
//        int[] expected = new int[]{2, 2};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testFactorizeComposite35() {
//        int[] actual = factorizer100.computePrimeFactorization(35);
//        int[] expected = new int[]{5, 7};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testFactorizeComposite84() {
//        int[] actual = factorizer100.computePrimeFactorization(84);
//        int[] expected = new int[]{2, 2, 3, 7};
//        assertArrayEquals(expected, actual);
//    }
//
//    /**
//     *  Tests factorization that includes more than one distinct prime.
//     */
//
//    @Test
//    void testFactorizeMultiDistinct14() {
//        int[] actual = factorizer100.computePrimeFactorization(14);
//        int[] expected = new int[]{2, 7};
//        assertArrayEquals(expected, actual);
//    }
//
//    /**
//     *  Tests factorization that includes repeats.
//     */
//
//    @Test
//    void testFactorizeRepeats24() {
//        int[] actual = factorizer100.computePrimeFactorization(24);
//        int[] expected = new int[]{2, 2, 2, 3};
//        assertArrayEquals(expected, actual);
//    }
//
//    /**
//     *  Tests factorization with a prime input too large to be factorized.
//     */
//
//    @Test
//    void testFactorizePrimeOverMax() {
//        int[] actual = factorizer100.computePrimeFactorization(151);
//        assertNull(actual);
//    }
//
//    /**
//     *  Tests factorization with a non-prime input too large to be factorized.
//     */
//
//    @Test
//    void testFactorizeOverMax() {
//        int[] actual = factorizer100.computePrimeFactorization(200);
//        assertNull(actual);
//    }
//
//    /**
//     *  Tests factorization with a prime input too large to be factorized.
//     */
//
//    @Test
//    void testFactorizePrimeVeryOverMax() {
//        int[] actual = factorizer100.computePrimeFactorization(10271);
//        assertNull(actual);
//    }
//
//    /**
//     *  Tests factorization with a non-prime input way too large to be factorized.
//     */
//
//    @Test
//    void testFactorizeVeryOverMax() {
//        int[] actual = factorizer100.computePrimeFactorization(20000);
//        assertNull(actual);
//    }
//
//
//    private static PrimeFactorizer factorizer100000 = new PrimeFactorizer(100000);
//
//    /**
//     * Tests factorization of a prime that can be factorized.
//     */
//    @Test
//    void testFactorizePrimeVeryLargeNumber() {
//        int[] actual = factorizer100000.computePrimeFactorization(1427);
//        int[] expected = new int[]{1427};
//        assertArrayEquals(expected, actual);
//    }
//
//    /**
//     * Tests factorization of a composite that can be factorized.
//     */
//    @Test
//    void testFactorizeCompositeVeryLargeNumber() {
//        int[] actual = factorizer100000.computePrimeFactorization(1833);
//        int[] expected = new int[]{3, 13, 47};
//        assertArrayEquals(expected, actual);
//    }
//}