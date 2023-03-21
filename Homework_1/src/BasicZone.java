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

    public void registerAnimal(BasicAnimal animal) {
        animals.add(animal);
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
        double ageSum = 0;
        for (BasicAnimal animal : animals) {
            ageSum += animal.age;
        }
        return (ageSum / (double) animals.size());
    }

    /*
     * TODO: COMPLETE MESS, NOT DONE YET
     * public String changeFeed(String food, Integer quantity) {
     *
     * return String.format(baseMarque, foodStoreQuantities);
     * }
     *
     * private void changeFeedBy(String food, Integer quantity) {
     * for (String name : foodStoreNames) {
     * if (name.equals(food)) {
     *
     * }
     * }
     * }
     */
}
