/**
 * This class MaxHeap implement for using BSTHeapTree  
 * @author Ozan GECKIN
 * 
 */
//package part2;

public class MaxHeap {

	/**
	 * Node represents heap nodes as value, occurrence
	 */
	public class Node implements Comparable<Object> {

		private int value;
		private int occurrence;

		/**
		 * Node constructor Sets occurrence of value to 1
		 * 
		 * @param int value
		 */
		public Node(int item) {
			this.value = item;
			this.occurrence = 1;
		}

		/**
		 * Getter of value in Node class
		 * 
		 * @return int value
		 */
		public int getValue() {
			return value;
		}

		/**
		 * Getter of occurrence in Node class
		 * 
		 * @return int occurrence
		 */
		public int getOccurence() {
			return occurrence;
		}

		/**
		 * Setter for value in Node class
		 * 
		 * @param int value
		 */
		public void setValue(int value) {
			this.value = value;
		}

		/**
		 * Increments occurrence of value by 1
		 */
		public void incrementOccurrence() {
			this.occurrence++;
		}

		/**
		 * Decrements occurrence of value by 1
		 */
		public void decrementOccurrence() {
			this.occurrence--;
		}

		/**
		 * Compares this object with the specified object for order. Returns a negative
		 * integer, zero, or a positive integer as this object is less than, equal to,
		 * or greater than the specified object.
		 *
		 * <p>
		 * The implementor must ensure <tt>sgn(x.compareTo(y)) ==
		 * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>. (This implies
		 * that <tt>x.compareTo(y)</tt> must throw an exception iff
		 * <tt>y.compareTo(x)</tt> throws an exception.)
		 *
		 * <p>
		 * The implementor must also ensure that the relation is transitive:
		 * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
		 * <tt>x.compareTo(z)&gt;0</tt>.
		 *
		 * <p>
		 * Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt> implies
		 * that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for all <tt>z</tt>.
		 *
		 * <p>
		 * It is strongly recommended, but <i>not</i> strictly required that
		 * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>. Generally speaking, any class
		 * that implements the <tt>Comparable</tt> interface and violates this condition
		 * should clearly indicate this fact. The recommended language is "Note: this
		 * class has a natural ordering that is inconsistent with equals."
		 *
		 * <p>
		 * In the foregoing description, the notation
		 * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
		 * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
		 * <tt>0</tt>, or <tt>1</tt> according to whether the value of <i>expression</i>
		 * is negative, zero or positive.
		 *
		 * @param o the object to be compared.
		 * @return a negative integer, zero, or a positive integer as this object is
		 *         less than, equal to, or greater than the specified object.
		 * @throws NullPointerException if the specified object is null
		 * @throws ClassCastException   if the specified object's type prevents it from
		 *                              being compared to this object.
		 */
		@Override
		public int compareTo(Object o) {
			if (o != null) {
				Node node = (Node) o;
				if (this.value < node.value)
					return -1;
				if (this.value == node.value)
					return 0;
				return 1;
			} else {
				return 1;
			}
		}
	}

	/** Node array for heap data */
	private Node[] heapData;
	/** Size of heap */
	private int size;
	/** Maximum size of heap nodes */
	private final static int MAXSIZE = 7;

	/**
	 * No parameter constructor for MaxHeap max heap with given maximum capacity and
	 * value.
	 */
	public MaxHeap() {
		this.size = 0;
		heapData = new Node[MAXSIZE + 1];
		Node node = new Node(Integer.MAX_VALUE);
		node.decrementOccurrence();
		heapData[0] = node;
	}

	/**
	 * Getter of heapData in MaxHeap class
	 * 
	 * @return Node[] heapData
	 */
	public Node[] getHeapData() {
		return heapData;
	}

	/**
	 * Setter for size in MaxHeap class
	 * 
	 * @param int size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * This method returns position of parent in MaxHeap class
	 * 
	 * @param int position
	 * @return int parent position
	 */
	private int parent(int pos) {
		return pos / 2;
	}

	/**
	 * This method return left child in MaxHeap class
	 * 
	 * @param int position
	 * @return int leftChild position
	 */
	private int leftChild(int pos) {
		return (2 * pos);
	}

