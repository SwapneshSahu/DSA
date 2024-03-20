package DP;

import java.util.Arrays;

public class BrainPower {

	public static void main(String[] args) {
	int [][] nn = new int [][] {{3,2},{4,3},{4,4},{2,5}};
	
	System.out.println(mostPointsTablulation(nn));

	}

	public static long mostPointsTablulation(int[][] questions) {
		int n = questions.length;
		long[] dp = new long[n + 1];
		Arrays.fill(dp, 0);
		for (int i = n - 1; i >= 0; i--) {
			int point = questions[i][0];
			int jump = questions[i][1];

			int nextQuestion = Math.min(n, i + jump + 1);
			                 //exclusive        //inclusive
			dp[i] = Math.max(dp[i + 1], point + dp[nextQuestion]);
		}
		return dp[0];
	}

	public long mostPointsMemorization(int[][] questions, int start, long[] dp) {
		if (start >= questions.length)
			return 0;

		if (dp[start] != 0)
			return dp[start];

		long inclusive = mostPointsRecursive(questions, start + 1 + questions[start][1]) + (long) questions[start][0];

		long exclusive = mostPointsRecursive(questions, start + 1);

		dp[start] = Math.max(inclusive, exclusive);

		return dp[start];

	}

	public long mostPointsRecursive(int[][] questions, int start) {
		if (start >= questions.length)
			return 0;

		long inclusive = mostPointsRecursive(questions, start + 1 + questions[start][1]) + (long) questions[start][0];

		long exclusive = mostPointsRecursive(questions, start + 1);

		return Math.max(inclusive, exclusive);

	}

}
