public class GoateryZone extends BasicZone {

    public GoateryZone() {
        super("Goat: %s piles of edible substance", new String[] { "" });
    }

    /**
     * Adds a new goat to the zone
     *
     * @param name          Name of the goat
     * @param age           Age of the goat
     * @param currentWeight Goat's current weight
     * @param whereabouts   Coordinates of the goat
     * @return This zone
     */
    @Override
    public IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        return registerAnimal(new Goat(name, age, currentWeight, whereabouts));
    }
}