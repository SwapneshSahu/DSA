package DP;

import java.util.Arrays;

public class O10_MinSqures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int MinSquares(int n) {
		// return recursive(n);
		// int [] dp = new int [n+1];
		// return recursiveMemo(n,dp);
		return tab(n);
	}

	public int tab(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		// base case
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= n; j++) {
				if (i - j * j >= 0)
					dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
			}
		}

		return dp[n];
	}

	public int recursiveMemo(int n, int[] dp) {

		// base case
		if (n == 0)
			return 0;

		if (dp[n] != 0)
			return dp[n];
		int ans = n;

		for (int i = 1; i * i <= n; i++) {
			ans = Math.min(ans, 1 + recursiveMemo(n - i * i, dp));

		}
		dp[n] = ans;

		return dp[n];
	}

	public int recursive(int n) {

		// base case
		if (n == 0)
			return 0;

		int ans = n;

		for (int i = 1; i * i <= n; i++) {
			ans = Math.min(ans, 1 + recursive(n - i * i));
		}

		return ans;
	}

}
