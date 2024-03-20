package DP;

import java.util.Arrays;

public class O6_CutRod {

	public static void main(String[] args) {
		int n = 10;
		int x = 2;
		int y = 3;
		int z = 4;

		System.out.println("Tabulation: " + cutRodRecursionTabulation(n, x, y, z));

		int[] dp = new int[n + 1];
		System.out.println("Recursion + Memorization: " + cutRodRecursionMemorization(n, x, y, z, dp));

		System.out.println("Recursion: " + cutRodRecursion(n, x, y, z));
	}

	/** Tabulation **/
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	public static int cutRodRecursionTabulation(int n, int x, int y, int z) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			if (i - x >= 0) {
				dp[i] = Math.max(dp[i], dp[i - x] + 1);
			}
			if (i - y >= 0) {
				dp[i] = Math.max(dp[i], dp[i - y] + 1);
			}
			if (i - z >= 0) {
				dp[i] = Math.max(dp[i], dp[i - z] + 1);
			}
		}
		return dp[n];
	}

	/** Recursion + Memorization **/
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	public static int cutRodRecursionMemorization(int n, int x, int y, int z, int[] dp) {
		// base case
		if (n == 0)
			return 0;

		if (n < 0)
			return Integer.MIN_VALUE;

		if (dp[n] != 0)
			return dp[n];

		// using each section XYZ one by one
		int ansX = cutRodRecursionMemorization(n - x, x, y, z, dp) + 1;
		int ansY = cutRodRecursionMemorization(n - y, x, y, z, dp) + 1;
		int ansZ = cutRodRecursionMemorization(n - z, x, y, z, dp) + 1;

		dp[n] = Math.max(ansX, Math.max(ansY, ansZ));
		return dp[n];
	}

	/** Recursion **/
	// Time Complexity: Exponential
	// Space Complexity: O(n) (recursion stack)
	public static int cutRodRecursion(int n, int x, int y, int z) {
		// base case
		if (n == 0)
			return 0;

		if (n < 0)
			return Integer.MIN_VALUE;

		// using each section XYZ one by one
		int ansX = cutRodRecursion(n - x, x, y, z) + 1;
		int ansY = cutRodRecursion(n - y, x, y, z) + 1;
		int ansZ = cutRodRecursion(n - z, x, y, z) + 1;

		return Math.max(ansX, Math.max(ansY, ansZ));
	}

}
