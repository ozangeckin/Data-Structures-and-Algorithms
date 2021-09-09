//package part2;

/**
 * This class contains key and value pairs for a hash table
 * 
 * @author Ozan GECKIN
 * @param <K> Generic type
 * @param <V> Generic type
 */
@SuppressWarnings("rawtypes")
public class CoalescedList<K, V> implements Comparable<CoalescedList> {
	/** The key */
	private K key;
	/** The value */
	private V value;
	/** pointer to the next value with same hash */
	private int next;

	/**
	 * Three parameter Constructor creates a new key, value and next.
	 * 
	 * @param key   The key
	 * @param value The value
	 * @param next  The next
	 */
	public CoalescedList(K key, V value, Integer next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}

	/**
	 * This method getter of the key
	 * 
	 * @return The key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * This method getter of the value
	 * 
	 * @return The value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * This method getter of the next
	 * 
	 * @return the next
	 */
	public int getNext() {
		return next;
	}

	/**
	 * This method setter for the next
	 * 
	 * @param next integer
	 */
	public void setNext(int next) {
		this.next = next;
	}

	/**
	 * This method setter for the value
	 * 
	 * @param val The new value
	 * @return The old value
	 */
	public V setValue(V val) {
		V oldVal = value;
		value = val;
		return oldVal;
	}

	/**
	 * This method provide compare to CoalescedList objects
	 * 
	 * @param o CoalescedList other object
	 */
	@Override
	public int compareTo(CoalescedList o) {
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
	 * This method print use CoalescedList class object
	 * 
	 * @return String CoalescedList
	 */
	@Override
	public String toString() {
		return "(key: " + key.toString() + ",value: " + value.toString() + ")";
	}
}
