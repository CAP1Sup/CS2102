import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface RatingStorage {
    /**
     * Finds the best rank across all platforms in the given month. Returns
     * Integer.MAX_VALUE if no ranks exist for this month
     *
     * @return The best (lowest) rank this month
     */
    public int bestMonthlyRank(GregorianCalendar month);

    /**
     * Returns the total number of subscribers gained across all platforms in the
     * given month and year. 0 is returned if data doesn't exist for given month
     *
     * @param month Month number subscriptions occurred in, starting at 0
     * @param year  Year subscriptions occurred
     * @return The total number of subscribers gained over the given month
     */
    public int totalSubs(GregorianCalendar targetMonth);

    /**
     * Adds analytics from different platforms for a given day. Day is incremented
     * with each call
     *
     * @param analytics List of analytics from different platforms
     */
    public void addAnalytics(GregorianCalendar today, LinkedList<Analytics> analytics);
}
