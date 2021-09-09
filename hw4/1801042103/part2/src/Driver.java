//package part2;

import java.util.Arrays;
import java.util.Random;

public class Driver {
	public static void main(String[] args) {
		final int NUMBER_OF_ITEMS = 3000;
		BSTHeapTree tree = new BSTHeapTree();
		int[] control = new int[NUMBER_OF_ITEMS];

		/**
		 * TEST 1 Insert the 3000 numbers that are randomly generated in the range
		 * 0-5000 into the BSTHeapTree. Store these numbers in an array as well. Sort
		 * the numbers to find the number occurrences of all the numbers.
		 */
		// generate BST heap tree with random numbers
		for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
			Random ran = new Random();
			int item = ran.nextInt(5000);
			int result = tree.add(item);
			control[i] = item;
		}
		Arrays.sort(control);

		/**
		 * TEST 2 Search for 100 numbers in the array and 10 numbers not in the array
		 * and make sure that the number of occurrences is correct.
		 */
		System.out.println("\n--------- CHECKING OCCURRENCE OF VALUES THAT EXIST IN ARRAY----------\n");
		// Get random 100 values from control array
		for (int i = 0; i < 100; i++) {

			Random ran = new Random();
			int index = ran.nextInt(3000);
			int value = control[index];

			int expectedOccurrence = ControlArrayUtils.getOccurrence(control, value);
			int actualOccurrenceTree = tree.find(value);
			if (expectedOccurrence == actualOccurrenceTree) {
				System.out.println("Value:" + value + " Occurrence:" + actualOccurrenceTree + " TRUE");
			} else {
				System.err.println("Value:" + value + " Occurrence:" + actualOccurrenceTree + " FALSE");
			}
		}

		System.out.println("\n--------- CHECKING OCCURRENCE OF VALUES THAT NON-EXIST IN ARRAY----------\n");
		// Get random 10 values from not in control array
		for (int i = 0; i < 10; i++) {

			int value;
			// find random value not in array
			do {
				Random ran = new Random();
				value = ran.nextInt(5000);
			} while (ControlArrayUtils.inArray(control, value));

			int expectedOccurrence = -1;
			int actualOccurrenceTree = tree.find(value);
			if (expectedOccurrence == actualOccurrenceTree) {
				System.out.println("Value:" + value + " Occurrence:" + actualOccurrenceTree + " TRUE");
			} else {
				System.err.println("Value:" + value + " Occurrence:" + actualOccurrenceTree + " FALSE");
			}
		}

		/**
		 * TEST 3 Find the mode of the BSTHeapTree. Check whether the mode value is
		 * correct.
		 */

		System.out.println("\n--------- CHECKING MODE OF BST HEAP TREE----------\n");

		// Since there can be max occurrence for more than one value
		// max occurrence for value found in BST Heap Tree and max occurrence
		// calculated in array is compared
		int actualModeTree = tree.find_mode();
		int actualOccurrenceForMode = tree.find(actualModeTree);

		int mostOccurrenceInArray = ControlArrayUtils.getMaxOccurrence(control);

		if (actualOccurrenceForMode == mostOccurrenceInArray) {
			System.out.println("Mode:" + actualModeTree + " TRUE");
		} else {
			System.err.println("Mode:" + actualModeTree + " FALSE");
		}

		/**
		 * TEST 4 Remove 100 numbers in the array and 10 numbers not in the array and
		 * make sure that the number of occurrences after removal is correct.
		 */
		System.out.println("\n--------- CHECKING OCCURRENCE OF VALUES THAT EXIST IN ARRAY AFTER REMOVAL----------\n");
		// Get random 100 values from control array
		for (int i = 0; i < 100; i++) {

			Random ran = new Random();
			int index = ran.nextInt(3000);
			int value = control[index];

			int occurrenceInArray = ControlArrayUtils.getOccurrence(control, value);
			int expectedOccurrence;
			if (occurrenceInArray == 1) {
				expectedOccurrence = -1;
			} else {
				expectedOccurrence = occurrenceInArray - 1;
			}
			// remove item from tree
			tree.remove(value);

			int actualOccurrenceTree = tree.find(value);
			if (expectedOccurrence == actualOccurrenceTree) {
				System.out.println("Value:" + value + " Occurrence:" + actualOccurrenceTree + " TRUE");
			} else {
				System.err.println("Value:" + value + " Occurrence:" + actualOccurrenceTree + " FALSE");
			}
		}

		System.out
				.println("\n--------- CHECKING OCCURRENCE OF VALUES THAT NON-EXIST IN ARRAY AFTER REMOVAL----------\n");
		// Get random 10 values from not in control array
		for (int i = 0; i < 10; i++) {

			int value;
			// find random value not in array
			do {
				Random ran = new Random();
				value = ran.nextInt(5000);
			} while (ControlArrayUtils.inArray(control, value));

			int expectedOccurrence = -1;

			// remove item from tree
			tree.remove(value);
			int actualOccurrenceTree = tree.find(value);

			if (expectedOccurrence == actualOccurrenceTree) {
				System.out.println("Value:" + value + " Occurrence:" + actualOccurrenceTree + " TRUE");
			} else {
				System.err.println("Value:" + value + " Occurrence:" + actualOccurrenceTree + " FALSE");
			}
		}
	}
}
