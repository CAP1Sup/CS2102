import org.junit.Test;

import static org.junit.Assert.*;

public class Examples2 {

    // Test the size visitor
    @Test
    public void testSizeVisitor() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        SizeVisitor sizeVisitor = new SizeVisitor(tree);
        assertEquals(10, sizeVisitor.getSize());
    }

    // Test the max heap validator
    @Test
    public void testMaxHeapValidatorGoodData() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10, 9 });
        MaxHeapValidator maxHeapValidator = new MaxHeapValidator(tree);
        assertTrue(maxHeapValidator.isValid());
    }

    @Test
    public void testMaxHeapValidatorBadData() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategyBuggy1());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10, 9 });
        MaxHeapValidator maxHeapValidator = new MaxHeapValidator(tree);
        assertFalse(maxHeapValidator.isValid());
    }

    // Test the contains element validator
    @Test
    public void testContainsElementValidatorGoodData() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        ContainsElementValidator containsElementValidator = new ContainsElementValidator(tree, 1);
        assertTrue(containsElementValidator.isValid());
    }

    @Test
    public void testContainsElementValidatorBadData() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        ContainsElementValidator containsElementValidator = new ContainsElementValidator(tree, 11);
        assertFalse(containsElementValidator.isValid());
    }

    // Test the contains all validator
    @Test
    public void testContainsAllValidatorItself() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        ContainsAllValidator containsAllValidator = new ContainsAllValidator(tree, tree);
        assertTrue(containsAllValidator.isValid());
    }

    @Test
    public void testContainsAllValidatorBadData() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        ContainsAllValidator containsAllValidator = new ContainsAllValidator(tree.addInt(11), tree);
        assertFalse(containsAllValidator.isValid());
    }

    // Test one greater validator
    @Test
    public void testOneGreaterValidatorGoodData() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        IBinTree afterAddTree = tree.addInt(11);
        OneGreaterValidator oneGreaterValidator = new OneGreaterValidator(tree, afterAddTree);
        assertTrue(oneGreaterValidator.isOneGreater());
    }

    @Test
    public void testOneGreaterValidatorSameTree() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        OneGreaterValidator oneGreaterValidator = new OneGreaterValidator(tree, tree);
        assertFalse(oneGreaterValidator.isOneGreater());
    }

    @Test
    public void testOneGreaterValidatorReversed() {
        IBinTree tree = new EmptyBT(new MaxHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        IBinTree afterAddTree = tree.addInt(11);
        OneGreaterValidator oneGreaterValidator = new OneGreaterValidator(afterAddTree, tree);
        assertFalse(oneGreaterValidator.isOneGreater());
    }

    // Test the min heap validator
    @Test
    public void testMinHeapValidatorGoodData() {
        IBinTree tree = new EmptyBT(new MinHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 });
        MinHeapValidator minHeapValidator = new MinHeapValidator(tree);
        assertTrue(minHeapValidator.isValid());
    }

    @Test
    public void testMinHeapValidatorBadData() {
        IBinTree tree = new EmptyBT();
        tree = Examples.addInts(tree, new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 });
        MinHeapValidator minHeapValidator = new MinHeapValidator(tree);
        assertFalse(minHeapValidator.isValid());
    }

    // Test the binary search tree validator
    @Test
    public void testBinarySearchTreeValidatorGoodData() {
        IBinTree tree = new EmptyBT(new BinarySearchTreeStrategy());
        tree = Examples.addInts(tree, new int[] { 5, 3, 7, 2, 4, 6, 8 });
        BinarySearchTreeValidator binarySearchTreeValidator = new BinarySearchTreeValidator(tree);
        assertTrue(binarySearchTreeValidator.isValid());
    }

    @Test
    public void testBinarySearchTreeValidatorBadData() {
        IBinTree tree = new EmptyBT();
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        BinarySearchTreeValidator binarySearchTreeValidator = new BinarySearchTreeValidator(tree);
        assertFalse(binarySearchTreeValidator.isValid());
    }

    // Test the min heap verifier verify add method
    @Test
    public void testMinHeapVerifierAddGoodData() {
        IBinTree tree = new EmptyBT(new MinHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MinHeapVerifier minHeapVerifier = new MinHeapVerifier();
        assertTrue(minHeapVerifier.verifyAdd(tree, 11, tree.addInt(11)));
    }

    @Test
    public void testMinHeapVerifierAddNotMinHeap() {
        IBinTree tree = new EmptyBT();
        tree = Examples.addInts(tree, new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 });
        MinHeapVerifier minHeapVerifier = new MinHeapVerifier();
        assertFalse(minHeapVerifier.verifyAdd(tree, 11, tree.addInt(11)));
    }

    @Test
    public void testMinHeapVerifierAddNotContainsAll() {
        IBinTree tree = new EmptyBT(new MinHeapStrategy());
        IBinTree otherTree = new EmptyBT(new MinHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        otherTree = Examples.addInts(otherTree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        MinHeapVerifier minHeapVerifier = new MinHeapVerifier();
        assertFalse(minHeapVerifier.verifyAdd(tree, 9, otherTree));
    }

    @Test
    public void testMinHeapVerifierAddNotContainsElement() {
        IBinTree tree = new EmptyBT(new MinHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MinHeapVerifier minHeapVerifier = new MinHeapVerifier();
        assertFalse(minHeapVerifier.verifyAdd(tree, 12, tree.addInt(11)));
    }

    @Test
    public void testMinHeapVerifierAddNotOneGreater() {
        IBinTree tree = new EmptyBT(new MinHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MinHeapVerifier minHeapVerifier = new MinHeapVerifier();
        assertFalse(minHeapVerifier.verifyAdd(tree, 10, tree));
    }

    // Test the min heap verifier verify remove root method
    @Test
    public void testMinHeapVerifierRemoveRootGoodData() {
        IBinTree tree = new EmptyBT(new MinHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MinHeapVerifier minHeapVerifier = new MinHeapVerifier();
        assertTrue(minHeapVerifier.verifyRemoveRoot(tree, tree.getRoot().get(), tree.removeRoot().get()));
    }

    @Test
    public void testMinHeapVerifierRemoveRootNotMinHeap() {
        IBinTree tree = new EmptyBT();
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MinHeapVerifier minHeapVerifier = new MinHeapVerifier();
        assertFalse(minHeapVerifier.verifyRemoveRoot(tree, 10, tree.removeRoot().get()));
    }

    @Test
    public void testMinHeapVerifierRemoveRootNotContainsAll() {
        IBinTree tree = new EmptyBT(new MinHeapStrategy());
        IBinTree otherTree = new EmptyBT(new MinHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        otherTree = Examples.addInts(otherTree, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 });
        MinHeapVerifier minHeapVerifier = new MinHeapVerifier();
        assertFalse(minHeapVerifier.verifyRemoveRoot(tree, 10, otherTree));
    }

    @Test
    public void testMinHeapVerifierRemoveRootContainsElement() {
        IBinTree tree = new EmptyBT(new MinHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MinHeapVerifier minHeapVerifier = new MinHeapVerifier();
        assertFalse(minHeapVerifier.verifyRemoveRoot(tree, 9, tree.removeRoot().get()));
    }

    @Test
    public void testMinHeapVerifierRemoveRootNotOneGreater() {
        IBinTree tree = new EmptyBT(new MinHeapStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        MinHeapVerifier minHeapVerifier = new MinHeapVerifier();
        assertFalse(minHeapVerifier.verifyRemoveRoot(tree, 10, tree));
    }

    // Test the binary search tree verifier verify add method
    @Test
    public void testBinarySearchTreeVerifierAddGoodData() {
        IBinTree tree = new EmptyBT(new BinarySearchTreeStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        BinarySearchTreeVerifier binarySearchTreeVerifier = new BinarySearchTreeVerifier();
        assertTrue(binarySearchTreeVerifier.verifyAdd(tree, 11, tree.addInt(11)));
    }

    @Test
    public void testBinarySearchTreeVerifierAddNotBinarySearchTree() {
        IBinTree tree = new EmptyBT();
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        BinarySearchTreeVerifier binarySearchTreeVerifier = new BinarySearchTreeVerifier();
        assertFalse(binarySearchTreeVerifier.verifyAdd(tree, 11, tree.addInt(11)));
    }

    @Test
    public void testBinarySearchTreeVerifierAddNotContainsAll() {
        IBinTree tree = new EmptyBT(new BinarySearchTreeStrategy());
        IBinTree otherTree = new EmptyBT(new BinarySearchTreeStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        otherTree = Examples.addInts(otherTree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        BinarySearchTreeVerifier binarySearchTreeVerifier = new BinarySearchTreeVerifier();
        assertFalse(binarySearchTreeVerifier.verifyAdd(tree, 9, otherTree));
    }

    @Test
    public void testBinarySearchTreeVerifierAddNotContainsElement() {
        IBinTree tree = new EmptyBT(new BinarySearchTreeStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        BinarySearchTreeVerifier binarySearchTreeVerifier = new BinarySearchTreeVerifier();
        assertFalse(binarySearchTreeVerifier.verifyAdd(tree, 12, tree.addInt(11)));
    }

    @Test
    public void testBinarySearchTreeVerifierAddNotOneGreater() {
        IBinTree tree = new EmptyBT(new BinarySearchTreeStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        BinarySearchTreeVerifier binarySearchTreeVerifier = new BinarySearchTreeVerifier();
        assertFalse(binarySearchTreeVerifier.verifyAdd(tree, 10, tree));
    }

    // Test the binary search tree verifier verify remove root method
    @Test
    public void testBinarySearchTreeVerifierRemoveRootGoodData() {
        IBinTree tree = new EmptyBT(new BinarySearchTreeStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        BinarySearchTreeVerifier binarySearchTreeVerifier = new BinarySearchTreeVerifier();
        assertTrue(binarySearchTreeVerifier.verifyRemoveRoot(tree, tree.getRoot().get(), tree.removeRoot().get()));
    }

    @Test
    public void testBinarySearchTreeVerifierRemoveRootNotBinarySearchTree() {
        IBinTree tree = new EmptyBT();
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        BinarySearchTreeVerifier binarySearchTreeVerifier = new BinarySearchTreeVerifier();
        assertFalse(binarySearchTreeVerifier.verifyRemoveRoot(tree, 10, tree.removeRoot().get()));
    }

    @Test
    public void testBinarySearchTreeVerifierRemoveRootNotContainsAll() {
        IBinTree tree = new EmptyBT(new BinarySearchTreeStrategy());
        IBinTree otherTree = new EmptyBT(new BinarySearchTreeStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        otherTree = Examples.addInts(otherTree, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 });
        BinarySearchTreeVerifier binarySearchTreeVerifier = new BinarySearchTreeVerifier();
        assertFalse(binarySearchTreeVerifier.verifyRemoveRoot(tree, 10, otherTree));
    }

    @Test
    public void testBinarySearchTreeVerifierRemoveRootContainsElement() {
        IBinTree tree = new EmptyBT(new BinarySearchTreeStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        BinarySearchTreeVerifier binarySearchTreeVerifier = new BinarySearchTreeVerifier();
        assertFalse(binarySearchTreeVerifier.verifyRemoveRoot(tree, 9, tree.removeRoot().get()));
    }

    @Test
    public void testBinarySearchTreeVerifierRemoveRootNotOneGreater() {
        IBinTree tree = new EmptyBT(new BinarySearchTreeStrategy());
        tree = Examples.addInts(tree, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        BinarySearchTreeVerifier binarySearchTreeVerifier = new BinarySearchTreeVerifier();
        assertFalse(binarySearchTreeVerifier.verifyRemoveRoot(tree, 10, tree));
    }
}
