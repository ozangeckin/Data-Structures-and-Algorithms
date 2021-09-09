/**
 * This class control to array.I used in tests.
 * @author Ozan GECKIN
 */
//package part2;


public class ControlArrayUtils {
	
	/**
	 * This method return occurrence counter.
	 * 
	 * @param int array 
	 * @param int value
	 * @return int occurrence
	 */
	public static int getOccurrence(int[] array,int value) {
		int count=0;
        int i=0;
        while ( i<array.length && array[i]<=value){
            if (array[i]==value) count++;
            i++;
        }
        return count;
	}
	/**
	 * This method checks if that value is in the array.
	 * @param int array
	 * @param int value
	 * @return boolean true if element is present
	 */
	public static boolean inArray(int[] array, int value) {
		 for (int i=0;i<array.length-1;i++) {
			 if (array[i]>value) {
				 return false;
			 }
			 if (array[i]==value) {
				 return true;
			 }
		 }
		 return false;
	}
	/**
	 * This method returns the largest occurence value in the array.
	 * @param int array 
	 * @return int max occurence counter.
	 */
	public static int getMaxOccurrence(int[] array) {
		int count=1;
        int maxCount=0;
        
        for (int i=0;i<array.length-1;i++) {
        	if (array[i]==array[i+1]) {
        		count++;
        	}
        	else {
        		if (count>maxCount) {
        			maxCount=count;
        			
        		}
        		count=1;
        	}
        }
        if (count>maxCount) {
			maxCount=count;
			
		}
        return maxCount;
	}
}
