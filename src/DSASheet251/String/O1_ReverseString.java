package DSASheet251.String;

import java.util.Scanner;

public class O1_ReverseString {
//* Problem Link ***/
	
	// https://www.codingninjas.com/codestudio/problems/reverse-string-word-wise_1262348?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=1
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String ans = reverseStringWordWiseWithExtraSpace(input); //T(N) S(N)
		System.out.println(ans);
		
		ans = reverseStringWordWise(input); // T(N) S(1)
		System.out.println(ans); 
	}

	static String reverseStringWordWiseWithExtraSpace(String input) {
		String[] ss = input.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = ss.length - 1; i >= 0; i--) {
			sb.append(ss[i]);
			sb.append(" ");
		}
		return sb.toString();
	}

	/**
	 * You're correct that using StringBuilder does require some space to hold the
	 * characters of the output string. However, the space complexity of the second
	 * implementation I provided is still O(1) because the amount of space used by
	 * the StringBuilder does not depend on the length of the input string. Instead,
	 * it only depends on the number of words in the input string, which is a
	 * constant value.
	 * 
	 * This is in contrast to the first implementation, which uses an array to hold
	 * the words of the input string and a StringBuilder to hold the reversed output
	 * string. The space used by these data structures does depend on the length of
	 * the input string, so the space complexity of the first implementation is
	 * O(n).
	 * 
	 * So while the second implementation does use some space for the StringBuilder,
	 * the amount of space it uses is constant and does not depend on the length of
	 * the input string, which is why we can consider it to have O(1) space
	 * complexity.
	 */

	static String reverseStringWordWise(String input) {
		StringBuilder sb = new StringBuilder();
		int j = input.length();
		for (int i = input.length() - 1; i >= 0; i--) {
			if (input.charAt(i) == ' ') {
				sb.append(input.substring(i + 1, j)).append(' ');
				j = i;
			}
		}
		sb.append(input.substring(0, j));
		return sb.toString();
	}

}
