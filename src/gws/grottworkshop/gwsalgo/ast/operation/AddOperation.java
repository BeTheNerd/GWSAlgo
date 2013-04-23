package gws.grottworkshop.gwsalgo.ast.operation;

import gws.grottworkshop.gwsalgo.ast.ASTNode;

// TODO: Auto-generated Javadoc
/**
 * The Class AddOperation.
 */
public class AddOperation extends BinaryOperation {

	/**
  	 * Instantiates a new adds the operation.
  	 *
  	 * @param left the left
  	 * @param right the right
  	 */
  	public AddOperation(ASTNode left, ASTNode right) {
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
	    return left + "+" + right;
	  }
}
