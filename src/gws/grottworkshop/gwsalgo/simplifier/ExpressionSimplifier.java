package gws.grottworkshop.gwsalgo.simplifier;

import gws.grottworkshop.gwsalgo.ast.ASTNode;

// TODO: Auto-generated Javadoc
/**
 * The Class ExpressionSimplifier.
 *
 * @param <T> the generic type
 */
public abstract class ExpressionSimplifier<T extends ASTNode> {

	  /**
  	 * Gets the applicable element.
  	 *
  	 * @return the applicable element
  	 */
  	public abstract Class<T> getApplicableElement();

	  /**
  	 * Simplify.
  	 *
  	 * @param element the element
  	 * @return the simplify result
  	 */
  	public abstract SimplifyResult simplify(T element);

}
