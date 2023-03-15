import static org.junit.Assert.*; // make sure to use junit 4!!!
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author @CAP1Sup
 * Note: These test cases were written with help from GitHub Co-Pilot
 */

public class Examples {

    // Listed titles for checking titling
    static String listedTitles[] = { "Prince", "Princess", "Duke", "Dutchess", "Baron", "Baroness", "Count", "Countess",
    "Judge" };

    // Total Kittens Method Tests
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

    // Average Puppy Age Method Tests
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

    // Honorably Titled Method Tests
    @Test
    public void testHonorablyTitledFalseListedTitle() {
        assertFalse("Detected false listed title", Rescue.honorablyTitled("Title Fluffykins, MD"));
    }

    @Test
    public void testHonorablyTitledFalsePeriodTitle() {
        assertFalse("Detected false period title", Rescue.honorablyTitled("Fluffykins, Esq."));
    }

    @Test
    public void testHonorablyTitledFalseNoCredentialsListedTitle() {
        assertFalse("Detected false credentials", Rescue.honorablyTitled("Judge Fluffykins"));
    }

    @Test
    public void testHonorablyTitledFalseNoCredentialsPeriodTitle() {
        assertFalse("Detected false credentials", Rescue.honorablyTitled("Mr. Fluffykins"));
    }

    @Test
    public void testHonorablyTitledTrueAllListedTitles() {
        for (String title : listedTitles) {
            assertTrue(String.format("Detected false listed title: %s", title), Rescue.honorablyTitled(title + " Fluffykins, MD"));
        }
    }

    @Test
    public void testHonorablyTitledFalseOutOfOrderListedTitle() {
        assertFalse("Produced true on out of order listed title with good credentials", Rescue.honorablyTitled("Fluffykins Judge, MD"));
    }

    @Test
    public void testHonorablyTitledFalseOutOfOrderPeriodTitle() {
        assertFalse("Produced true on out of order period title with good credentials", Rescue.honorablyTitled("Fluffykins Dr., MD"));
    }

    @Test
    public void testHonorablyTitledFalseOutOfOrderCredentialsListedTitle() {
        assertFalse("Produced true on out of order credentials with listed title", Rescue.honorablyTitled("Judge, MD Fluffykins"));
    }

    @Test
    public void testHonorablyTitledFalseOutOfOrderCredentialsPeriodTitle() {
        assertFalse("Produced true on out of order credentials with listed title", Rescue.honorablyTitled("Dr., MD Fluffykins"));
    }

    @Test
    public void testHonorablyTitledTrueListedTitle() {
        assertTrue("Returned false on both given title and credentials", Rescue.honorablyTitled("Count Fluffykins, Esq."));
    }

    @Test
    public void testHonorablyTitledTruePeriodTitle() {
        assertTrue("Returned false on both period title and credentials", Rescue.honorablyTitled("Dr. Fluffykins, Esq."));
    }

    // Chinchilla Feed Method Tests
    @Test
    public void testChinchillaFeedWithGoodNums() {
        assertEquals("String formatting incorrect",
                "Chinchilla: 4 lbs. of pellets | 13 oz. of hay | 22 units of dried fruit",
                Rescue.chinchillaFeed(4, 13, 22));
    }

    @Test
    public void testChinchillaFeedWithNegativePellets() {
        assertEquals("Negative pellet count produces incorrect string printout",
                "Chinchilla: unknown lbs. of pellets | 13 oz. of hay | 22 units of dried fruit",
                Rescue.chinchillaFeed(-1, 13, 22));
    }

    @Test
    public void testChinchillaFeedWithNegativeHay() {
        assertEquals("Negative hay count produces incorrect string printout",
                "Chinchilla: 5 lbs. of pellets | unknown oz. of hay | 10 units of dried fruit",
                Rescue.chinchillaFeed(5, -1, 10));
    }

    @Test
    public void testChinchillaFeedWithNegativeDriedFruit() {
        assertEquals("Negative dried fruit count produces incorrect string printout",
                "Chinchilla: 7 lbs. of pellets | 12 oz. of hay | unknown units of dried fruit",
                Rescue.chinchillaFeed(7, 12, -1));
    }

    // Hearding Cats Method Tests
    @Test
    public void testHeardingCatsWithAllPositives() {
        LinkedList<Coord> testData = new LinkedList<Coord>(
                Arrays.asList(new Coord(1, 1), new Coord(10, 2), new Coord(6, 3)));
        Coord testCoord = new Coord(2, 3);
        assertEquals("Failed X with positive coords", 1, Rescue.heardingCats(testData, testCoord).x);
        assertEquals("Failed Y with positive coords", 1, Rescue.heardingCats(testData, testCoord).y);
    }

    @Test
    public void testHeardingCatsWithClosestX() {
        LinkedList<Coord> testData = new LinkedList<Coord>(
                Arrays.asList(new Coord(1, 1), new Coord(10, 2), new Coord(6, 20)));
        Coord testCoord = new Coord(10, 15);
        assertEquals("Failed X with closest X", 6, Rescue.heardingCats(testData, testCoord).x);
        assertEquals("Failed Y with closest X", 20, Rescue.heardingCats(testData, testCoord).y);
    }

