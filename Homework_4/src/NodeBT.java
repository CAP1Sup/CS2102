import java.util.Arrays;
import java.util.Optional;

/**
 * One of two possible cases for an overly encapsulated Binary Tree
 * Not meant to be extended/inherited from
 * Uses the Strategy pattern for deciding which algorithm to use to add ints:
 * - MaxHeap
 * - MinHeap
 * - BST
 * etc.
 * Uses the Visitor Pattern to generalize traversal of each element and data
 * (E.g. `map` or a very general for-loop)
 */
public class NodeBT implements IBinTree {

    /** The int in this data node */
    private int data;
    /** The left subtree */
    private IBinTree left;

    /** The right subtree */
    private IBinTree right;

    /** The algorithm for adding integers into this tree */
    private IBinTreeStrategy strategy;

    /**
     * A typical constructor with the default strategy of adding subsequent ints
     * randomly to either the left or right subtree
     *
     * @param data  the root data
     * @param left  the left subtree
     * @param right the right subtree
     */
    public NodeBT(int data, IBinTree left, IBinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.strategy = new DefaultBTStrategy();
    }

    /**
     * A constructor parameterized by the strategy of which algorithm to use to add
     * subsequent ints to this tree
     *
     * @param data
     * @param left
     * @param right
     * @param strategy
     */
    public NodeBT(int data, IBinTree left, IBinTree right, IBinTreeStrategy strategy) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.strategy = strategy;
    }

    /**
     * A Copy Constructor for duplicating the tree
     * Since the data is immutable,
     *
     * @param tree
     */
    public NodeBT(NodeBT tree) {
        this.data = tree.data;
        this.left = tree.left.copy();
        this.right = tree.right.copy();
        this.strategy = tree.strategy;
    }

    /**
     * Add an integer to the contents of this tree using the algorithm in the stored
     * strategy
     *
     * @param i the number to insert.
     * @return a new tree combining the data of this node and it's subtrees with the
     *         input int i
     */
    @Override
    public NodeBT addInt(int i) {
        return this.strategy.addInt(i, this.left, this.data, this.right);

    }

    /**
     * Combining all the data in this tree with another tree
     *
     * @param other the other tree to "insert into" to make a new tree, but no
     *              mutation occurs
     * @return a new tree with the data of this tree and the other tree
     */
    @Override
    public IBinTree addAll(IBinTree other) {
        return other.addAll(this.left).addAll(this.right).addInt(this.data);
    }

    /**
     * Compute a tree containing the data of this node's left and right subtrees
     *
     * @return a new tree with the data of this tree except for the root node
     */
    @Override
    public Optional<IBinTree> removeRoot() {
        return Optional.of(this.left.addAll(this.right));
    }

    /**
     * Used for debugging, produces the root int
     *
     * @return the int at the root of this node
     */
    @Override
    public Optional<Integer> getRoot() {
        return Optional.of(this.data);
    }

    /**
     * Traverses this node using the given object to handle the data of this node as
     * well as the left and right subtrees
     * Uses depth first search for traversing the subtrees
     *
     * @param v an object that can handle either the values in a current NodeBT or
     *          an EmptyBT
     * @return true if whoever called this.accept() should keep traversing according
     *         to the visitor object
     */
    @Override
    public boolean accept(IVisitor v) {
        boolean keepGoing = v.visit(this.data, this.left, this.right); // visit this node and see if the visitor wants
                                                                       // to keep going
        if (keepGoing) {
            keepGoing = this.left.accept(v); // recursively visit the left subtree and see if the visitor wants to keep
                                             // going
        }
        if (keepGoing) {
            keepGoing = this.right.accept(v); // recursively visit the right subtree and see if the visitor wants to
                                              // keep going
        }
        return keepGoing;
    }

    /**
     * Mutation: changes the strategy of this node and all of the subtrees
     *
     * @param strategy a strategy which knows how to add elements to create NodeBTs
     */
    @Override
    public void apply(IBinTreeStrategy strategy) {
        this.strategy = strategy;
        this.left.apply(strategy);
        this.right.apply(strategy);
    }

    /**
     * Deep copy the full tree recursively
     *
     * @return A deep copy of the current Node and its subtrees with a shallow copy
     *         of the strategy
     */
    @Override
    public IBinTree copy() {
        return new NodeBT(this.data, this.left.copy(), this.right.copy(), this.strategy);
    }

    /**
     * A helper method for formating numbers to 3 digits (numbers greater than 3
     * digits don't get pretty printed well)
     *
     * @return
     */
    private String toThreeDigit() {
        int num = Math.abs(this.data);
        if (num < 10) {
            return "00" + num;
        } else if (num < 100) {
            return "0" + num;
        } else
            return "" + num;
    }

    /**
     * Code that took Prof. Ahrens too long to write to pretty-print the binary tree
     *
     * @return the pretty-printed tree which is easier on the eyes than the
     *         debugging window
     */
    @Override
    public String toString() {
        String[] leftLines = this.left.toString().split("\n");
        String[] rightLines = this.right.toString().split("\n");

        int maxLeft = 0;
        int maxRight = 0;
        for (String s : leftLines) {
            maxLeft = Math.max(maxLeft, s.length());

        }

        for (String s : rightLines) {
            maxRight = Math.max(maxRight, s.length());
        }
        int length = 4 + maxLeft + maxRight;
        for (int i = 0; i < leftLines.length; i++) {
            int pad = maxLeft - leftLines[i].length();
            for (int j = 0; j < pad; j++) {
                leftLines[i] += " ";
            }
            leftLines[i] += "    ";
        }
        for (int i = 0; i < rightLines.length; i++) {
            int pad = maxRight - rightLines[i].length();
            for (int j = 0; j < pad; j++) {
                rightLines[i] += " ";
            }
        }
        String[] lines = new String[Math.max(leftLines.length, rightLines.length)];
        for (int i = 0; i < Math.max(leftLines.length, rightLines.length); i++) {
            if (i < leftLines.length) {
                lines[i] = leftLines[i];
            } else {
                lines[i] = "";
                for (int j = 0; j < 4 + maxLeft; j++) {
                    lines[i] += " ";
                }
            }
            if (i < rightLines.length) {
                lines[i] += rightLines[i];
            } else {
                for (int j = 0; j < maxRight; j++) {
                    lines[i] += " ";
                }
            }
        }
        String firstLine = "";
        for (int i = 0; i < maxLeft; i++) {
            firstLine += " ";
        }
        firstLine += " | ";
        for (int i = 0; i < maxRight; i++) {
            firstLine += " ";
        }
        firstLine += "\n";
        for (int i = 0; i < maxLeft; i++) {
            firstLine += "_";
        }
        firstLine += (this.data >= 0 ? "+" : "-") + this.toThreeDigit();
        for (int i = 0; i < maxRight; i++) {
            firstLine += "_";
        }
        return firstLine + "\n" + Arrays.stream(lines).reduce((s, a) -> s + "\n" + a).get();

    }

    /**
     * Overriding equality to mean the same data and shape. Ignores strategy
     * equality.
     *
     * @param o another tree, hopefully
     * @return true if the two trees have the same data in the same "structure".
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NodeBT)) {
            return false;
        }

        NodeBT no = (NodeBT) o;
        return no.data == this.data && no.left.equals(this.left) && no.right.equals(this.right);

    }

}
