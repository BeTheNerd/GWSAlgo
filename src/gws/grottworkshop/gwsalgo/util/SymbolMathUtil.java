package gws.grottworkshop.gwsalgo.util;

import gws.grottworkshop.gwsalgo.ast.ASTNode;

// TODO: Auto-generated Javadoc
/**
 * The Class SymbolMathUtil.
 */
public class SymbolMathUtil {

	/**
	 * Check parents.
	 *
	 * @param element the element
	 * @param parent the parent
	 */
	public static void checkParents(ASTNode element, ASTNode parent) {
	    if (element.getParent() != parent) {
	      throw new RuntimeException("Wrong parent");
	    }
	    for (ASTNode child : element.getChildren()) {
	      checkParents(child, element);
	    }
	  }

	  /**
  	 * Checks if is identifier.
  	 *
  	 * @param s the s
  	 * @return true, if is identifier
  	 */
  	public static boolean isIdentifier(String s) {
	    if (!Character.isJavaIdentifierStart(s.charAt(0))) {
	      return false;
	    }
	    for (int i = 1; i < s.length(); i++) {
	      if (!Character.isJavaIdentifierPart(s.charAt(i))) {
	        return false;
	      }
	    }
	    return true;
	  }

	  /**
  	 * Parses the as int.
  	 *
  	 * @param s the s
  	 * @return the integer
  	 */
  	public static Integer parseAsInt(String s) {
	    try {
	      return Integer.parseInt(s);
	    } catch (NumberFormatException e) {
	      return null;
	    }
	  }

	  /**
  	 * Parses the as float.
  	 *
  	 * @param s the s
  	 * @return the double
  	 */
  	public static Double parseAsFloat(String s) {
	    try {
	      return Double.parseDouble(s);
	    } catch (NumberFormatException e) {
	      return null;
	    }
	  }

	

}
