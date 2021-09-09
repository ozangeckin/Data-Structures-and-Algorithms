//package part2;

/**
 * This class contains key value pairs for a hash table
 * 
 * @author Ozan GECKIN
 * @param <K> Generic type
 * @param <V> Generic type
 */
@SuppressWarnings("rawtypes")
public class Entry<K, V> implements Comparable<Entry> {
	/** The key */
	private K key;

	/** The value */
	private V value;

	/**
	 * Two parameter constructor creates a new key and value pair
	 * 
	 * @param key   The key
	 * @param value The value
	 */
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * This method getter of the key;
	 * 
	 * @return K the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * This method getter of the value
	 * 
	 * @return V the value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * This method setter for the value
	 * 
	 * @param val the new value
	 * @return the old value
	 */
	public V setValue(V val) {
		V oldVal = value;
		value = val;
		return oldVal;
	}
	
	/**
	 * This method provide compare to Entry objects
	 * 
	 * @param o Entry other object
	 */
	@Override
	public int compareTo(Entry o) {
		if (key.hashCode() < o.getKey().hashCode()) {
			return -1;
		} else {
			if (key.hashCode() == o.getKey().hashCode()) {
				return 0;
			} else {
				return 1;
			}
		}
	}
	
	/**
	 * This method provide print Entry class object
	 */
	@Override
	public String toString() {
		return "("+key.toString()+","+value.toString()+")";
	}
}
