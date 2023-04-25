/**
 * Checks if the other tree contains all the elements of the first tree
 */
public class ContainsAllValidator implements IValidator {

    /** The other tree to compare to */
    private IBinTree otherTree;

    /** Stores if the other tree contains all the elements of the tree */
    private boolean containsAllElements = true;

    /**
     * Validates that otherTree contains all elements of tree.
     *
     * @param tree      Binary tree containing elements to check
     * @param otherTree Binary tree to check if it contains all elements of tree
     */
    public ContainsAllValidator(IBinTree tree, IBinTree otherTree) {
        this.otherTree = otherTree;
        tree.accept(this);
    }

    /**
     * Checks if the other tree contains the data.
     *
     * @param data  Integer representing the current node's data
     * @param left  The left subtree
     * @param right The right subtree
     * @return A boolean indicating whether or not we need to continue searching the
     *         tree
     */
    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        ContainsElementValidator containsElement = new ContainsElementValidator(otherTree, data);
        if (!containsElement.isValid()) {
            containsAllElements = false;
        }
        return containsAllElements;
    }

    /**
     * Checks if the other tree contains the data.
     *
     * @return A boolean indicating whether or not we need to continue searching the
     *         tree
     */
    @Override
    public boolean visit() {
        return containsAllElements;
    }

    /**
     * Returns a boolean indicating whether or not the other tree contains all the
     * elements of the tree.
     *
     * @return A boolean indicating whether or not the other tree contains all the
     *         elements of the tree.
     */
    @Override
    public boolean isValid() {
        return containsAllElements;
    }
}
