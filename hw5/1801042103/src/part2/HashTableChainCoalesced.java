//package part2;

/**
 * This class is HashTableChainCoalesced. It holds the data field and methods of
 * the HashTableChainCoalesced class. KWHashMap implements the interface.
 * 
 * @author Ozan GECKIN
 *
 * @param <K> Generic type
 * @param <V> Generic type
 */
@SuppressWarnings("rawtypes")
public class HashTableChainCoalesced<K, V> implements KWHashMap {

	/** The table */
	private CoalescedList<K, V>[] table;
	/** Empty Slot */
	private int emptyIndex;
	/** Size of Hash table */
	private int size;

	/**
	 * Constructor for hash table
	 * @param capacity integer
	 */
	@SuppressWarnings("unchecked")
	public HashTableChainCoalesced(int capacity) {
		table = new CoalescedList[capacity];
		size = 0;
		emptyIndex = capacity - 1;
	}

	/**
	 * This method gets the Object with given key
	 * 
	 * @param key Object
	 * @return value object
	 */
	@SuppressWarnings("unused")
	@Override
	public Object get(Object key) {

		int index = key.hashCode() % 10;
		if (index < 0)
			index += 10;
		if (table[index] == null)
			return null; // key is not in the table.
		// Search the list at table[index] to find the key.
		int probNumber = 0;
		int newIndex = index;
		while (newIndex >= 0 && table[newIndex] != null) {
			if (table[newIndex].getKey().equals(key)) {
				return table[newIndex].getValue();
			}
			newIndex = table[newIndex].getNext();
		}
		// assert: key is not in the table.
		return null;
	}

	/**
	 * This method put value in key return boolean
	 * 
	 * @param key   object
	 * @param value object
	 * @return boolean if add true,else false
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public Object put(Object key, Object value) {
		int index = key.hashCode() % 10;
		if (index < 0) {
			index += 10;
		}

		int probNumber = 0;
		int newIndex = index;
		index = -1;
		while (table[newIndex] != null) {
			if (table[newIndex].getKey().equals(key)) {
				table[newIndex] = new CoalescedList(key, value, table[newIndex].getNext());
				return true;
			}
			index = newIndex;
			newIndex = table[newIndex].getNext();
			if (newIndex == -1) {
				newIndex = emptyIndex;
				emptyIndex--;
			}
		}
		if (index != -1) {
			table[index].setNext(newIndex);
		}
		table[newIndex] = new CoalescedList(key, value, -1);
		size++;

		return true;
	}

	/**
	 * This method removes item from hash table by key
	 * 
	 * @param key object
	 * @return boolean true or false
	 */
	@SuppressWarnings("unused")
	@Override
	public Object remove(Object key) {
		int index = key.hashCode() % 10;
		if (index < 0)
			index += 10;
		if (table[index] == null) {
			return null; // Key is not in the table
		}
		int newIndex = index;
		index = -1;
		int probNumber = 0;
		while (table[newIndex] != null) {

			if (table[newIndex].getKey().equals(key)) {
				table[newIndex] = null;

				size--;
				return true;
			}
			newIndex = table[newIndex].getNext();
		}
		if (index != -1) {
			table[index].setNext(-1);
		}
		// Search the list at table[index] to find the key.

		return null;
	}

	/**
	 * This method returns number of items in Hash table
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
	 * This method provide print CoalescedList
	 * 
	 * @return String CoalescedList object
	 */
	@Override
	public String toString() {
		String text = "";
		for (CoalescedList<K, V> tableItem : table) {
			if (tableItem != null) {
				text += "Hash : " + tableItem.getKey().hashCode() % 10 + tableItem.toString();
				text += "\n";
			}
		}
		return text;
	}
}
