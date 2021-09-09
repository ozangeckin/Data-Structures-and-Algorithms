package part1;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

/**
 * This class implements the NavigableSet interface. I implemented insert(add),
 * delete(remove), toString ,descendingIterator using Skip List.
 * 
 * @author 1801042103
 */
public class NavigableSetSkipList<E extends Comparable<E>> implements NavigableSet<E> {

	private SkipList<E> skipList = new SkipList<E>();

	/**
	 * This method NavigableSetSkipList class keeps data to skipList. Adds the
	 * incoming data to skipList.
	 * 
	 * @param  Generic type e value
	 * @return boolean if E adding skipList true
	 */
	@Override
	public boolean add(E e) {
		return skipList.add(e);
	}

	/**
	 * This method NavigableSetSkipList class keeps data to skipList. Remove the
	 * incoming data to skipList
	 * 
z	 * @param Generic Type o
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		return skipList.remove((E) o);
	}

	/**
	 * this method allows me to print the SkipList
	 * 
	 * @return String Skip List
	 */
	@Override
	public String toString() {
		return skipList.toString();
	}

	/**
	 * This method Returns the DescendingIterator according to the object that
	 * called itself.
	 * 
	 * @return Iterator descending Iterator
	 */
	@Override
	public Iterator<E> descendingIterator() {
		return new NavigableSkipListIterator<E>(this);
	}

	/**
	 * This method returns the skipList iterator.
	 * 
	 * @return Iterator skipList Iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return skipList.iterator();
	}

	@Override
	public Comparator<? super E> comparator() {
		return null;
	}

	@Override
	public E first() {
		return null;
	}

	@Override
	public E last() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public E lower(E e) {
		return null;
	}

	@Override
	public E floor(E e) {
		return null;
	}

	@Override
	public E ceiling(E e) {
		return null;
	}

	@Override
	public E higher(E e) {
		return null;
	}

	@Override
	public E pollFirst() {
		return null;
	}

	@Override
	public E pollLast() {
		return null;
	}

	@Override
	public NavigableSet<E> descendingSet() {
		return null;
	}

	@Override
	public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
		return null;
	}

	@Override
	public NavigableSet<E> headSet(E toElement, boolean inclusive) {
		return null;
	}

	@Override
	public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		return null;
	}

	@Override
	public SortedSet<E> subSet(E fromElement, E toElement) {
		return null;
	}

	@Override
	public SortedSet<E> headSet(E toElement) {
		return null;
	}

	@Override
	public SortedSet<E> tailSet(E fromElement) {
		return null;
	}

}
