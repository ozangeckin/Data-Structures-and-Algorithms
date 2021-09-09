//package part2;

import java.util.LinkedList;

/**
 * This class is HashTableChainLinkedList. It holds the data field and methods
 * of the HashTableChainLinkedList class. KWHashMap implements the interface.
 * 
 * @author Ozan GECKIN
 * 
 * @param <K> Generic type
 * @param <V> Generic type
 */
@SuppressWarnings("rawtypes")
public class HashTableChainLinkedList<K, V> implements KWHashMap {

	/** The table */
	private LinkedList<Entry<K, V>>[] table;
	/** The number of keys */
	private int numKeys;
	/** The capacity */
	private static final int CAPACITY = 10;

	private int size;

	/**
	 * Constructor for HashTable
	 */
	@SuppressWarnings("unchecked")
	public HashTableChainLinkedList() {
		table = new LinkedList[CAPACITY];
		size = 0;
	}

	/**
	 * Gets the item with given key from hash table
	 * 
	 * @param key the key
	 * @return value object
	 */
	@Override
	public Object get(Object key) {
		int index = key.hashCode() % 10;
		if (index < 0)
			index += 10;
		if (table[index] == null)
			return null; // key is not in the table.
		// Search the list at table[index] list to find the key.
		for (Entry<K, V> nextItem : table[index]) {
			if (nextItem.getKey().equals(key))
				return nextItem.getValue();
		}
		// key is not in the table.
		return null;
	}

	/**
	 * This method adds item to hash table If key is already in table old value is
	 * replaced with value and old value is returned
	 *
	 * @param key   the key
	 * @param value the value
	 * @return value the old value
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object put(Object key, Object value) {
		int index = key.hashCode() % CAPACITY;
		if (index < 0)
			index += 10;
		if (table[index] == null) {
			// Create a new linked list at table[index].
			table[index] = new LinkedList<>();
		}

		// Search the list at table[index] to find the key.
		for (Entry<K, V> nextItem : table[index]) {
			// If the search is successful, replace the old value.
			if (nextItem.getKey().equals(key)) {
				// Replace value for this key.
				V oldVal = nextItem.getValue();
				nextItem.setValue((V) value);
				return oldVal;
			}
		}
		// key is not in the table, add new item.
		table[index].addFirst(new Entry(key, value));
		size++;
		numKeys++;

		return null;
	}

	/**
	 * This method remove item from hash table.
	 * 
	 * @param key the key
	 * @return value object
	 */
	@Override
	public Object remove(Object key) {
		int index = key.hashCode() % CAPACITY;
		if (index < 0)
			index += CAPACITY;
		if (table[index] == null) {
			return null; // Key is not in the table
		}
		// Search the list at table[index] to find the key.
		for (Entry<K, V> nextItem : table[index]) {
			if (nextItem.getKey().equals(key)) {
				V value = nextItem.getValue();
				table[index].remove(nextItem);
				numKeys--;
				if (table[index].isEmpty()) {
					table[index] = null;
					size--;
				}
				return value;
			}
		}
		return null;
	}

	/**
	 * This method returns number of items in hash table
	 * 
	 * @return size integer
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * This method returns true if hash table is empty otherwise false
	 * 
	 * @return boolean true or false
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * This method returns string representation of hash table
	 * 
	 * @return String HashTableChainLinkedList object
	 */
	@Override
	public String toString() {
		String text = "";
		for (LinkedList<Entry<K, V>> tableItem : table) {
			if (tableItem != null) {
				text += "Hash : " + tableItem.get(0).getKey().hashCode() % CAPACITY;
				for (Entry<K, V> item : tableItem) {
					text += "(" + item.getKey() + "," + item.getValue() + ")";
				}
				text += "\n";
			}
		}
		return text;
	}
}
