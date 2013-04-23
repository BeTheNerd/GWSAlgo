package gws.grottworkshop.gwsalgo.scanner;

// TODO: Auto-generated Javadoc
/**
 * The Enum TokenType.
 */
public enum TokenType {

	/** The plus. */
	PLUS("+"),
	  
  	/** The minus. */
  	MINUS("-"),
	  
  	/** The times. */
  	TIMES("*"),
	  
  	/** The division. */
  	DIVISION("/"),
	  
  	/** The power. */
  	POWER("^"),
	  
  	/** The lparen. */
  	LPAREN("("),
	  
  	/** The rparen. */
  	RPAREN(")"),
	  
  	/** The equals. */
  	EQUALS("="),
	  
  	/** The integer. */
  	INTEGER(),
	  
  	/** The float. */
  	FLOAT(),
	  
  	/** The identifier. */
  	IDENTIFIER(),
	  
  	/** The whitespace. */
  	WHITESPACE(),
	  
  	/** The eof. */
  	EOF();

	  /** The text. */
  	private String text;

	  /**
  	 * Instantiates a new token type.
  	 */
  	TokenType() {
	  }

	  /**
  	 * Instantiates a new token type.
  	 *
  	 * @param text the text
  	 */
  	TokenType(String text) {
	    this.text = text;
	  }

	  /**
  	 * Gets the text.
  	 *
  	 * @return the text
  	 */
  	public String getText() {
	    return text;
	  }
}
