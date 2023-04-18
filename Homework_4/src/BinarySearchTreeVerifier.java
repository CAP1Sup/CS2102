/**
 * Checks if an addition or removal to a binary search tree is valid
 */
public class BinarySearchTreeVerifier {

    /**
     * The binary tree, after, is a valid binary search tree:
     * 1. Its root element is greater than all elements in its subtree
     * 2. All of its subtrees are also valid binary search trees
     * 3. All of the elements in before are also present in after
     * added is present in after
     * 4. |after| is equal to |before| + 1
     *
     * @param before Binary tree before
     * @param added  Number added
     * @param after  Binary tree afterward
     * @return If all of the conditions for a valid addition are met
     */
    public boolean verifyAdd(IBinTree before, int added, IBinTree after) {
        if (!new BinarySearchTreeValidator(after).isValid()) {
            return false;
        }
        if (!new ContainsAllValidator(before, after).isValid()) {
            return false;
        }
        if (!new ContainsElementValidator(after, added).isValid()) {
            return false;
        }
        if (!new OneGreaterValidator(before, after).isOneGreater()) {
            return false;
        }
        return true;
    }

    /**
     * The binary tree, after, is a valid binary search tree:
     * 1. Its root element is greater than all elements in its subtree
     * 2. All of its subtrees are also valid binary search trees
     * 3. All of the elements in after are also present in before
     * root is not present in after
     * 4. |after| is equal to |before| - 1
     *
     * @param before Binary tree before
     * @param root   Number added
     * @param after  Binary tree afterward
     * @return If all of the conditions for a valid removal are met
     */
    public boolean verifyRemoveRoot(IBinTree before, int root, IBinTree after) {
        if (!new BinarySearchTreeValidator(after).isValid()) {
            return false;
        }
        if (!new ContainsAllValidator(after, before).isValid()) {
            return false;
        }
        if (new ContainsElementValidator(after, root).isValid()) {
            return false;
        }
        if (!new OneGreaterValidator(after, before).isOneGreater()) {
            return false;
        }
        return true;
    }
}
