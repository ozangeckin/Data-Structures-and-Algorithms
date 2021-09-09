/**
 * This class is part 1 Driver class. In it, I tested the functions I implemented for the NaviagableSetSkipList and NavigableSetAVLTree objects.
 * 
 * @author 1801042103
 * 
 */
package part1;

import java.util.Iterator;

public class Driver {

	public static void main(String argv[]) {
		NavigableSetSkipList<Integer> test = new NavigableSetSkipList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		System.out.println("Fill NavigableSetSkipList :");
		System.out.println(test.toString());

		test.remove(2);
		test.remove(3);
		System.out.println("Remove value 2 and 3 :");
		System.out.println(test.toString());

		System.out.println("Testing descending Iterator: ");
		Iterator<Integer> iter = test.descendingIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		System.out.println("\n Testing Filling NavigableSetSkipList:");
		NavigableSetSkipList<Integer> test2 = new NavigableSetSkipList<>();
		test2.add(10);
		test2.add(21);
		test2.add(32);
		test2.add(43);
		test2.add(54);
		test2.add(65);
		test2.add(76);
		test2.add(87);
		System.out.println("Fill NavigableSetSkipList :");
		System.out.println(test2.toString());

		test2.remove(21);
		test2.remove(32);
		System.out.println("Remove value 21 and 32 :");
		System.out.println(test2.toString());

		System.out.println("Testing descending Iterator: ");
		Iterator<Integer> iter2 = test2.descendingIterator();
		while (iter2.hasNext()) {
			System.out.println(iter2.next());
		}
		
		NavigableSetAVLTree<Integer> test3 = new NavigableSetAVLTree<Integer>();
		test3.add(1);
		test3.add(2);
		test3.add(3);
		test3.add(4);
		test3.add(5);
		test3.add(6);
		test3.add(7);
		test3.add(8);
		System.out.println(test3.toString());

	}

}
