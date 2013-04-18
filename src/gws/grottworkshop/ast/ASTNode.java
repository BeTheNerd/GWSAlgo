package gws.grottworkshop.ast;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ASTNode, our ast tree.
 * 
 * @author fredgrott
 */
public abstract class ASTNode {

	/** The Constant NO_CHILDREN. */
	public static final List<ASTNode> NO_CHILDREN = new ArrayList<ASTNode>();

	  /** The parent. */
  	protected ASTNode parent;

	  /**
  	 * Instantiates a new aST node.
  	 */
  	public ASTNode() {
	  }

	  /**
  	 * Gets the parent.
  	 *
  	 * @return the parent
  	 */
  	public ASTNode getParent() {
	    return parent;
	  }

	  /**
  	 * Sets the parent.
  	 *
  	 * @param parent the new parent
  	 */
  	public void setParent(ASTNode parent) {
	    this.parent = parent;
	  }

	  /**
  	 * Replace child.
  	 *
  	 * @param element the element
  	 * @param newElement the new element
  	 */
  	public abstract void replaceChild(ASTNode element, ASTNode newElement);

	  /* (non-Javadoc)
  	 * @see java.lang.Object#toString()
  	 */
  	public abstract String toString();

	  /**
  	 * Gets the children.
  	 *
  	 * @return the children
  	 */
  	public abstract List<? extends ASTNode> getChildren();

}
