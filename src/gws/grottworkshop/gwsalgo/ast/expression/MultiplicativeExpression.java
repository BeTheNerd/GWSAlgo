package gws.grottworkshop.gwsalgo.ast.expression;

import gws.grottworkshop.gwsalgo.ast.ASTNode;
import gws.grottworkshop.gwsalgo.ast.leaf.IntegerElement;
import gws.grottworkshop.gwsalgo.ast.operation.NegativeOperation;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class MultiplicativeExpression.
 */
public class MultiplicativeExpression extends MathExpression {
	  
  	/** The multiplier. */
  	private int multiplier;

    /**
  	 * Instantiates a new multiplicative expression.
  	 *
  	 * @param multiplier the multiplier
  	 * @param terms the terms
  	 */
  	private MultiplicativeExpression(int multiplier, List<ASTNode> terms) {
	    super(terms);
	    this.multiplier = multiplier;
	  }

	  /**
  	 * Creates the.
  	 *
  	 * @param terms the terms
  	 * @return the math expression
  	 */
  	public static MathExpression create(List<ASTNode> terms) {
	    int multiplier = 1;
	    List<ASTNode> newTerms = new ArrayList<ASTNode>(terms.size());
	    for (ASTNode term : terms) {
	      multiplier = process(multiplier, term, newTerms);
	    }
	    MultiplicativeExpression expression = new MultiplicativeExpression(multiplier, newTerms);
	    return expression;
	  }

	  /**
  	 * Process.
  	 *
  	 * @param multiplier the multiplier
  	 * @param term the term
  	 * @param newTerms the new terms
  	 * @return the int
  	 */
  	private static int process(int multiplier, ASTNode term, List<ASTNode> newTerms) {
	    if (term instanceof NegativeOperation) {
	      multiplier = process(multiplier, term.getChildren().get(0), newTerms);
	      multiplier *= -1;
	    } else if (term instanceof IntegerElement) {
	      multiplier *= ((IntegerElement)term).getValue();
	    } else {
	      newTerms.add(term);
	    }
	    return multiplier;
	  }

	  /**
  	 * Join.
  	 *
  	 * @param expression the expression
  	 */
  	public void join(MultiplicativeExpression expression) {
	    this.multiplier += expression.multiplier;
	  }

	/**
	 * To string.
	 *
	 * @return the string
	 * @see gws.grottworkshop.gwsalgo.ast.ASTNode#toString()
	 */
  	@Override
	  public String toString() {
	    return (multiplier != 1 ? multiplier : "") + getSignature();
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
	    for (ASTNode term : terms) {
	      s += "" + term;
	    }
	    return s;
	  }

	  /**
  	 * Gets the multiplier.
  	 *
  	 * @return the multiplier
  	 */
  	public int getMultiplier() {
	    return multiplier;
	  }
}
