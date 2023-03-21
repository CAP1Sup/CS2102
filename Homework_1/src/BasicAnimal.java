public abstract class BasicAnimal extends Adoptable {

    String title = "";
    String credentials;

    /**
     * Creates a profile for an adoptable pet-to-be
     *
     * @param name          the name of the animal with no title(s) nor
     *                      credential(s)
     * @param age           the age of the pet in months
     * @param currentWeight the current weight of the pet in grams
     * @param whereabouts   the last known location of the pet as a 2D coordinate
     */
    public BasicAnimal(String name, Double age, Double currentWeight, Coord whereabouts) {
        super(name, age, currentWeight, whereabouts);
    }

    /**
     * Constructs a name from the adoptable pet-to-be's base name and their title
     * and credentials
     *
     * @return the full name of the pet in "title name, cred" format.
     */
    @Override
    public String getName() {
        String result = name;
        if (!title.equals("")) {
            result = title.concat(" ").concat(result);
        }
        if (credentials != null) {
            result = result.concat(", ").concat(credentials);
        }
        return result;
    }

    /**
     * Determines whether the current pet's name has a title and a credential
     *
     * @return true if the name is both titled and credentialed.
     */
    @Override
    public Boolean honorablyTitled() {
        return !(title.equals("") || credentials == null);
    }

    /**
     * Takes a title and adds it to the adoptable pet's name
     * If the adoptable already has a title, it should replace the old title with a
     * new one
     *
     * @param title the title to bestow
     */
    @Override
    public void bestowTitle(String title) {
        this.title = title;
    }

    /**
     * Takes a credential and adds it to the end of the adoptable pet's name after a
     * ","
     * If the name already has a credential, add this credential after the current
     * one(s) space separated
     *
     * @param credential the credential to add
     */
    @Override
    public void bestowCredential(String credential) {
        if (credentials == null) {
            credentials = credential;
        } else {
            credentials.concat(" ").concat(credential);
        }
    }
}
