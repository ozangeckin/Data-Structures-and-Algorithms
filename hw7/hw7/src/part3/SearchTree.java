package part3;


public interface SearchTree<E> {
	/**
	 * Inserts item where it belongs in  the tree. Returns true if item is inserted; 
	 * false if it isn’t (already in tree)
	 * @param item Item that will be added
	 * @return true if item is inserted; false if it isn’t
	 */
	boolean add(E item);
	/**
	 * Returns true if target is  found in the tree
	 * @param target Target that will be searched
	 * @return true if target is  found in the tree
	 */
	boolean contains(E target);
	/**
	 * Returns a reference to the data in  the node that is equal to target. If no such node is found, returns null
	 * @param target Target that will be searched
	 * @return reference to the data in  the node that is equal to target
	 */
	E find(E target);
	/**
	 * Removes target (if found) from tree and returns it; otherwise, returns null
	 * @param target Target that will be deleted from tree
	 * @return If target is deleted, returns it; otherwise, return null
	 */
	E delete(E target);
	/**
	 * Removes target (if found) from tree and returns true; otherwise, returns false
	 * @param target Target that will be deleted from tree
	 * @return If target is removed, returns true; otherwise, returns false
	 */
	boolean remove(E target);
}

