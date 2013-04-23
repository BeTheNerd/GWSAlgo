package gws.grottworkshop.gwsalgo.ast.operation;

import gws.grottworkshop.gwsalgo.ast.ASTNode;
import gws.grottworkshop.gwsalgo.exception.TransformException;

import java.util.Arrays;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class BinaryOperation.
 */
public abstract class BinaryOperation extends ASTOperation {
	  
  	/** The left. */
  	protected ASTNode left;
	  
  	/** The right. */
  	protected ASTNode right;

	/**
  	 * Instantiates a new binary operation.
  	 *
  	 * @param left the left
  	 * @param right the right
  	 */
  	public BinaryOperation(ASTNode left, ASTNode right) {
	    this.left = left;
	    this.right = right;
	  }

	  /**
  	 * Gets the left.
  	 *
  	 * @return the left
  	 */
  	public ASTNode getLeft() {
	    return left;
	  }

	  /**
  	 * Gets the right.
  	 *
  	 * @return the right
  	 */
  	public ASTNode getRight() {
	    return right;
	  }

	/**
	 * Replace child.
	 *
	 * @param element the element
	 * @param newElement the new element
	 * @see gws.grottworkshop.gwsalgo.ast.ASTNode#replaceChild(gws.grottworkshop.gwsalgo.ast.ASTNode, gws.grottworkshop.gwsalgo.ast.ASTNode)
	 */
  	public void replaceChild(ASTNode element, ASTNode newElement) {
	    if (element == left) {
	      left = newElement;
	      newElement.setParent(this);
	    } else if (element == right) {
	      right = newElement;
	      newElement.setParent(this);
	    } else {
	      throw new TransformException("No such child: " + element);
	    }
	  }

	/**
	 * Gets the children.
	 *
	 * @return the children
	 * @see gws.grottworkshop.gwsalgo.ast.ASTNode#getChildren()
	 */
  	@Override
	  public List<ASTNode> getChildren() {
	    return Arrays.asList(left, right);
	  }
	}
