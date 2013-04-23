package gws.grottworkshop.gwsalgo.scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Token.
 */
public class Token {

	/** The type. */
	private final TokenType type;
	  
  	/** The value. */
  	private Object value;

	/**
  	 * Instantiates a new token.
  	 *
  	 * @param type the type
  	 * @param value the value
  	 */
  	public Token(TokenType type, Object value) {
	    this.type = type;
	    this.value = value;
	  }

	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
  	public String toString() {
	    return type + (value == null ? "" : "(" + value + ")");
	  }

	  /**
  	 * Gets the type.
  	 *
  	 * @return the type
  	 */
  	public TokenType getType() {
	    return type;
	  }

	  /**
  	 * Gets the value.
  	 *
  	 * @return the value
  	 */
  	public Object getValue() {
	    return value;
	  }
}
