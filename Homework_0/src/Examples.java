import org.junit.Assert; // make sure to use junit 4!!!
import org.junit.Test;

import static org.junit.Assert.*;

public class Examples {

    // It's better form to have 1 assert per test, but here are a few
    @Test
    public void testTotalKittensPos() {
        int[] positiveTestData = { 1, 2, 3, 4 };
        assertEquals("Failed total with positives", 10, Rescue.totalKittens(positiveTestData));
    }

    @Test
    public void testTotalKittensZeroNeg() {
        int[] zeroNegTestData = { -1, 0, 2, -1 };
        assertEquals("Failed total with zeroes and negatives", 2, Rescue.totalKittens(zeroNegTestData));
    }

    @Test
    public void testTotalKittensEmpty() {
        int[] emptyArray = {};
        assertEquals("Failed total with empty array", 0, Rescue.totalKittens(emptyArray));
    }

    @Test
    public void testAvgPuppyAgePos() {
        double[] positiveTestData = { 1, 2, 3, 4 };
        assertEquals("Failed avg with positives", 2.5d, Rescue.averagePuppyAge(positiveTestData), 0.01d);
    }

    @Test
    public void testAvgPuppyAgeZeroNeg() {
        double[] zeroNegTestData = { -1, 0, 4, -1 };
        assertEquals("Failed avg with zeroes and negatives", 1d, Rescue.averagePuppyAge(zeroNegTestData), 0.01d);
    }

    @Test
    public void testAvgPuppyAgeEmpty() {
        double[] emptyArray = {};
        assertEquals("Failed avg with empty array", 0d, Rescue.averagePuppyAge(emptyArray), 0.01d);
    }
}
