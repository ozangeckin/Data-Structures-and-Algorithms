//package part1;

import java.util.HashMap;
import java.util.Map;

/**
 * This class implements MapIterator Interface that iterates
 * through the keys in a HashMap data structure. Map keys are stored in an array
 * and pointer for next and previous methods works on this key array. The
 * iterator starts from the given key and iterate though all the keys in the
 * Map. The iterator starts from any key in the Map when the starting key is not
 * in the Map or not specified.
 * 
 * @author Ozan GECKIN
 *
 * @param <K> Generic type
 * @param <V> Generic type
 */
public class MapIterator<K, V> implements MapIteratorInterface<K> {

	/** Map that iterateor will going to iterate over */
	@SuppressWarnings("unused")
	private Map<K, V> kvMap = new HashMap<>();
	/** Pointer to get next and prev element */
	private int pointer = -1;
	/** Array of map keys */
	@SuppressWarnings("unchecked")
	private K[] keysArray = (K[]) new Object[] {};
	/** Staring key to iterate */
	private K keyToStart = null;

	/**
	 * No parameter Constructor for MapIterator
	 */
	public MapIterator() {

	}

	/**
	 * One parameter Constructor for MapIterator with starting key
	 * 
	 * @param key K
	 */
	public MapIterator(K key) {
		keyToStart = key;
	}

	/**
	 * This method sets the key array starting from key to start parameter Iterator
	 * will iterate over this key array
	 * 
	 * @param kvMap Map
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	public void setKvMap(Map<K, V> kvMap) {
		this.kvMap = kvMap;
		int size = kvMap.keySet().size();
		K[] tempKeysArray = (K[]) kvMap.keySet().toArray();
		keysArray = (K[]) kvMap.keySet().toArray();
		if (kvMap.containsKey(keyToStart)) {
			int index = -1;
			for (int i = 0; i < tempKeysArray.length; i++) {
				if (tempKeysArray[i] == keyToStart) {
					index = i;
					break;
				}
			}
			for (int i = 0; i < tempKeysArray.length; i++) {
				keysArray[i] = tempKeysArray[index];
				index++;
				index = index % tempKeysArray.length;
			}
		} else {
			keysArray = tempKeysArray;
		}
	}

	/**
	 * This method returns True if there are still not-iterated keys in the Map,
	 * otherwise returns False.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean hasNext() {
		return pointer < keysArray.length - 1;
	}

	/**
	 * This method returns the next key in the Map. It returns the first key when
	 * there is no not-iterated key in the Map.
	 * 
	 * @return K key
	 */
	@Override
	public K next() {
		if (pointer == keysArray.length - 1) {
			pointer++;
			return null;
		} else {
			pointer++;
		}
		return keysArray[pointer];
	}

	/**
	 * The method the iterator points to the previous key in the Map. It returns the
	 * last key when the iterator is at the first key
	 * 
	 * @return K key
	 */
	@Override
	public K prev() {
		if (pointer == 0) {
			return keysArray[keysArray.length - 1];
		} else {
			return keysArray[pointer - 1];
		}
	}

}
