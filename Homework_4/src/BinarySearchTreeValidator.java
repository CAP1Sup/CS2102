/**
 * Checks if a binary tree is a valid binary search tree
 */
public class BinarySearchTreeValidator implements IValidator {

    /** Stores if the tree is a valid binary search tree */
    private boolean valid = true;

    /**
     * Checks if the binary tree is a valid binary search tree.
     *
     * @param tree Binary tree to check
     */
    public BinarySearchTreeValidator(IBinTree tree) {
        tree.accept(this);
    }

    /**
     * Checks if the node's data value is larger than the data value of the node's
     * left child and smaller than the data value of the node's right child.
     *
     * @param data  The node's value
     * @param left  Left binary subtree
     * @param right Right binary subtree
     * @return If to continue searching the tree
     */
    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        if (new IsSmallerValidator(data, left).isValid() || new IsLargerValidator(data, right).isValid()) {
            valid = false;
        }
        return valid;
    }

    /**
     * Checks if the node's data value is larger than the data value of the node's
     * left child and smaller than the data value of the node's right child.
     *
     * @return If to continue searching the tree
     */
    @Override
    public boolean visit() {
        return valid;
    }

    /**
     * Returns true if the tree is a valid binary search tree.
     *
     * @return Is the tree a valid binary search tree?
     */
    @Override
    public boolean isValid() {
        return valid;
    }
}
