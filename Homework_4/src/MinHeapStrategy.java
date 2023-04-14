public class MinHeapStrategy implements IBinTreeStrategy {

    /**
     *
     * Consumes an integer to add to the existing binary tree
     *
     * @param i     Integer being added
     * @param left  Left side of the binary tree
     * @param data  Data of the current node
     * @param right Right side of the binary tree
     */
    @Override
    public NodeBT addInt(int i, IBinTree left, int data, IBinTree right) {
        // i should not be root by default
        int dataToInsert = i;
        int dataForRoot = data;

        // Oh, i is smaller than the current root, so make it the root and "Bubble Down"
        // the previous root
        // make i the new root and insert the current root into the subtrees
        if (i < data) {
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

    /**
     * Consumes an integer to add to the tree via a new node
     *
     * @param i Integer being added
     */
    @Override
    public NodeBT addInt(int i) {
        return new NodeBT(i, new EmptyBT(this), new EmptyBT(this), this);
    }

}
