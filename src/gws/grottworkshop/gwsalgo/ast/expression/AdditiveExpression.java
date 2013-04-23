package gws.grottworkshop.gwsalgo.ast.expression;

import gws.grottworkshop.gwsalgo.ast.ASTNode;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class AdditiveExpression.
 */
public class AdditiveExpression extends MathExpression {

	/**
  	 * Instantiates a new additive expression.
  	 *
  	 * @param terms the terms
  	 */
  	public AdditiveExpression(List<ASTNode> terms) {
	    super(terms);
	  }

	/**
	 * To string.
	 *
	 * @return the string
	 * @see gws.grottworkshop.gwsalgo.ast.ASTNode#toString()
	 */
  	@Override
	  public String toString() {
	    if (getChildren().size() > 1) {
	      return "(" + getSignature() + ")";
	    } else {
	      return getSignature();
	    }
	  }

	/**
	 * Gets the signature.
	 *
	 * @return the signature
	 * @see gws.grottworkshop.gwsalgo.ast.expression.MathExpression#getSignature()
	 */
  	@Override
	  public String getSignature() {
	    String s = "";
	    for (int i = 0; i < terms.size(); i++) {
	      s += "" + terms.get(i);
	      s += (i != terms.size() - 1) ? " + " : "";
	    }
	    return s;
	  }
}
