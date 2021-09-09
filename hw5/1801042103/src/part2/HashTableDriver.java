//package part2;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * This class Driver.I am testing all my functions
 * 
 * @author Ozan GECKIN
 *
 */
public class HashTableDriver {

	public final static int SIZELARGE = 2500;
	public final static int SIZEMEDIUM = 250;
	public final static int SIZESMALL = 25;

	public static void main(String[] args) {
		long start;
		long end;
		NumberFormat formatter = new DecimalFormat("#0.00000");

		System.out.println("Hash Table Chain Linked List (Key type Integer ,Value type Integer)");
		
		HashTableChainLinkedList<Integer, Integer> linkedListMap = new HashTableChainLinkedList<>();
		System.out.println("\nAdd numbers from 0 to 2500 into Map");
		System.out.println("Is Empty");
		System.out.println("Empty:"+linkedListMap.isEmpty());
		start = System.nanoTime();
		for(int i=0;i<SIZELARGE;i++) {
			linkedListMap.put(i, i);
		}
		end = System.nanoTime();
		System.out.println("Hash Table Chain Linked List running time (add 2500 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println(linkedListMap.toString());
		System.out.println("Get size");
		System.out.println("Size:" + linkedListMap.size());
		System.out.println("Get key 2350");
		start = System.nanoTime();
		System.out.println("Value:" + linkedListMap.get(2350));
		end = System.nanoTime();
		System.out.println("Hash Table Chain Linked List running time (get(K key) 2500 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Remove key 1002");
		start = System.nanoTime();
		System.out.println("Value:" + linkedListMap.remove(1002));
		end = System.nanoTime();
		System.out.println("Again Remove key 1002");
		if(linkedListMap.remove(1002)==null) {
			System.out.println("invalid key");
		}
		System.out.println("Hash Table Chain Linked List running time (remove(K key) 2500 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Get key 1");
		if (linkedListMap.get(1) == null) {
			System.out.println("invalid key");
		}
		System.out.println("Is Empty");
		System.out.println("Empty:" + linkedListMap.isEmpty());
//--------------------------------------------------------------------------------------------------------		
		/* Add numbers from 0 to 250 into Map */
		System.out.println("\nAdd numbers from 0 to 250 into Map");
		linkedListMap = new HashTableChainLinkedList<>();
		System.out.println("Is Empty");
		System.out.println("Empty:" + linkedListMap.isEmpty());
		start = System.nanoTime();
		for (int i = 0; i < SIZEMEDIUM; i++) {
			linkedListMap.put(i, i);
		}
		end = System.nanoTime();
		System.out.println("Hash Table Chain Linked List running time (add 250 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println(linkedListMap.toString());
		System.out.println("Get size");
		System.out.println("Size:" + linkedListMap.size());
		System.out.println("Get key 235");
		start = System.nanoTime();
		System.out.println("Value:" + linkedListMap.get(235));
		end = System.nanoTime();
		System.out.println("Hash Table Chain Linked List running time (get(K key) 250 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Remove key 18");
		start = System.nanoTime();
		System.out.println("Value:" + linkedListMap.remove(18));
		end = System.nanoTime();
		System.out.println("Remove key 18");
		if(linkedListMap.remove(18)==null) {
			System.out.println("invalid key");
		}
		System.out.println("Hash Table Chain Linked List running time (remove(K key) 250 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Get key 18");
		if (linkedListMap.get(18) == null) {
			System.out.println("invalid key");
		}
		System.out.println("Is Empty");
		System.out.println("Empty:" + linkedListMap.isEmpty());
//--------------------------------------------------------------------------------------------------------------------
		/* Add numbers from 0 to 25 with duplicate keys into Map */
		System.out.println("\nAdd numbers from 0 to 25 into Map");
		linkedListMap = new HashTableChainLinkedList<>();
		System.out.println("Is Empty");
		System.out.println("Empty:" + linkedListMap.isEmpty());
		start = System.nanoTime();
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < SIZESMALL; i++) {
				linkedListMap.put(i, i * k);
			}
		}
		end = System.nanoTime();
		System.out.println("Hash Table Chain Linked List running time (add 25 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println(linkedListMap.toString());
		System.out.println("Get size");
		System.out.println("Size:" + linkedListMap.size());
		System.out.println("Get key 23");
		start = System.nanoTime();
		System.out.println("Value:" + linkedListMap.get(23));
		end = System.nanoTime();
		System.out.println("Hash Table Chain Linked List running time (get(K key) 25 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Get key 121213");
		if (linkedListMap.get(121213) == null) {
			System.out.println("invalid key");
		}
		System.out.println("Remove key 6");
		start = System.nanoTime();
		System.out.println("Value:" + linkedListMap.remove(6));
		end = System.nanoTime();
		System.out.println("Again Remove key 6");
		if(linkedListMap.remove(6)==null) {
			System.out.println("invalid key");
		}
		System.out.println("Hash Table Chain Linked List running time (remove(K key) 25 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Get key 6");
		if (linkedListMap.get(6) == null) {
			System.out.println("invalid key");
		}
		System.out.println("Is Empty");
		System.out.println("Empty:" + linkedListMap.isEmpty());
//------------------------------------------------------------------------------------------------------------
		System.out.println("\n\nHash Table Chain Linked List (Key type String ,Value type String)");
		HashTableChainLinkedList<String, String> linkedListMap2 = new HashTableChainLinkedList<>();
		System.out.println("Is Empty");
		System.out.println("Empty:" + linkedListMap2.isEmpty());
		linkedListMap2.put("a", "Samsun");
		linkedListMap2.put("b", "Istanbul");
		linkedListMap2.put("c", "Ankara");
		linkedListMap2.put("d", "Bursa");
		linkedListMap2.put("e", "Izmir");
		linkedListMap2.put("f", "Ordu");
		linkedListMap2.put("g", "Antalya");
		linkedListMap2.put("h", "Mugla");
		linkedListMap2.put("i", "Balikesir");
		linkedListMap2.put("k", "Mersin");
		linkedListMap2.put("l", "Adana");
		linkedListMap2.put("m", "Gaziantep");
		linkedListMap2.put("n", "Sanliurfa");
		linkedListMap2.put("p", "Zonguldak");
		linkedListMap2.put("r", "Karabuk");
		linkedListMap2.put("t", "Trabzon");
		linkedListMap2.put("v", "Giresun");
		linkedListMap2.put("y", "Sinop");
		linkedListMap2.put("z", "Canakkale");
		System.out.println(linkedListMap2.toString());
		System.out.println("Get size");
		System.out.println("Size:" + linkedListMap2.size());
		System.out.println("Get key a");
		System.out.println("Value:" + linkedListMap2.get("a"));
		System.out.println("Get ket o");
		if (linkedListMap2.get("o") == null) {
			System.out.println("invalid key");
		}
		System.out.println("Remove key a");
		System.out.println("Value:" + linkedListMap2.remove("a"));
		System.out.println("Get key a");
		if (linkedListMap2.get("a") == null) {
			System.out.println("invalid key");
		}
		System.out.println("Is Empty");
		System.out.println("Empty:" + linkedListMap2.isEmpty());

//---------------------------------------------------------------------------------------------------------
		System.out.println("\n\nHash Table Chain Tree Set (Key type Integer ,Value type Integer)");
		System.out.println("\nAdd numbers from 0 to 2500 into Tree Set Chain Map");
		HashTableChainTreeSet<Integer, Integer> treeSetMap = new HashTableChainTreeSet<>();	
		System.out.println("Is Empty");
		System.out.println("Empty:" + treeSetMap.isEmpty());
		start = System.nanoTime();
		for (int i = 0; i < SIZELARGE; i++) {
			treeSetMap.put(i, i);
		}
		end = System.nanoTime();
		System.out.println("Hash Table Chain Tree Set running time (add 2500 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println(treeSetMap.toString());
		System.out.println("Get size");
		System.out.println("Size:" + treeSetMap.size());
		System.out.println("Get key 1000");
		start = System.nanoTime();
		System.out.println("Value:" + treeSetMap.get(1000));
		end = System.nanoTime();
		System.out.println("Hash Table Chain Tree Set running time (get(K key) 2500 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Remove key 1800");
		start = System.nanoTime();
		System.out.println("Value:" + treeSetMap.remove(1800));
		end = System.nanoTime();
		System.out.println("Again Remove key 1800");
		if(treeSetMap.remove(1800)==null) {
			System.out.println("invalid key");
		}
		System.out.println("Hash Table Chain Tree Set running time (remove(K key) 2500 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Get key 1800");
		if(treeSetMap.get(1800)==null) {
			System.out.println("Invalid key");
		}
		System.out.println("Is Empty");
		System.out.println("Empty:" + treeSetMap.isEmpty());
//---------------------------------------------------------------------------------------------------------------		
		/* Add numbers from 0 to 250 into Tree Set Chain Map */
		System.out.println("\nAdd numbers from 0 to 250 into Tree Set Chain Map");
		treeSetMap = new HashTableChainTreeSet<>();
		System.out.println("Is Empty");
		System.out.println("Empty:" + treeSetMap.isEmpty());
		start = System.nanoTime();
		for (int i = 0; i < SIZEMEDIUM; i++) {
			treeSetMap.put(i, i);
		}
		end = System.nanoTime();
		System.out.println("Hash Table Chain Tree Set running time (add 250 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println(treeSetMap.toString());
		System.out.println("Get size");
		System.out.println("Size:" + treeSetMap.size());
		System.out.println("Get key 50");
		start = System.nanoTime();
		System.out.println("Value:" + treeSetMap.get(50));
		end = System.nanoTime();
		System.out.println("Hash Table Chain Tree Set running time (get(K key) 250 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Remove key 18");
		start = System.nanoTime();
		System.out.println("Value:" + treeSetMap.remove(18));
		end = System.nanoTime();
		System.out.println("Again Remove key 18");
		if(treeSetMap.remove(18)==null) {
			System.out.println("invalid key");
		}
		System.out.println("Hash Table Chain Tree Set running time (remove(K key) 250 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Get key 18");
		if(treeSetMap.get(1800)==null) {
			System.out.println("Invalid key");
		}
		System.out.println("Is Empty");
		System.out.println("Empty:" + treeSetMap.isEmpty());
//--------------------------------------------------------------------------------------------------------------		
		System.out.println("\nAdd numbers from 0 to 25 into Tree Set Chain Map");
		treeSetMap = new HashTableChainTreeSet<>();
		System.out.println("Is Empty");
		System.out.println("Empty:" + treeSetMap.isEmpty());
		start = System.nanoTime();
		for (int i = 0; i < SIZESMALL; i++) {
			treeSetMap.put(i, i);
		}
		end = System.nanoTime();
		System.out.println("Hash Table Chain Tree Set running time (add 25 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println(treeSetMap.toString());
		System.out.println("Get size");
		System.out.println("Size:" + treeSetMap.size());
		System.out.println("Get key 10");
		start = System.nanoTime();
		System.out.println("Value:" + treeSetMap.get(10));
		end = System.nanoTime();
		System.out.println("Hash Table Chain Tree Set running time (get(K key) 25 item): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Remove key 5");
		start = System.nanoTime();
		System.out.println("Value:" + treeSetMap.remove(5));
		end = System.nanoTime();
		System.out.println("Again Remove key 5");
		if(treeSetMap.remove(5)==null) {
			System.out.println("invalid key");
		}
		System.out.println("Hash Table Chain Tree Set running time (remove(K key) 25 item): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Get key 5");
		if(treeSetMap.get(5)==null) {
			System.out.println("Invalid key");
		}
		System.out.println("Is Empty");
		System.out.println("Empty:" + treeSetMap.isEmpty());
		
		System.out.println("\nHash Table Chain Tree Set (Key type String ,Value type String)");
		HashTableChainTreeSet<String, String> treeSetMap2 = new HashTableChainTreeSet<>();
		System.out.println("Is Empty");
		System.out.println("Empty:" + treeSetMap2.isEmpty());
		treeSetMap2.put("a", "Samsun");
		treeSetMap2.put("b", "Istanbul");
		treeSetMap2.put("c", "Ankara");
		treeSetMap2.put("d", "Bursa");
		treeSetMap2.put("e", "Izmir");
		treeSetMap2.put("f", "Ordu");
		treeSetMap2.put("g", "Antalya");
		treeSetMap2.put("h", "Mugla");
		treeSetMap2.put("i", "Balikesir");
		treeSetMap2.put("k", "Mersin");
		treeSetMap2.put("l", "Adana");
		treeSetMap2.put("m", "Gaziantep");
		treeSetMap2.put("n", "Sanliurfa");
		treeSetMap2.put("p", "Zonguldak");
		treeSetMap2.put("r", "Karabuk");
		treeSetMap2.put("t", "Trabzon");
		treeSetMap2.put("v", "Giresun");
		treeSetMap2.put("y", "Sinop");
		treeSetMap2.put("z", "Canakkale");
		System.out.println(treeSetMap2.toString());
		System.out.println("Get size");
		System.out.println("Size:" + treeSetMap2.size());
		System.out.println("Get key a");
		System.out.println("Value:" + treeSetMap2.get("a"));
		System.out.println("Get ket o");
		if (treeSetMap2.get("o") == null) {
			System.out.println("invalid key");
		}
		System.out.println("Remove key a");
		System.out.println("Value:" + treeSetMap2.remove("a"));
		System.out.println("Get key a");
		if (treeSetMap2.get("a") == null) {
			System.out.println("invalid key");
		}
		System.out.println("Is Empty");
		System.out.println("Empty:" + treeSetMap2.isEmpty());
		
//---------------------------------------------------------------------------------------------------------		
		System.out.println("\n\nHash Table Chain Coalesced (Key type Integer ,Value type Integer)");
		HashTableChainCoalesced<Integer, Integer> coalescedMap = new HashTableChainCoalesced<>(2500);	
		
		System.out.println("Add numbers from 0 to 2500 into Coalesced Map");
		coalescedMap = new HashTableChainCoalesced<>(2500);
		System.out.println("Is Empty");
		System.out.println("Empty:" + coalescedMap.isEmpty());
		start = System.nanoTime();
		for (int i = 0; i < SIZELARGE; i++) {
			coalescedMap.put(i, i);
		}
		end = System.nanoTime();
		System.out.println("Hash Table Chain Coalesced running time (add 2500 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println(coalescedMap.toString());
		System.out.println("Get size");
		System.out.println("Size:" + coalescedMap.size());
		System.out.println("Get key 1000");
		start = System.nanoTime();
		System.out.println("Value:" + coalescedMap.get(1000));
		end = System.nanoTime();
		System.out.println("Hash Table Chain Coalesced running time (get(K key) 2500 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Remove key 180");
		start = System.nanoTime();
		System.out.println("Value:" + coalescedMap.remove(180));
		end = System.nanoTime();
		System.out.println("Again Remove key 180");
		if(coalescedMap.remove(180)==null) {
			System.out.println("invalid key");
		}
		System.out.println("Hash Table Chain Coalesced running time (remove(K key) 2500 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Get key 180");
		if(coalescedMap.get(180) == null) {
			System.out.println("Invalid key");
		}
		System.out.println("Is Empty");
		System.out.println("Empty:" + coalescedMap.isEmpty());
//-----------------------------------------------------------------------------------------------------------------------				
		/* Add numbers from 0 to 250 into Coalesced Map */
		System.out.println("Add numbers from 0 to 250 into Coalesced Map");
		coalescedMap = new HashTableChainCoalesced<>(250);
		System.out.println("Is Empty");
		System.out.println("Empty:" + coalescedMap.isEmpty());
		start = System.nanoTime();
		for (int i = 0; i < SIZEMEDIUM; i++) {
			coalescedMap.put(i, i);
		}
		end = System.nanoTime();
		System.out.println("Hash Table Chain Coalesced running time (add 250 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println(coalescedMap.toString());
		System.out.println("Get size");
		System.out.println("Size:" + coalescedMap.size());
		System.out.println("Get key 235");
		start = System.nanoTime();
		System.out.println("Value:" + coalescedMap.get(235));
		end = System.nanoTime();
		System.out.println("Hash Table Chain Coalesced running time (get(K key) 250 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Remove key 18");
		start = System.nanoTime();
		System.out.println("Value:" + coalescedMap.remove(18));
		end = System.nanoTime();
		System.out.println("Again Remove key 18");
		if(coalescedMap.remove(18)==null) {
			System.out.println("invalid key");
		}
		System.out.println("Hash Table Chain Coalesced running time (remove(K key) 250 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Get key 18");
		if(coalescedMap.get(18) == null) {
			System.out.println("Invalid key");
		}
		System.out.println("Is Empty");
		System.out.println("Empty:" + coalescedMap.isEmpty());
//---------------------------------------------------------------------------------------------------------		
		System.out.println("\nAdd numbers from 0 to 25 into Coalesced Map");
		coalescedMap = new HashTableChainCoalesced<>(25);
		System.out.println("Is Empty");
		System.out.println("Empty:" + coalescedMap.isEmpty());
		start = System.nanoTime();
		for (int i = 0; i < SIZESMALL; i++) {
			coalescedMap.put(i, i);
		}
		end = System.nanoTime();
		System.out.println("Hash Table Chain Coalesced running time (add 25 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println(coalescedMap.toString());
		System.out.println("Get size");
		System.out.println("Size:" + coalescedMap.size());
		System.out.println("Get key 12");
		start = System.nanoTime();
		System.out.println("Value:" + coalescedMap.get(12));
		end = System.nanoTime();
		System.out.println("Hash Table Chain Coalesced running time (get(K key) 25 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Remove key 20");
		start = System.nanoTime();
		System.out.println("Value:" + coalescedMap.remove(20));
		end = System.nanoTime();
		System.out.println("Again Remove key 20");
		if(coalescedMap.remove(20)==null) {
			System.out.println("invalid key");
		}
		System.out.println("Hash Table Chain Coalesced running time (remove(K key) 25 items): "+formatter.format ((end-start)/(float) 1000000)+"ms");
		System.out.println("Get key 20");
		if(coalescedMap.get(20) == null) {
			System.out.println("Invalid key");
		}
		System.out.println("Is Empty");
		System.out.println("Empty:" + coalescedMap.isEmpty());
//-----------------------------------------------------------------------------------------------------------------------		
		System.out.println("\n\nHash Table Chain Coalesced (Key type String ,Value type String)");
		HashTableChainCoalesced<Integer, Integer> coalescedMap2 = new HashTableChainCoalesced<>(19);	
		System.out.println("Is Empty");
		System.out.println("Empty:" + coalescedMap2.isEmpty());
		coalescedMap2.put("a", "Samsun");
		coalescedMap2.put("b", "Istanbul");
		coalescedMap2.put("c", "Ankara");
		coalescedMap2.put("d", "Bursa");
		coalescedMap2.put("e", "Izmir");
		coalescedMap2.put("f", "Ordu");
		coalescedMap2.put("g", "Antalya");
		coalescedMap2.put("h", "Mugla");
		coalescedMap2.put("i", "Balikesir");
		coalescedMap2.put("k", "Mersin");
		coalescedMap2.put("l", "Adana");
		coalescedMap2.put("m", "Gaziantep");
		coalescedMap2.put("n", "Sanliurfa");
		coalescedMap2.put("p", "Zonguldak");
		coalescedMap2.put("r", "Karabuk");
		coalescedMap2.put("t", "Trabzon");
		coalescedMap2.put("v", "Giresun");
		coalescedMap2.put("y", "Sinop");
		coalescedMap2.put("z", "Canakkale");
		System.out.println(coalescedMap2.toString());
		System.out.println("Get size");
		System.out.println("Size:" + coalescedMap2.size());
		System.out.println("Get key a");
		System.out.println("Value:" + coalescedMap2.get("a"));
		System.out.println("Get ket o");
		if (coalescedMap2.get("o") == null) {
			System.out.println("invalid key");
		}
		System.out.println("Remove key a");
		System.out.println("Value:" + coalescedMap2.remove("a"));
		System.out.println("Get key a");
		if (coalescedMap2.get("a") == null) {
			System.out.println("invalid key");
		}
		System.out.println("Is Empty");
		System.out.println("Empty:" + coalescedMap2.isEmpty());
		
	}
	
	
}
