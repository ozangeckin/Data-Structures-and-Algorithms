//package part2;

/**
 * This class BSTHeapTree ,I have defined the necessary methods for part 2 of
 * the assignment.
 * 
 * @autor Ozan GECKIN
 */
public class BSTHeapTree {

	private BSTNode root;

	/**
	 * BSTNode represents tree nodes
	 */
	public class BSTNode {
		/** tree data represented as Max-Heap */
		private MaxHeap data;
		/** left node */
		private BSTNode left;
		/** right node */
		private BSTNode right;
		/** parent node */
		private BSTNode parent;

		/**
		 * No parametre constructor BSTNode class I set up data fiels
		 */
		public BSTNode() {
			super();
			this.data = new MaxHeap();
			this.left = null;
			this.right = null;
			this.parent = null;
		}
	}

	/**
	 * constructor for BST Heap Tree
	 */
	public BSTHeapTree() {
		root = new BSTNode();
	}

	/**
	 * Getter of BSTNode
	 * 
	 * @return BSTNode
	 */
	public BSTNode getRoot() {
		return root;
	}

	/**
	 * Getter of data
	 * 
	 * @param BSTNode node
	 * @return MaxHeap data
	 */
	public MaxHeap getData(BSTNode node) {
		return node.data;
	}

	/**
	 * This method sends the item it receives as a parameter to the addToMaxHeap
	 * function
	 * 
	 * @param item
	 * @return int addToMaxHeap mehthod result
	 */
	public int add(int item) {
		return addToMaxHeap(root, null, item);
	}

	/**
	 * This method Adds item to BST Heap Tree If item is already in tree occurrence
	 * of value is incremented Otherwise it is added to tree as a heap node
	 * 
	 * @param node
	 * @param parent
	 * @param item
	 * @return
	 */
	private int addToMaxHeap(BSTNode node, BSTNode parent, int item) {
		if (node == null) {
			node = new BSTNode();
			MaxHeap heap = new MaxHeap();
			heap.add(item);
			node.data = heap;
			node.parent = parent;
			if (parent != null) {
				if (parent.data.getMaxNode().compareTo(node.data.getMaxNode()) > 0) {
					parent.left = node;
				} else {
					parent.right = node;
				}
			}
			return 1;
		}

		if (!node.data.isFull() || node.data.contains(item)) {
			return node.data.add(item);
		} else {
			if (node.data.getMaxValue() > item) {
				return addToMaxHeap(node.left, node, item);
			} else {
				return addToMaxHeap(node.right, node, item);
			}
		}

	}

	/**
	 * This method returns result findInHeap
	 * 
	 * @param item
	 * @return int
	 */
	public int find(int item) {
		return findInHeap(root, item);
	}

	/**
	 * This method returns the number of occurrences of the item in the BST Heap
	 * Tree
	 * 
	 * @param node
	 * @param item
	 * @return
	 */
	private int findInHeap(BSTNode node, int item) {
		if (node == null) {
			return -1;
		}

		int occurence = node.data.getOccurence(item);
		if (occurence > -1) {
			return occurence;
		} else {
			if (node.data.getMaxNode().getValue() > item) {
				return findInHeap(node.left, item);
			} else {
				return findInHeap(node.right, item);
			}
		}
	}

	/**
	 * This method returns the value in the BST Heap Tree that occurs most
	 * frequently
	 * 
	 * @return int the value tha occurs most frequently
	 */
	public int find_mode() {
		MaxHeap.Node heapNode = findMode(root);
		return heapNode.getValue();
	}

	/**
	 * This method returns the node with the highest frequency by comparing the
	 * occurrences of each node.
	 * 
	 * @param node
	 * @return MaxHeap node
	 */
	private MaxHeap.Node findMode(BSTNode node) {

		if (node.left == null & node.right == null) {
			return node.data.getMaxOccurence();
		}
		if (node.left == null) {
			return findMode(node.right);
		} else {
			if (node.right == null) {
				return findMode(node.left);
			} else {
				MaxHeap.Node leftMax = findMode(node.left);
				MaxHeap.Node rightMax = findMode(node.right);
				if (leftMax.getOccurence() > rightMax.getOccurence()) {
					if (leftMax.getOccurence() > node.data.getMaxOccurence().getOccurence()) {
						return leftMax;
					} else {
						return node.data.getMaxOccurence();
					}
				} else {
					if (rightMax.getOccurence() > node.data.getMaxOccurence().getOccurence()) {
						return rightMax;
					} else {
						return node.data.getMaxOccurence();
					}
				}
			}
		}

	}

