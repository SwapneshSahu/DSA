package DP;

public class MinOperationTOmakeXZero {

	public static void main(String[] args) {
		
     int [] nums  =new int [] {1,1};
     System.out.println(minOperations(nums, 3));
	}
	
	public static int minOperations(int[] nums, int x) {
	      int ans = minOpertionRec(nums,0 , nums.length-1 , 0 , x);
	        return ans != Integer.MAX_VALUE ? ans : -1;
	    }

	    public static int minOpertionRec(int [] nums, int left , int right , int count , int x){

	          
	          if (x == 0) return count;

	          if (left == nums.length || right < 0 || left >right) return Integer.MAX_VALUE;

	          int fromLeft = Integer.MAX_VALUE;
	          int fromRight = Integer.MAX_VALUE;

	          if ( x >= nums[left] ){
	            fromLeft = minOpertionRec(nums,left+1 , right , count+1 , x- nums[left]);
	          }
	          if ( x >= nums[right] ){
	            fromRight = minOpertionRec(nums,left , right-1 , count+1 , x- nums[right]);
	          }

	           return Math.min(fromRight,fromLeft);
	    }

}
