public class Chinchilla extends BasicAnimal {

    /**
     * Creates a profile for an adoptable pet-chinchilla-to-be
     *
     * @param name          the name of the chinchilla with no title(s) nor
     *                      credential(s)
     * @param age           the age of the chinchilla in months
     * @param currentWeight the current weight of the chinchilla in grams
     * @param whereabouts   the last known location of the chinchilla as a 2D coordinate
     */
    public Chinchilla(String name, Double age, Double currentWeight, Coord whereabouts) {
        super(name, age, currentWeight, whereabouts);
    }

    /**
     * Calculates the difference between this adoptable pet-chinchilla-to-be's current weight
     * and the target weight for it's species
     *
     * @return the magnitude (non-negative) value of the difference
     */
    @Override
    public Double deltaWeight() {
        double targetWeight = ((BasicZone)this.zone).avgWeight();
        return Adoptable.weightRound(Math.abs(this.currentWeight - targetWeight), 2);
    }
}