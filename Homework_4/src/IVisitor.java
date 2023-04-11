/**
 * An interface for objects that can handle data from an IBinTree using the
 * Visitor Pattern
 * Traverses each element in a Binary Tree to perform a side-effecting action
 */
public interface IVisitor {
    /**
     * A callback function for when the current traversal reaches a NodeBT
     * 
     * @param data  the data in the current node
     * @param left  the left subtree of the current node
     * @param right the right subtree of the current node
     * @return true when the traversal should continue; false if it should stop
     *         early (short-circuiting)
     */
    public boolean visit(int data, IBinTree left, IBinTree right);

    /**
     * A callback function for when the current traversal reaches an EmptyBT
     * 
     * @return true when the traversal should continue (backtracking); false if it
     *         should stop early (short-circuiting)
     */
    public boolean visit();
}
