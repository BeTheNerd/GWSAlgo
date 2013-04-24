package gws.grottworkshop.gwsalgo.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class SyntaxException.
 */
@SuppressWarnings("serial")
public class SyntaxException extends ParseException {

	  /**
  	 * Instantiates a new syntax exception.
  	 *
  	 * @param message the message
  	 * @param text the text
  	 * @param index the index
  	 */
  	public SyntaxException(String message, String text, int index) {
	    super(getError(message, text, index));
	  }

	  /**
  	 * Gets the error.
  	 *
  	 * @param message the message
  	 * @param text the text
  	 * @param index the index
  	 * @return the error
  	 */
  	private static String getError(String message, String text, int index) {
	    return message + "\n" + text + "\n" + spaces(index) + "^";
	  }

	  /**
  	 * Spaces.
  	 *
  	 * @param n the n
  	 * @return the string
  	 */
  	private static String spaces(int n) {
	    StringBuilder f = new StringBuilder(n);
	    for (int i = 0; i < n; i++) {
	      f.append(' ');
	    }
	    return f.toString();
	  }

}
