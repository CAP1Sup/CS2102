import static org.junit.Assert.*;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

public class Examples {

    @Test
    public void testBestRankSingleDaySingleAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 2, 19), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics1);
        assertEquals(3, s.bestRankThisMonth());
    }

    @Test
    public void testTotalSubsSingleDaySingleAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 2, 14), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics1);
        assertEquals(100, s.totalSubscribers(2, 2023));
    }

    @Test
    public void testBestRankSingleDayMultipleAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics1);
        assertEquals(1, s.bestRankThisMonth());
    }

    @Test
    public void testTotalSubsSingleDayMultipleAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics1);
        assertEquals(150, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testBestRankSingleDayNoAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), drs);
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(Integer.MAX_VALUE, s.bestRankThisMonth());
    }

    @Test
    public void testTotalSubsSingleDayNoAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), drs);
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(0, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testBestRankSingleDayWrongMonthAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 3, 30), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(1, 50));
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(Integer.MAX_VALUE, s.bestRankThisMonth());
    }

    @Test
    public void testTotalSubsSingleDayWrongMonthAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 3, 30), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(1, 50));
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(0, s.totalSubscribers(0, 2023));
    }

    @Test
    public void testBestRankMultipleDaysSingleAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics1);
        LinkedList<Analytics> analytics2 = new LinkedList<>();
        analytics2.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics2);
        assertEquals(1, s.bestRankThisMonth());
    }

    @Test
    public void testTotalSubsMultipleDaysSingleAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics1);
        LinkedList<Analytics> analytics2 = new LinkedList<>();
        analytics2.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics2);
        assertEquals(150, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testBestRankMultipleDaysMultipleAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(4, 50));
        s.addTodaysAnalytics(analytics1);
        LinkedList<Analytics> analytics2 = new LinkedList<>();
        analytics2.add(new Analytics(2, 200));
        analytics2.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics2);
        assertEquals(1, s.bestRankThisMonth());
    }

    @Test
    public void testTotalSubsMultipleDaysMultipleAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(4, 50));
        s.addTodaysAnalytics(analytics1);
        LinkedList<Analytics> analytics2 = new LinkedList<>();
        analytics2.add(new Analytics(2, 200));
        analytics2.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics2);
        assertEquals(400, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testBestRankMultipleDaysNoAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(4, 50));
        s.addTodaysAnalytics(analytics1);
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(3, s.bestRankThisMonth());
    }

    @Test
    public void testTotalSubsMultipleDaysNoAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(4, 50));
        s.addTodaysAnalytics(analytics1);
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(150, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testBestRankMultipleDaysWrongMonthAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 3, 29), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(4, 50));
        s.addTodaysAnalytics(analytics1);
        LinkedList<Analytics> analytics2 = new LinkedList<>();
        analytics2.add(new Analytics(2, 200));
        analytics2.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics2);
        assertEquals(Integer.MAX_VALUE, s.bestRankThisMonth());
    }

    @Test
    public void testTotalSubsMultipleDaysWrongMonthAnalytics() {
        LinkedList<DailyRatings> drs = new LinkedList<>();
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 3, 30), drs);
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(4, 50));
        s.addTodaysAnalytics(analytics1);
        LinkedList<Analytics> analytics2 = new LinkedList<>();
        analytics2.add(new Analytics(2, 200));
        analytics2.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics2);
        assertEquals(0, s.totalSubscribers(0, 2023));
    }
}
