package gws.grottworkshop.gwsalgo.simplifier;

import java.util.Collection;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

import gws.grottworkshop.gwsalgo.ast.ASTNode;
import gws.grottworkshop.gwsalgo.ast.expression.AdditiveExpression;
import gws.grottworkshop.gwsalgo.ast.expression.MathExpression;
import gws.grottworkshop.gwsalgo.ast.expression.MultiplicativeExpression;
import gws.grottworkshop.gwsalgo.ast.operation.PowerOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class AdditiveExpressionSimplifier.
 */
public class AdditiveExpressionSimplifier extends ExpressionSimplifier<AdditiveExpression> {

	  /* (non-Javadoc)
  	 * @see gws.grottworkshop.gwsalgo.simplifier.ExpressionSimplifier#getApplicableElement()
  	 */
  	public Class<AdditiveExpression> getApplicableElement() {
	    return AdditiveExpression.class;
	  }

	  /* (non-Javadoc)
  	 * @see gws.grottworkshop.gwsalgo.simplifier.ExpressionSimplifier#simplify(gws.grottworkshop.gwsalgo.ast.ASTNode)
  	 */
  	public SimplifyResult simplify(AdditiveExpression expression) {
	    Multimap<String, ASTNode> mapping = LinkedListMultimap.create();
	    for (ASTNode term : expression.getChildren()) {
	      MathExpression expr = (MathExpression) term;
	      mapping.put(expr.getSignature(), term);
	    }
	    boolean simplified = false;
	    for (String key : mapping.keySet()) {
	      Collection<ASTNode> elements = mapping.get(key);
	      if (elements.size() > 1) {
	        MultiplicativeExpression joinedExpression = null;
	        for (ASTNode astElement : elements) {
	          if (!(astElement instanceof MultiplicativeExpression) && !(astElement instanceof PowerOperation)) {
	            throw new RuntimeException("Must be a MultiplicativeExpression or a PowerOperation");
	          }
	          if (joinedExpression == null) {
	            joinedExpression = (MultiplicativeExpression) astElement;
	          } else {
	            joinedExpression.join((MultiplicativeExpression) astElement);
	            expression.removeChild(astElement);
	          }
	        }
	        simplified = true;
	      }
	    }

	    // convert to multiplicative expression
	    ASTNode newElement = expression;
	    if (expression.getChildren().size() == 1) {
	      newElement = expression.getChildren().get(0);
	    }

	    return new SimplifyResult(simplified, newElement);
	  }

	}
