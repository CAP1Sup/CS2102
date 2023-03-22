import java.util.LinkedList;

public class CatastropheZone extends BasicZone {

    public CatastropheZone() {
        super("Cat: %d lbs. of dry food | %d cans of wet food", new String[]{"dry", "wet"});
    }

    @Override
    public IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        return registerAnimal(new Cat(name, age, currentWeight, whereabouts));
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
