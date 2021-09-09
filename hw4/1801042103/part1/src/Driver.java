//package part1;
/**
 * This is the driver class of the class heap class.
 * @author Ozan GECKIN
 */
//import part1.Heap;
public class Driver {

	public static void main(String[] args) {
		
		Heap<Integer> heap=new Heap<Integer>(20);
		if(heap.isFull()) {
			System.out.println("Heap is full");
		}else {
			System.out.println("Heap is not full");
		}
		System.out.println("Integer Adding element in heap");
		heap.add(5);
		heap.add(2);
		heap.add(15);
		heap.add(1);
		heap.add(67);
		heap.add(45);
		heap.add(23);
		System.out.println(heap.toString());
		
		System.out.println("Heap Size: "+heap.getSize());
		
		System.out.println("------------------------------------------------");
		System.out.println("Remove index 2");
		heap.removeKthLargest(2);
		System.out.println(heap.toString());
		System.out.println("Remove 2");
		heap.remove(2);
		System.out.println("Remove 15");
		heap.remove(15);
		System.out.println(heap.toString());

		System.out.println("------------------------------------------------");
		System.out.println("Search 67");
		int foundItem= heap.search(67);
		if(foundItem == 67) {
			System.out.println("Founded " + foundItem);
		}else {
			System.out.println("Not founded " + foundItem);
		}
		
		System.out.println("------------------------------------------------");
		Heap<Integer> heap2=new Heap<Integer>(6);
		heap2.add(12);
		heap2.add(3);
		heap2.add(26);
		System.out.println("Heap2:" + heap2.toString());
		System.out.println("------------------------------------------------");

		System.out.println("Merge");
		heap.mergeHeap(heap2);
		System.out.println(heap.toString());
		System.out.println("------------------------------------------------");

		Heap<Double> heapDouble=new Heap<Double>(10);
		System.out.println("Double Adding element in heap");
		heapDouble.add(7.5);
		heapDouble.add(15.3);
		heapDouble.add(1.1);
		heapDouble.add(67.6);
		heapDouble.add(45.4);
		heapDouble.add(23.9);
		System.out.println(heapDouble.toString());
		System.out.println("------------------------------------------------");

		System.out.println("Set Values:");
		heapDouble.setValues(1.1);
		System.out.println(heapDouble.toString());
		System.out.println("------------------------------------------------");
		Heap<String> stringHeap=new Heap<String>(5);
		stringHeap.add("Ozan");
		stringHeap.add("Ayca");
		stringHeap.add("Oguzcan");
		stringHeap.add("Nuray");
		stringHeap.add("Resul");
		System.out.println(stringHeap.toString());		

		System.out.println("------------------------------------------------");
		System.out.println("Remove index 3");
		stringHeap.removeKthLargest(2);
		System.out.println(stringHeap.toString());
		System.out.println(stringHeap.toString());
		System.out.println("Remove Resul");
		stringHeap.remove("Resul");
		System.out.println(stringHeap.toString());
		
		System.out.println("------------------------------------------------");
		System.out.println("Search Nuray");
		String foundString= stringHeap.search("Nuray");
		if(foundString.matches("Nuray")) {
			System.out.println("Founded " + foundString);
		}else {
			System.out.println("Not founded " + foundString);
		}
				
		
	}
}
