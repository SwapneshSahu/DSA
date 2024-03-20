package DP;

public class O1_FibonaciSeries {

	public static void main(String[] args) {

		int x = 13;

		/*** recursion T(2^n) space (n) ***/
		// System.out.println(recursive(x));

		/*** recursion + memorization T(n) space (n) + (n) ***/

//		int[] dp = new int[x + 1];
//		dp[0] = 1;
//		dp[1] = 1;
//		System.out.println(usingMemorization(x, dp));

		/*** Tabulation T(n) space (n) **/
		// Initializing dp and base values
		int[] dp = new int[x + 1];
		dp[0] = 0;
		dp[1] = 1;
		System.out.println(usingTabulation(x, dp));

		/*** Space Optimization T(n) space (1) **/
		System.out.println(usingSpaceOptimization(x));
	}

	public static int usingSpaceOptimization(int x) {

		// base case
		if (x <= 1)
			return 1;

		int prev_1 = 1;
		int prev_2 = 0;

		for (int i = 2; i <= x; i++) {
			int curr = prev_1 + prev_2;
			prev_2 = prev_1;
			prev_1 = curr;
		}

		return prev_1;

	}

	/**
	 * 
	 * The time complexity of the usingTabulation function is O(N), where N is the
	 * input x. This is because the function iterates through the values from 2 to
	 * N, computing the result for each value once, and storing it in the dp array.
	 * Since the loop iterates N-1 times, the time complexity is O(N).
	 * 
	 * The space complexity of the function is O(N), because it creates an array dp
	 * of size N to store the results of subproblems. Each element of the array
	 * takes constant space, so the total space required is proportional to N.
	 **/
	public static int usingTabulation(int x, int[] dp) {

		// base case
		if (x <= 1)
			return 1;

		for (int i = 2; i <= x; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[x];

	}

	/**
	 * The time complexity of the usingMemorization function is O(N), where N is the
	 * input x. This is because the function will only compute the value of each
	 * subproblem once, since it stores the solutions in a cache using memoization.
	 * As a result, the maximum number of recursive calls that can be made is N, and
	 * each call will only take constant time to execute.
	 * 
	 * The space complexity of the function is also O(N), because it creates an
	 * array dp of size N to store the results of subproblems. Each element of the
	 * array takes constant space, so the total space required is proportional to N.
	 */

	public static int usingMemorization(int x, int[] dp) {

		// base case
		if (x <= 1)
			return 1;

		// check for available vlaue
		if (dp[x] != 0)
			return dp[x];

		// storing value
		dp[x] = usingMemorization(x - 1, dp) + usingMemorization(x - 2, dp);
		return dp[x];

	}

	/**
	 * 
	 * The time complexity of the recursive function is O(2^N), where N is the input
	 * x, because it recursively calls itself twice for each value of x greater than
	 * 1, leading to an exponential growth in the number of function calls. The
	 * space complexity of the function is O(N), as it will create a call stack with
	 * N frames for the function calls, each storing the local variables and return
	 * address.
	 */
	public static int recursive(int x) {

		// base case
		if (x <= 1)
			return 1;
		// recursive call
		return recursive(x - 1) + recursive(x - 2);

	}

}
