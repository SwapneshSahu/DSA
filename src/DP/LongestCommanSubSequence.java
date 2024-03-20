package DP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public final class LongestCommanSubSequence {

	public static void main(String[] args) {
		// System.out.println(longestCommonSubsequence("aabc", "chaabc"));
		
		
		int [] arr = new int [] {1,2,5,12,4,10,5,12};
		
		Optional<Integer> ans =Arrays.stream(arr).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst();
	 
	}

	public static int longestCommonSubsequence(String text1, String text2) {
	
		if (text1.equals(text2))
			return text1.length();
		// return longestCommonSubsequenceRec(text1,text2,0,0,0);

//		int dp[][] = new int[text1.length() + 1][text2.length() + 1];
//		return longestCommonSubsequenceDp(text1, text2, 0, 0, 0, dp);
		
		return longestCommonSubsequenceTab(text1,text2);
	}

	public static int longestCommonSubsequenceTab(String text1, String text2) {
		int dp[][] = new int[text1.length() + 1][text2.length() + 1];

		for (int i_index = text1.length() - 1; i_index >= 0; i_index--) {

			for (int j_index = text2.length() - 1; j_index >= 0; j_index--) {

				int max;
				if (text1.charAt(i_index) == text2.charAt(j_index)) {
					max = 1 + dp[i_index + 1][j_index + 1];
				} else{
					int case1 = dp[i_index][j_index + 1];
					int case2 = dp[i_index + 1][j_index];
					max = Math.max(case1, case2);
				}
				dp[i_index][j_index] = max;
			}
		}
		return dp[0][0];
	}

	public static int longestCommonSubsequenceDp(String text1, String text2, int index1, int index2, int count,
			int[][] dp) {

		if (index2 >= text2.length() || index1 >= text1.length())
			return 0;
		// if whole string is same from here
		if (text1.substring(index1).equals(text2.substring(index2)))
			return count + text1.substring(index1).length();

		if (text1.contains(text2) || text2.contains(text1))
			return Math.min(text2.length(), text1.length());
		if (dp[index1][index2] != 0)
			return dp[index1][index2];

		int max = 0;
		if (text1.charAt(index1) == text2.charAt(index2)) {
			max = longestCommonSubsequenceDp(text1, text2, index1 + 1, index2 + 1, count + 1, dp);
		} else {
			max = Math.max(longestCommonSubsequenceDp(text1, text2, index1, index2 + 1, count, dp),
					longestCommonSubsequenceDp(text1, text2, index1 + 1, index2, count, dp));
		}

		return dp[index1][index2] = max;
	}

	public static int longestCommonSubsequenceRec(String text1, String text2, int index1, int index2, int count) {

		// if whole string is same from here
		if (text1.substring(index1).equals(text2.substring(index2)))
			return count + text1.substring(index1).length();

		int max = 0;
		if (index2 < text2.length() && index1 < text1.length() && text1.charAt(index1) == text2.charAt(index2))
			max = Math.max(max, longestCommonSubsequenceRec(text1, text2, index1 + 1, index2 + 1, count + 1));

		if (index2 < text2.length())
			max = Math.max(max, longestCommonSubsequenceRec(text1, text2, index1, index2 + 1, count));

		if (index1 < text1.length())
			max = Math.max(max, longestCommonSubsequenceRec(text1, text2, index1 + 1, index2, count));

		return max;
	}
}
