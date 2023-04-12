public class ContainsAllValidator implements IValidator {

    private IBinTree otherTree;
    private boolean containsAllElements = true;

    public ContainsAllValidator(IBinTree tree, IBinTree otherTree) {
        this.otherTree = otherTree;
        tree.accept(this);
    }

    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        ContainsElementValidator containsElement = new ContainsElementValidator(otherTree, data);
        if (!containsElement.isValid()) {
            containsAllElements = false;
        }
        return containsAllElements;
    }

    @Override
    public boolean visit() {
        return containsAllElements;
    }

    @Override
    public boolean isValid() {
        return containsAllElements;
    }

}
