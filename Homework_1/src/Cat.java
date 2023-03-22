public class Cat extends BasicAnimal {

    /**
     * Creates a profile for an adoptable pet-cat-to-be
     *
     * @param name          the name of the animal with no title(s) nor
     *                      credential(s)
     * @param age           the age of the pet in months
     * @param currentWeight the current weight of the pet in grams
     * @param whereabouts   the last known location of the pet as a 2D coordinate
     */
    public Cat(String name, Double age, Double currentWeight, Coord whereabouts) {
        super(name, age, currentWeight, whereabouts);
    }

    @Override
    public Double deltaWeight() {
        if (this.age < 24) {
            return 0.0d;
        }
        return (this.currentWeight - 4500);
    }
}
