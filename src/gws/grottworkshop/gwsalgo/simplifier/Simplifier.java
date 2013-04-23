package gws.grottworkshop.gwsalgo.simplifier;

import java.util.List;

import gws.grottworkshop.gwsalgo.ast.ASTNode;
import gws.grottworkshop.gwsalgo.parser.Parser;

// TODO: Auto-generated Javadoc
/**
 * The Class Simplifier.
 */
public class Simplifier {
	  
  	/** The simplifiers. */
  	private static ExpressionSimplifier[] simplifiers = {
	      new AdditiveExpressionSimplifier()
	  };

	  /** The tree. */
  	private ASTNode tree;

	  /**
  	 * Instantiates a new simplifier.
  	 *
  	 * @param tree the tree
  	 */
  	public Simplifier(ASTNode tree) {
	    this.tree = tree;
	  }

	  /**
  	 * Instantiates a new simplifier.
  	 *
  	 * @param expression the expression
  	 */
  	public Simplifier(String expression) {
	    this(new Parser(expression, true).parse());
	  }

	  /**
  	 * Simplify.
  	 *
  	 * @return the aST node
  	 */
  	public ASTNode simplify() {
	    SimplifyResult result;
	    while ((result = simplify(tree)).simplified) {
	      tree = result.newElement;
	    }
	    return tree;
	  }

	  /**
  	 * Simplify.
  	 *
  	 * @param element the element
  	 * @return the simplify result
  	 */
  	private SimplifyResult simplify(ASTNode element) {
	    boolean simplified = false;

	    for (ExpressionSimplifier simplifier : simplifiers) {
	      if (element.getClass().isAssignableFrom(simplifier.getApplicableElement())) {
	        SimplifyResult result = simplifier.simplify(element);
	        if (result.simplified) {
	          simplified = true;
	          if (result.newElement != null) {
	            ASTNode parent = element.getParent();
	            if (parent != null) {
	              parent.replaceChild(element, result.newElement);
	            } else {
	              element = result.newElement;
	            }
	          }
	        }
	      }
	    }

	    if (!simplified) {
	      List<? extends ASTNode> children = element.getChildren();
	      for (ASTNode child : children) {
	        SimplifyResult result = simplify(child);
	        if (result.simplified) {
	          simplified = true;
	        }
	      }
	    }

	    return new SimplifyResult(simplified, element);
	  }

	}
