package gws.grottworkshop.gwsalgo.ast.operation;

import gws.grottworkshop.gwsalgo.ast.ASTNode;

// TODO: Auto-generated Javadoc
/**
 * The Class SubtractOperation.
 */
public class SubtractOperation extends BinaryOperation {

	/**
  	 * Instantiates a new subtract operation.
  	 *
  	 * @param left the left
  	 * @param right the right
  	 */
  	public SubtractOperation(ASTNode left, ASTNode right) {
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
	    return left + "-" + right;
	  }
}
