//package part1;

import java.util.Iterator;

/**
 * This class generic max heap implementation with extended iterator.
 * 
 * @author Ozan GECKIN
 *
 * @param <T>
 */
public class Heap<T extends Comparable<T>> implements Iterable<T> {

	private T[] data;
	private int size;
	private int maxSize;

	/**
	 * Constructor for max-heap sets the maximum size of heap
	 * 
	 * @param maxSize int heap max size
	 */
	@SuppressWarnings("unchecked")
	public Heap(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		data = (T[]) new Comparable[this.maxSize + 1];
	}

	/**
	 * Getter of data in Heap class
	 * 
	 * @return data T[] in Heap
	 */
	public T[] getData() {
		return data;
	}

	/**
	 * Getter of size in Heap class
	 * 
	 * @return int size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * This method returns position of parent in Heap class
	 * 
	 * @param posistion in Heap
	 * @return position of parent
	 */
	private int parent(int pos) {
		return pos / 2;
	}

	/**
	 * This method below two functions return left children.
	 * 
	 * @param posistion in Heap
	 * @return position left children.
	 */
	private int leftChild(int pos) {
		return (2 * pos);
	}

	/**
	 * This method below two functions return right children.
	 * 
	 * @param posistion in Heap
	 * @return position right children.
	 */
	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	/**
	 * This method returns true of given node is leaf
	 * 
	 * @param posistion in Heap
	 * @return boolean true of given node is leaf
	 */
	private boolean isLeaf(int pos) {
		if (pos > (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	/**
	 * This method performs the classic swap operation
	 * 
	 * @param fpos posistion in Heap
	 * @param spos posistion in Heap
	 */
	private void swap(int fpos, int spos) {
		T tmp;
		tmp = data[fpos];
		data[fpos] = data[spos];
		data[spos] = tmp;
	}

	/**
	 * This method that a recursive function to max heapify the given subtree. This
	 * function assumes that the left and right subtrees are already heapified, we
	 * only need to fix the root.
	 * 
	 * @param posistion in Heap
	 */
	private void maxHeapify(int pos) {
		if (isLeaf(pos))
			return;

		if ((data[leftChild(pos)] != null && data[pos].compareTo(data[leftChild(pos)]) < 0)
				|| (data[rightChild(pos)] != null && data[pos].compareTo(data[rightChild(pos)]) < 0)) {

			if (data[leftChild(pos)].compareTo(data[rightChild(pos)]) > 0) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			} else {
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}

	/**
	 * This method insert new element into heap if heap is not full
	 * 
	 * @param T element
	 */
	public void add(T element) {
		if (!isFull()) {
			data[++size] = element;

			// Traverse up and fix violated property
			int current = size;
			while (parent(current) != 0 && data[current].compareTo(data[parent(current)]) > 0) {
				swap(current, parent(current));
				current = parent(current);
			}
		}
	}

	/**
	 * This method removes node from heap
	 * 
	 * @param T node
	 */
	public void remove(T node) {

		for (int i = 1; i < size; i++) {
			if (node.equals(data[i])) {
				T lastNode = data[size];
				data[i] = lastNode;
				data[size] = null;
				size--;
				if (i == 1) {
					maxHeapify(1);
				}
				return;
			}
		}

		// node is the lastNode in the heap
		data[size] = null;

		if (this.size == 0) {
			data = null;
		}
	}

	/**
	 * This method search given item in heap returns heap data if found otherwise
	 * null
	 * 
	 * @param T item
	 * @return return T item if not found , return null
	 */
	public T search(T item) {
		for (int i = 1; i <= size; i++) {
			if (data[i].compareTo(item) == 0) {
				return data[i];
			}
		}
		return null;
	}

	/**
	 * This method merges given heap if total size is less then maximum size of heap
	 * 
	 * @param mergeHeap heap
	 */
	public void mergeHeap(Heap<T> mergeHeap) {
		if (size + mergeHeap.size <= maxSize) {
			for (int i = 1; i <= mergeHeap.size; i++) {
				data[++size] = (T) mergeHeap.data[i];
			}
			maxHeapify(1);
		}
	}

	/**
	 * This method remove kth largest item from heap.kth largest means (size-k+1)th
	 * smallest new max-heap is used to store (size-k+1) items that are less then
	 * k-1 items.max item in the second heap is the kth largest item
	 * 
	 * @param int order
	 */
	public void removeKthLargest(int order) {

		Heap<T> newHeap = new Heap<T>(size - order + 1);
		for (int i = 1; i <= size; i++) {
			if (newHeap.search(data[i]) == null) {
				if (newHeap.isFull()) {
					newHeap.remove(newHeap.data[1]);
				}
				newHeap.add(data[i]);
			}
		}
		T kLargest = newHeap.data[1];
		remove(kLargest);

	}

	/**
	 * This method Extend the Iterator class by adding a method to set the value
	 * (value passed as parameter) of the last element returned by the next methods.
	 * 
	 * @param T val
	 */
	@SuppressWarnings("unchecked")
	public void setValues(T val) {

		MaxHeapIterator iterator = (Heap<T>.MaxHeapIterator) this.iterator();
		while (iterator.hasNext()) {
			iterator.setValue(val);
		}
	}

	/**
	 * This method provide that print heap.
	 */
	@Override
	public String toString() {
		String str = "";
		for (int i = 1; i <= this.size; i++) {
			str += "(" + data[i] + ")";
		}
		return "Heap{" + str + '}';
	}

	/**
	 * This method returns if heap is full
	 * 
	 * @return boolean if size equal maxSize, true
	 */
	public boolean isFull() {
		return size == maxSize;
	}

	/**
	 * This method create and return MaxHeapIterator.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<T> iterator() {
		return new MaxHeapIterator();
	}

	/**
	 * This class my iterator class. I use Heap class.This class implements
	 * MaxHeapIteratorInterface interface.
	 * 
	 * @author ozan.geckin
	 *
	 */
	public class MaxHeapIterator implements MaxHeapIteratorInterface<T> {
		/** iterator index */
		private int index;

		/**
		 * No parameter constructor MaxHeapIteror. This set index -1.
		 */
		public MaxHeapIterator() {
			super();
			this.index = -1;
		}

		/**
		 * This method check nextItem null or not null.necessary for traversing
		 * 
		 * @return boolean if index small size ,true
		 */ 
		@Override
		public boolean hasNext() {
			return (index + 1) < size;
		}

		/**
		 * This method returns next element in the list and increase index.
		 * 
		 * @return the next element;
		 */
		@Override
		public T next() {
			index++;
			return data[index];
		}

		/**
		 * This method sets the data in the array with the value it takes as a
		 * parameter.
		 * 
		 * @param T value
		 */
		@Override
		public void setValue(T value) {
			index++;
			data[index] = value;

		}

	}

}
