package DP;

public class O2_NStepsCost {
	/**
	 * Time complexity and space complexity of each algorithm:
	 * 
	 * NStepsCostSpaceOptimization: Time complexity: O(N) as it traverses the entire
	 * array of length N once. Space complexity: O(1) as it uses only constant extra
	 * space.
	 * 
	 * NStepsCostTabulation: Time complexity: O(N) as it traverses the entire array
	 * of length N once. Space complexity: O(N) as it uses an array of size N to
	 * store intermediate results.
	 * 
	 * NStepsCostRecursiveMemorization: Time complexity: O(N) as each recursive call
	 * is made only once for each value of N, and the results are stored in the
	 * memory for future use. Space complexity: O(N) as the function uses an array
	 * of size N to store intermediate results.
	 * 
	 * NStepsCostRecursive: Time complexity: O(2^N) as each recursive call makes two
	 * more recursive calls, leading to an exponential increase in the number of
	 * function calls. Space complexity: O(N) as the maximum depth of the recursion
	 * tree is N.
	 * 
	 * Among these algorithms, the best one in terms of time and space complexity is
	 * NStepsCostSpaceOptimization, as it has both time and space complexity of O(N)
	 * and does not require any extra space.
	 */
	public static void main(String[] args) {

		// int[] cost = new int[] {10,15,20};
		int[] cost = new int[] { 81, 2, 66, 38, 43, 543, 417, 534, 427, 327, 179, 90, 341, 949, 368, 692, 64 ,81, 2, 66, 38, 43, 543, 417, 534, 427, 327, 179, 90, 341, 949, 368, 692, 64 };

		System.out.println("Recursive " + NStepsCostRecursive(cost, cost.length - 1));

		int[] dp = new int[cost.length + 1];
		System.out.println("Recursive + Memorization" + NStepsCostRecursiveMemorization(cost, cost.length - 1, dp));

		int[] tab = new int[cost.length + 1];
		System.out.println("Tabulation " + NStepsCostTabulation(cost, cost.length - 1, tab));

		System.out.println("Space Optimization " + NStepsCostSpaceOptimization(cost, cost.length));

		// System.out.println(NStepsRecursive(3, 0));

	}

	public static int minCostClimbingStairs(int[] cost) {

		// return Math.min(NStepsCostRecursive(cost , cost.length-1),
		// NStepsCostRecursive(cost , cost.length-2));

		int[] dp = new int[cost.length + 1];
		// return Math.min(NStepsCostRecursiveMemorization(cost , cost.length-1,dp),
		// NStepsCostRecursiveMemorization(cost , cost.length-2 ,dp));

		// return Math.min(NStepsCostTabulation(cost , cost.length-1,dp),
		// NStepsCostTabulation(cost , cost.length-2 ,dp));
		return NStepsCostSpaceOptimization(cost, cost.length);

	}

	// T(N) S(1)
	public static int NStepsCostSpaceOptimization(int[] cost, int stairs) {

		for (int i = 2; i < stairs; i++) {

			cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
		}

		return Math.min(cost[stairs - 1], cost[stairs - 2]);
	}

	// T(N) S(N)
	public static int NStepsCostTabulation(int[] cost, int stairs, int[] dp) {

		dp[0] = cost[0];
		dp[1] = cost[1];

		for (int i = 2; i <= stairs; i++) {

			dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
		}

		return dp[stairs];
	}

	// T(N) S(N) + S(N)
	public static int NStepsCostRecursiveMemorization(int[] cost, int stairs, int[] dp) {
		// Base Case
		if (stairs == 0)
			return cost[0]; // if you have started from 0 index you have given choice to start with 0 or 1
							// index

		if (stairs == 1)
			return cost[1]; // if you have started from 1 index

		// reading from memory
		if (dp[stairs] != 0)
			return dp[stairs];

		int ans = Math.min(NStepsCostRecursive(cost, stairs - 1), NStepsCostRecursive(cost, stairs - 2)) + cost[stairs];

		// memorization
		dp[stairs] = ans;

		return ans;
	}

	// T(N) S(N)
	public static int NStepsCostRecursive(int[] cost, int stairs) {
		// Base Case
		if (stairs == 0)
			return cost[0]; // if you have started from 0 index you have given choice to start with 0 or 1
							// index

		if (stairs == 1)
			return cost[1]; // if you have started from 1 index

		return Math.min(NStepsCostRecursive(cost, stairs - 1), NStepsCostRecursive(cost, stairs - 2)) + cost[stairs];
	}

	// demo
	public static int NStepsRecursive(int stairs, int currentPosition) {

		// base case
		if (currentPosition == stairs)
			return 1;

		if (currentPosition > stairs)
			return 0;

		// we have two ways either taking one step or two steps
		return NStepsRecursive(stairs, currentPosition + 1) + NStepsRecursive(stairs, currentPosition + 2);

	}

}
