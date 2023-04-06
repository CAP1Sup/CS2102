
public class Analytics {
    private final int rank;
    private final int subs;

    /**
     * Creates a new Analytics object, which contains two integer fields of the
     * user's rank and total number of subs
     */
    public Analytics(int rank, int subs) {
        this.rank = rank;
        this.subs = subs;
    }

    /**
     * Returns the user's rank, can be used in other classes since Analytics fields
     * are private
     */
    public int getRank() {
        return this.rank;
    }

    /**
     * Returns the user's total number of subscribers, can be used in other classes
     * since Analytics fields are private
     */
    public int getSubs() {
        return this.subs;
    }
}
