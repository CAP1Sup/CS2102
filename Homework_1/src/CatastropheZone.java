public class CatastropheZone extends BasicZone {

    public CatastropheZone() {
        super("Cat: %s lbs. of dry food | %s cans of wet food", new String[] { "dry", "wet" });
    }

    /**
     * Adds a new cat to the zone
     *
     * @param name          Name of the cat
     * @param age           Age of the cat
     * @param currentWeight Cat's current weight
     * @param whereabouts   Coordinates of the cat
     * @return This zone
     */
    @Override
    public IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        return registerAnimal(new Cat(name, age, currentWeight, whereabouts));
    }
}
