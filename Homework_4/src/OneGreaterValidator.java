/**
 * Checks if the first binary tree's size is one greater than the second binary
 * tree's
 */
public class OneGreaterValidator {

    // Stores if the first binary tree's size is one greater than the second
    // binary's
    private boolean isOneGreater;

    /**
     * The binary tree "first" is one greater than the binary tree "second".
     *
     * @param first  Smaller binary tree
     * @param second Larger binary tree
     */
    public OneGreaterValidator(IBinTree first, IBinTree second) {
        SizeVisitor firstSize = new SizeVisitor(first);
        SizeVisitor secondSize = new SizeVisitor(second);
        isOneGreater = (firstSize.getSize() + 1) == secondSize.getSize();
    }

    /**
     * Is the first binary tree's size one greater than the second binary tree's?
     *
     * @return If the first binary tree's size is one greater than the second binary
     *         tree's
     */
    public boolean isOneGreater() {
        return isOneGreater;
    }
}
