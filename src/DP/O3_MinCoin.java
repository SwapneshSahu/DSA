package DP;

import java.util.Arrays;

public class O3_MinCoin {

	public static void main(String[] args) {
		int[] num = new int[] { 17, 10, 5 };
		System.out.println(minimumElements(num, 6));

	}

	public static int minimumElements(int num[], int x) {
		// int ans = minimumElementsRecursive(num, x);
		// return ans != Integer.MAX_VALUE ? ans : -1 ;

		// int [] dp = new int[x+1];
		// int ans = minimumElementsMemorization(num, x,dp);
		// return ans != Integer.MAX_VALUE ? ans : -1 ;

		int[] dp = new int[x + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		int ans = minimumElementsTabulation(num, x, dp);
		return ans != Integer.MAX_VALUE ? ans : -1;
	}

	public static int minimumElementsTabulation(int num[], int x, int[] dp) {
		// base case

		int prev = 0;

		for (int i = 1; i <= x; i++) {
			for (int j = 0; j < num.length; j++) {

				if (i - num[j] >= 0 && dp[i - num[j]] != Integer.MAX_VALUE)
					dp[i] = Math.min(dp[i - num[j]] + 1, dp[i]);

			}

		}
		return dp[x];
	}

	public static int minimumElementsMemorization(int num[], int x, int[] dp) {
		// base case

		if (x == 0)
			return 0;

		if (x < 0)
			return Integer.MAX_VALUE;

		if (dp[x] != 0)
			return dp[x];

		int mini = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			int ans = minimumElementsMemorization(num, x - num[i], dp);

			if (ans != Integer.MAX_VALUE) {
				mini = Math.min(ans + 1, mini);
			}
		}

		dp[x] = mini;
		return mini;
	}

	public static int minimumElementsRecursive(int num[], int x) {
		// base case

		if (x == 0)
			return 0;

		if (x < 0)
			return Integer.MAX_VALUE;

		int mini = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			int ans = minimumElementsRecursive(num, x - num[i]);

			if (ans != Integer.MAX_VALUE) {
				mini = Math.min(ans + 1, mini);
			}
		}
		return mini;
	}

}
