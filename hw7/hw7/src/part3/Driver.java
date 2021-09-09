package part3;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class Driver class.The methods I tested for performance. I made a total
 * of 200 instructions using BinarySearchTree , RedBlackTree, TwoThreeTree,
 * SkipList, BTree data structures. I added 10000, 20000, 40000, 80000 random
 * elements 10 times each. I did a time analysis while adding it.
 * 
 * @author 1801042103
 */
public class Driver {

	public static void main(String argv[]) {
		/** I defined data structures */
		BinarySearchTree<Integer> BST;
		RedBlackTree<Integer> RBT;
		TwoThreeTree<Integer> TTT;
		SkipList<Integer> Skp;
		BTree<Integer> BTR;

		Random rand = new Random();
		int temp;
		long startTime, stopTime;
		long average = 0;

		/** Fills the arraylist up to 10000 with random and uniqe numbers */
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (list.size() < 10000) {
			temp = rand.nextInt();
			if (!list.contains(temp)) {
				list.add(temp);
			}
		}

		/** Fills the arraylist up to 20000 with random and uniqe numbers */
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		while (list2.size() < 20000) {
			temp = rand.nextInt();
			if (!list2.contains(temp)) {
				list2.add(temp);
			}
		}

		/** Fills the arraylist up to 40000 with random and uniqe numbers */
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		while (list3.size() < 40000) {
			temp = rand.nextInt();
			if (!list3.contains(temp)) {
				list3.add(temp);
			}
		}

		/** Fills the arraylist up to 80000 with random and uniqe numbers */
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		while (list4.size() < 80000) {
			temp = rand.nextInt();
			if (!list4.contains(temp)) {
				list4.add(temp);
			}
		}

		/** Fills the arraylist up to 100 with random and uniqe numbers */
		ArrayList<Integer> list5 = new ArrayList<Integer>();
		while (list5.size() < 100) {
			temp = rand.nextInt();
			if (!list5.contains(temp)) {
				list5.add(temp);
			}
		}

		/**
		 * 10 times Binary Search Tree fills the tree with random and unique numbers up
		 * to 10000 and adds an extra 100 numbers on top. I kept the time added by 100
		 * numbers and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			BST = new BinarySearchTree<Integer>();
			for (int j = 0; j < list.size(); j++) {
				BST.add(list.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				BST.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the Binary Search Tree, which is filled with 10000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times Binary Search Tree fills the tree with random and unique numbers up
		 * to 20000 and adds an extra 100 numbers on top. I kept the time added by 100
		 * numbers and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			BST = new BinarySearchTree<Integer>();
			for (int j = 0; j < list2.size(); j++) {
				BST.add(list2.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				BST.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the Binary Search Tree, which is filled with 20000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;
		/**
		 * 10 times Binary Search Tree fills the tree with random and unique numbers up
		 * to 40000 and adds an extra 100 numbers on top. I kept the time added by 100
		 * numbers and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			BST = new BinarySearchTree<Integer>();
			for (int j = 0; j < list3.size(); j++) {
				BST.add(list3.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				BST.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}

		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the Binary Search Tree, which is filled with 40000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times Binary Search Tree fills the tree with random and unique numbers up
		 * to 80000 and adds an extra 100 numbers on top. I kept the time added by 100
		 * numbers and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			BST = new BinarySearchTree<Integer>();
			for (int j = 0; j < list4.size(); j++) {
				BST.add(list4.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				BST.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}

		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the Binary Search Tree, which is filled with 80000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times Red Black Tree fills the tree with random and unique numbers up to
		 * 10000 and adds an extra 100 numbers on top. I kept the time added by 100
		 * numbers and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			RBT = new RedBlackTree<Integer>();
			for (int j = 0; j < list.size(); j++) {
				RBT.add(list.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				RBT.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}

		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the Red Black Tree, which is filled with 10000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times Red Black Tree fills the tree with random and unique numbers up to
		 * 20000 and adds an extra 100 numbers on top. I kept the time added by 100
		 * numbers and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			RBT = new RedBlackTree<Integer>();
			for (int j = 0; j < list2.size(); j++) {
				RBT.add(list2.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				RBT.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the Red Black Tree, which is filled with 20000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times Red Black Tree fills the tree with random and unique numbers up to
		 * 40000 and adds an extra 100 numbers on top. I kept the time added by 100
		 * numbers and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			RBT = new RedBlackTree<Integer>();
			for (int j = 0; j < list3.size(); j++) {
				RBT.add(list3.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				RBT.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the Red Black Tree, which is filled with 40000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times Red Black Tree fills the tree with random and unique numbers up to
		 * 80000 and adds an extra 100 numbers on top. I kept the time added by 100
		 * numbers and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			RBT = new RedBlackTree<Integer>();
			for (int j = 0; j < list4.size(); j++) {
				RBT.add(list4.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				RBT.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the Red Black Tree, which is filled with 80000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times Two Three Tree fills the tree with random and unique numbers up to
		 * 10000 and adds an extra 100 numbers on top. I kept the time added by 100
		 * numbers and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			TTT = new TwoThreeTree<Integer>();
			for (int j = 0; j < list.size(); j++) {
				TTT.add(list.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				TTT.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the 2-3 Tree, which is filled with 10000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times Two Three Tree fills the tree with random and unique numbers up to
		 * 20000 and adds an extra 100 numbers on top. I kept the time added by 100
		 * numbers and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			TTT = new TwoThreeTree<Integer>();
			for (int j = 0; j < list2.size(); j++) {
				TTT.add(list2.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				TTT.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the 2-3 Tree, which is filled with 20000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times Two Three Tree fills the tree with random and unique numbers up to
		 * 40000 and adds an extra 100 numbers on top. I kept the time added by 100
		 * numbers and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			TTT = new TwoThreeTree<Integer>();
			for (int j = 0; j < list3.size(); j++) {
				TTT.add(list3.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				TTT.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the 2-3 Tree, which is filled with 40000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times Two Three Tree fills the tree with random and unique numbers up to
		 * 80000 and adds an extra 100 numbers on top. I kept the time added by 100
		 * numbers and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			TTT = new TwoThreeTree<Integer>();
			for (int j = 0; j < list4.size(); j++) {
				TTT.add(list4.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				TTT.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the 2-3 Tree, which is filled with 80000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times Skip List fills the list with random and unique numbers up to 10000
		 * and adds an extra 100 numbers on top. I kept the time added by 100 numbers
		 * and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			Skp = new SkipList<Integer>();
			for (int j = 0; j < list.size(); j++) {
				Skp.add(list.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				Skp.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the Skip List, which is filled with 10000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times Skip List fills the list with random and unique numbers up to 20000
		 * and adds an extra 100 numbers on top. I kept the time added by 100 numbers
		 * and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			Skp = new SkipList<Integer>();
			for (int j = 0; j < list2.size(); j++) {
				Skp.add(list2.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				Skp.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the Skip List, which is filled with 20000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times Skip List fills the list with random and unique numbers up to 40000
		 * and adds an extra 100 numbers on top. I kept the time added by 100 numbers
		 * and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			Skp = new SkipList<Integer>();
			for (int j = 0; j < list3.size(); j++) {
				Skp.add(list3.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				Skp.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the Skip List, which is filled with 40000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times Skip List fills the list with random and unique numbers up to 80000
		 * and adds an extra 100 numbers on top. I kept the time added by 100 numbers
		 * and then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			Skp = new SkipList<Integer>();
			for (int j = 0; j < list4.size(); j++) {
				Skp.add(list4.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				Skp.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the Skip List, which is filled with 80000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times BTree fills the tree with random and unique numbers up to 10000 and
		 * adds an extra 100 numbers on top. I kept the time added by 100 numbers and
		 * then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			BTR = new BTree<Integer>(50);
			for (int j = 0; j < list.size(); j++) {
				BTR.add(list.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				BTR.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the B-Tree, which is filled with 10000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times BTree fills the tree with random and unique numbers up to 20000 and
		 * adds an extra 100 numbers on top. I kept the time added by 100 numbers and
		 * then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			BTR = new BTree<Integer>(50);
			for (int j = 0; j < list2.size(); j++) {
				BTR.add(list2.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				BTR.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the B-Tree, which is filled with 20000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times BTree fills the tree with random and unique numbers up to 40000 and
		 * adds an extra 100 numbers on top. I kept the time added by 100 numbers and
		 * then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			BTR = new BTree<Integer>(50);
			for (int j = 0; j < list3.size(); j++) {
				BTR.add(list3.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				BTR.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the B-Tree, which is filled with 40000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

		/**
		 * 10 times BTree fills the tree with random and unique numbers up to 80000 and
		 * adds an extra 100 numbers on top. I kept the time added by 100 numbers and
		 * then calculates the average time
		 */
		for (int i = 0; i < 10; i++) {
			BTR = new BTree<Integer>(50);
			for (int j = 0; j < list4.size(); j++) {
				BTR.add(list4.get(j));
			}
			startTime = System.nanoTime();
			for (int q = 0; q < list5.size(); q++) {
				BTR.add(list5.get(q));
			}
			stopTime = System.nanoTime();
			average += stopTime - startTime;
		}
		average /= 10;
		System.out.println(
				"It is an average microsecond of adding 100 extra elements to the B-Tree, which is filled with 80000 random and unique elements 10 times : "
						+ (average / 1000) + " 탎");
		average = 0;

	}

}
