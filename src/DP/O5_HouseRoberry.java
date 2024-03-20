package DP;

import java.util.ArrayList;

public class O5_HouseRoberry {
/*Problem Link*/
	//https://www.codingninjas.com/codestudio/problems/house-robber_839733?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static long houseRobber(int[] valueInHouse) {
		if (valueInHouse.length == 1)
			return valueInHouse[0];
		/***
		 * We cant rob in two adjacent houses and houses are in circle that means 1 and
		 * last house are adjacent so we create to arrays in one we include 1 st house
		 * and in other we include last house and then solve and return max of them
		 ***/
		ArrayList<Integer> first = new ArrayList<>();

		ArrayList<Integer> second = new ArrayList<>();

		for (int i = 0; i < valueInHouse.length; i++) {
			if (i != valueInHouse.length - 1) {
				first.add(valueInHouse[i]);
			}
			if (i != 0) {
				second.add(valueInHouse[i]);
			}
		}

		return (long) Math.max(houseRobberNonAdjacentSum(first), houseRobberNonAdjacentSum(second));

	}

	public static int houseRobberNonAdjacentSum(ArrayList<Integer> nums) {
		// return houseRobberNonAdjacentSumRecursive(nums,nums.size()-1);

		int[] dp = new int[nums.size()];
		// return houseRobberNonAdjacentSumTabulation(nums, nums.size()-1, dp);

		return houseRobberNonAdjacentSumSpaceOptimization(nums, nums.size() - 1);
	}

	public static int houseRobberNonAdjacentSumSpaceOptimization(ArrayList<Integer> nums, int n) {

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

	public static int houseRobberNonAdjacentSumTabulation(ArrayList<Integer> nums, int n, int[] dp) {

		dp[0] = nums.get(0);

		for (int i = 1; i <= n; i++) {
			int inclusive = i - 2 >= 0 ? dp[i - 2] + nums.get(i) : nums.get(i);
			int exclusive = dp[i - 1];

			dp[i] = Math.max(inclusive, exclusive);
		}

		return dp[n];

	}

	public static int houseRobberNonAdjacentSumMemorization(ArrayList<Integer> nums, int n, int[] dp) {
		// base case
		if (n < 0)
			return 0;

		// only one element
		if (n == 0)
			return nums.get(n);

		if (dp[n] != 0)
			return dp[n];

		int inclusive = houseRobberNonAdjacentSumMemorization(nums, n - 2, dp) + nums.get(n);
		int exclusive = houseRobberNonAdjacentSumMemorization(nums, n - 1, dp);

		dp[n] = Math.max(inclusive, exclusive);
		return dp[n];

	}

	public static int houseRobberNonAdjacentSumRecursive(ArrayList<Integer> nums, int n) {
		// base case
		if (n < 0)
			return 0;

		// only one element
		if (n == 0)
			return nums.get(n);

		int inclusive = houseRobberNonAdjacentSumRecursive(nums, n - 2) + nums.get(n);
		int exclusive = houseRobberNonAdjacentSumRecursive(nums, n - 1);

		return Math.max(inclusive, exclusive);

	}

}
