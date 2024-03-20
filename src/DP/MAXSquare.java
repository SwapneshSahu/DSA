package DP;

public class MAXSquare {

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 1, 0 },
				{ 0, 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1, 1 } };

		System.out.println(maxSquare(5, 6, mat));

	}

	static int maxSquare(int n, int m, int mat[][]) {
		boolean checkOne = false;
		int[][] dp = new int[n][m];

		// Copying values for the last row and last column
		// If a cell contains 1, set checkOne to true
		// Fill in the last row
		for (int i = 0; i < m; i++) {
			if (mat[n - 1][i] == 1)
				checkOne = true;
			dp[n - 1][i] = mat[n - 1][i];
		}

		// Fill in the last column
		for (int i = 0; i < n; i++) {
			if (mat[i][m - 1] == 1)
				checkOne = true;
			dp[i][m - 1] = mat[i][m - 1];
		}

		// Traverse the matrix from bottom-right to top-left
		int ans = 1;
		for (int row = n - 2; row >= 0; row--) {
			for (int col = m - 2; col >= 0; col--) {
				if (mat[row][col] == 1)
					checkOne = true;

				// If the current cell contains 0, set dp[row][col] to 0
				if (mat[row][col] == 0) {
					dp[row][col] = 0;
				} else {
					// Calculate the values for right, diagonal, and down cells
					int right = dp[row][col + 1];
					int diagonal = dp[row + 1][col + 1];
					int down = dp[row + 1][col];

					// Set dp[row][col] to 1 + minimum of right, diagonal, and down cells
					dp[row][col] = 1 + Math.min(right, Math.min(diagonal, down));

					// Update ans if dp[row][col] is greater than ans
					if (dp[row][col] > ans)
						ans = dp[row][col];
				}
			}
		}

		// Return ans if checkOne is true, otherwise return 0
		return checkOne ? ans : 0;
	}

}
