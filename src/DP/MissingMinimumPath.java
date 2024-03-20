package DP;

public class MissingMinimumPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = new int[][] { { 100, -42, -46, -41 }, { 31, 97, 10, -10 }, { -58, -51, 82, 89 },
				{ 51, 81, 69, -51 } };

		// int[][] matrix = new int[][] {{2,1,3},{6,5,4},{7,8,9}};
		// int[][] matrix = new int[][] {{-19,57},{-40,-5}};

		int n = matrix.length;
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int ans = help(matrix, dp, 0, i);
			if (ans < min) {
				min = ans;
			}
		}
		System.out.println(min);

	}

	

	public static int help(int[][] matrix, int[][] dp, int i, int j) {

		if (i == matrix.length)
			return 0;

		if (j < 0 || j >= matrix.length)
			return Integer.MAX_VALUE;

		if (dp[i][j] != Integer.MAX_VALUE) {
			return dp[i][j];
		}

		// left
		int left = help(matrix, dp, i + 1, j - 1);

		// center
		int center = help(matrix, dp, i + 1, j);

		// right

		int right = help(matrix, dp, i + 1, j + 1);

		int sum = matrix[i][j] + Math.min(center, Math.min(left, right));
		dp[i][j] = sum;

		return sum;

	}
}
