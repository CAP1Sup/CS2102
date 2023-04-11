import java.util.Optional;

/**
 * An Interface for a heavily-encapsulated, Immutable Binary Tree
 * Uses the Strategy Pattern for how to add elements
 * Uses the Visitor Pattern for how to traverse itself
 */
public interface IBinTree {

    /**
     * Add an integer i to the Binary Tree using the stored strategy
     * 
     * @param i the number to insert.
     * @return A new NodeBT object containing the integers of the current binary
     *         tree as well as i
     */
    public NodeBT addInt(int i);

    /**
     * Add all of the integers of this tree into another tree using the stored
     * strategy
     * 
     * @param other the other tree to "insert into", but no mutation occurs
     * @return A new IBinTree (NodeBT or EmptyBT) containing all of the elements of
     *         both this tree and the other tree
     */
    public IBinTree addAll(IBinTree other);

    /**
     * Remove the root element of this tree
     * 
     * @return a new IBinTree containing all of the elements of this tree except for
     *         the root or Optional.empty() if called on an EmptyBT
     */
    public Optional<IBinTree> removeRoot();

    /**
     * Grab the root of the current tree for display/debugging purposes
     * 
     * @return the root integer or Optional.empty() when called on an EmptyBT
     */
    public Optional<Integer> getRoot();

    /**
     * Traverses the tree for side effects using the Visitor pattern
     * A generalization of a for-loop (or `map` from Functional Programming).
     * 
     * @param v an object that can handle either the values in a current NodeBT or
     *          an EmptyBT
     * @return true if the traversal should continue, false if it has been signaled
     *         to stop (short-circuiting)
     */
    public boolean accept(IVisitor v);

    /**
     * Changes (mutates) the current strategy of adding elements to the binary tree
     * for the entire tree (current node and subtrees).
     * 
     * @param strategy a strategy which knows how to add elements to create NodeBTs
     */
    public void apply(IBinTreeStrategy strategy);

    /**
     * Make a deep copy (deep clone) of the tree with the same strategy for each
     * node
     * 
     * @return an IBinTree where each subtree is a new node (strategies may be
     *         shared by reference)
     */
    public IBinTree copy();

    /**
     * a convenience method for debugging to turn an array of integers into a
     * BALANCED tree using breadth first input
     * Example: `IBinTree.makeTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});`
     * 
     * @param ints a list of ints to put in a tree
     * @return a tree with the first int at the root, then left, then right, then
     *         left left, the right right, etc..
     *         Don't forget to update the strategy afterwards
     */
    public static IBinTree makeTree(int[] ints) {
        IBinTree t = new EmptyBT();
        for (Integer i : ints) {
            t = t.addInt(i);
        }
        return t;
    }

}
