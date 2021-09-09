package part2;

import part2.BinaryTree.Node;

/**
 * This class Check Red black tree .
 * 
 * @author 1801042103
 * 
 */
public class CheckRedBlack<E extends Comparable<E>> {

	public boolean isRedBlack(Node<E> root) {
		if (root.isRed()) {
			return false;
		}
		return true;

	}

}
