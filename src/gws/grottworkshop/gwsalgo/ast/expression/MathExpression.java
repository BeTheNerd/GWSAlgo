package gws.grottworkshop.gwsalgo.ast.expression;

import java.util.List;

import gws.grottworkshop.gwsalgo.ast.ASTNode;

// TODO: Auto-generated Javadoc
/**
 * The Class MathExpression.
 */
public abstract class MathExpression extends ASTNode {
	  
  	/** The terms. */
  	protected List<ASTNode> terms;

	  /**
  	 * Instantiates a new math expression.
  	 *
  	 * @param terms the terms
  	 */
  	public MathExpression(List<ASTNode> terms) {
	    this.terms = terms;
	    setTermParents();
	  }

	/**
  	 * Sets the term parents.
  	 */
  	private void setTermParents() {
	    for (ASTNode term : terms) {
	      term.setParent(this);
	    }
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
	    throw new UnsupportedOperationException("not supported yet");
	  }

	/**
	 * Gets the children.
	 *
	 * @return the children
	 * @see gws.grottworkshop.gwsalgo.ast.ASTNode#getChildren()
	 */
  	@Override
	  public List<ASTNode> getChildren() {
	    return terms;
	  }

	/**
  	 * Removes the child.
  	 *
  	 * @param astNode the ast node
  	 */
  	public void removeChild(ASTNode astNode) {
	    terms.remove(astNode);
	  }

	  /**
  	 * Gets the signature.
  	 *
  	 * @return the signature
  	 */
  	public abstract String getSignature();

	}
