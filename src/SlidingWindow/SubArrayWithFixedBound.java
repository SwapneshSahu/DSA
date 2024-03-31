package SlidingWindow;

public class SubArrayWithFixedBound {

	//Leetcode 2444
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public long countSubarrays(int[] nums, int minK, int maxK) {
	      
	      int maxFound = -1;
	      int minFound = -1;
	      int culprit = -1;

	      int i = 0 ;
	      long count = 0;

	      while ( i < nums.length){
	             
	            int num = nums[i];
	           
	           if (num < minK || num > maxK){
	               culprit = i;
	              
	           }

	           if (num == minK)  minFound = i;
	           if (num == maxK)  maxFound = i;

	           int temp = Math.min(minFound,maxFound) - culprit;
	             
	            count+= temp > 0 ? temp :0 ; 
	           i++;
	      }

	      return count;
	    }
}
