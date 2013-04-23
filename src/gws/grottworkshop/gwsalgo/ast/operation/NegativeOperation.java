package gws.grottworkshop.gwsalgo.ast.operation;

import java.util.Arrays;
import java.util.List;

import gws.grottworkshop.gwsalgo.ast.ASTNode;
import gws.grottworkshop.gwsalgo.exception.TransformException;

// TODO: Auto-generated Javadoc
/**
 * The Class NegativeOperation.
 */
public class NegativeOperation extends ASTOperation {
	  
  	/** The expression. */
  	private ASTNode expression;

	  /**
  	 * Instantiates a new negative operation.
  	 *
  	 * @param expression the expression
  	 */
  	public NegativeOperation(ASTNode expression) {
	    this.expression = expression;
	    this.expression.setParent(this);
	  }

	/**
	 * To string.
	 *
	 * @return the string
	 * @see gws.grottworkshop.gwsalgo.ast.ASTNode#toString()
	 */
  	@Override
	  public String toString() {
	    return "(-(" + expression + "))";
	  }

	/**
	 * Gets the children.
	 *
	 * @return the children
	 * @see gws.grottworkshop.gwsalgo.ast.ASTNode#getChildren()
	 */
  	@Override
	  public List<? extends ASTNode> getChildren() {
	    return Arrays.asList(expression);
	  }

	/**
	 * Replace child.
	 *
	 * @param element the element
	 * @param newElement the new element
	 * @see gws.grottworkshop.gwsalgo.ast.ASTNode#replaceChild(gws.grottworkshop.gwsalgo.ast.ASTNode, gws.grottworkshop.gwsalgo.ast.ASTNode)
	 */
  	@Override
	  public void replaceChild(ASTNode element, ASTNode newElement) {
	    if (expression == element) {
	      expression = newElement;
	      newElement.setParent(this);
	    } else {
	      throw new TransformException("No such child: " + element);
	    }
	  }
}
