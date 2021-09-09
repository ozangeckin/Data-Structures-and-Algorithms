//package part2;
/**
 * This class tested method of MaxHeap class
 * @autor Ozan GECKIN
 */
import org.junit.Test;

public class MaxHeapTest {
    /**
     * This method test addNode method in MaxHeap class
     */
	@Test
    public void addNodeTest() {
        MaxHeap heap=new MaxHeap();
        heap.add(5);
        heap.add(3);
        heap.add(5);
        heap.add(12);
        heap.add(1);
        heap.add(3);
        System.out.println(heap.toString());
        System.out.println(heap.getMaxNode().getValue());
        if (heap.contains(5)) {
        	System.out.println("Add node test passed");
        }
        else {
        	System.out.println("Add node test failed");
        }
      
    }

	/**
	 * This method test isFull method in MaxHeap class
	 */
    @Test
    public void isFullTest(){
        MaxHeap heap=new MaxHeap();
        for (int i=1;i<=7;i++){
            heap.add(i);
        }
        if (heap.isFull()) {
        	System.out.println("IsFull test passed");
        }
        else {
        	System.out.println("IsFull test failed");
        }
    }
    
    /**
     * This method test remove method in MaxHeap 
     */
    @Test
    public void removeTest(){
        MaxHeap heap=new MaxHeap();
        for (int i=1;i<=7;i++){
            heap.add(i);
        }
        heap.add(2);
        heap.add(2);
        int removeResult=heap.remove(2);
        if (removeResult==2) {
        	System.out.println("remove test passed");
        }
        else {
        	System.out.println("remove test failed");
        }

    }
    /**
     * This method test remove method in MaxHeap 
     */
    @Test
    public void removeTestZero(){
        MaxHeap heap=new MaxHeap();
        for (int i=1;i<=7;i++){
            heap.add(i);
        }
        heap.add(2);
        heap.add(2);
        int removeResult=heap.remove(3);
        if (removeResult==0) {
        	System.out.println("Remove 0 test passed");
        }
        else {
        	System.out.println("Remove 0 test failed");
        }
        

    }
    /**
     * This method test remove(root) method in MaxHeap 
     */
    @Test
    public void removeRootTest(){
        MaxHeap heap=new MaxHeap();
        for (int i=1;i<=7;i++){
            heap.add(i);
        }
       
        heap.remove(7);
        int rootValue=heap.getMaxValue();
        if (rootValue==6) {
        	System.out.println("Remove root test passed");
        }
        else {
        	System.out.println("Remove root test failed");
        }

    }
    /**
     * This method test remove method in MaxHeap 
     */
    @Test
    public void removeNonExistTest(){
        MaxHeap heap=new MaxHeap();
        for (int i=1;i<=7;i++){
            heap.add(i);
        }
       
        heap.remove(10);
        int rootValue=heap.getMaxValue();
        if (rootValue==7) {
        	System.out.println("Remove non-exist test passed");
        }
        else {
        	System.out.println("Remove non-exist test failed");
        }

    }
}
