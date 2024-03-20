package DP;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubSequence {
//LT 300
	public static void main(String[] args) {
		int[] nums = new int[] { 0, 1, 0, 3, 2, 3 };
		System.out.println(lengthOfLIS(nums));
	}

	public static int lengthOfLIS(int[] nums) {
		// return lengthOfLISRec(nums,0,-1);
		int[][] dp = new int[nums.length + 1][nums.length + 1];
		return lengthOfLISDp(nums, 0, -1, dp);

		// return lengthOfLISTab(nums);
	}

	public static int lengthOfLISTab(int[] nums) {
		int[][] dp = new int[nums.length + 1][nums.length + 1];

		for (int index = nums.length - 1; index >= 0; index--) {
			for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {

				int include = 0;
				if (prevIndex == -1 || nums[prevIndex] < nums[index]) {
					include = 1 + dp[index + 1][index + 1]; // in 2nd index+1 for shifting
				}

				int exclude = dp[index + 1][prevIndex + 1];
				dp[index][prevIndex + 1] = Math.max(include, exclude);
			}
		}
		return dp[0][0];

	}

	public static int lengthOfLISDp(int[] nums, int index, int prevIndex, int[][] dp) {

		if (index >= nums.length)
			return 0;
		// prevIndex+1 This is index shifting because we are using -1 for prevIndex so
		// we moved index one forword
		if (dp[index][prevIndex + 1] != 0)
			return dp[index][prevIndex + 1];

		int include = 0;
		if (prevIndex == -1 || nums[prevIndex] < nums[index]) {
			include = 1 + lengthOfLISDp(nums, index + 1, index, dp);
		}

		int exclude = lengthOfLISDp(nums, index + 1, prevIndex, dp);

		return dp[index][prevIndex + 1] = Math.max(include, exclude);

	}

	public int lengthOfLISRec(int[] nums, int index, int prevIndex) {

		if (index >= nums.length)
			return 0;

		int include = 0;
		if (prevIndex == -1 || nums[prevIndex] < nums[index]) {
			include = 1 + lengthOfLISRec(nums, index + 1, index);
		}

		int exclude = lengthOfLISRec(nums, index + 1, prevIndex);

		return Math.max(include, exclude);

	}
}
