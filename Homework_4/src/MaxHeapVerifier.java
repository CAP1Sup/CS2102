public class MaxHeapVerifier {

    /**
     * The binary tree, after, is a valid max heap:
     * 1. Its root element is greater than all elements in its subtree
     * 2. All of its subtrees are also valid max heaps
     * 3. All of the elements in before are also present in after
     * added is present in after
     * 4. |after| is equal to |before| + 1
     *
     * @param before Binary tree before
     * @param added  Number added
     * @param after  Binary tree afterward
     * @return If all of the conditions for a valid max heap are met
     */
    public boolean verifyAdd(IBinTree before, int added, IBinTree after) {
        throw new RuntimeException("HW NOT IMPLEMENTED"); // <- Delete and replace with your code
    }

    /**
     * The binary tree, after, is a valid max heap:
     * 1. Its root element is greater than all elements in its subtree
     * 2. All of its subtrees are also valid max heaps
     * 3. All of the elements in after are also present in before
     * root is not present in after
     * 4. |after| is equal to |before| - 1
     *
     * @param before Binary tree before
     * @param root   Number added
     * @param after  Binary tree afterward
     * @return If all of the conditions for a valid max heap are met
     */
    public boolean verifyRemoveRoot(IBinTree before, int root, IBinTree after) {
        throw new RuntimeException("HW NOT IMPLEMENTED"); // <- Delete and replace with your code
    }
}
