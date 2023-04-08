import static org.junit.Assert.*;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

public class Examples {

    // DailyRatingStorage tests
    @Test
    public void testDailyRatingStorageBestRankSingleDaySingleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 2, 19), new DailyRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics1);
        assertEquals(3, s.bestRankThisMonth());
    }

    @Test
    public void testDailyRatingStorageTotalSubsSingleDaySingleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 2, 14), new DailyRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics1);
        assertEquals(100, s.totalSubscribers(2, 2023));
    }

    @Test
    public void testDailyRatingStorageBestRankSingleDayMultipleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new DailyRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics1);
        assertEquals(1, s.bestRankThisMonth());
    }

    @Test
    public void testDailyRatingStorageTotalSubsSingleDayMultipleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new DailyRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics1);
        assertEquals(150, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testDailyRatingStorageBestRankSingleDayNoAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new DailyRatingStorage());
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(Integer.MAX_VALUE, s.bestRankThisMonth());
    }

    @Test
    public void testDailyRatingStorageTotalSubsSingleDayNoAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new DailyRatingStorage());
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(0, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testDailyRatingStorageBestRankSingleDayWrongMonthAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 3, 30), new DailyRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(1, 50));
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(Integer.MAX_VALUE, s.bestRankThisMonth());
    }

    @Test
    public void testDailyRatingStorageTotalSubsSingleDayWrongMonthAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 3, 30), new DailyRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(1, 50));
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(0, s.totalSubscribers(0, 2023));
    }

    @Test
    public void testDailyRatingStorageBestRankMultipleDaysSingleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new DailyRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics1);
        LinkedList<Analytics> analytics2 = new LinkedList<>();
        analytics2.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics2);
        assertEquals(1, s.bestRankThisMonth());
    }

    @Test
    public void testDailyRatingStorageTotalSubsMultipleDaysSingleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new DailyRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics1);
        LinkedList<Analytics> analytics2 = new LinkedList<>();
        analytics2.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics2);
        assertEquals(150, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testDailyRatingStorageBestRankMultipleDaysMultipleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new DailyRatingStorage());
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
    public void testDailyRatingStorageTotalSubsMultipleDaysMultipleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new DailyRatingStorage());
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
    public void testDailyRatingStorageBestRankMultipleDaysNoAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new DailyRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(4, 50));
        s.addTodaysAnalytics(analytics1);
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(3, s.bestRankThisMonth());
    }

    @Test
    public void testDailyRatingStorageTotalSubsMultipleDaysNoAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new DailyRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(4, 50));
        s.addTodaysAnalytics(analytics1);
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(150, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testDailyRatingStorageBestRankMultipleDaysWrongMonthAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 3, 29), new DailyRatingStorage());
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
    public void testDailyRatingStorageTotalSubsMultipleDaysWrongMonthAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 3, 30), new DailyRatingStorage());
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

    // ArrayListRatingStorage tests
    @Test
    public void testArrayListRatingStorageBestRankSingleDaySingleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 2, 19), new ArrayListRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics1);
        assertEquals(3, s.bestRankThisMonth());
    }

    @Test
    public void testArrayListRatingStorageTotalSubsSingleDaySingleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 2, 14), new ArrayListRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics1);
        assertEquals(100, s.totalSubscribers(2, 2023));
    }

    @Test
    public void testArrayListRatingStorageBestRankSingleDayMultipleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new ArrayListRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics1);
        assertEquals(1, s.bestRankThisMonth());
    }

    @Test
    public void testArrayListRatingStorageTotalSubsSingleDayMultipleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new ArrayListRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics1);
        assertEquals(150, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testArrayListRatingStorageBestRankSingleDayNoAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new ArrayListRatingStorage());
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(Integer.MAX_VALUE, s.bestRankThisMonth());
    }

    @Test
    public void testArrayListRatingStorageTotalSubsSingleDayNoAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new ArrayListRatingStorage());
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(0, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testArrayListRatingStorageBestRankSingleDayWrongMonthAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 3, 30), new ArrayListRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(1, 50));
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(Integer.MAX_VALUE, s.bestRankThisMonth());
    }

    @Test
    public void testArrayListRatingStorageTotalSubsSingleDayWrongMonthAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 3, 30), new ArrayListRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(1, 50));
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(0, s.totalSubscribers(0, 2023));
    }

    @Test
    public void testArrayListRatingStorageBestRankMultipleDaysSingleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new ArrayListRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics1);
        LinkedList<Analytics> analytics2 = new LinkedList<>();
        analytics2.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics2);
        assertEquals(1, s.bestRankThisMonth());
    }

    @Test
    public void testArrayListRatingStorageTotalSubsMultipleDaysSingleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new ArrayListRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics1);
        LinkedList<Analytics> analytics2 = new LinkedList<>();
        analytics2.add(new Analytics(1, 50));
        s.addTodaysAnalytics(analytics2);
        assertEquals(150, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testArrayListRatingStorageBestRankMultipleDaysMultipleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new ArrayListRatingStorage());
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
    public void testArrayListRatingStorageTotalSubsMultipleDaysMultipleAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new ArrayListRatingStorage());
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
    public void testArrayListRatingStorageBestRankMultipleDaysNoAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new ArrayListRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(4, 50));
        s.addTodaysAnalytics(analytics1);
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(3, s.bestRankThisMonth());
    }

    @Test
    public void testArrayListRatingStorageTotalSubsMultipleDaysNoAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 1, 14), new ArrayListRatingStorage());
        LinkedList<Analytics> analytics1 = new LinkedList<>();
        analytics1.add(new Analytics(3, 100));
        analytics1.add(new Analytics(4, 50));
        s.addTodaysAnalytics(analytics1);
        s.addTodaysAnalytics(new LinkedList<Analytics>());
        assertEquals(150, s.totalSubscribers(1, 2023));
    }

    @Test
    public void testArrayListRatingStorageBestRankMultipleDaysWrongMonthAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 3, 29), new ArrayListRatingStorage());
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
    public void testArrayListRatingStorageTotalSubsMultipleDaysWrongMonthAnalytics() {
        Streamometer s = new Streamometer(new GregorianCalendar(2023, 3, 30), new ArrayListRatingStorage());
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
