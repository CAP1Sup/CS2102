import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyRatings {
    private final GregorianCalendar date;
    private final LinkedList<Integer> ranks;
    private final LinkedList<Integer> subs;

    public DailyRatings(GregorianCalendar date, LinkedList<Integer> ranks, LinkedList<Integer>  subs){
        this.date = date;
        this.ranks = ranks;
        this.subs = subs;
    }

    public GregorianCalendar getDate() {
        return (GregorianCalendar) this.date.clone();
    }

    public LinkedList<Integer> getRanks() {
        LinkedList<Integer> copy = new LinkedList<Integer>();
        for (Integer rank : this.ranks) {
            copy.add(rank);
        }
        return copy;
    }

    public LinkedList<Integer> getSubs(){
        LinkedList<Integer> copy = new LinkedList<Integer>();
        for (Integer subs : this.subs) {
            copy.add(subs);
        }
        return copy;
    }
}
