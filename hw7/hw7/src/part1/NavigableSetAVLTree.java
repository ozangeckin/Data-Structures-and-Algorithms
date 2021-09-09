package part1;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

/**
 * This class implements the NavigableSet interface. I implemented insert(add),
 * toString using AVLTree.
 * 
 * @author 1801042103
 */
public class NavigableSetAVLTree<E extends Comparable<E>> implements NavigableSet<E> {

	private AVLTree<E> avlTree = new AVLTree<E>();

	/**
	 * This method NavigableSetAVLTree class keeps data to AVLTree. Adds the
	 * incoming data to avlTree.
	 * 
	 * @param E value added
	 */
	@Override
	public boolean add(E e) {
		return avlTree.add(e);
	}

	/**
	 * This method print NavigableSetAVLTree.
	 * 
	 * @return String avlTree
	 */
	@Override
	public String toString() {
		return avlTree.toString();
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
	public boolean remove(Object o) {
		return false;
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
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public NavigableSet<E> descendingSet() {
		return null;
	}

	@Override
	public Iterator<E> descendingIterator() {
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
