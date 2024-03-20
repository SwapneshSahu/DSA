package __CodeHelp.String;

public class CW5_PalindromicSubString {
// Lt 647
	public static void main(String[] args) {
		System.out.println(countSubstringsApp2("bbcadcbddcadb"));
	}

	// Since we have O(n) operations for each of the 2 * n - 1 possible centers,
	// the overall time complexity is O((2 * n - 1) * n), which simplifies to O(n^2
	public static int countSubstringsApp2(String s) {
		int countPalindrome = 0;
		int n = s.length();

		// Loop through each character in the string
		for (int center = 0; center < 2 * n - 1; center++) {
			int left = center / 2;
			int right = left + center % 2;

			// Expand around the center to find palindromic substrings
			while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
				countPalindrome++;
				left--;
				right++;
			}
		}

		return countPalindrome;
	}

	/**
	 * The key is to recognize that you can expand around each character to find
	 * palindromes. Here's an optimized version of the method:
	 * 
	 * 
	 * Here's an explanation of the optimized code:
	 * 
	 * The key insight is to recognize that there are 2 * n - 1 possible centers for
	 * palindromic substrings. These centers can be either characters or the spaces
	 * between characters.
	 * 
	 * The code uses a single loop to iterate through all possible centers, where
	 * center varies from 0 to 2 * n - 2.
	 * 
	 * Inside the loop, it calculates the left and right pointers based on the
	 * current center. If center is even, it means the center is a character, and
	 * both left and right point to it. If center is odd, it means the center is
	 * between two characters, and left and right point to the characters on either
	 * side of the center.
	 * 
	 * It then expands around the center by comparing characters at left and right
	 * positions and incrementing countPalindrome for each palindromic substring
	 * found.
	 * 
	 * This optimized approach reduces the time complexity to O(n^2), making it more
	 * efficient for larger input strings.
	 * 
	 * 
	 * 
	 * 
	 * User int left = center / 2; int right = left + center % 2; why we written
	 * like this please explain and why we are taking center < 2 * n - 1;
	 * 
	 * Certainly, let's break down the expressions left = center / 2 and right =
	 * left + center % 2 and explain why we iterate from center = 0 to center < 2 *
	 * n - 1.
	 * 
	 * Calculating left and right pointers:
	 * 
	 * In the optimized algorithm, we use a single loop to iterate through all
	 * possible centers for palindromic substrings. center represents the position
	 * of the center of a candidate palindrome. It can be either an actual character
	 * position or a position between two characters. To handle both cases (center
	 * at a character and center between characters), we calculate left and right
	 * pointers differently: If center is even, it means it corresponds to a
	 * character position. In this case, we set left to center / 2, which directly
	 * maps center to the position of a character in the string. If center is odd,
	 * it means it corresponds to a position between two characters. In this case,
	 * left is set to (center / 2) (the position before the center), and right is
	 * set to left + 1 (the position after the center). Looping through centers:
	 * 
	 * The loop iterates from center = 0 to center < 2 * n - 1 because there are 2 *
	 * n - 1 possible centers for palindromic substrings in a string of length n.
	 * This includes both character positions and positions between characters.
	 * Here's why we have 2 * n - 1 possible centers: For each of the n characters
	 * in the string, we have a center (odd indices). For each of the n - 1
	 * positions between characters, we have a center (even indices). So, the total
	 * number of possible centers is n + (n - 1) = 2 * n - 1. To efficiently
	 * identify palindromic substrings, we need to consider both character positions
	 * and positions between characters as potential centers. The expressions for
	 * left and right and the loop conditions are designed to handle these cases
	 * effectively and ensure that we check all possible centers.
	 * 
	 **/
	// time complexity is O(n^3). for cases where whole string has same character
	// like "aaaa"
	public static int countSubstrings(String s) {
		// Initialize a variable to count palindromic substrings
		int countPalindrome = 0;

		// Iterate through the characters of the input string s
		for (int i = 0; i < s.length(); i++) {
			// Find the next occurrence of the same character
			int nextIndex = s.indexOf(s.charAt(i), i + 1);

			// While there are more occurrences of the same character
			while (nextIndex != -1) {
				// Check if the substring from i to nextIndex is a palindrome
				if (checkPalindrome(s.substring(i, nextIndex + 1))) {
					countPalindrome++;
				}
				// Find the next occurrence of the same character
				nextIndex = s.indexOf(s.charAt(i), nextIndex + 1);
			}
		}

		// The total number of palindromic substrings is the count of palindromes found
		// plus the length of the input string s
		return countPalindrome + s.length();
	}

	private static boolean checkPalindrome(String substring) {
		// Initialize two pointers: left and right
		int left = 0;
		int right = substring.length() - 1;

		// Check if the substring is a palindrome by comparing characters from both ends
		while (left <= right) {
			if (substring.charAt(right) != substring.charAt(left)) {
				return false;
			}
			left++;
			right--;
		}

		// If the loop completes without returning false, the substring is a palindrome
		return true;
	}
}
