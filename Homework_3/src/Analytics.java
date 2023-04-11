
public class Analytics {
    private final int rank;
    private final int subs;

    /**
     * Creates a new Analytics object, which contains two integer fields of the
     * streamer's rank and total number of subs
     */
    public Analytics(int rank, int subs) {
        this.rank = rank;
        this.subs = subs;
    }

    /**
     * Returns the streamer's rank, can be used in other classes since Analytics fields
     * are private
     *
     * @return Streamer's rank
     */
    public int getRank() {
        return this.rank;
    }

    /**
     * Returns the change in streamer's total number of subscribers, can be used in other classes
     * since Analytics fields are private
     *
     * @return Streamer's change in subscriptions
     */
    public int getSubs() {
        return this.subs;
    }
}
