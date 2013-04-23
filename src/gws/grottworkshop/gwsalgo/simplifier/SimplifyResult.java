package gws.grottworkshop.gwsalgo.simplifier;

import gws.grottworkshop.gwsalgo.ast.ASTNode;

// TODO: Auto-generated Javadoc
/**
 * The Class SimplifyResult.
 */
public class SimplifyResult {
	  
  	/** The simplified. */
  	public final boolean simplified;
	  
  	/** The new element. */
  	public final ASTNode newElement;

	  /**
  	 * Instantiates a new simplify result.
  	 *
  	 * @param simplified the simplified
  	 */
  	public SimplifyResult(boolean simplified) {
	    this.simplified = simplified;
	    this.newElement = null;
	  }

	  /**
  	 * Instantiates a new simplify result.
  	 *
  	 * @param simplified the simplified
  	 * @param newElement the new element
  	 */
  	public SimplifyResult(boolean simplified, ASTNode newElement) {
	    this.simplified = simplified;
	    this.newElement = newElement;
	  }
}
