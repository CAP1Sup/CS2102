
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Streamometer {
    public GregorianCalendar today;
    public LinkedList<DailyRatings> dailyRatings;

    public Streamometer(GregorianCalendar today, LinkedList<DailyRatings> dailyRatings) {
        this.today = today;
        this.dailyRatings = dailyRatings;
    }

    public int bestRankThisMonth() {
        int lowestRank = Integer.MAX_VALUE;
        // Start from the end of the list, which will have the most recent data
        for (int ratingIndex = dailyRatings.size() - 1; ratingIndex >= 0; ratingIndex--) {

            // Break the for loop if we've exceed this month's ratings
            if (!sameMonth(dailyRatings.get(ratingIndex).date, today)) {
                break;
            }

            // Check if this days rank is lower
            // TODO: Finish writing
        }
        return -1;
    }

    public int totalSubscribers(int month, int year) {
        return -1;
    }

    public void addTodaysAnalytics(LinkedList<Analytics> analytics) {
        DailyRatings todaysRatings = new DailyRatings((GregorianCalendar) today.clone(), null, null);
        for (Analytics analytic : analytics) {
            todaysRatings.ranks.add(analytic.rank);
            todaysRatings.subs.add(analytic.subs);
        }
        dailyRatings.add(todaysRatings);
        today.add(GregorianCalendar.DAY_OF_YEAR, 1);
    }

    private boolean sameMonth(GregorianCalendar calendar, GregorianCalendar otherCalendar) {
        if (calendar.get(GregorianCalendar.YEAR) == otherCalendar.get(GregorianCalendar.YEAR)) {
            if (calendar.get(GregorianCalendar.MONTH) == otherCalendar.get(GregorianCalendar.MONTH)) {
                return true;
            }
        }
        return false;
    }
}
