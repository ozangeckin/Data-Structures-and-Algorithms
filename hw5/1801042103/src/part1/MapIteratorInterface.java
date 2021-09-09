//package part1;

import java.util.Iterator;
/**
 * This interface extends Iterator class.It content MapIterator methods
 * @author Ozan GECKIN
 *
 * @param <K> Generic Type
 */
public interface MapIteratorInterface<K> extends Iterator<K> {
	public K next();
	public K prev();
	
	@Override
	boolean hasNext();
}
