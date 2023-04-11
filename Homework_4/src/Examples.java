import org.junit.Test;

import static org.junit.Assert.*;

public class Examples {
    public IBinTree mtHeap = new EmptyBT(new MaxHeapStrategy());
    public IBinTree someTree;

    public Examples() {
        // Make a valid max heap with 2 4 6 8 16 15 7 3
        someTree = mtHeap.copy();
        someTree.apply(new MaxHeapStrategy());
        someTree = someTree.addInt(2).addInt(4).addInt(8).addInt(16)
                .addInt(15).addInt(7).addInt(3);
    }

    @Test
    public void test_someTree_example1() {
        IBinTree before = someTree.copy();
        before.apply(new MaxHeapStrategy2());
        IBinTree after = before.addInt(5);
        assertTrue(new MaxHeapVerifier().verifyAdd(before, 5, after));
    }

    @Test
    public void test_someTree_example2() {
        IBinTree before = someTree.copy();
        before.apply(new MaxHeapStrategyBuggy1());
        IBinTree after = before.addInt(5);
        assertFalse(new MaxHeapVerifier().verifyAdd(before, 5, after));
    }

    @Test
    public void test_someTree_example3() {
        IBinTree before = IBinTree.makeTree(new int[] { 5, 1, 4 });
        // simulate adding 3
        IBinTree after1 = IBinTree.makeTree(new int[] { 5, 3, 4, 1 });
        IBinTree after2 = IBinTree.makeTree(new int[] { 5, 4, 1, 3 });
        assertTrue(new MaxHeapVerifier().verifyAdd(before, 3, after1));
        assertTrue(new MaxHeapVerifier().verifyAdd(before, 3, after2));
    }

    @Test
    public void test_someTree_example4() {
        IBinTree before = IBinTree.makeTree(new int[] { 5, 4, 1, 3 });
        // simulate adding 3
        IBinTree after1 = IBinTree.makeTree(new int[] { 4, 1, 3 });
        IBinTree after2 = IBinTree.makeTree(new int[] { 4, 3, 1 });
        assertTrue(new MaxHeapVerifier().verifyRemoveRoot(before, 5, after1));
        assertTrue(new MaxHeapVerifier().verifyRemoveRoot(before, 5, after2));
    }

}
