package part1;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class It is the iterator of the NavigableSkipList class to implement the
 * descendingIterator() function in my assignment. I override the methods in the
 * Iterator interface.
 * 
 * @author 1801042103
 */
public class NavigableSkipListIterator<E extends Comparable<E>> implements Iterator<E> {

	private LinkedList<E> list = new LinkedList<>();
	private int index = 0;

	/** No parameter constructor */
	public NavigableSkipListIterator() {
	}

	/**
	 * One parameter constructor. Gets a NavigableSetSkipList object. Sets the
	 * Iterator. I used a linkedList to hold the data. I also set the linked list.
	 * 
	 * @param startPoint NavgiableSetSkipList<E>
	 */
	public NavigableSkipListIterator(NavigableSetSkipList<E> startPoint) {
		Iterator<E> iter = startPoint.iterator();
		while (iter.hasNext()) {
			list.add(0, iter.next());
		}
	}

	/**
	 * This method allows me to return to the end of the NavigableSkipListIterator
	 * with iterator.
	 * 
	 * @return boolean true or false
	 */
	@Override
	public boolean hasNext() {
		int size = list.size();
		if (size > index) {
			return true;
		}
		return false;
	}

	/**
	 * This method returns the value indicated by the iterator in the linklist.
	 * 
	 * @return E value
	 */
	@Override
	public E next() {
		return list.get(index++);
	}
}