package gws.grottworkshop.gwsalgo.ast.operation;

import gws.grottworkshop.gwsalgo.ast.ASTNode;

// TODO: Auto-generated Javadoc
/**
 * The Class MultiplyOperation.
 */
public class MultiplyOperation extends BinaryOperation {

	/**
  	 * Instantiates a new multiply operation.
  	 *
  	 * @param left the left
  	 * @param right the right
  	 */
  	public MultiplyOperation(ASTNode left, ASTNode right) {
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
	    return left + "*" + right;
	  }

}