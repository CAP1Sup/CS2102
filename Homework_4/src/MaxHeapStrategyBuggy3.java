public class MaxHeapStrategyBuggy3 implements IBinTreeStrategy {

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

        // If the left has a shallower minimum depth, fill it in!
        if (new DepthVisitor(left).getMinDepth() <= new DepthVisitor(right).getMinDepth()) {
            return new NodeBT(dataForRoot, left.addInt(dataToInsert), right, this);
        } else { // If right has a shallower minimum depth, fill it in!
            return new NodeBT(dataForRoot, left, right.addInt(dataToInsert), this);
        }
    }

    @Override
    public NodeBT addInt(int i) {
        // BUG: Thinks only positive numbers are valid
        if (i < 0) {
            return new NodeBT(0, new EmptyBT(this), new EmptyBT(this), this);
        } else {
            return new NodeBT(i, new EmptyBT(this), new EmptyBT(this), this);
        }
    }

}
