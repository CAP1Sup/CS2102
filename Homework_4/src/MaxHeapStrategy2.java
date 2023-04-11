import java.util.Random;

public class MaxHeapStrategy2 implements IBinTreeStrategy {

    @Override
    public NodeBT addInt(int i, IBinTree left, int data, IBinTree right) {
        // i should not be root by default
        int dataToInsert = i;
        int dataForRoot = data;

        // Oh, i is bigger than the current root, so make it the root and "Bubble Down"
        // the previous root
        // make i the new root and insert the current root into the subtrees
        if (i > data) {
            dataToInsert = data;
            dataForRoot = i;
        }

        // Bubble down, but in a random order since it doesn't matter which tree gets
        // filled
        Random r = new Random();
        if (r.nextBoolean()) {
            return new NodeBT(dataForRoot, left.addInt(dataToInsert), right, this);
        } else { // If right has a shallower minimum depth, fill it in!
            return new NodeBT(dataForRoot, left, right.addInt(dataToInsert), this);
        }
    }

    @Override
    public NodeBT addInt(int i) {
        return new NodeBT(i, new EmptyBT(this), new EmptyBT(this), this);
    }

}
