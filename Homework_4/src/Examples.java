import org.junit.Test;

import static org.junit.Assert.*;

public class Examples {

    // Test the max heap verifier verify add method
    @Test
    public void testMaxHeapVerifierAddGoodData() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MaxHeapVerifier maxHeapVerifier = new MaxHeapVerifier();
        assertTrue(maxHeapVerifier.verifyAdd(tree, 11, tree.addInt(11)));
    }

    @Test
    public void testMaxHeapVerifierAddNotMaxHeap() {
        IBinTree tree = new EmptyBT();
        tree = addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MaxHeapVerifier maxHeapVerifier = new MaxHeapVerifier();
        assertFalse(maxHeapVerifier.verifyAdd(tree, 11, tree.addInt(11)));
    }

    @Test
    public void testMaxHeapVerifierAddNotContainsAll() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        IBinTree otherTree = new EmptyBT(new MaxHeapStrategy());
        tree = addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        otherTree = addInts(otherTree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        MaxHeapVerifier maxHeapVerifier = new MaxHeapVerifier();
        assertFalse(maxHeapVerifier.verifyAdd(tree, 9, otherTree));
    }

    @Test
    public void testMaxHeapVerifierAddNotContainsElement() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MaxHeapVerifier maxHeapVerifier = new MaxHeapVerifier();
        assertFalse(maxHeapVerifier.verifyAdd(tree, 12, tree.addInt(11)));
    }

    @Test
    public void testMaxHeapVerifierAddNotOneGreater() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MaxHeapVerifier maxHeapVerifier = new MaxHeapVerifier();
        assertFalse(maxHeapVerifier.verifyAdd(tree, 10, tree));
    }

    // Test the max heap verifier verify remove root method
    @Test
    public void testMaxHeapVerifierRemoveRootGoodData() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MaxHeapVerifier maxHeapVerifier = new MaxHeapVerifier();
        assertTrue(maxHeapVerifier.verifyRemoveRoot(tree, tree.getRoot().get(), tree.removeRoot().get()));
    }

    @Test
    public void testMaxHeapVerifierRemoveRootNotMaxHeap() {
        IBinTree tree = new EmptyBT();
        tree = addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MaxHeapVerifier maxHeapVerifier = new MaxHeapVerifier();
        assertFalse(maxHeapVerifier.verifyRemoveRoot(tree, 10, tree.removeRoot().get()));
    }

    @Test
    public void testMaxHeapVerifierRemoveRootNotContainsAll() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        IBinTree otherTree = new EmptyBT(new MaxHeapStrategy());
        tree = addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        otherTree = addInts(otherTree, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 });
        MaxHeapVerifier maxHeapVerifier = new MaxHeapVerifier();
        assertFalse(maxHeapVerifier.verifyRemoveRoot(tree, 10, otherTree));
    }

    @Test
    public void testMaxHeapVerifierRemoveRootContainsElement() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MaxHeapVerifier maxHeapVerifier = new MaxHeapVerifier();
        assertFalse(maxHeapVerifier.verifyRemoveRoot(tree, 9, tree.removeRoot().get()));
    }

    @Test
    public void testMaxHeapVerifierRemoveRootNotOneGreater() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MaxHeapVerifier maxHeapVerifier = new MaxHeapVerifier();
        assertFalse(maxHeapVerifier.verifyRemoveRoot(tree, 10, tree));
    }

    /**
     * Creates a binary tree with the given integers.
     *
     * @param tree The binary tree
     * @param ints The integers to add
     */
    public static IBinTree addInts(IBinTree tree, int[] ints) {
        for (int i : ints) {
            tree = tree.addInt(i);
        }
        return tree;
    }
}
