public class Goat extends BasicAnimal {

    /**
     * Creates a profile for an adoptable pet-goat-to-be
     *
     * @param name          the name of the goat with no title(s) nor
     *                      credential(s)
     * @param age           the age of the goat in months
     * @param currentWeight the current weight of the goat in grams
     * @param whereabouts   the last known location of the goat as a 2D coordinate
     */
    public Goat(String name, Double age, Double currentWeight, Coord whereabouts) {
        super(name, age, currentWeight, whereabouts);
    }

    /**
     * Calculates the difference between this adoptable pet-goat-to-be's current weight
     * and the target weight for it's species
     *
     * @return the magnitude (non-negative) value of the difference
     */
    @Override
    public Double deltaWeight() {
        double targetWeight = 55000.0 + (Math.floor(this.age / 12) * 1000.0);
        return Adoptable.weightRound(Math.abs(this.currentWeight - targetWeight), 2);
    }
}
