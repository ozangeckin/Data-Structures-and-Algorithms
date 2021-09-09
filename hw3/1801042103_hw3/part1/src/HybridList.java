/**
 * @author ozan.geckin
 * This class is implementation of KWLinkedList HybridList.Node data contains KWArrayList 
 */
//package hw3;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class HybridList<E> {

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	private int nodeSize = 0;

	/**
	 * This method adding the obj at the specified positin in this list
	 * 
	 * @param index
	 * @param obj
	 */
	public void add(int index, E obj) {
		HybridListIterator it = new HybridListIterator(index);
		it.add(obj);
	}

	/**
	 * This method adding a new element head list.
	 * 
	 * @param obj new elment
	 */
	public void addFirst(E obj) {
		HybridListIterator it = new HybridListIterator(0);
		it.add(obj);
	}

	/**
	 * This method adding a new element Tail list
	 * 
	 * @param obj new element
	 */
	public void addLast(E obj) {
		HybridListIterator it = new HybridListIterator(size - 1);
		it.add(obj);
	}

	/**
	 * This method returns the element at the specified position in this list
	 * 
	 * @param index int element position
	 * @return E element that at specified position
	 */
	public E get(int index) {
		HybridListIterator it = new HybridListIterator(index);
		return it.get();
	}

	/**
	 * This method return the first element.
	 * 
	 * @return first element
	 */
	public E getFirst() {
		HybridListIterator it = new HybridListIterator(0);
		return it.get();
	}

	/**
	 * This method return the last element
	 * 
	 * @return last element
	 */
	public E getLast() {
		HybridListIterator it = new HybridListIterator(size - 1);
		return it.get();
	}

	/**
	 * This method searching the list an iterator.Takes the index of the data and
	 * send is to remove(index) method
	 * 
	 * @param obj element to be removed
	 * @return if element is remove true,element is not remove false.
	 */
	public boolean remove(E obj) {
		HybridListIterator it = new HybridListIterator(0);
		int index;
		while (it.hasNext()) {
			if (it.next().equals(obj)) {
				index = it.nextItem.dataList.indexOf((E) obj);
				it.nextItem.dataList.remove(index);
				size--;
				if (it.nextItem.dataList.getSize() == 0) {
					it.remove();
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * This method allow to remove at specified position.
	 * 
	 * @param index specified position
	 * @return if index is remove true,index is not remove false.
	 */
	public E remove(int index) {
		HybridListIterator it = new HybridListIterator(index);
		E temp = it.nextItem.dataList.remove(it.arrayIndex);
		if (it.nextItem.dataList.getSize() == 0) {
			it.remove();
		}
		size--;
		return temp;
	}

	/**
	 * Getter for HybridList size
	 * 
	 * @return size size of HybridList
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 
	 * Getter for hybridList node Size
	 * 
	 * @return nodeSize nodeSize of HybridList
	 */
	public int getNodeSize() {
		return nodeSize;
	}

	/**
	 * This method return HybridListIterator in this list.
	 * 
	 * @return HybridListIterator
	 */
	public HybridListIterator hybridListIterator() {
		return new HybridListIterator(0);
	}

	/**
	 * This method returns a hybridlistIterator starting at index.
	 * 
	 * @param index specified position
	 * @return HybridListIterator
	 */
	public HybridListIterator hybridListIterator(int index) {
		return new HybridListIterator(index);
	}

	/**
	 * This method allows to check contains obj in list
	 * 
	 * @param o wanted element
	 * @return boolean if element find in list true,element do not find in list
	 *         false
	 */
	public boolean find(E o) {
		HybridListIterator it = new HybridListIterator(0);
		while (it.hasNext()) {
			if (it.next().equals(o)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * This class to create a linked List .
	 *
	 * @param <E> Type of node
	 */
	private static class Node<E> {
		private KWArrayList<E> dataList;
		private Node<E> next;
		private Node<E> prev;
		private int MAXCAPACITY = 5;

		/**
		 * Constructor Node class with one parametre data.
		 * 
		 * @param data add element in dataList
		 */
		public Node(E data) {
			dataList = new KWArrayList<E>();
			dataList.add(data);
			next = null;
			prev = null;
		}

		/**
		 * This method adding element in this end of list.If datalist size equal
		 * MAXCAPACITY .New node create.
		 * 
		 * @param value element adding in the dataList
		 */
		public void add(E value) {
			if (MAXCAPACITY == dataList.getSize()) {
				throw new ArrayIndexOutOfBoundsException();
			}
			dataList.add(value);
		}
		
		/**
		 * This method returns element that at position index.
		 * @param index int specificed position
		 * @return element E at the specified position in this list
		 */
		public E get(int index) {
			return dataList.get(index);
		}
		/**
		 * This method allows to compares two nodes.
		 * @param obj other node
		 * @return boolean true if the specified Node is equal to this Node
		 */
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			@SuppressWarnings("unchecked")
			Node<E> temp = (Node<E>) obj;
			if (next != temp.next || prev != temp.prev || dataList.getSize() != temp.dataList.getSize()
					|| MAXCAPACITY != temp.MAXCAPACITY) {
				return false;
			} else {
				for (int i = 0; i < dataList.getSize(); i++) {
					if (!dataList.get(i).equals(temp.get(i)))
						return false;
				}
			}
			return true;
		}
		/**
		 * Getter for MAXCAPACITY of Node
		 * @return MMAXCAPACITY MAXCAPACITY of Node 
		 */
		public int getMaxCapacity() {
			return MAXCAPACITY;
		}
	}

	/**
	 * 
	 * This class is implementation of java ListIterator<E> interface
	 *
	 */

	private class HybridListIterator implements ListIterator<E> {
		private Node<E> nextItem;
		private Node<E> lastItem;
		private int index;
		private int flag;
		private int elementIndex;
		private E nextElement;
		private int arrayIndex;

		/**
		 * Constructor HybridListIterator to create iterator index i.
		 * 
		 * @param i int index
		 */
		public HybridListIterator(int i) {
			if (i < 0 || i > size) {
				throw new IndexOutOfBoundsException("Error : Invalid Index" + i);
			}
			lastItem = null;
			if (i == size) {
				index = nodeSize;
				nextItem = tail;
				elementIndex = size;
				arrayIndex = 0;
				flag = 1;
			} else if (i == 0) {
				arrayIndex = 0;
				elementIndex = 0;
				index = 0;
				nextItem = head;
				flag = 2;
				int counter = 0;
				nextElement = nextItem.get(counter);
			} else {
				arrayIndex = -1;
				elementIndex = 0;
				index = 0;
				nextItem = head;
				flag = 2;
				int counter = 0;
				nextElement = nextItem.get(counter);
				for (int j = 0; j <= i; j++) {
					if (nextItem.dataList.getSize() == counter) {
						nextItem = nextItem.next;
						index++;
						counter = 0;
						arrayIndex = 0;
						nextElement = nextItem.get(counter);
						counter++;
					} else {
						nextElement = nextItem.get(counter);
						counter++;
						arrayIndex++;
						elementIndex++;
					}
				}
			}

		}

		/**
		 * This method add at index into list
		 * 
		 * @param obj new element
		 */
		public void add(E obj) {
			if (nextItem != null) {
				if (nextItem.dataList.getSize() != nextItem.getMaxCapacity()) {
					nextItem.add(obj);
				} else {
					if (nextItem == head && flag == 2) {
						Node<E> newNode = new Node<E>(obj);
						newNode.next = nextItem;
						nextItem.prev = newNode;
						head = newNode;
						index++;
						nodeSize++;
					} else if (nextItem == tail && flag == 1) {
						Node<E> newNode = new Node<E>(obj);
						tail.next = newNode;
						newNode.prev = tail;
						tail = newNode;
						index++;
						nodeSize++;
					} else {
						Node<E> newNode = new Node<E>(obj);
						newNode.prev = nextItem.prev;
						nextItem.prev.next = newNode;
						newNode.next = nextItem;
						nextItem.prev = newNode;
						index++;
						nodeSize++;
					}
				}
			} else {
				head = new Node<E>(obj);
				tail = head;
				index++;
				nodeSize++;
			}
			size++;
			lastItem = null;
		}

		/**
		 * This method check nextItem null or not null.necessary for traversing
		 * 
		 * @return boolean if nextItem is null false, nextItem is not null true.
		 */
		public boolean hasNext() {
			return nextItem != null;
		}

		/**
		 * This method check prevItem null or not null.necessary for traversing
		 * 
		 * @return boolean if prevItem is null false, nextItem is not null true.
		 */
		public boolean hasPrevious() {
			return nextItem.prev != null;
		}

		/**
		 * This method returns next element in the list and increase index .
		 * 
		 * @return the next element
		 */
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			if (arrayIndex >= nextItem.dataList.getSize()) {
				lastItem = nextItem;
				nextItem = nextItem.next;
				index++;
				arrayIndex = 0;
			}
			if (nextItem != null) {
				nextElement = nextItem.get(arrayIndex);
				elementIndex++;
				arrayIndex++;
				return nextElement;
			} else {
				return nextElement;
			}

		}

		/**
		 * This method return index of the element that the index on one of next ().
		 * 
		 * @return index int
		 */
		public int nextIndex() {
			return elementIndex + 1;
		}

		/**
		 * This method returns previous element in the list and decrease index .
		 * 
		 * @return the previous element
		 */
		public E previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if (nextItem == null) {
				nextItem = tail;
			} else {
				if (arrayIndex == 0) {
					nextItem = nextItem.prev;
					lastItem = nextItem;
					index--;
					arrayIndex = nextItem.dataList.getSize();
				}
				arrayIndex--;
				elementIndex--;
				nextElement = nextItem.get(arrayIndex);
			}
			return nextElement;
		}

		/**
		 * This method return index of the element that the index on one of previous ().
		 * 
		 * @return index int
		 */
		public int previousIndex() {
			return elementIndex - 1;
		}

		/**
		 * This method used to remove an element from the beginning or end of the list.
		 */
		public void remove() {
			if (head == null) {
				throw new NoSuchElementException();
			} else if (head != null && head.next == null) {
				nextItem = null;
				head = null;
				tail = null;
				nodeSize--;
				index--;
			} else if (nextItem.next == null) {
				nextItem.prev.next = null;
				tail = nextItem.prev;
				nodeSize--;
				index--;
			} else if (nextItem.prev == null && nextItem.next != null) {
				nextItem.next.prev = null;
				head = nextItem.next;
				nodeSize--;
				index--;
			} else {
				nextItem.prev.next = nextItem.next;
				nextItem.next.prev = nextItem.prev;
				nodeSize--;
				index--;
			}
			lastItem = null;
		}

		/**
		 * This method return nextElemet
		 * 
		 * @return E
		 */
		public E get() {
			return nextElement;
		}

		public void set(E e) {
			if (lastItem != null) {
				lastItem.dataList.set(lastItem.dataList.getSize() - 1, e);
			} else {
				throw new IllegalStateException();
			}
		}

	}

}
