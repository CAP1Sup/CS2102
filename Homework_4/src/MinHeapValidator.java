/**
 * Checks if a binary tree is a valid min heap
 */
public class MinHeapValidator implements IValidator {

    /** Stores if the tree is a valid min heap */
    private boolean valid = true;

    /**
     * The binary tree, tree, is a valid min heap:
     *
     * @param tree Binary tree
     */
    public MinHeapValidator(IBinTree tree) {
        tree.accept(this);
    }

    /**
     * Checks if the node's data value is smaller than the data value of the node's
     * children.
     *
     * @param data  The node's value
     * @param left  Left binary subtree
     * @param right Right binary subtree
     * @return If to continue searching the tree
     */
    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        if (new IsLargerValidator(data, left).isValid() || new IsLargerValidator(data, right).isValid()) {
            valid = false;
        }
        return valid;
    }

    /**
     * Checks if the node's data value is smaller than the data value of the node's
     * children.
     *
     * @return If to continue searching the tree
     */
    @Override
    public boolean visit() {
        return valid;
    }

    /**
     * Returns true if the tree is a valid max heap.
     *
     * @return Is the tree a valid max heap?
     */
    @Override
    public boolean isValid() {
        return valid;
    }
}
