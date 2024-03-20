package DSASheet251.String;

public class O5_FirstPalindrome {

	public static void main(String[] args) {
		System.out.println(nextLargestPalindrome("999", 3));
		System.out.println(nextLargestPalindrome("3234", 4));
		System.out.println(nextLargestPalindrome("64466", 5));
		System.out.println(nextLargestPalindrome("9687", 4));
		// System.out.println(nextLargestPalindrome(null, 0));

	}

	/** T(N) O(N)
	 * nextLargestPalindrome function takes a number string and its length as input
	 * and returns the next largest palindrome of that number. isAll9s function
	 * checks if all the digits in the given number string are 9. If all the digits
	 * are 9, we can directly add 2 to the number to get the next palindrome.
	 * getNextPalindrome function gets the next palindrome of a given number string
	 * using the following steps: Find the middle of the string and start traversing
	 * towards the left and right sides of the middle until you find a non-matching
	 * character. If the left side of the string is smaller than the right side or
	 * all the characters on the left side are matched with the right side, set
	 */
	// Function to find the next largest palindrome of a given number string
	public static String nextLargestPalindrome(String number, int length) {
		// If all the digits are 9, add 2 to the number and return it as the next
		// palindrome
		if (isAll9s(number)) {
			return String.valueOf(Long.parseLong(number) + 2);
		} else {
			// Else, get the next palindrome and return it
			String nextPalindrome = getNextPalindrome(number);
			return nextPalindrome;
		}
	}

	// Function to check if all the digits in the given number are 9
	public static boolean isAll9s(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != '9') {
				return false;
			}
		}
		return true;
	}

	// Function to get the next palindrome of a given number string
	public static String getNextPalindrome(String input) {
		int len = input.length();
		char[] arr = input.toCharArray();
		boolean leftSmaller = false;
		int mid = len / 2;
		int i = mid - 1;
		int j = (len % 2 == 0) ? mid : mid + 1;

		// Traverse from middle towards left and right until you find a non-matching
		// character
		while (i >= 0 && arr[i] == arr[j]) {
			i--;
			j++;
		}

		// Check if the left side is smaller than the right side
		if (i < 0 || arr[i] < arr[j]) {
			leftSmaller = true;
		}

		// Copy the left side to the right side to make it a palindrome
		while (i >= 0) {
			arr[j++] = arr[i--];
		}

		// If left side is smaller, add 1 to the middle digit and propagate the carry
		// towards left side
		if (leftSmaller) {
			int carry = 1;
			i = mid - 1;

			if (len % 2 == 1) {
				int num = arr[mid] - '0' + carry;
				carry = num / 10;
				arr[mid] = (char) (num % 10 + '0');
				j = mid + 1;
			} else {
				j = mid;
			}

			while (i >= 0) {
				int num = arr[i] - '0' + carry;
				carry = num / 10;
				arr[i] = (char) (num % 10 + '0');
				arr[j++] = arr[i--];
			}
		}

		// Return the next palindrome as a string
		return String.valueOf(arr);
	}

}

// 1246278 8885278
// 1246279 9726421
