
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Streamometer {
    private GregorianCalendar today;
    private RatingStorage ratingStorage;

    /**
     * Creates a new Streamometer
     *
     * @param today        The current date
     * @param dailyRatings A list of the current daily ratings
     */
    public Streamometer(GregorianCalendar today, RatingStorage ratingStorage) {
        this.today = (GregorianCalendar) today.clone();
        this.ratingStorage = ratingStorage;
    }

    /**
     * Finds the best rank across all platforms in the current month. Returns
     * Integer.MAX_VALUE if no ranks exist for this month
     *
     * @return The best (lowest) rank this month
     */
    public int bestRankThisMonth() {
        return ratingStorage.bestMonthlyRank(today);
    }

    /**
     * Returns the total number of subscribers gained across all platforms in the
     * given month and year. 0 is returned if data doesn't exist for given month
     *
     * @param month Month number subscriptions occurred in, starting at 0
     * @param year  Year subscriptions occurred
     * @return The total number of subscribers gained over the given month
     */
    public int totalSubscribers(int month, int year) {
        GregorianCalendar targetMonth = new GregorianCalendar(year, month, 1);
        return ratingStorage.totalSubs(targetMonth);
    }

    /**
     * Adds analytics from different platforms for a given day. Day is incremented
     * with each call
     *
     * @param analytics List of analytics from different platforms
     */
    public void addTodaysAnalytics(LinkedList<Analytics> analytics) {
        ratingStorage.addAnalytics(today, analytics);
        today.add(GregorianCalendar.DAY_OF_YEAR, 1);
    }

}
