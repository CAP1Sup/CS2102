import java.util.Optional;

/**
 * One of exactly two cases for a Binary Tree: a Leaf
 * Contains no data, used mainly to signal the end/backtracking of traversal
 * or base cases of algorithms
 */
public class EmptyBT implements IBinTree {

    /**
     * The strategy for how to add data to an empty tree
     */
    private IBinTreeStrategy strategy;

    /**
     * The no arg constructor with the default strategy to produce a Leaf
     */
    public EmptyBT() {
        this.strategy = new DefaultBTStrategy();
    }

    /**
     * A constructor to produce a leaf with a given strategy for adding ints to the
     * tree
     * 
     * @param strategy the strategy for how to add ints to this tree
     */
    public EmptyBT(IBinTreeStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Delegate to the strategy for how to add an int to a Leaf
     * 
     * @param i the number to insert.
     * @return a node containing the int via the strategy
     */
    @Override
    public NodeBT addInt(int i) {

        NodeBT after = this.strategy.addInt(i);
        return after;
    }

    /**
     * Adding all the elements of the Leaf (e.g. none) into another tree
     * 
     * @param b the other tree to "insert into", but no mutation occurs
     * @return the given tree since there are no elements
     */
    @Override
    public IBinTree addAll(IBinTree b) {
        return b;
    }

    /**
     * A nonsensical operation, but possible, so we handle it with Optional
     * 
     * @return Optional.empty() since there would be no tree to remove the root from
     *         to signal failure
     */
    @Override
    public Optional<IBinTree> removeRoot() {
        return Optional.empty();
    }

    /**
     * A sensible operation, but since there is no data to produce, we handle it
     * with Optional
     * 
     * @return Optional.empty() since there is no data to produce
     */
    @Override
    public Optional<Integer> getRoot() {
        return Optional.empty();
    }

    /**
     * VISITOR PATTERN
     * A request to visit this leaf which is handled with no data
     * 
     * @param v an object that can handle either the values in a current NodeBT or
     *          an EmptyBT
     * @return true if the visitor signals they wish to backtrack (e.g. keep
     *         visiting/traversing)
     */
    @Override
    public boolean accept(IVisitor v) {
        return v.visit();
    }

    /**
     * STRATEGY PATTERN
     * Changes (mutates) the strategy for adding integers into this tree
     * 
     * @param strategy a strategy which knows how to add elements to create NodeBTs
     */
    @Override
    public void apply(IBinTreeStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Make a new leaf in memory with the same strategy as this one
     * 
     * @return a fresh EmptyBT object
     */
    @Override
    public IBinTree copy() {
        return new EmptyBT(this.strategy);
    }

    /**
     * Pretty-prints leaf as a *
     * 
     * @return a dangling leaf. leaf Emojis messed up the formatting :(
     */
    @Override
    public String toString() {
        return " | \n * ";
    }

    /**
     * Overriding equality for a Leaf
     * 
     * @param o another Object, hopefully an IBinTree
     * @return true if o is also a leaf
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof EmptyBT;
    }

}
