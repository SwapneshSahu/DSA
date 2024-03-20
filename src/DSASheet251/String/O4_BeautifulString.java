package DSASheet251.String;

public class O4_BeautifulString {
/**Problem link*/
	
//  https://www.codingninjas.com/codestudio/problems/beautiful-string_1115625?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=1
	public static void main(String[] args) {
		System.out.println(makeBeautifulWithoutExtrSpace("10101010"));
		System.out.println(makeBeautifulWithoExtrSpace("10101010"));

	}

	// T(N) S(1)
	public static int makeBeautifulWithoutExtrSpace(String str) {
		// Initialize two counts, one for each possible beautiful string pattern
		int count1 = 0; // to check 1 based beautiful string 10101010
		int count2 = 0; // to check 0 based beautiful string 01010101

		// Loop through the input string, character by character
		for (int i = 0; i < str.length(); i++) {

			/***
			 * for 1 based string their should be 1 in every even index and 0 on every odd
			 * index
			 ****/

			// If the index is even and the character is not '1', increment count1
			if (i % 2 == 0 && str.charAt(i) != '1') {
				count1++;
			}
			// If the index is odd and the character is not '0', increment count1
			else if (i % 2 == 1 && str.charAt(i) != '0') {
				count1++;
			}
			/***
			 * for 0 based string their should be 0 in every even index and 1 on every odd
			 * index
			 ****/

			// If the index is even and the character is not '0', increment count2
			if (i % 2 == 0 && str.charAt(i) != '0') {
				count2++;
			}
			// If the index is odd and the character is not '1', increment count2
			else if (i % 2 == 1 && str.charAt(i) != '1') {
				count2++;
			}
		}

		// Return the minimum count required to make the string beautiful
		return Math.min(count1, count2);
	}

	private static int makeBeautifulWithoExtrSpace(String str) {
		// here we are using to extra array to store 1 based and 0 based beautiful
		// string
		int count1 = 0;
		int count2 = 0;
		char[] ch1 = new char[str.length()];
		char[] ch2 = new char[str.length()];

		for (int i = 0; i < ch1.length; i++) {
			if (i % 2 == 0) {
				ch1[i] = '1';
				ch2[i] = '0';
			} else {
				ch1[i] = '0';
				ch2[i] = '1';
			}
		}

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ch1[i])
				count1++;
			else {
				count2++;
			}

		}

		return Math.min(count1, count2);
	}

}
