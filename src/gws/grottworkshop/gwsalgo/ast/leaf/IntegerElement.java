package gws.grottworkshop.gwsalgo.ast.leaf;

import gws.grottworkshop.gwsalgo.scanner.Token;

// TODO: Auto-generated Javadoc
/**
 * The Class IntegerElement.
 */
public class IntegerElement extends LeafElement {
	  
  	/** The value. */
  	private Integer value;

	/**
  	 * Instantiates a new integer element.
  	 *
  	 * @param token the token
  	 */
  	public IntegerElement(Token token) {
	    this.value = (Integer) token.getValue();
	  }

	/**
	 * To string.
	 *
	 * @return the string
	 * @see gws.grottworkshop.gwsalgo.ast.leaf.LeafElement#toString()
	 */
  	@Override
	public String toString() {
	    return value.toString();
	}

	/**
  	 * Gets the value.
  	 *
  	 * @return the value
  	 */
  	public int getValue() {
	    return value;
	  }
	}
