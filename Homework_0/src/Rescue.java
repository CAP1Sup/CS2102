import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class Rescue {

    // Listed titles for checking titling
    static String listedTitles[] = { "Prince", "Princess", "Duke", "Dutchess", "Baron", "Baroness", "Count", "Countess",
            "Judge" };

    /**
     * Returns the total number of kittens across all litters.
     * Any litters with a value of less than 0 are not considered
     *
     * @param litters List of number of cats in each litter
     * @return The sum of all kittens across the litters
     */
    public static int totalKittens(int[] litters) {
        int sum = 0;
        for (int cats : litters) {
            if (cats > 0) {
                sum += cats;
            }
        }
        return sum;
    }

    /**
     * Returns the average age from a list of puppy ages
     * Ages less than 0 are assumed to be 0
     *
     * @param puppyAges List of ages of various puppies
     * @return The average age of all of the puppies
     */
    public static double averagePuppyAge(double[] puppyAges) {
        double sum = 0;

        // Only add ages to sum if they are greater than 0
        for (double age : puppyAges) {
            if (age > 0) {
                sum += age;
            }
        }

        // Return sum if list isn't empty, otherwise 0
        if (puppyAges.length > 0) {
            return sum / puppyAges.length;
        } else {
            return 0;
        }
    }

    /**
     * Checks if an animal's name is honorably titled (has both title and
     * credential)
     *
     * @param name Name of animal
     * @return If the animal is honorably titled
     */
    public static boolean honorablyTitled(String name) {
        if (hasListedTitle(name) || hasPeriodTitle(name)) {
            if (hasCredentials(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the name has one of the provided titles
     *
     * @param name Name of animal
     * @return If the animal's name has a listed title
     */
    private static boolean hasListedTitle(String name) {
        for (String title : listedTitles) {
            if (name.contains(title)) {
                if (name.indexOf(title) < name.indexOf(" ")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the name has a title which uses a period (such as Dr.)
     * Titles with periods should have the period within the first 5 characters
     *
     * @param name Name of animal
     * @return If the animal's name has a title using a period
     */
    private static boolean hasPeriodTitle(String name) {

        // Find the first index of a period in the name (-1 if none)
        int periodIndex = name.indexOf(".");

        // If the name has a period title, then it must contain a period
        // The period must also be within the first 5 characters
        return (periodIndex != -1 && periodIndex < 5);
    }

    /**
     * Checks if a name has credentials
     * Credentials will always use a comma
     * A comma will never exist unless the name has a credential
     *
     * @param name Name of animal
     * @return If the animal's name has credentials
     */
    private static boolean hasCredentials(String name) {
        // If a name contains a comma, it must have a credential
        // Check that the credential is at the end of the name
        // Done by checking if the comma and space are the last space in the name
        if (name.contains(",")) {
            if ((name.indexOf(", ") + 1) == name.lastIndexOf(" ")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Concatenates pellet, hay, and dried fruit counts into single, labelled string
     *
     * @param pellets Pounds of pellets
     * @param hay     Ounces of hay
     * @param fruit   Units of dried fruit
     * @return Concatenated string
     */
    public static String chinchillaFeed(int pellets, int hay, int fruit) {
        return String.format("Chinchilla: %s lbs. of pellets | %s oz. of hay | %s units of dried fruit",
                convertCountToString(pellets),
                convertCountToString(hay),
                convertCountToString(fruit));
    }

    /**
     * Coverts a count of objects to a string
     * Any counts less than 0 are converted to "unknown"
     *
     * @param count Number of objects
     * @return String form of count
     */
    private static String convertCountToString(int count) {
        if (count < 0) {
            return "unknown";
        }
        return String.valueOf(count);
    }

    /**
     * Returns the closest cat to the given location
     * X and Y can be negative
     * With an empty list, null is returned
     * In the case of a tie, the coords that appear later will be returned
     *
     * @param catCoords List of cat coords
     * @param location  Coordinates of given location
     * @return The closest cat's coordinates
     */
    public static Coord heardingCats(LinkedList<Coord> catCoords, Coord location) {
        if (catCoords.size() == 0) {
            return null;
        }
        double lowestDistance = Double.MAX_VALUE;
        Coord lowestCatsCoord = new Coord(0, 0);
        for (int index = 0; index < catCoords.size(); index++) {
            double catsDistance = catDistance(catCoords.get(index), location);
            if (catsDistance <= lowestDistance) {
                lowestDistance = catsDistance;
                lowestCatsCoord = catCoords.get(index);
            }
        }
        return lowestCatsCoord;
    }

    /**
     * Returns the distance between a cat and a location
     *
     * @param cat      Cat's coordinates
     * @param location Location's coordinates
     * @return Distance between them
     */
    private static double catDistance(Coord cat, Coord location) {
        return Math.sqrt(Math.pow(cat.x - location.x, 2) + Math.pow(cat.y - location.y, 2));
    }

    /**
     * Returns the number of goats that are exclusively outside of the target weight
     * error
     * tolerance
     * Any goats with current or target weights <= 0 are ignored
     * If lists are of different lengths, the shorter list is used
     * All units are in grams
     *
     * @param currentWeights List of current weights
     * @param targetWeights  List of target weights
     * @param errorTolerance Allowable weight tolerance
     * @return Number of goats outside of error tolerance
     */
    public static int goatBloat(ArrayList<Double> currentWeights, ArrayList<Double> targetWeights,
            double errorTolerance) {
        int shortestListLen;
        if (currentWeights.size() < targetWeights.size()) {
            shortestListLen = currentWeights.size();
        } else {
            shortestListLen = targetWeights.size();
        }

        int bloatedGoatSum = 0;
        for (int goatNum = 0; goatNum < shortestListLen; goatNum++) {
            if (currentWeights.get(goatNum) > 0) {
                if (targetWeights.get(goatNum) > 0) {
                    if (goatBloated(currentWeights.get(goatNum), targetWeights.get(goatNum), errorTolerance)) {
                        bloatedGoatSum++;
                    }
                }
            }
        }
        return bloatedGoatSum;
    }

    /**
     * Returns if a goat is bloated
     * Goats are bloated when their current weight is over or under the target
     * weight by more than the tolerance
     *
     * @param currentWeight  Goat's current weight
     * @param targetWeight   Goat's target weight
     * @param errorTolerance Tolerance for making weight
     * @return If goat is bloated
     */
    private static boolean goatBloated(double currentWeight, double targetWeight, double errorTolerance) {
        return (Math.abs(currentWeight - targetWeight) > errorTolerance);
    }
}
