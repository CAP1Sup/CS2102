public class SizeVisitor implements IVisitor {
    // TODO: WRITE COMMENTS
    private int size = 0;

    /**
     * SizeVisitor object contains a Binary Tree object parameter and is used to kep
     * track of every time a node is visited
     */

    public SizeVisitor(IBinTree tree) {
        tree.accept(this);
    }

    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        size++;
        return true;
    }

    @Override
    public boolean visit() {
        return true;
    }

    public int getSize() {
        return size;
    }
}
