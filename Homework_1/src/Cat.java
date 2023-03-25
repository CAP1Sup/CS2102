public class Cat extends BasicAnimal {

    /**
     * Creates a profile for an adoptable pet-cat-to-be
     *
     * @param name          the name of the cat with no title(s) nor
     *                      credential(s)
     * @param age           the age of the cat in months
     * @param currentWeight the current weight of the cat in grams
     * @param whereabouts   the last known location of the cat as a 2D coordinate
     */
    public Cat(String name, Double age, Double currentWeight, Coord whereabouts) {
        super(name, age, currentWeight, whereabouts);
    }

    /**
     * Calculates the difference between this adoptable pet-cat-to-be's current weight
     * and the target weight for it's species
     *
     * @return the magnitude (non-negative) value of the difference
     */
    @Override
    public Double deltaWeight() {
        if (this.age < 24) {
            return 0.0d;
        }
        return Adoptable.weightRound(Math.abs(this.currentWeight - 4500.0), 2);
    }
}
