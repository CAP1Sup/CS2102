import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyRatingStorage implements RatingStorage {

    private LinkedList<DailyRatings> dailyRatings = new LinkedList<DailyRatings>();

    /**
     * Finds the best rank across all platforms in the given month. Returns
     * Integer.MAX_VALUE if no ranks exist for this month
     *
     * @return The best (lowest) rank this month
     */
    @Override
    public int bestMonthlyRank(GregorianCalendar month) {
        int lowestRank = Integer.MAX_VALUE;
        // Start from the end of the list, which will have the most recent data
        for (int ratingIndex = dailyRatings.size() - 1; ratingIndex >= 0; ratingIndex--) {

            // Break the for loop if we've exceed this month's ratings
            if (!sameMonth(dailyRatings.get(ratingIndex).getDate(), month)) {
                break;
            }

            // Check the if the day has a lower rank
            for (Integer rank : dailyRatings.get(ratingIndex).getRanks()) {
                if (rank < lowestRank) {
                    lowestRank = rank;
                }
            }
        }
        return lowestRank;
    }

    /**
     * Returns the total number of subscribers gained across all platforms in the
     * given month and year. 0 is returned if data doesn't exist for given month
     *
     * @param month Month number subscriptions occurred in, starting at 0
     * @param year  Year subscriptions occurred
     * @return The total number of subscribers gained over the given month
     */
    @Override
    public int totalSubs(GregorianCalendar targetMonth) {
        int startingIndex = 0;

        // Loop through until the starting index of the month is found
        while (startingIndex < dailyRatings.size()) {
            if (sameMonth(dailyRatings.get(startingIndex).getDate(), targetMonth)) {
                break;
            }
            startingIndex++;
        }

        // Starting index wasn't found, return 0
        if (startingIndex >= dailyRatings.size()) {
            return 0;
        }

        int totalSubscribers = 0;

        // Loop through and add the subscribers
        while (startingIndex < dailyRatings.size()) {
            if (!sameMonth(dailyRatings.get(startingIndex).getDate(), targetMonth)) {
                break;
            }
            for (Integer subs : dailyRatings.get(startingIndex).getSubs()) {
                totalSubscribers += subs;
            }
            startingIndex++;
        }

        return totalSubscribers;
    }

    /**
     * Adds analytics from different platforms for a given day. Day is incremented
     * with each call
     *
     * @param analytics List of analytics from different platforms
     */
    @Override
    public void addAnalytics(GregorianCalendar today, LinkedList<Analytics> analytics) {
        LinkedList<Integer> ranks = new LinkedList<Integer>();
        LinkedList<Integer> subs = new LinkedList<Integer>();
        for (Analytics analytic : analytics) {
            ranks.add(analytic.getRank());
            subs.add(analytic.getSubs());
        }
        dailyRatings.add(new DailyRatings((GregorianCalendar) today.clone(), ranks, subs));
    }

    /**
     * Checks if the calendars have the same month and year
     *
     * @param calendar      First calendar to compare
     * @param otherCalendar Second calender to compare
     * @return If the first calendar and second calendar share the same month and
     *         year
     */
    private boolean sameMonth(GregorianCalendar calendar, GregorianCalendar otherCalendar) {
        if (calendar.get(GregorianCalendar.YEAR) == otherCalendar.get(GregorianCalendar.YEAR)) {
            if (calendar.get(GregorianCalendar.MONTH) == otherCalendar.get(GregorianCalendar.MONTH)) {
                return true;
            }
        }
        return false;
    }
}
