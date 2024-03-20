package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestArthmeticSeq {

	public static void main(String[] args) {
		int [] nums = new int [] {20,1,15,3,10,5,8};
		
		System.out.println(longestArithSeqLength(nums));

	}
	
	 public static int longestArithSeqLength(int[] nums) {
		    
	       int n = nums.length;
	        if (n <= 2)
	            return n;

	        int longest = 2;
	        Map<Integer, Integer>[] dp = new HashMap[n];

 	        for (int i = 0; i < n; i++) {
	            dp[i] = new HashMap<>();
	            for (int j = 0; j < i; j++) {
	                int diff = nums[i] - nums[j];
	                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
	                longest = Math.max(longest, dp[i].get(diff));
	            }
	        }

	        return longest;
	    }

}
