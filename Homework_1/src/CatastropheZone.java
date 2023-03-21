import java.util.LinkedList;

public class CatastropheZone extends BasicZone {

    public CatastropheZone() {
        super("Cat: %d lbs. of dry food | %d cans of wet food", new String[]{"dry", "wet"});
    }

    @Override
    public IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerAdoptable'");
    }

    @Override
    public int totalYoungins() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalYoungins'");
    }

    @Override
    public double averageAge() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'averageAge'");
    }

    @Override
    public String changeFeed(String food, Integer quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeFeed'");
    }

    @Override
    public Adoptable closestTo(Coord location) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'closestTo'");
    }

    @Override
    public LinkedList<Adoptable> weighIn(Double threshold) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'weighIn'");
    }

}
