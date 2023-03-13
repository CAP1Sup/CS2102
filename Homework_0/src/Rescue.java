import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class Rescue {

    /////////////
    // Autograded

    public static int totalKittens(int[] litters) {
        int sum = 0;
        for (int cats : litters) {
            if (cats > 0) {
                sum += cats;
            }
        }
        return sum;
    }

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

    public static boolean honorablyTitled(String name) {
        // Delete and replace with your code:
        throw new RuntimeException("HW Not Implemented");
    }

    public static String chinchillaFeed(int pellets, int hay, int fruit) {
        // Delete and replace with your code:
        throw new RuntimeException("HW Not Implemented");
    }

    public static Coord heardingCats(LinkedList<Coord> catCoords, Coord location) {
        // Delete and replace with your code:
        throw new RuntimeException("HW Not Implemented");
    }

    public static int goatBloat(ArrayList<Double> currentWeights, ArrayList<Double> targetWeights,
            double errorTolerance) {
        // Delete and replace with your code:
        throw new RuntimeException("HW Not Implemented");
    }

    /////////////
    // Design
    // get Min and Max temps from a double[][]

}
