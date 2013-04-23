package gws.grottworkshop.gwsalgo.transformer;

import gws.grottworkshop.gwsalgo.ast.ASTNode;
import gws.grottworkshop.gwsalgo.ast.expression.MathExpression;
import gws.grottworkshop.gwsalgo.ast.operation.BinaryOperation;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExpressionTransformer.
 */
public interface ExpressionTransformer {

	/**
	 * Can transform.
	 *
	 * @param operation the operation
	 * @return true, if successful
	 */
	boolean canTransform(ASTNode operation);

	/**
	 * Transform.
	 *
	 * @param operation the operation
	 * @return the math expression
	 */
	MathExpression transform(BinaryOperation operation);

}
