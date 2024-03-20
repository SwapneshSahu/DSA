package DP;

public class PartitionEqualSubset {

	public static void main(String[] args) {
		int[] nums = new int [] {1,2,5};
		
		int totalSum =0 ;
        for (int i : nums){
            totalSum+=i;
        }
     //   if ((totalSum & 1) == 1)  return false;
    //  return canPartitionRec(nums , 0 , totalSum, 0);

      totalSum = totalSum / 2;
		
		System.out.println(canPartitionSo(nums,totalSum));

	}
	
	public static boolean canPartitionSo(int[] nums, int totalSum) {
		 //   boolean[][] dp = new boolean[nums.length + 2][totalSum + 1];
		 
		   boolean[]curr = new boolean[totalSum + 1];
		   boolean[] next = new boolean[totalSum + 1];
		    
		    // Base case: If the total sum is 0, it's always possible
		    // for (int i = 0; i <= nums.length; i++) {
		    //     dp[i][totalSum] = true;
		    // }
		    curr[totalSum] = true;
		    next[totalSum] = true;
		    
		    // Build the dp table
		    for (int index = nums.length - 1; index >= 0; index--) {
		        for (int currSum = totalSum; currSum >=0; currSum--) {
		               boolean include = false;
		            if (currSum + nums[index] <= totalSum) {
		                include = next[currSum + nums[index] ] ;
		            }          
		             boolean exclude= next[currSum];

		             curr[currSum] = include ||exclude;
		            
		        }
		        //shifting   n --->0
		        next = curr;
		    }
		    
		    return next[0];
		 }

}
