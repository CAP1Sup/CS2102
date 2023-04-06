import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyRatings {
    private final GregorianCalendar date;
    private final LinkedList<Integer> ranks;
    private final LinkedList<Integer> subs;

    /**
     * Creates a new DailyRatings object
     *
     * @param date  The date of the ratings
     * @param ranks The ranks of the stream on each platform
     * @param subs  The number of subscribers gained on each platform
     */
    public DailyRatings(GregorianCalendar date, LinkedList<Integer> ranks, LinkedList<Integer> subs) {
        this.date = date;
        this.ranks = ranks;
        this.subs = subs;
    }

    /**
     * Returns a copy of the date of the ratings
     *
     * @return The date of the ratings
     */
    public GregorianCalendar getDate() {
        return (GregorianCalendar) this.date.clone();
    }

    /**
     * Returns a copy of the ranks of the stream on each platform
     *
     * @return The ranks of the stream on each platform
     */
    public LinkedList<Integer> getRanks() {
        LinkedList<Integer> copy = new LinkedList<Integer>();
        for (Integer rank : this.ranks) {
            copy.add(rank);
        }
        return copy;
    }

    /**
     * Returns a copy of the number of subscribers gained on each platform
     *
     * @return The number of subscribers gained on each platform
     */
    public LinkedList<Integer> getSubs() {
        LinkedList<Integer> copy = new LinkedList<Integer>();
        for (Integer subs : this.subs) {
            copy.add(subs);
        }
        return copy;
    }
}
