/**
 * This is the class that I tested junit of class heap functions.
 * @author Ozan GECKIN
 */
//package part1;
import org.junit.Test;

public class HeapTest {
	
	/**
	 * This method testing add method in Heap class.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void addNodeTest() {
		Heap heap = new Heap(10);
		heap.add(5);
		heap.add(3);
		heap.add(12);
		heap.add(1);
		heap.add(8);
		System.out.println(heap.toString());
		if (heap.search(5).compareTo(5) == 0) {
			System.out.println("Add Node test passed");
		} else {
			System.out.println("Add node test failed");
		}
	}

	/**
	 * This method testing isFull method in Heap class.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void isFullTest() {
		Heap heap = new Heap(10);
		for (int i = 1; i <= 10; i++) {
			heap.add(i);
		}
		if (heap.isFull()) {
			System.out.println("ISFull test passed");
		} else {
			System.out.println("IsFull test failed");
		}
	}

	/**
	 * This method testing remove method in Heap class.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void removeTest() {
		Heap heap = new Heap(10);
		for (int i = 1; i <= 10; i++) {
			heap.add(i);
		}

		heap.remove(2);

		if (heap.search(2) == null) {
			System.out.println("Remove Node test passed");
		} else {
			System.out.println("Remove Node test failed");
		}

	}

	/**
	 * This method testing remove(root) method in Heap class.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void removeRootTest() {
		Heap heap = new Heap(10);
		for (int i = 1; i <= 10; i++) {
			heap.add(i);
		}

		heap.remove(10);
		if (heap.search(10) == null) {
			System.out.println("Remove root test passed");
		} else {
			System.out.println("Remove root test failed");
		}

	}
	/**
	 * This method testing mergeHeap method in Heap class.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void mergeHeapTest() {
		Heap heap = new Heap(25);
		for (int i = 1; i <= 10; i++) {
			heap.add(i);
		}

		Heap heap2 = new Heap(8);
		for (int i = 20; i <= 28; i++) {
			heap2.add(i);
		}

		heap.mergeHeap(heap2);
		if (heap.getSize() == 18 && heap.search(21).compareTo(21) == 0) {
			System.out.println("Merge Heaps test passed");
		} else {
			System.out.println("Merge Hesps test failed");
		}

	}
	/**
	 * This method testing removeKthLargest method in Heap class.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void removeKthLargest() {
		Heap heap = new Heap(10);
		for (int i = 1; i <= 10; i++) {
			heap.add(i);
		}
		heap.removeKthLargest(3);

		if (heap.search(8) == null) {
			System.out.println("Remove Kth largest test passed");
		} else {
			System.out.println("Remove Kth largest test failed");
		}

	}
	/**
	 * This method testing iteratorSetValue method in Heap class.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void iteratorSetValueTest() {
		Heap heap = new Heap(10);
		for (int i = 1; i <= 10; i++) {
			heap.add(i);
		}

		Heap.MaxHeapIterator iterator = (Heap.MaxHeapIterator) heap.iterator();
		while (iterator.hasNext()) {
			iterator.setValue(2);
		}

		iterator = (Heap.MaxHeapIterator) heap.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().compareTo(2) == 0) {
				System.out.println("Iterator test passed");
			} else {
				System.out.println("Iterator test failed");
			}

		}
	}
}
