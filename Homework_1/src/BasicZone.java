import java.util.LinkedList;

public abstract class BasicZone implements IZone {

    private String baseMarque;
    private String[] foodStoreNames;
    private int[] foodStoreQuantities;
    LinkedList<BasicAnimal> animals = new LinkedList<BasicAnimal>();

    public BasicZone(String baseMarque, String[] foodStoreNames) {
        this.baseMarque = baseMarque;
        this.foodStoreNames = foodStoreNames;
        foodStoreQuantities = new int[foodStoreNames.length];
    }

    public IZone registerAnimal(BasicAnimal animal) {
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
        if (animals.size() < 1) {
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
     * @param quantity the amount of food being added or subtracked
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
}
