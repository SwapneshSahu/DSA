package DP;

import java.util.ArrayList;

public class O4_MaxSumAlternatingNumber {
/**Problem Link**/
	
	//https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// return maximumNonAdjacentSumRecursive(nums,nums.size()-1);

		int[] dp = new int[nums.size()];
	//	return maximumNonAdjacentSumMemorization(nums, nums.size()-1, dp);
		// return maximumNonAdjacentSumTabulation(nums, nums.size()-1, dp);

		return maximumNonAdjacentSumSpaceOptimization(nums, nums.size() - 1);
	}

	public static int maximumNonAdjacentSumSpaceOptimization(ArrayList<Integer> nums, int n) {

		int prev1 = nums.get(0);
		int prev2 = Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) {
			int inclusive = prev2 != Integer.MIN_VALUE ? prev2 + nums.get(i) : nums.get(i);
			int exclusive = prev1;

			int curr = Math.max(inclusive, exclusive);
			prev2 = prev1;
			prev1 = curr;
		}

		return prev1;

	}

	public static int maximumNonAdjacentSumTabulation(ArrayList<Integer> nums, int n, int[] dp) {

		dp[0] = nums.get(0);

		for (int i = 1; i <= n; i++) {
			int inclusive = i - 2 >= 0 ? dp[i - 2] + nums.get(i) : nums.get(i);
			int exclusive = dp[i - 1];

			dp[i] = Math.max(inclusive, exclusive);
		}

		return dp[n];

	}

	public static int maximumNonAdjacentSumMemorization(ArrayList<Integer> nums, int n, int[] dp) {
		// base case
		if (n < 0)
			return 0;

		// only one element
		if (n == 0)
			return nums.get(n);

		if (dp[n] != 0)
			return dp[n];

		int inclusive = maximumNonAdjacentSumMemorization(nums, n - 2, dp) + nums.get(n);
		int exclusive = maximumNonAdjacentSumMemorization(nums, n - 1, dp);

		dp[n] = Math.max(inclusive, exclusive);
		return dp[n];

	}

	public static int maximumNonAdjacentSumRecursive(ArrayList<Integer> nums, int n) {
		// base case
		if (n < 0)
			return 0;

		// only one element
		if (n == 0)
			return nums.get(n);

		int inclusive = maximumNonAdjacentSumRecursive(nums, n - 2) + nums.get(n);
		int exclusive = maximumNonAdjacentSumRecursive(nums, n - 1);

		return Math.max(inclusive, exclusive);

	}
}
