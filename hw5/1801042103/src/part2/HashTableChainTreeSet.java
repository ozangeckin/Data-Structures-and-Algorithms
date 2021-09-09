//package part2;

/**
 * 
 * This class is HashTableChainTreeSet. It holds the data field and methods of
 * the HashTableChainTreeSet class. KWHashMap implements the interface.
 * 
 * @author Ozan GECKIN
 *
 * @param <K> Generic type
 * @param <V> Generic type
 */
@SuppressWarnings("rawtypes")
public class HashTableChainTreeSet<K, V> implements KWHashMap {

	/** The table */
	private BinaryTree<Entry<K, V>>[] table;
	/** The number of keys */
	private int numKeys;
	/** The capacity */
	private static final int CAPACITY = 10;

	private int size;

	/**
	 * Constructor for Hash table
	 */
	@SuppressWarnings("unchecked")
	public HashTableChainTreeSet() {
		table = new BinaryTree[CAPACITY];
		size = 0;
	}

	/**
	 * This method gets the Object with given key
	 * 
	 * @param key object
	 * @return value object
	 */
	@Override
	public Object get(Object key) {
        int index = key.hashCode()%10;
        if (index < 0)
            index += 10;
        if (table[index] == null)
            return null; // key is not in the table.
        // Search the list at table[index] to find the key.
        Entry  item = (Entry)table[index].get(key);
        if (item!=null) {
            return item.getValue();
        }
        else {
            return null;
        }
    }
	/**
	 * This method put value in key return boolean
	 * 
	 * @param key   object
	 * @param value object
	 * @return boolean if add true,else false
	 */
	@SuppressWarnings("unchecked")
	@Override
	  public Object put(Object key, Object value) {
        int index = key.hashCode() % CAPACITY;
        if (index < 0)
            index += 10;
        if (table[index] == null) {
            // Create a new binary tree list at table[index].
            table[index] = new BinaryTree<>();
        }

        // assert: key is not in the table, add new item.
        table[index].add(new Entry(key, value));
        size++;
        numKeys++;

        return true;
    }

	/**
	 * This method removes item from hash table by key
	 * 
	 * @param key object
	 * @return boolean true or false
	 */
	@Override
	  public Object remove(Object key) {
        int index = key.hashCode() % CAPACITY;
        if (index < 0)
            index += CAPACITY;
        if (table[index] == null) {
           return null; //Key is not in the table
        }
        // Search the tree at table[index] to find the key.
        Entry item = (Entry) table[index].get(key);
        if (item != null) {
            boolean success = table[index].remove(item);
            if(success){
                size--;
                if(table[index].isEmpty()){
                    numKeys--;
                }
            }
            return item.getValue();
        }

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
	 * This method provide print HashTableChainTreeSet
	 * 
	 * @return String HashTableChainTreeSet
	 */
	@Override
	public String toString() {
		String text = "";
		for (BinaryTree tableItem : table) {
			if (tableItem != null) {
				text += "Hash : " + tableItem.getRootKey() % CAPACITY + tableItem.toString();
				text += "\n";
			}
		}
		return text;
	}
}