    @Test
    public void testHeardingCatsWithClosestY() {
        LinkedList<Coord> testData = new LinkedList<Coord>(
                Arrays.asList(new Coord(1, 1), new Coord(10, 2), new Coord(6, 20)));
        Coord testCoord = new Coord(7, 3);
        assertEquals("Failed X with closest Y", 10, Rescue.heardingCats(testData, testCoord).x);
        assertEquals("Failed Y with closest Y", 2, Rescue.heardingCats(testData, testCoord).y);
    }

    @Test
    public void testHeardingCatsWithSameDistance() {
        LinkedList<Coord> testData = new LinkedList<Coord>(
                Arrays.asList(new Coord(2, 2), new Coord(10, 2), new Coord(6, 20)));
        Coord testCoord = new Coord(6, 1);
        assertEquals("Failed X with same distance", 10, Rescue.heardingCats(testData, testCoord).x);
        assertEquals("Failed Y with same distance", 2, Rescue.heardingCats(testData, testCoord).y);
    }

    @Test
    public void testHeardingCatsWithSomeNegatives() {
        LinkedList<Coord> testData = new LinkedList<Coord>(
                Arrays.asList(new Coord(-10, 1), new Coord(10, 2), new Coord(6, 3)));
        Coord testCoord = new Coord(10, 1);
        assertEquals("Failed X with some negative coords", 10, Rescue.heardingCats(testData, testCoord).x);
        assertEquals("Failed Y with some negative coords", 2, Rescue.heardingCats(testData, testCoord).y);
    }

    @Test
    public void testHeardingCatsWithEmptyList() {
        LinkedList<Coord> testData = new LinkedList<Coord>();
        assertEquals("Failed with empty list", null, Rescue.heardingCats(testData, new Coord(10, 1)));
    }

    // Goat Bloated Method Tests
    @Test
    public void testGoatBloatedWithNoBloats() {
        ArrayList<Double> currentWeights = new ArrayList<Double>(Arrays.asList(15.0, 20.0, 25.0));
        ArrayList<Double> targetWeights = new ArrayList<Double>(Arrays.asList(20.0, 25.0, 30.0));
        double allowedError = 10.0;
        assertEquals("Failed with no bloat case", 0, Rescue.goatBloat(currentWeights, targetWeights, allowedError));
    }

    @Test
    public void testGoatBloatedWithErrorExclusivity() {
        ArrayList<Double> currentWeights = new ArrayList<Double>(Arrays.asList(10.0));
        ArrayList<Double> targetWeights = new ArrayList<Double>(Arrays.asList(20.0));
        double allowedError = 10.0;
        assertEquals("Failed with exclusivity case", 0, Rescue.goatBloat(currentWeights, targetWeights, allowedError));
    }

    @Test
    public void testGoatBloatedWithUnderWeight() {
        ArrayList<Double> currentWeights = new ArrayList<Double>(Arrays.asList(10.0));
        ArrayList<Double> targetWeights = new ArrayList<Double>(Arrays.asList(20.0));
        double allowedError = 5.0;
        assertEquals("Failed with underweight case", 1, Rescue.goatBloat(currentWeights, targetWeights, allowedError));
    }

    @Test
    public void testGoatBloatedWithOverWeight() {
        ArrayList<Double> currentWeights = new ArrayList<Double>(Arrays.asList(20.0));
        ArrayList<Double> targetWeights = new ArrayList<Double>(Arrays.asList(10.0));
        double allowedError = 5.0;
        assertEquals("Failed with overweight case", 1, Rescue.goatBloat(currentWeights, targetWeights, allowedError));
    }

    @Test
    public void testGoatBloatedWithNegCurrentWeight() {
        ArrayList<Double> currentWeights = new ArrayList<Double>(Arrays.asList(-1.0));
        ArrayList<Double> targetWeights = new ArrayList<Double>(Arrays.asList(1.0));
        double allowedError = 10.0;
        assertEquals("Failed with negative current weight", 0, Rescue.goatBloat(currentWeights, targetWeights, allowedError));
    }

    @Test
    public void testGoatBloatedWithNegTargetWeight() {
        ArrayList<Double> currentWeights = new ArrayList<Double>(Arrays.asList(1.0));
        ArrayList<Double> targetWeights = new ArrayList<Double>(Arrays.asList(-1.0));
        double allowedError = 10.0;
        assertEquals("Failed with negative current weight", 0, Rescue.goatBloat(currentWeights, targetWeights, allowedError));
    }

    @Test
    public void testGoatBloatedWithLongerCurrentWeightList() {
        ArrayList<Double> currentWeights = new ArrayList<Double>(Arrays.asList(15.0, 10.0, 10.0, 30.0));
        ArrayList<Double> targetWeights = new ArrayList<Double>(Arrays.asList(15.0, 20.0, 10.0));
        double allowedError = 5.0;
        assertEquals("Failed uneven list test", 1, Rescue.goatBloat(currentWeights, targetWeights, allowedError));
    }

    @Test
    public void testGoatBloatedWithLongerTargetWeightList() {
        ArrayList<Double> currentWeights = new ArrayList<Double>(Arrays.asList(15.0, 10.0, 10.0));
        ArrayList<Double> targetWeights = new ArrayList<Double>(Arrays.asList(15.0, 20.0, 10.0, 30.0));
        double allowedError = 5.0;
        assertEquals("Failed uneven list test", 1, Rescue.goatBloat(currentWeights, targetWeights, allowedError));
    }
}
