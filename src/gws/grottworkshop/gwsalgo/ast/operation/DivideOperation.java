package gws.grottworkshop.gwsalgo.ast.operation;

import gws.grottworkshop.gwsalgo.ast.ASTNode;

// TODO: Auto-generated Javadoc
/**
 * The Class DivideOperation.
 */
public class DivideOperation extends BinaryOperation {

	/**
  	 * Instantiates a new divide operation.
  	 *
  	 * @param left the left
  	 * @param right the right
  	 */
  	public DivideOperation(ASTNode left, ASTNode right) {
	    super(left, right);
	  }

    /**
     * To string.
     *
     * @return the string
     * @see gws.grottworkshop.gwsalgo.ast.ASTNode#toString()
     */
  	@Override
	  public String toString() {
	    return left + "/" + right;
	  }
}
