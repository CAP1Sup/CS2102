
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Streamometer {
    public GregorianCalendar today;
    public LinkedList<DailyRatings> dailyRatings;

    public Streamometer(GregorianCalendar today, LinkedList<DailyRatings> dailyRatings) {
        this.today = today;
        this.dailyRatings = dailyRatings;
    }

    /**
     * Finds the best rank across all platforms in the current month. Returns Integer.MAX_VALUE if no ranks exist for this month
     * @return The best (lowest) rank this month
     */
    public int bestRankThisMonth() {
        int lowestRank = Integer.MAX_VALUE;
        // Start from the end of the list, which will have the most recent data
        for (int ratingIndex = dailyRatings.size() - 1; ratingIndex >= 0; ratingIndex--) {

            // Break the for loop if we've exceed this month's ratings
            if (!sameMonth(dailyRatings.get(ratingIndex).date, today)) {
                break;
            }

            // Check the if the day has a lower rank
            for (Integer rank : dailyRatings.get(ratingIndex).ranks) {
                if (rank < lowestRank) {
                    lowestRank = rank;
                }
            }
        }
        return lowestRank;
    }

    /**
     * Returns the total number of subscribers gained across all platforms in the given month and year. 0 is returned if data doesn't exist for given month
     * @param month Month number subscriptions occurred in, starting at 0
     * @param year Year subscriptions occurred
     * @return The total number of subscribers gained over the given month
     */
    public int totalSubscribers(int month, int year) {

        int startingIndex = -1;
        GregorianCalendar targetMonth = new GregorianCalendar(year, month, 0);

        // Loop through until the starting index of the month is found
        while (startingIndex < dailyRatings.size()) {
            if (sameMonth(dailyRatings.get(startingIndex).date, targetMonth)) {
                break;
            }
            startingIndex++;
        }

        // Starting index wasn't found, return 0
        if (startingIndex == -1) {
            return 0;
        }

        int totalSubscribers = 0;

        // Loop through and add the subscribers
        while (startingIndex < dailyRatings.size()) {
            if (!sameMonth(dailyRatings.get(startingIndex).date, targetMonth)) {
                break;
            }
            for (Integer subs : dailyRatings.get(startingIndex).subs) {
                totalSubscribers += subs;
            }
        }

        return totalSubscribers;
    }

    /**
     * Adds analytics from different platforms for a given day. Day is incremented with each call
     * @param analytics List of analytics from different platforms
     */
    public void addTodaysAnalytics(LinkedList<Analytics> analytics) {
        DailyRatings todaysRatings = new DailyRatings((GregorianCalendar) today.clone(), null, null);
        for (Analytics analytic : analytics) {
            todaysRatings.ranks.add(analytic.rank);
            todaysRatings.subs.add(analytic.subs);
        }
        dailyRatings.add(todaysRatings);
        today.add(GregorianCalendar.DAY_OF_YEAR, 1);
    }

    /**
     * Checks if the calendars have the same month and year
     * @param calendar First calendar to compare
     * @param otherCalendar Second calender to compare
     * @return If the first calendar and second calendar share the same month and year
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
