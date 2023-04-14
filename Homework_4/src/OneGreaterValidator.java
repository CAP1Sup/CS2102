public class OneGreaterValidator {

    private boolean isOneGreater;

    /**
     * The binary tree, first, is one greater than the binary tree, second.
     *
     * @param first  Binary tree
     * @param second Binary tree
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
