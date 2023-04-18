/**
 * Computes the size of a given binary tree
 */
public class SizeVisitor implements IVisitor {

    // Stores the size of the tree
    // Increments every time a node is visited
    private int size = 0;

    /**
     * Computes the size of the binary tree "tree".
     *
     * @param tree Binary tree to compute the size of
     */
    public SizeVisitor(IBinTree tree) {
        tree.accept(this);
    }

    /**
     * Increments the size of the tree.
     *
     * @param data  Integer representing the current node's data
     * @param left  The left subtree
     * @param right The right subtree
     * @return A boolean indicating whether or not we need to continue searching the
     *         tree
     */
    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        size++;
        return true;
    }

    /**
     * Increments the size of the tree.
     *
     * @return A boolean indicating whether or not we need to continue searching the
     *         tree
     */
    @Override
    public boolean visit() {
        return true;
    }

    /**
     * Returns the size of the tree.
     *
     * @return The size of the tree
     */
    public int getSize() {
        return size;
    }
}
