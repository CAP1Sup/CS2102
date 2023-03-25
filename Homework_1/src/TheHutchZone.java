public class TheHutchZone extends BasicZone {

    public TheHutchZone() {
        super("Chinchilla: %s lbs. of pellets | %s oz. of hay | %s units of dried fruit",
                new String[] { "pellets", "hay", "fruit" });
    }

    /**
     * Adds a new chinchilla to the zone
     *
     * @param name          Name of the chinchilla
     * @param age           Age of the chinchilla
     * @param currentWeight Chinchilla's current weight
     * @param whereabouts   Coordinates of the chinchilla
     * @return This zone
     */
    @Override
    public IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        return registerAnimal(new Chinchilla(name, age, currentWeight, whereabouts));
    }
}
