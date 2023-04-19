/**
 * Checks if a node's value is larger than the value of the node's subtree.
 */
public class IsLargerValidator implements IValidator {

    // Stores if the node is larger than the subtree's root value
    private boolean larger = false;

    // Stores the node's value
    private int node;

    /**
     * Checks if the node is larger than the subtree's root value.
     *
     * @param node Node's value
     * @param tree Binary tree to check
     */
    public IsLargerValidator(int node, IBinTree subtree) {
        this.node = node;
        subtree.accept(this);
    }

    /**
     * Checks if the node's data value is larger than the data value of the node's
     * subtree. We only have to check one node down, so we only have to run the
     * visit method once.
     *
     * @param data  The node's value
     * @param left  Left binary subtree
     * @param right Right binary subtree
     * @return If to continue searching the tree
     */
    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        if (data < node) {
            larger = true;
        }
        return false;
    }

    /**
     * Checks if the node's data value is larger than the data value of the node's
     * subtree. We only have to check one node down, so we only have to run the
     * visit method once.
     *
     * @return If to continue searching the tree
     */
    @Override
    public boolean visit() {
        return false;
    }

    /**
     * Returns true if the node is larger than the subtree's root value.
     *
     * @return Is the node larger than the subtree's root value?
     */
    @Override
    public boolean isValid() {
        return larger;
    }
}
