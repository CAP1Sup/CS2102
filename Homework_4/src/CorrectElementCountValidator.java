public class CorrectElementCountValidator implements IValidator {

    public CorrectElementCountValidator(IBinTree tree) {
        tree.accept(this);
    }

    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public boolean visit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public boolean isValid() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }

}
