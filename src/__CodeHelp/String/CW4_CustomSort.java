package __CodeHelp.String;

public class CW4_CustomSort {

//791. Custom Sort String
	public static void main(String[] args) {
		
  System.out.println(customSortString("cba", "abcd"));
	}
	
//	T (s.length + order.length)  S(s.length)
	public static String customSortString(String order, String s) {
	    // Create an array to count the occurrences of each character ('a' to 'z') in the string
	    int[] countMap = new int[26];

	    // Iterate through the characters of string s
	    for (char ch : s.toCharArray()) {
	        // Increment the count for the corresponding character in the countMap array
	        countMap[ch - 'a']++;
	    }

	    // Create a StringBuilder to build the sorted string
	    StringBuilder ans = new StringBuilder();

	    // Iterate through the characters in the specified order
	    for (char ch : order.toCharArray()) {
	        // While there are occurrences of the character in the countMap
	        while (countMap[ch - 'a'] > 0) {
	            // Append the character to the result string
	            ans.append(ch);
	            // Decrement the count for this character
	            countMap[ch - 'a']--;
	        }
	    }

	    // Iterate through the countMap to add any remaining characters to the result
	    for (int i = 0; i < countMap.length; i++) {
	        // While there are remaining occurrences of the character
	        while (countMap[i] != 0) {
	            // Append the character (converted from index to 'a' character)
	            ans.append((char) (i + 'a'));
	            // Decrement the count for this character
	            countMap[i]--;
	        }
	    }

	    // Return the sorted string as a result
	    return ans.toString();
	}
	/***
	Here's an explanation of each part:

	The customSortString method takes two inputs: order (a string specifying the desired order) and s (the input string to be sorted based on the order).

	It initializes an array countMap to count the occurrences of characters from 'a' to 'z' (26 characters) in the input string s.

	The code iterates through the characters of s using a for-each loop and increments the count for each character in the countMap array.

	A StringBuilder named ans is created to build the sorted string.

	The code then iterates through the characters in the order string using another for-each loop. It checks if the character exists in s and appends it to the ans StringBuilder while decrementing the count in the countMap.

	After processing the characters in order, there might still be characters left in s that are not in the specified order. The code iterates through the countMap to add any remaining characters to the result.

	The sorted string is returned by converting the ans StringBuilder to a string using toString().

	The code effectively sorts the characters in the input string s based on the specified order and returns the sorted string.

	***/
	

}