	/**
	 * This method removes the item from BST Heap Tree and returns the number of
	 * occurrence after removal
	 * 
	 * @param item
	 * @return the number of occurrence after removal
	 */
	public int remove(int item) {
		return removeFromMaxHeap(root, item);
	}

	/**
	 * This method finds the BST node that contains item and removes from heap data
	 * if heap is empty after removal BST node is deleted
	 * 
	 * @param node BSTNode
	 * @param item data
	 * @return int the number of occurrence after removal
	 */
	private int removeFromMaxHeap(BSTNode node, int item) {

		if (node == null) {
			return -1;
		}
		if (node.data.contains(item)) {
			int occurence = node.data.remove(item);
			if (node.data.isEmpty()) {
				removeNode(node);
			}
			return occurence;
		} else {
			if (node.data.getMaxValue() > item) {
				return removeFromMaxHeap(node.left, item);
			} else {
				return removeFromMaxHeap(node.right, item);
			}
		}
	}

	/**
	 * This method deletes the node filter it takes as a parameter.
	 * 
	 * @param node BSTNode
	 */
	private void removeNode(BSTNode node) {

		if (this.root.equals(node)) {
			removeRoot();
			return;
		}

		// left child of parent
		if (node.equals(node.parent.left)) {
			removeLeft(node.parent, node);
			return;
		}

		// right child of parent if
		if (node.equals(node.parent.right)) {
			removeRight(node.parent, node);

			return;
		}

	}

	/**
	 * This method checks root and deletes the treen
	 */
	private void removeRoot() {

		if (root.left != null && root.right != null) {
			addToFarRight(root.left, root.right);
			root.left.parent = null;
			root = root.left;
			return;
		}
		if (root.right != null) {
			root.right.parent = null;
			root = root.right;
			return;
		}
		if (root.left != null) {
			root.left.parent = null;
			root = root.left;
			return;
		}
		this.root = null;

	}

	/**
	 * This method After taking the parent node and node and making the necessary
	 * checks and assignments, it deletes it from the left side.
	 * 
	 * @param parent BSTNode
	 * @param node   BSTNode
	 */
	private void removeLeft(BSTNode parent, BSTNode node) {
		if (node.left != null && node.right != null) {
			addToFarRight(node.left, node.right);
			node.left.parent = parent;
			parent.left = node.left;
			return;
		}
		if (node.right != null) {
			parent.left = node.right;
			node.right.parent = parent;
			return;
		}

		if (node.left != null) {
			parent.left = node.left;
			node.left.parent = parent;
			return;
		}

		parent.left = null;

	}

	/**
	 * This method after taking the parent node and node and making the necessary
	 * checks and assignments, it deletes it from the right side.
	 * 
	 * @param parent BSTNode
	 * @param node   BSTNode
	 */
	private void removeRight(BSTNode parent, BSTNode node) {
		if (node.left != null && node.right != null) {
			addToFarLeft(node.right, node.left);
			node.right.parent = parent;
			parent.right = node.right;
			return;
		}
		if (node.right != null) {
			parent.right = node.right;
			node.right.parent = parent;
			return;
		}

		if (node.left != null) {
			parent.right = node.left;
			node.left.parent = parent;
			return;
		}

		parent.right = null;

	}

	/**
	 * This method until the right node is null. I use it in the removeRight method.
	 * 
	 * @param left  BSTNode
	 * @param right BSTNode
	 */
	public void addToFarRight(BSTNode left, BSTNode right) {
		while (left.right != null) {
			left = left.right;
		}
		left.right = right;
		right.parent = left;

	}
	/**
	 * This method until the left node is null. I use it in the removeLeft method.
	 * @param right BSTNode
	 * @param left BSTNode
	 */
	public void addToFarLeft(BSTNode right, BSTNode left) {
		while (right.left != null) {
			right = right.left;
		}
		right.left = left;
		left.parent = right;

	}
}
