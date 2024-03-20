package __CodeHelp.Recursion;

public class CW1_NStairs {

	public static void main(String[] args) {

	}

	public int climbStairs(int n) {

		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		// int[] dp = new int[n+1] ;
		// return climbStairsRecu(n,0, dp);
		// return climbStairsTab(n,0);

		return climbStairsSpaceOptimization(n);
	}

	public int climbStairsSpaceOptimization(int n) {
		int prev1 = 2; // when 2 stair
		int prev2 = 1; // when 1 stair

		for (int i = 3; i <= n; i++) {

			int curr = prev1 + prev2;

			prev2 = prev1;
			prev1 = curr;
		}

		return prev1;

	}

	public int climbStairsTab(int n, int index) {
		int[] dp = new int[n + 1];

		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {

			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];

	}

	public int climbStairsRecu(int n, int index, int[] dp) {

		if (n == index)
			return 1;

		if (dp[index] != 0)
			return dp[index];

		int temp = 0;
		if (index + 1 <= n)
			temp += climbStairsRecu(n, index + 1, dp);
		if (index + 2 <= n)
			temp += climbStairsRecu(n, index + 2, dp);

		return dp[index] = temp;

	}
}
