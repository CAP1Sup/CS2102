import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A prototypical class that describes an adoptable pet-to-be
 */
public abstract class Adoptable {
    /**
     * The name of this pet-to-be (including title and credential)
     */
    protected String name;
    /**
     * The age of this pet-to-be in months
     */
    public Double age;
    /**
     * the current weight of this pet-to-be in grams
     */
    public Double currentWeight;
    /**
     * The last sensed 2D coordinate of this pet-to-be
     */
    public Coord whereabouts;
    /**
     * The zone this pet-to-be has been added to.
     * May be null until the pet-to-be is added to a zone
     */
    public IZone zone;

    /**
     * Creates a profile for an adoptable pet-to-be
     *
     * @param name          the name of the animal with no title(s) nor
     *                      credential(s)
     * @param age           the age of the pet in months
     * @param currentWeight the current weight of the pet in grams
     * @param whereabouts   the last known location of the pet as a 2D coordinate
     */
    public Adoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        this.name = name;
        this.age = age <= 0.0d ? 0.0d : age;
        this.currentWeight = currentWeight <= 0.0d ? 0.0d : currentWeight;
        this.whereabouts = whereabouts;
    }

    /**
     * Calculates the difference between this adoptable pet-to-be's current weight
     * and the target weight for it's species
     *
     * @return the magnitude (non-negative) value of the difference
     */
    public abstract Double deltaWeight();

    /**
     * Constructs a name from the adoptable pet-to-be's base name and their title
     * and credentials
     *
     * @return the full name of the pet in "title name, cred" format.
     */
    public abstract String getName();

    /**
     * Determines whether the current pet's name has a title and a credential
     *
     * @return true if the name is both titled and credentialed.
     */
    public abstract Boolean honorablyTitled();

    /**
     * Takes a title and adds it to the adoptable pet's name
     * If the adoptable already has a title, it should replace the old title with a
     * new one
     *
     * @param title the title to bestow
     */
    public abstract void bestowTitle(String title);

    /**
     * Takes a credential and adds it to the end of the adoptable pet's name after a
     * ","
     * If the name already has a credential, add this credential after the current
     * one(s) space separated
     *
     * @param credential the credential to add
     */
    public abstract void bestowCredential(String credential);

    public static double weightRound(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
