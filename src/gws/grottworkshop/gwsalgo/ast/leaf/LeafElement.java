package gws.grottworkshop.gwsalgo.ast.leaf;

import java.util.List;

import gws.grottworkshop.gwsalgo.ast.ASTNode;

// TODO: Auto-generated Javadoc
/**
 * The Class LeafElement.
 */
public abstract class LeafElement extends ASTNode {

	/**
	 * Replace child.
	 *
	 * @param element the element
	 * @param newElement the new element
	 * @see gws.grottworkshop.gwsalgo.ast.ASTNode#replaceChild(gws.grottworkshop.gwsalgo.ast.ASTNode, gws.grottworkshop.gwsalgo.ast.ASTNode)
	 */
	@Override
	public void replaceChild(ASTNode element, ASTNode newElement) {
		throw new UnsupportedOperationException("replaceChild() not supported for leaf elements.");
		
	}

	/**
	 * To string.
	 *
	 * @return the string
	 * @see gws.grottworkshop.gwsalgo.ast.ASTNode#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the children.
	 *
	 * @return the children
	 * @see gws.grottworkshop.gwsalgo.ast.ASTNode#getChildren()
	 */
	@Override
	public List<? extends ASTNode> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

}
