package part2;

/**
 * This class Part2 driver class. I'm creating a BinarySearchTree and populating
 * it. I check if BSTs are AVL or RedBlackTree using CheckAvl objects.
 * 
 * @author 1801042103
 */
public class Driver {

	public static void main(String argv[]) {

		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		CheckAVL<Integer> checkAVL = new CheckAVL<Integer>();
		CheckRedBlack<Integer> checkRBT = new CheckRedBlack<Integer>();
		
		BST.add(100);
		BST.add(50);
		BST.add(49);
		BST.add(150);
		BST.add(48);
		BST.add(51);
		BST.add(149);
		BST.add(151);
		System.out.println(BST.toString());
		if (checkAVL.isAVLTree(BST)) {
			System.out.println("This Binary Search Tree is AVLTree");
		} else {
			System.out.println("This Binary Search Tree is not AVLTree");
		}

		BinarySearchTree<Integer> BST2 = new BinarySearchTree<Integer>();
		BST2.add(1);
		BST2.add(2);
		BST2.add(3);
		BST2.add(4);
		BST2.add(5);
		BST2.add(6);
		BST2.add(7);
		System.out.println(BST2.toString());
		if (checkAVL.isAVLTree(BST2)) {
			System.out.println("This Binary Search Tree is AVLTree");
		} else {
			System.out.println("This Binary Search Tree is not AVLTree");
		}
		
		if (checkRBT.isRedBlack(BST.root)) {
			System.out.println("\nThis Binary Search Tree is Red Black Tree");
		} else {
			System.out.println("\nThis Binary Search Tree is not Red Black Tree");
		}
		
		
		if (checkRBT.isRedBlack(BST2.root)) {
			System.out.println("\nThis Binary Search Tree is Red Black Tree");
		} else {
			System.out.println("\nThis Binary Search Tree is not Red Black Tree");
		}
		

	}

}
