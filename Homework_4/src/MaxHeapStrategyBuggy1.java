public class MaxHeapStrategyBuggy1 implements IBinTreeStrategy {

    @Override
    public NodeBT addInt(int i, IBinTree left, int data, IBinTree right) {
        // BUG: Assumes i should always be the new root and "bubbles down" the previous
        // root.
        int dataToInsert = data;
        int dataForRoot = i;

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
