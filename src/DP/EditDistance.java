package DP;

public class EditDistance {
//LT-72
	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
	}

//	Insert a character
//	Delete a character
//	Replace a character
//	 
//
//	Example 1:
//
//	Input: word1 = "horse", word2 = "ros"
	public static int minDistance(String word1, String word2) {
		// return minDistanceRec(word1, word2,0,0);

		// int [][]dp = new int [word1.length()+1][word2.length()+1];
		// return minDistanceDp(word1, word2,0,0,dp);

		return minDistanceTab(word1, word2);
	}

	public static int minDistanceTab(String word1, String word2) {

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		// base case
		for (int col = 0; col < word2.length(); col++) {
			dp[word1.length()][col] = word2.length() - col;
		}

		for (int row = 0; row < word1.length(); row++) {
			dp[row][word2.length()] = word1.length() - row;
		}

		for (int i = word1.length() - 1; i >= 0; i--) {
			for (int j = word2.length() - 1; j >= 0; j--) {

				// When equal
				if (word1.charAt(i) == word2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1];
				} else {
					// insertCase
					int insert = 1 + dp[i][j + 1];

					// delete Case
					int delete = 1 + dp[i + 1][j];

					// Replace case
					int replace = 1 + dp[i + 1][j + 1];

					dp[i][j] = Math.min(insert, Math.min(replace, delete));
				}

			}

		}

		return dp[0][0];

	}

	public static int minDistanceDp(String word1, String word2, int i, int j, int[][] dp) {

		if (i == word1.length()) {
			return word2.length() - j;
		}
		if (j == word2.length()) {
			return word1.length() - i;
		}

		if (dp[i][j] != 0)
			return dp[i][j];
		// When equal
		if (word1.charAt(i) == word2.charAt(j)) {
			return dp[i][j] = minDistanceDp(word1, word2, i + 1, j + 1, dp);
		} else {
			// insertCase
			int insert = 1 + minDistanceDp(word1, word2, i, j + 1, dp);

			// delete Case
			int delete = 1 + minDistanceDp(word1, word2, i + 1, j, dp);

			// Replace case
			int replace = 1 + minDistanceDp(word1, word2, i + 1, j + 1, dp);

			return dp[i][j] = Math.min(insert, Math.min(replace, delete));
		}

	}

	public static int minDistanceRec(String word1, String word2, int i, int j) {

		if (i == word1.length()) {
			return word2.length() - j;
		}
		if (j == word2.length()) {
			return word1.length() - i;
		}

		// When equal
		if (word1.charAt(i) == word2.charAt(j)) {
			return minDistanceRec(word1, word2, i + 1, j + 1);
		} else {
			// insertCase
			int insert = 1 + minDistanceRec(word1, word2, i, j + 1);

			// delete Case
			int delete = 1 + minDistanceRec(word1, word2, i + 1, j);

			// Replace case
			int replace = 1 + minDistanceRec(word1, word2, i + 1, j + 1);

			return Math.min(insert, Math.min(replace, delete));
		}

	}
}
