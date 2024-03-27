package SlidingWindow;

public class SubArrayProdLessThenk {
//Lt-713
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int numSubarrayProductLessThanK(int[] nums, int k) {
	        
	        if (k <= 1) return 0;
	        int left = 0;
	        int right = 0;
	        int curr = 1;
	        int count =0;

	        while (right < nums.length && left <=right){

	             curr *= nums[right];

	             while (curr >= k && left < nums.length) {
	                curr /= nums[left];
	                 left++;
	                                
	             } 
	             count += right -left +1;  // to calculate number of sub array between these two index

	             right++;

	        }

	        return count ;
	    }

}

