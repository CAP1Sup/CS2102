import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyRatings {
    public GregorianCalendar date;
    public LinkedList<Integer> ranks;
    public LinkedList<Integer> subs;

    public DailyRatings(GregorianCalendar date, LinkedList<Integer> ranks, LinkedList<Integer>  subs){
        this.date = date;
        this.ranks = ranks;
        this.subs = subs;
    }
}
