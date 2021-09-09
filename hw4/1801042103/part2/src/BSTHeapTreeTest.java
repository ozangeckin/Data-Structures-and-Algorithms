//package part2;
/**
 * This class tested method of MaxHeap class
 * @author Ozan GECKIN
 */
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class BSTHeapTreeTest {
    final static int NUMBER_OF_ITEMS=3000;
    BSTHeapTree tree=new BSTHeapTree();
    int[] control=new int[NUMBER_OF_ITEMS];


    private int getArrayOccurence(int value) {
        int count=0;
        int i=0;
        while ( i<control.length && control[i]<=value){
            if (control[i]==value) count++;
            i++;
        }
        return count;
    }
    
    private int getArrayMode() {
        int count=1;
        int maxCount=0;
        int mode=control[0];
        
        for (int i=0;i<control.length-1;i++) {
        	if (control[i]==control[i+1]) {
        		count++;
        	}
        	else {
        		if (count>maxCount) {
        			maxCount=count;
        			mode=control[i];
        		}
        		count=1;
        	}
        }
        if (count>maxCount) {
			maxCount=count;
			mode=control[control.length-1];
		}
        return mode;
    }

    @Before
    public void setUp() throws Exception {

        for (int i=0;i<NUMBER_OF_ITEMS;i++){
            Random ran = new Random();
            int x = ran.nextInt(5000);
            int result=tree.add(x);
            control[i]=x;
        }
        Arrays.sort(control);
    }

    @Test
    public void generateBSTHeapTest() {

    	MaxHeap heap=tree.getData(tree.getRoot());
    	int rootValue=heap.getMaxValue();
    	int rootOccurrence=heap.getOccurence(rootValue);
    	
        int arrayOccurence=getArrayOccurence(rootValue);
        if (rootOccurrence==arrayOccurence) {
        	System.out.println("BST Tree generated successfully");
        }
        else {
        	System.out.println("Wrong occurrence values");
        }
        
    }



    @Test
    public void findTest() {
        Random ran=new Random();
        int x = ran.nextInt(control.length);
        int value=control[x];

        int heapOccurence=tree.find(value);
        int arrayOccurence=getArrayOccurence(value);
        if (heapOccurence==arrayOccurence) {
        	System.out.println("Find test passed");
        }
        else {
        	System.out.println("Find test failed");
        }
    }
    
    @Test 
    public void removeTest() {
    	 Random ran=new Random();
         int x = ran.nextInt(control.length);
         int value=control[x];
         int expected;
         
         int arrayOccurence=getArrayOccurence(value);
         if (arrayOccurence==1) {
        	 expected=-1;
         }
         else {
        	 expected=arrayOccurence-1;
         }
         tree.remove(value);
         int heapOccurence=tree.find(value);
         
         if (expected==heapOccurence) {
         	System.out.println("Remove test passed");
         }
         else {
         	System.out.println("Remove test failed");
         }
    }
    
    @Test 
    public void removeHeapNodeTest() {
    	 Random ran=new Random();
         int x = ran.nextInt(control.length);
         int value=control[x];

         int arrayOccurence=getArrayOccurence(value);
           
         for (int i=0;i<arrayOccurence;i++) {
        	 tree.remove(value);
         }
         
         int heapOccurence=tree.find(value);
         
         if (heapOccurence==-1) {
         	System.out.println("Remove Node test passed");
         }
         else {
         	System.out.println("Remove Node test failed");
         }
    }
    
    @Test 
    public void findModeTest() {
    	
    	 int treeMode=tree.find_mode();
    	 int maxOccurrenceTree=tree.find(treeMode);
    	 
    	 int arrayMode=getArrayMode();
    	 int maxOccerrenceArray=getArrayOccurence(arrayMode);
    	 
    	 if (maxOccerrenceArray==maxOccurrenceTree) {
         	System.out.println("Mode test passed");
         }
         else {
         	System.out.println("Mode test failed");
         }
    }
    
}
