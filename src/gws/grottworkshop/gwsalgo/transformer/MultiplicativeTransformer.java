package gws.grottworkshop.gwsalgo.transformer;

import java.util.ArrayList;
import java.util.List;

import gws.grottworkshop.gwsalgo.ast.ASTNode;
import gws.grottworkshop.gwsalgo.ast.expression.MathExpression;
import gws.grottworkshop.gwsalgo.ast.expression.MultiplicativeExpression;
import gws.grottworkshop.gwsalgo.ast.operation.BinaryOperation;
import gws.grottworkshop.gwsalgo.ast.operation.MultiplyOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class MultiplicativeTransformer.
 */
public class MultiplicativeTransformer implements ExpressionTransformer {

	  /* (non-Javadoc)
  	 * @see gws.grottworkshop.gwsalgo.transformer.ExpressionTransformer#canTransform(gws.grottworkshop.gwsalgo.ast.ASTNode)
  	 */
  	public boolean canTransform(ASTNode operation) {
	    return operation instanceof MultiplyOperation;
	  }

	  /* (non-Javadoc)
  	 * @see gws.grottworkshop.gwsalgo.transformer.ExpressionTransformer#transform(gws.grottworkshop.gwsalgo.ast.operation.BinaryOperation)
  	 */
  	public MathExpression transform(BinaryOperation operation) {
	    List<ASTNode> terms = new ArrayList<ASTNode>();
	    collectTerms(operation, terms);
	    return MultiplicativeExpression.create(terms);
	  }

	  /**
  	 * Collect terms.
  	 *
  	 * @param operation the operation
  	 * @param terms the terms
  	 */
  	private void collectTerms(BinaryOperation operation, List<ASTNode> terms) {
	    ASTNode left = operation.getLeft();
	    if (canTransform(left)) {
	      collectTerms((BinaryOperation) left, terms);
	    } else {
	      terms.add(left);
	    }
	    ASTNode right = operation.getRight();
	    if (canTransform(right)) {
	      collectTerms((BinaryOperation) right, terms);
	    } else {
	      terms.add(right);
	    }
	  }

	}
