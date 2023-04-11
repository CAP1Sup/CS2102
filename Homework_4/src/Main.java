
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Testing how to make heaps using the given starter code

        MaxHeapStrategy mhs = new MaxHeapStrategy();
        IBinTree b = new EmptyBT(mhs); // <- make an empty heap
        Random r = new Random(); // <- make a number generator
        int howBig = 10; // change these values to play with the code
        int howManyToRemove = 4;

        for (int i = 0; i < howBig; i++) {
            b = b.addInt(r.nextInt(999));
        }
        System.out.println(b);

        for (int i = 0; i < howManyToRemove; i++) {
            b = b.removeRoot().get();
        }
        System.out.println(b);

        // Make a balanced binary tree with the following integers (not guaranteed to be
        // a heap)
        IBinTree tree1 = IBinTree.makeTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
        IBinTree tree2 = IBinTree.makeTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
        System.out.println(tree1);
        System.out.println(tree1.equals(tree2));
    }

}
