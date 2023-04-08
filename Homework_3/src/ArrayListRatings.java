import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ArrayListRatings {
    private final GregorianCalendar date;
    private final ArrayList<Integer> ranks;
    private final ArrayList<Integer> subs;

    /**
     * Creates a new ArrayListRatings object
     *
     * @param date  The date of the ratings
     * @param ranks The ranks of the stream on each platform
     * @param subs  The number of subscribers gained on each platform
     */
    public ArrayListRatings(GregorianCalendar date, ArrayList<Integer> ranks, ArrayList<Integer> subs) {
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
    public ArrayList<Integer> getRanks() {
        ArrayList<Integer> copy = new ArrayList<Integer>();
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
    public ArrayList<Integer> getSubs() {
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for (Integer subs : this.subs) {
            copy.add(subs);
        }
        return copy;
    }
}
