public class MaxHeapStrategyBuggy2 implements IBinTreeStrategy {

    @Override
    public NodeBT addInt(int i, IBinTree left, int data, IBinTree right) {
        // i should not be root by default
        int dataToInsert = i;
        int dataForRoot = data;

        // BUG: If i is bigger than the current root, replace it with the current root.
        // the current root is forgotten
        if (i > data) {
            return new NodeBT(i, left, right);
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
        return new NodeBT(i, new EmptyBT(this), new EmptyBT(this), this);
    }

}
