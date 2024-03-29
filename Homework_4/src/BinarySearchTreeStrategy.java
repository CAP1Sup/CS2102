/**
 * Organizes the binary tree as a binary search tree
 */
public class BinarySearchTreeStrategy implements IBinTreeStrategy {

    /**
     *
     * Consumes an integer to add to the existing binary tree
     *
     * @param i     Integer being added
     * @param left  Left side of the binary tree
     * @param data  Data of the current node
     * @param right Right side of the binary tree
     */
    @Override
    public NodeBT addInt(int i, IBinTree left, int data, IBinTree right) {

        // Check if the value should be added to the left or right subtree
        if (i < data) {

            // Add to the left subtree
            return new NodeBT(data, left.addInt(i), right, this);
        } else if (i > data) {

            // Add to the right subtree
            return new NodeBT(data, left, right.addInt(i), this);
        } else {
            // Reject the value, it is already in the tree
            return new NodeBT(data, left, right, this);
        }
    }

    /**
     * Consumes an integer to add to the tree via a new node
     *
     * @param i Integer being added
     */
    @Override
    public NodeBT addInt(int i) {
        return new NodeBT(i, new EmptyBT(this), new EmptyBT(this), this);
    }
}