	/**
	 * This method return right child in MaxHeap class
	 * 
	 * @param int position
	 * @return int rightChild position
	 */
	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	/**
	 * This method returns true of given node is leaf in MaxHeap class
	 * 
	 * @param int position
	 * @return boolean
	 */
	private boolean isLeaf(int pos) {
		if (pos > (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	/**
	 * This method swaps two heap node in MaxHeap class
	 * 
	 * @param fpos
	 * @param spos
	 */
	private void swap(int fpos, int spos) {
		Node tmpNode;
		tmpNode = heapData[fpos];
		heapData[fpos] = heapData[spos];
		heapData[spos] = tmpNode;
	}

	/**
	 * This method a recursive function to max heapify the given subtree.This
	 * function assumes that the left and right subtrees are already heapified,we
	 * only need to fix the root
	 * 
	 * @param int position
	 */
	private void maxHeapify(int pos) {
		if (isLeaf(pos))
			return;

		if (heapData[pos].compareTo(heapData[leftChild(pos)]) < 0
				|| heapData[pos].compareTo(heapData[rightChild(pos)]) < 0) {

			if (heapData[leftChild(pos)].compareTo(heapData[rightChild(pos)]) > 0) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			} else {
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}

	/**
	 * This method searches the heap for value returns heap node if found null
	 * otherwise
	 * 
	 * @param int value
	 * @return Node in heap
	 */
	public Node search(int item) {
		if (this.size == 0) {
			return null;
		}
		for (int i = 1; i <= this.size; i++) {

			if (this.heapData[i].value == item) {
				return this.heapData[i];
			}

		}
		return null;
	}

	/**
	 * This method returns occurence of value if found in heap -1 if value is not
	 * found in heap
	 * 
	 * @param int value
	 * @return int occuruence in founded node
	 */
	public int getOccurence(int value) {
		Node node = this.search(value);
		if (node != null) {
			return node.getOccurence();
		} else {
			return -1;
		}
	}

	/**
	 * This method returns true if heap array contains value
	 * 
	 * @param int value
	 * @return boolean depending on whether the value is in heap array
	 */
	public boolean contains(int item) {
		for (int i = 0; i <= size; i++) {
			if (this.heapData[i].value == item) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method increments the occurrence of value if it is found in heap
	 * otherwise adds the value into heap returns the occurrence of value
	 * 
	 * @param int value
	 * @return int occurence of value
	 */
	public int add(int item) {
		Node node = this.search(item);

		if (node != null) {
			node.incrementOccurrence();
			return node.getOccurence();
		} else {
			this.insert(item);
			return 1;
		}
	}

	/**
	 * This method inserts a new element to max heap
	 * 
	 * @param int value
	 */
	private void insert(int item) {
		Node node = new Node(item);
		heapData[++size] = node;

		// Traverse up and fix violated property
		int current = size;
		while (heapData[current].compareTo(heapData[parent(current)]) > 0) {
			swap(current, parent(current));
			current = parent(current);
		}

	}

	/**
	 * This method decrements occurrence of value if it is found in heap returns
	 * occurrence of value after removal
	 * 
	 * @param int value
	 * @return int occurrence of value after removal
	 */
	public int remove(int value) {
		Node node = this.search(value);
		if (node != null) {
			node.decrementOccurrence();
			if (node.occurrence == 0) {
				removeHeapNode(node);
				return 0;
			}
			return node.getOccurence();
		} else {
			return -1;
		}
	}

	/**
	 * This method removes node from heap and sets heap size in MaxHeap class. if
	 * root node is removed sets the max valued node as root
	 * 
	 * @param node node from heap
	 */
	private void removeHeapNode(Node node) {

		for (int i = 1; i < size; i++) {
			if (node.value == this.heapData[i].value) {
				Node lastNode = this.heapData[size];
				this.heapData[i] = lastNode;
				this.heapData[size] = null;
				size--;
				if (i == 1) {
					maxHeapify(1);
				}
				return;
			}
		}

		// node is the lastNode in the heap
		this.heapData[size] = null;
		this.size--;

		if (this.size == 0) {
			this.heapData = null;
		}
	}

	/**
	 * This method returns if heap is full in MaxHeap class.
	 * 
	 * @return boolean if size equals MAXSIZE,true
	 */
	public boolean isFull() {
		return size == MAXSIZE;
	}

	/**
	 * This method returns if heap is empty in MaxHeap class.
	 * 
	 * @return boolean if size equal zero, true
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * This method returns max valued heap node in MaxHeap class.
	 * 
	 * @return Node MaxHeap node
	 */
	public Node getMaxNode() {
		if (this.size > 0) {
			return this.heapData[1];
		}
		return null;
	}

	/**
	 * This method returns max value in heap
	 * 
	 * @return int value in heapData
	 */
	public int getMaxValue() {
		if (this.size > 0) {
			return this.heapData[1].value;
		}
		return Integer.MIN_VALUE;
	}

	/**
	 * This method returns node with maximum occurrence in MaxHeap.
	 * 
	 * @return Node node have max occurence.
	 */
	public Node getMaxOccurence() {
		if (this.size > 0) {
			Node maxNode = this.heapData[1];
			for (int i = 2; i <= size; i++) {
				if (heapData[i].getOccurence() > maxNode.getOccurence()) {
					maxNode = heapData[i];
				}
			}
			return maxNode;
		}
		return null;
	}

	/**
	 * This method print Maxheap.
	 */
	@Override
	public String toString() {
		String str = "";
		for (int i = 1; i <= this.size; i++) {
			str += "(" + heapData[i].getValue() + "," + heapData[i].getOccurence() + ")";
		}
		return "MaxHeap{" + str + '}';
	}

}
