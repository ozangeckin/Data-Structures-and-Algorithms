//package part1;

import java.util.HashMap;
/**
 * This class driver class that content MapIterator class of methods.
 * @author Ozan GECKIN
 *
 */
public class Driver {
	public static void main(String[] args) {

		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("a", "Data Structure");
		hashMap.put("b", "Operating System");
		hashMap.put("c", "Programming Language");
		hashMap.put("d", "Computer Graph");
		hashMap.put("e", "Object Oriented Programming");
		hashMap.put("f", "System Programming");
		hashMap.put("g", "C programming");
		hashMap.put("h", "Computer Organization");
		hashMap.put("i", "Discreate Math");
		hashMap.put("k", "ISG");

		MapIterator<String, String> mapIterator = new MapIterator<>();
		mapIterator.setKvMap(hashMap);
		
		while (mapIterator.hasNext()) {
			String key = mapIterator.next();
			System.out.println(key + "-->" + hashMap.get(key));
		}
		System.out.println();
		mapIterator = new MapIterator<String, String>("g");
		mapIterator.setKvMap(hashMap);

		while (mapIterator.hasNext()) {
			String key = mapIterator.next();
			System.out.println(key + "-->" + hashMap.get(key));
		}
//------------------------------------------------------------------------------------		
		HashMap<Integer, Integer> hashMap2 = new HashMap<Integer, Integer>();
		for(int i=0; i< 20; i++) {
			hashMap2.put(i,i);
		}
		MapIterator<Integer, Integer> mapIterator2 = new MapIterator<>();
		mapIterator2.setKvMap(hashMap2);
	
		while (mapIterator2.hasNext()) {
			Integer key2 = mapIterator2.next();
			System.out.println(key2 + "-->" + hashMap2.get(key2));
		}
		System.out.println();
		mapIterator2 = new MapIterator<Integer, Integer>(10);
		mapIterator2.setKvMap(hashMap2);
		while (mapIterator2.hasNext()) {
			Integer key2 = mapIterator2.next();
			System.out.println(key2 + "-->" + hashMap2.get(key2));
		}
		
	}
}
