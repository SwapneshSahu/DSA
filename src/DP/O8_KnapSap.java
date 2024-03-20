package DP;

public class O8_KnapSap {

	public static void main(String[] args) {
		
		int [] weight = new int[] {1 ,2 ,4 ,5};
		int [] value = new int[] {5 ,4 ,8 ,6};
		
      System.out.println(knapsackRecursionTabulation(weight,value, 4, 5));
	}

	static int knapsackRecursionTabulation(int[] weight, int[] value, int n, int capacity) {

		int[][] dp = new int[n + 1][capacity + 1];
		// base case
		for (int w = weight[0]; w <= capacity; w++) {

			if (weight[0] <= capacity) {
				dp[0][w] = value[0];
			} else {
				dp[0][w] = 0;
			}
		}

		for (int index = 1; index < n; index++) {
			for (int w = 0; w <= capacity; w++) {

				// inclusive
				int inclusive = 0;
				if (weight[index] <= w) {
					inclusive = value[index] + dp[index - 1][w - weight[index]];
				}

				// exclusive
				int exclusive = dp[index - 1][w];
				dp[index][w] = Math.max(inclusive, exclusive);

			}
		}

		// memorizing
		return dp[n - 1][capacity];

	}

	static int knapsackRecursionMemorization(int[] weight, int[] value, int index, int capacity, int dp[][]) {
		// if only 1 element is their
		if (index == 0) {
			return weight[0] <= capacity ? value[0] : 0;
		}
		// Using memorization
		if (dp[index][capacity] != 0)
			return dp[index][capacity];

		// inclusive
		int inclusive = 0;
		if (weight[index] <= capacity) {
			inclusive = value[index]
					+ knapsackRecursionMemorization(weight, value, index - 1, capacity - weight[index], dp);
		}

		// exclusive
		int exclusive = knapsackRecursionMemorization(weight, value, index - 1, capacity, dp);

		// memorizing
		return dp[index][capacity] = Math.max(inclusive, exclusive);

	}

}
