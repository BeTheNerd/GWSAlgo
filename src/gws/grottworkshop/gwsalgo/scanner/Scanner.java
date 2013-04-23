package gws.grottworkshop.gwsalgo.scanner;

import gws.grottworkshop.gwsalgo.exception.ParseException;
import gws.grottworkshop.gwsalgo.exception.SyntaxException;
import gws.grottworkshop.gwsalgo.util.SymbolMathUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class Scanner.
 */
public class Scanner {

	/** The ignore whitespace. */
	private boolean ignoreWhitespace;
	  
  	/** The text. */
  	private String text;
	  
  	/** The index. */
  	private int index;
	  
  	/** The current char. */
  	private int currentChar;

	  /**
  	 * Instantiates a new scanner.
  	 *
  	 * @param text the text
  	 * @param ignoreWhitespace the ignore whitespace
  	 */
  	public Scanner(String text, boolean ignoreWhitespace) {
	    this.text = text;
	    this.ignoreWhitespace = ignoreWhitespace;
	    this.index = -1;
	    nextChar();
	  }

	  /**
  	 * Next char.
  	 *
  	 * @return the int
  	 */
  	private int nextChar() {
	    if (index == text.length() - 1) {
	      currentChar = -1;
	      return currentChar;
	    } else {
	      index++;
	      currentChar = text.charAt(index);
	      return currentChar;
	    }
	  }

	  /**
  	 * Checks for tokens.
  	 *
  	 * @return true, if successful
  	 */
  	public boolean hasTokens() {
	    return currentChar != -1;
	  }

	  /**
  	 * Next token.
  	 *
  	 * @return the token
  	 * @throws ParseException the parse exception
  	 */
  	public Token nextToken() throws ParseException {
	    if (currentChar == -1) {
	      return new Token(TokenType.EOF, "");
	    }
	    if (isWhitespace(currentChar)) {
	      if (ignoreWhitespace) {
	        parseWhitespace();
	        return nextToken();
	      } else {
	        return parseWhitespace();
	      }
	    }
	    for (TokenType tt : TokenType.values()) {
	      String text = tt.getText();
	      if (text != null && text.length() == 1 && currentChar == text.charAt(0)) {
	        nextChar();
	        return new Token(tt, null);
	      }
	    }
	    if (isIdentifierStart(currentChar)) {
	      return parseIdentifier();
	    }
	    if (isDigit(currentChar)) {
	      return parseNumber();
	    }
	    throw new SyntaxException("Syntax error: unexpected symbol '" + (char)currentChar + "'", text, index);
	  }

	  

	/**
	 * Parses the number.
	 *
	 * @return the token
	 */
	private Token parseNumber() {
	    StringBuilder digitText = new StringBuilder();
	    do {
	      digitText.append((char)currentChar);
	    } while (isDigit(nextChar()));
	    return new Token(TokenType.INTEGER, SymbolMathUtil.parseAsInt(digitText.toString()));
	  }

	  

	  /**
  	 * Parses the whitespace.
  	 *
  	 * @return the token
  	 */
  	private Token parseWhitespace() {
		    StringBuilder white = new StringBuilder();
		    do {
		      white.append((char)currentChar);
		    } while (isWhitespace(nextChar()));
		    return new Token(TokenType.WHITESPACE, white.toString());
		  }

		  /**
  		 * Parses the identifier.
  		 *
  		 * @return the token
  		 */
  		private Token parseIdentifier() {
		    StringBuilder id = new StringBuilder();
		    do {
		      id.append((char)currentChar);
		    } while (isIdentifierPart(nextChar()));
		    return new Token(TokenType.IDENTIFIER, id.toString());
		  }

		  /**
  		 * Checks if is digit.
  		 *
  		 * @param c the c
  		 * @return true, if is digit
  		 */
  		private boolean isDigit(int c) {
		    return c >= '0' && c <= '9';
		  }

		  /**
  		 * Checks if is whitespace.
  		 *
  		 * @param c the c
  		 * @return true, if is whitespace
  		 */
  		private boolean isWhitespace(int c) {
		    return Character.isWhitespace(c);
		  }

		  /**
  		 * Checks if is identifier part.
  		 *
  		 * @param c the c
  		 * @return true, if is identifier part
  		 */
  		private boolean isIdentifierPart(int c) {
		    return Character.isJavaIdentifierPart(c);
		  }

		  /**
  		 * Checks if is identifier start.
  		 *
  		 * @param c the c
  		 * @return true, if is identifier start
  		 */
  		private boolean isIdentifierStart(int c) {
		    return Character.isJavaIdentifierStart(c);
		  }

		

}
