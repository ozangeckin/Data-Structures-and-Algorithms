package part2;

import part2.BinaryTree.Node;

/**
 * This class contains methods that allow me to check if a binary search tree is
 * an AVL tree.
 * 
 * @author 1801042103
 */
public class CheckAVL<E extends Comparable<E>> {

	/**
	 * This method check AVLTree
	 * 
	 * @param tree BinarySearchTree
	 * @return
	 */
	public boolean isAVLTree(BinarySearchTree<E> tree) {
		return isBalance(tree.root);
	}

	/**
	 * This method return tree of height
	 * 
	 * @param root Node<E>
	 * @return integer height
	 */
	public int height(Node<E> root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	/**
	 * This method controls the right and left tree lengths starting from the root
	 * value it receives, recursively. If the subtree height difference is more than
	 * 1, it is not balance. I calculated the height difference in absolute value so
	 * that the difference is not negative.
	 * 
	 * @param node Node<E>
	 * @return boolean if tree is balanced true or false
	 */
	boolean isBalance(Node<E> node) {
		int leftHeight;
		int rightHeight;

		if (node == null) {
			return true;
		}
		leftHeight = height(node.left);
		rightHeight = height(node.right);
		if (Math.abs(leftHeight - rightHeight) <= 1 && isBalance(node.left) && isBalance(node.right)) {
			return true;
		}
		return false;
	}

}
