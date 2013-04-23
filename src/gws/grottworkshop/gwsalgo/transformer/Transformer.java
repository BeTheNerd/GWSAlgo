package gws.grottworkshop.gwsalgo.transformer;

import gws.grottworkshop.gwsalgo.ast.ASTNode;
import gws.grottworkshop.gwsalgo.ast.expression.MathExpression;
import gws.grottworkshop.gwsalgo.ast.operation.BinaryOperation;
import gws.grottworkshop.gwsalgo.parser.Parser;
import gws.grottworkshop.gwsalgo.util.SymbolMathUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class Transformer.
 */
public class Transformer {

	/** The transformers. */
	private static ExpressionTransformer[] transformers = {
	      new MultiplicativeTransformer(),
	      new AdditiveTransformer()
	  };
	  
  	/** The element. */
  	private ASTNode element;

	  /**
  	 * Instantiates a new transformer.
  	 *
  	 * @param element the element
  	 */
  	public Transformer(ASTNode element) {
	    this.element = element;
	  }

	  /**
  	 * Instantiates a new transformer.
  	 *
  	 * @param s the s
  	 */
  	public Transformer(String s) {
	    this(new Parser(s, true).parse());
	  }

	  /**
  	 * Transform.
  	 *
  	 * @return the aST node
  	 */
  	public ASTNode transform() {
	    SymbolMathUtil.checkParents(this.element, null);
	    for (ExpressionTransformer transformer : transformers) {
	      this.element = transform(this.element, transformer);
	      SymbolMathUtil.checkParents(this.element, null);
	    }
	    return this.element;
	  }

	  /**
  	 * Transform.
  	 *
  	 * @param operation the operation
  	 * @param transformer the transformer
  	 * @return the aST node
  	 */
  	private ASTNode transform(ASTNode operation, ExpressionTransformer transformer) {
	    if (transformer.canTransform(operation)) {
	      MathExpression expression = transformer.transform((BinaryOperation) operation);
	      ASTNode parent = operation.getParent();
	      if (parent != null) {
	        parent.replaceChild(operation, expression);
	      }
	      operation = expression;
	    }

	    for (ASTNode child : operation.getChildren()) {
	      transform(child, transformer);
	    }

	    return operation;
	  }

	

}
