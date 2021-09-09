//package hw3;

import java.util.*;

/**
 * This class implements some of the methods of the Java ArrayList class.
 * 
 * @author ozan.geckin
 * @author Koffman & Wolfgang
 */

public class KWArrayList<E> implements Iterable<E> {
	// Data Fields
	/** The default initial capacity */
	private static final int INITIAL_CAPACITY = 10;

	/** The underlying data array */
	private E[] theData;

	/** The current size */
	private int size = 0;

	/** The current capacity */
	private int capacity = 0;

	/**
	 * Construct an empty KWArrayList with the default initial capacity
	 */
	public KWArrayList() {
		capacity = INITIAL_CAPACITY;
		theData = (E[]) new Object[capacity];
	}

	/**
	 * One parametre constructor set size
	 * 
	 * @param newSize int
	 */
	public KWArrayList(int newSize) {
		this.size = newSize;
		capacity = INITIAL_CAPACITY;
		theData = (E[]) new Object[capacity];
	}

	/**
	 * Add an entry to the data inserting it before the item at the specified index.
	 * 
	 * @param index    - The index of the time that the new value it to be inserted
	 *                 in front of.
	 * @param theValue - The value to be inserted
	 * @throws ArrayIndexOUtOfBoundsException if index is less than zero or greater
	 *                                        than size
	 */
	public boolean add(E anEntry) {
		if (size == capacity) {
			reallocate();
		}
		theData[size] = anEntry;
		size++;
		return true;
	}

	/**
	 * This method to add an element to the index I want.Before this method, I do
	 * capacity control.I shift the index after I put the data
	 * 
	 * @param anEntry E
	 * @param index   int
	 */
	public void add(E anEntry, int index) {
		if (size == capacity) {
			reallocate();
		}
		for (int i = size; i > index; i--) {
			theData[i] = theData[i - 1];
		}
		theData[index] = anEntry;
		size++;
	}

	/**
	 * Get a value in the array based on its index.
	 * 
	 * @param index - The index of the item desired
	 * @return The contents of the array at that index
	 * @throws ArrayIndexOutOfBoundsException - if the index is negative or if it is
	 *                                        greater than or equal to the current
	 *                                        size
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theData[index];
	}

	/**
	 * Set the value in the array based on its index.
	 * 
	 * @param index    - The index of the item desired
	 * @param newValue - The new value to store at this position
	 * @return The old value at this position
	 * @throws ArrayIndexOutOfBoundsException - if the index is negative or if it is
	 *                                        greater than or equal to the current
	 *                                        size
	 */
	public E set(int index, E newValue) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E oldValue = theData[index];
		theData[index] = newValue;
		return oldValue;
	}

	/**
	 * Remove an entry based on its index
	 * 
	 * @param index - The index of the entry to be removed
	 * @return The value removed
	 * @throws ArrayIndexOutOfBoundsException - if the index is negative or if it is
	 *                                        greater than or equal to the current
	 *                                        size
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E returnValue = theData[index];
		for (int i = index + 1; i < size; i++) {
			theData[i - 1] = theData[i];
		}
		size--;
		return returnValue;
	}

	/**
	 * It returns the data it receives as a parameter, if there is an arrayList, it
	 * returns an index.
	 * 
	 * @param data E
	 * @return int i index
	 */
	private int findElement(E data) {
		int i = 0;
		while (i < size && theData[i].equals(data)) {
			i++;
		}
		if (i < size) {
			return i;
		} else {
			return -1;
		}
	}

	/**
	 * It searches the data it receives as a parameter, if it finds it, it calls the
	 * remove (index) method and returns true if it can remove it.
	 * 
	 * @param data E
	 * @return boolean
	 */
	public boolean remove(E data) {
		int removeIndex = findElement(data);
		if (removeIndex != -1) {
			remove(removeIndex);
			return true;
		}
		return false;
	}

	/**
	 * Allocate a new array to hold the directory
	 */
	private void reallocate() {
		capacity = 2 * capacity;
		E[] newData = (E[]) new Object[capacity];
		System.arraycopy(theData, 0, newData, 0, size);
		theData = newData;
	}

	/**
	 * If there is a list data, it returns the index of that data.
	 * 
	 * @param data E
	 * @return i index int
	 */
	public int indexOf(E data) {
		for (int i = 0; i < size; i++) {
			if (theData[i].equals(data)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Get the current size of the array
	 * 
	 * @return The current size of the array
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Setter of KWArrayList size
	 * 
	 * @param newSize int
	 */
	public void setSize(int newSize) {
		size = newSize;
	}

	/**
	 * Clone one list to another list
	 * 
	 * @param otherList KWArrayList<E>
	 * @return this KWArrayList<E>
	 */
	public KWArrayList<E> cloneList(KWArrayList<E> otherList) {
		for (E e : otherList) {
			this.add(e);
		}
		return this;
	}

	/**
	 * I defined it to use the for each loop
	 */
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
