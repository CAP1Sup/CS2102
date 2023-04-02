import java.util.LinkedList;

public abstract class BasicZone implements IZone {

    private String baseMarque;
    private String[] foodStoreNames;
    private int[] foodStoreQuantities;
    private LinkedList<BasicAnimal> animals = new LinkedList<BasicAnimal>();

    /**
     * Creates a new zone with the given base marquee and food store names
     * @param baseMarque Base marquee for the zone
     * @param foodStoreNames Names of the food stores in the zone
     */
    public BasicZone(String baseMarque, String[] foodStoreNames) {
        this.baseMarque = baseMarque;
        this.foodStoreNames = foodStoreNames;
        foodStoreQuantities = new int[foodStoreNames.length];
    }

    /**
     * Adds a new adoptable pet-to-be to the zone
     * @param animal the adoptable pet-to-be to add
     * @return this zone
     */
    public IZone registerAnimal(BasicAnimal animal) {
        animal.zone = this;
        animals.add(animal);
        return this;
    }

    /**
     * Calculates the total number of adoptable pets-to-be in the zone that are >= 0
     * and <= 12 months old
     *
     * @return the calculated total
     */
    public int totalYoungins() {
        int sum = 0;
        for (BasicAnimal animal : animals) {
            if (animal.age >= 0) {
                if (animal.age <= 12) {
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
     * Calculates the average age of the adoptable pets-to-be in the zone.
     *
     * @return the average age
     */
    public double averageAge() {
        if (animals.isEmpty()) {
            return 0.0;
        }
        double ageSum = 0;
        for (BasicAnimal animal : animals) {
            ageSum += animal.age;
        }
        return (ageSum / (double) animals.size());
    }

    /**
     * Changes the feed stores of the zone,
     * Generates a string label for the zone pantry marquee
     *
     * @param food     the type of food being added
     * @param quantity the amount of food being added or subtracted
     * @return a string of the form "Species: # unit of food-type | ..."
     *         where # is either a number or the text "unknown" if the amount is
     *         currently < 0
     */
    public String changeFeed(String food, Integer quantity) {
        foodStoreQuantities[findFeedIndex(food)] += quantity;
        return String.format(baseMarque, (Object[]) quantitiesToStrings());
    }

    /**
     * Finds the index corresponding to the name of the food
     *
     * @param food Name of food
     * @return The index associated (null if not found)
     */
    private Integer findFeedIndex(String food) {
        if (foodStoreNames.length == 1) {
            return 0;
        }
        for (int nameIndex = 0; nameIndex < foodStoreNames.length; nameIndex++) {
            if (foodStoreNames[nameIndex].equals(food)) {
                return nameIndex;
            }
        }
        return null;
    }

    /**
     * Returns a list of food quantities (converts negative quantities to "unknown")
     *
     * @return Food quantities
     */
    private String[] quantitiesToStrings() {
        String[] output = new String[foodStoreQuantities.length];
        for (int index = 0; index < foodStoreQuantities.length; index++) {
            if (foodStoreQuantities[index] >= 0) {
                output[index] = Integer.toString(foodStoreQuantities[index]);
            } else {
                output[index] = "unknown";
            }
        }
        return output;
    }

    /**
     * Using the last known sensor data for an animal, finds the closest
     * animal to some location
     *
     * @param location the 2D top-down coordinate we are searching near
     * @return The data profile of the adoptable last-seen nearest to that
     *         coordinate or null if the zone is empty
     *         If two animals are equal distances from a coord, produce the one
     *         added to the zone latest.
     */
    @Override
    public Adoptable closestTo(Coord location) {
        if (animals.isEmpty()) {
            return null;
        }
        double smallestDist = Double.MAX_VALUE;
        Adoptable closestAnimal = null;
        for (int index = 0; index < animals.size(); index++) {
            double dist = animals.get(index).whereabouts.distanceTo(location);
            if (dist <= smallestDist) {
                smallestDist = dist;
                closestAnimal = animals.get(index);
            }
        }
        return closestAnimal;
    }

    /**
     * Find the adoptable pets-to-be in the zone that are strictly over or under
     * weight
     *
     * @param threshold a threshold of how over or under weight each adoptable
     *                  pet-to-be can be
     * @return The list of adoptable animals that are currently beyond (> or <) the
     *         threshold of their target weight
     */
    @Override
    public LinkedList<Adoptable> weighIn(Double threshold) {
        LinkedList<Adoptable> output = new LinkedList<Adoptable>();
        for (Adoptable animal : animals) {
            if (animal.deltaWeight() > threshold) {
                output.add(animal);
            }
        }
        return output;
    }

    /**
     * Computes the average weight of all animals in the zone.
     *
     * @return Average weight in grams
     */
    public double avgWeight() {
        double sum = 0;
        for (BasicAnimal animal : animals) {
            sum += animal.currentWeight;
        }
        return (sum / (double) animals.size());
    }
}
