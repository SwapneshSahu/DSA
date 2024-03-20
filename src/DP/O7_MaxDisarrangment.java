package DP;

public class O7_MaxDisarrangment {
	/**
	 * https://www.codingninjas.com/codestudio/problems/count-derangements_873861?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static long countDerangements(int n) {
		long[] dp = new long[n + 1];

		return countDerangementsWithSpaceOptimization(n);
	}

	public static long countDerangementsWithSpaceOptimization(int n) {

		long prev2 = 0;
		long prev1 = 1;
		long mod = 1000000007;
		for (int i = 3; i <= n; i++) {
			long first = prev2 % mod;
			long second = prev1 % mod;
			long sum = (first + second) % mod;
			long curr = ((i - 1) * sum) % mod;

			// swapping
			prev2 = prev1;
			prev1 = curr;
		}

		return prev1;
	}

	public static long countDerangementsWithTabulation(int n) {
		long[] dp = new long[n + 1];
		dp[1] = 0;
		dp[2] = 1;
		long mod = 1000000007;
		for (int i = 3; i <= n; i++) {
			long first = dp[i - 2] % mod;
			long second = dp[i - 1] % mod;
			long sum = (first + second) % mod;
			dp[i] = ((i - 1) * sum) % mod;
		}

		return dp[n];
	}

	public static long countDerangementsRecursionWithMemorization(int n, long[] dp) {

		// base case
		if (n <= 2)
			return n - 1; // n=1 No derangments possible n=2 only one possible
		if (dp[n] != 0)
			return dp[n];
		long mod = 1000000007;
		/**
		 * (n-1) = if we choose 1 elemnt then their is n-1 element and n-1 places left
		 * (countDerangementsRecursion(n-2) lets say we swap index 0 and i then we left
		 * with n-2 elemts (countDerangementsRecursion(n-1) lets say we dont swap we
		 * only fix index 0 but not i so we left with n-1 elements
		 */
		long ans = ((n - 1) % mod * (countDerangementsRecursionWithMemorization(n - 2, dp) % mod
				+ countDerangementsRecursionWithMemorization(n - 1, dp) % mod)) % mod;

		return dp[n] = ans;

	}

	public static long countDerangementsRecursion(int n) {

		// base case
		if (n <= 2)
			return n - 1; // n=1 No derangments possible n=2 only one possible

		long mod = 1000000007;
		/**
		 * (n-1) = if we choose 1 elemnt then their is n-1 element and n-1 places left
		 * (countDerangementsRecursion(n-2) lets say we swap index 0 and i then we left
		 * with n-2 elemts (countDerangementsRecursion(n-1) lets say we dont swap we
		 * only fix index 0 but not i so we left with n-1 elements
		 */
		long ans = ((n - 1) % mod * (countDerangementsRecursion(n - 2) % mod + countDerangementsRecursion(n - 1) % mod))
				% mod;

		return ans;

	}

}
