package DSASheet251.TwoPointers;

public class O4_SubSequence {
	/** Problem Intution **/
	// https://www.codingninjas.com/codestudio/problems/is-subsequence_892991?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=1
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String isSubsequence(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		if (n > m)
			return "False";

		int first = 0;
		int second = 0;

		while (first < n && second < m) {

			while (second < m && str1.charAt(first) != str2.charAt(second)) {
				second++;
			}
			if (second == m)
				return "False";
			first++;
			second++;

		}

		return first != n ? "False" : "True";
	}

}
