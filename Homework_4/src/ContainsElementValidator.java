public class ContainsElementValidator implements IValidator {

    private int element;
    private boolean containsElement = false;

    public ContainsElementValidator(IBinTree tree, int element) {
        this.element = element;
        tree.accept(this);
    }

    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        if (data == element) {
            containsElement = true;
        }
        return !containsElement;
    }

    @Override
    public boolean visit() {
        return !containsElement;
    }

    @Override
    public boolean isValid() {
        return containsElement;
    }

}
