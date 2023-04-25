/**
 * Checks if the binary tree contains the given element
 */
public class ContainsElementValidator implements IValidator {

    /** The element to search for */
    private int element;

    /** Stores if the tree contains the element */
    private boolean containsElement = false;

    /**
     * Checks if the binary tree "tree" contains the element.
     *
     * @param tree    Binary tree
     * @param element Element to search for
     */
    public ContainsElementValidator(IBinTree tree, int element) {
        this.element = element;
        tree.accept(this);
    }

    /**
     * Checks if the element is equal to the data.
     *
     * @param data  Integer representing the current node's data
     * @param left  The left subtree
     * @param right The right subtree
     * @return If to continue searching the tree
     */
    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        if (data == element) {
            containsElement = true;
        }
        return !containsElement;
    }

    /**
     * Checks if the element is equal to the data.
     *
     * @return If to continue searching the tree
     */
    @Override
    public boolean visit() {
        return !containsElement;
    }

    /**
     * Returns true if the tree contains the element.
     *
     * @return Does the tree contain the element?
     */
    @Override
    public boolean isValid() {
        return containsElement;
    }
}
