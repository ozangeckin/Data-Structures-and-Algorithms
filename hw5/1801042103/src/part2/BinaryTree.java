//package part2;

/**
 * This class Binary Tree that hols hash table items
 * 
 * @author Ozan GECKIN
 *
 * @param <E> Generic Type
 */
public class BinaryTree<E> {

	// Inner Classes
	/** A Node is the building block for a tree. */
	@SuppressWarnings("hiding")
	private static class Node<Entry> {

		/** The data value. */
		private Entry data;

		/** The link to the left node. */
		private Node<Entry> left = null;

		/** The link to the right node. */
		private Node<Entry> right = null;

		/**
		 * Construct a node with the given data value.
		 * 
		 * @param dataItem The data value
		 */
		private Node(Entry dataItem) {
			data = dataItem;
		}
	}// end class Node

	// Data Fields
	/** A reference to the root of the tree. */
	@SuppressWarnings("rawtypes")
	private Node<Entry> root = null;

	/**
	 * This method add new item to tree
	 * 
	 * @param item Entry
	 */
	@SuppressWarnings("rawtypes")
	public void add( Entry item) {

		if (root == null) {
			root = new Node<Entry>(item);
			return;
		} else {
			addItem(root, item);
		}
	}

	/**
	 * This method adds the item into tree according to it's key.
	 * 
	 * @param root Node<Entry>
	 * @param item Entry
	 */
	@SuppressWarnings("rawtypes")
	private void addItem(Node<Entry> root, Entry item) {
		if (root.data.getKey() == item.getKey()) {
			root.data = item;
		} else {
			if (root.data.getKey().hashCode() > item.getKey().hashCode()) {
				if (root.left != null) {
					addItem(root.left, item);
				} else {
					root.left = new Node<Entry>(item);
				}
			} else {
				if (root.right != null) {
					addItem(root.right, item);
				} else {
					root.right = new Node<Entry>(item);
				}
			}
		}

	}

	/**
	 * This method returns root key
	 * 
	 * @return integer root key
	 */
	public Integer getRootKey() {
		return root == null ? null : root.data.getKey().hashCode();
	}

	/**
	 * This method returns value of key
	 * 
	 * @param key object
	 * @return value object
	 */
	public Object get(Object key) {
		return getObject(root, key);

	}

	/**
	 * This method gets object from tree for given key
	 * 
	 * @param root Node<Entry>
	 * @param key  Object
	 * @return Object
	 */
	@SuppressWarnings("rawtypes")
	private Object getObject(Node<Entry> root, Object key) {

		if (root == null) {
			return null;
		} else if (root.data.getKey().equals(key)) {
			return root.data;
		} else {
			if (root.data.getKey().hashCode() > key.hashCode()) {
				return getObject(root.left, key);
			} else {
				return getObject(root.right, key);
			}
		}
	}

	/**
	 * This method removes item
	 * 
	 * @param nextItem Entry
	 * @return boolean remove
	 */
	@SuppressWarnings("rawtypes")
	public boolean remove(Entry nextItem) {
		return removeObject(root, null, nextItem);
	}

	/**
	 * This method removes item from tree node
	 * 
	 * @param root     Node<Entry>
	 * @param nextItem Entry
	 * @return boolean remove
	 */
	@SuppressWarnings("rawtypes")
	private boolean removeObject(Node<Entry> root, Node<Entry> parent, Entry nextItem) {
		if (root == null) {
			return false;
		}

		if (root.data.getKey().equals(nextItem.getKey())) {
			if (parent == null) {
				this.root = removeNode(root);
				return true;
			}
			if (parent.left != null && parent.left.equals(root)) {
				parent.left = removeNode(root);
			} else {
				parent.right = removeNode(root);
			}
			return true;
		} else {
			if (root.data.getKey().hashCode() > nextItem.getKey().hashCode()) {
				return removeObject(root.left, root, nextItem);
			} else {
				return removeObject(root.right, root, nextItem);
			}
		}

	}

	/**
	 * This method removes node from tree
	 * 
	 * @param root Node<Entry>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Node<Entry> removeNode(Node<Entry> root) {
		if (root.left == null && root.right == null) {
			root = null;
		} else if (root.left == null) {
			root = root.right;
		} else if (root.right == null) {
			root = root.left;
		} else {
			Node predecessor = findPredecessor(root.left);
			root = predecessor;
		}
		return root;
	}

	/**
	 * This method find parent of given node
	 * 
	 * @param node Node<Entry>
	 * @return Node
	 */
	@SuppressWarnings("rawtypes")
	private Node findPredecessor(Node<Entry> node) {
		if (node.right != null) {
			return findPredecessor(node);
		}
		return node;
	}

	/**
	 * This method returns true if tree is empty otherwise false
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method prints the tree nodes in order
	 * 
	 * @param node
	 * @return String
	 */
	@SuppressWarnings("rawtypes")
	String printInorder(Node node) {
		if (node == null)
			return "";

		/* first recur on left child */
		String pre = printInorder(node.left);

		/* then print the data of node */

		/* now recur on right child */
		String post = printInorder(node.right);

		return pre + "" + node.data.toString() + "" + post;
	}

	/**
	 * This method print use BinaryTree class
	 * 
	 * @return String BinaryTree object
	 */
	@Override
	public String toString() {
		return printInorder(root);
	}
}
