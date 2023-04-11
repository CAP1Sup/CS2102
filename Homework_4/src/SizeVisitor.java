public class SizeVisitor implements IVisitor {
    private int size = 0;

    public SizeVisitor(IBinTree b) {
        b.accept(this);
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
