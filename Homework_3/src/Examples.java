import static org.junit.Assert.*;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

public class Examples {

    @Test
    public void testBestRankSingleDaySingleAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 02, 19), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics1);
        assertEquals(3, s.bestRankThisMonth());
    }

    @Test
    public void testTotalSubsSingleDaySingleAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 02, 14), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics1);
        assertEquals(100, s.totalSubscribers(2, 2023));
    }

    @Test
    public void testBestRankSingleDayMultipleAnalyticsStreamometer() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 01, 14), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics1);
        assertEquals(1, s.bestRankThisMonth());
    }

    @Test
    public void testTotalSubsSingleDayMultipleAnalyticsStreamometer() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 01, 14), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics1);
        assertEquals(150, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testTotalSubsSingleDayNoAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 01, 14), drs);
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(Integer.MAX_VALUE, s.bestRankThisMonth());
        assertEquals(0, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testBestRankSingleDayNoAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 01, 14), drs);
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(Integer.MAX_VALUE, s.bestRankThisMonth());
    }

    @Test
    public void testTotalSubsSingleDayNoAnalyticsTotalSubs() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 01, 14), drs);
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(0, s.totalSubscribers(01, 2023));
    }
}
