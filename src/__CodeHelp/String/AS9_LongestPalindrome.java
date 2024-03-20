package __CodeHelp.String;

public class AS9_LongestPalindrome {
//LT-5
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	String ans = ""; // Initialize a string variable 'ans' to store the longest palindrome found.

	public String longestPalindrome(String s) {
	    for (int i = 0; i < s.length(); i++) {
	        evenSizePalindrome(s, i); // Call a function to find even-length palindromes.
	        oddSizePalindrome(s, i); // Call a function to find odd-length palindromes.
	    }
	    return ans; // Return the longest palindrome found.
	}

	public void evenSizePalindrome(String s, int index) {
	    int left = index; // Initialize 'left' as the current index.
	    int right = index + 1; // Initialize 'right' as the next character after the current index.

	    // Expand the search to the left and right to find a palindrome.
	    while (left >= 0 && right < s.length()) {
	        if (s.charAt(left) != s.charAt(right)) break; // If characters don't match, exit the loop.
	        left--; // Move the left pointer to the left.
	        right++; // Move the right pointer to the right.
	    }

	    // If the current palindrome is longer than the previous 'ans,' update 'ans.'
	    if (ans.length() < right - left - 1) {
	        ans = s.substring(left + 1, right); // Update 'ans' with the new palindrome.
	    }
	}

	public void oddSizePalindrome(String s, int index) {
	    int left = index; // Initialize 'left' as the current index.
	    int right = index; // Initialize 'right' as the current index.

	    // Expand the search to the left and right to find a palindrome.
	    while (left >= 0 && right < s.length()) {
	        if (s.charAt(left) != s.charAt(right)) break; // If characters don't match, exit the loop.
	        left--; // Move the left pointer to the left.
	        right++; // Move the right pointer to the right.
	    }

	    // If the current palindrome is longer than the previous 'ans,' update 'ans.'
	    if (ans.length() < right - left - 1) {
	        ans = s.substring(left + 1, right); // Update 'ans' with the new palindrome.
	    }
	}
	
	
	/**
	 * Time Complexity:

The longestPalindrome function iterates through each character in the input string 's' in a loop. For each character, it calls both evenSizePalindrome and oddSizePalindrome functions.
In the evenSizePalindrome and oddSizePalindrome functions, there are two nested loops that expand around the current character to find palindromes.
The inner while loops in both evenSizePalindrome and oddSizePalindrome can run up to O(n) times in the worst case, where 'n' is the length of the input string 's'.
Therefore, the overall time complexity of the code is O(n^2) because, in the worst case, you may expand around every character in 's' for both even and odd palindromes.
Space Complexity:

The space complexity of the code is primarily determined by the extra space used to store the 'ans' variable and the substrings created in each function call.
'ans' stores the longest palindrome found, and the space it occupies depends on the length of the longest palindrome.
The substrings created using s.substring also consume space, but they are relatively small.
Therefore, the space complexity is O(n) in terms of the space used to store the 'ans' variable and the substrings.
In summary:

Time Complexity: O(n^2)
Space Complexity: O(n)
The time complexity could be improved by using more efficient algorithms, such as Manacher's algorithm, which can find the longest palindrome in linear time, O(n). However, your current code serves as a simple and understandable example of finding palindromes in a string.





*/


}
