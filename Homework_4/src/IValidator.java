/**
 * An interface for objects that can handle data from an IBinTree using the
 * Visitor Pattern
 * Specialized to check if the node is "valid" for some definition set by the
 * implementing class
 */
public interface IValidator extends IVisitor {

    /**
     * Produces an accumulated answer for the validator about whether the validator
     * found the tree to be valid
     * after being traversed
     * 
     * @return true if the tree passed the validator, false otherwise.
     */
    public boolean isValid();

}
