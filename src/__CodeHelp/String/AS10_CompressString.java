package __CodeHelp.String;

public class AS10_CompressString {
//Lt-443
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int compress(char[] chars) {
	    int ans = 0; // Initialize the result pointer to 0.
	    char prev = chars[0]; // Initialize prev with the first character.
	    int count = 1; // Initialize a counter for consecutive characters.

	    // Iterate through the character array.
	    for (int i = 1; i < chars.length; i++) {
	        if (prev == chars[i]) {
	            count++; // If the current character is the same as the previous, increment the count.
	        } else {
	            chars[ans++] = prev; // Store the character in the result and increment the result pointer.
	            
	            if (count > 1) {
	                // If there were more than one consecutive characters, convert the count to a character array.
	                for (char c : String.valueOf(count).toCharArray()) {
	                    chars[ans++] = c; // Store each digit of the count in the result.
	                }
	            }
	            
	            prev = chars[i]; // Update the previous character.
		        count = 1; // Reset the count for the current character.
	        }
	        
	    }

	    chars[ans++] = prev; // Store the last character in the result.
	    
	    if (count > 1) {
	        // If there were more than one consecutive characters at the end, convert the count to a character array.
	        for (char c : String.valueOf(count).toCharArray()) {
	            chars[ans++] = c; // Store each digit of the count in the result.
	        }
	    }

	    return ans; // Return the length of the compressed array.
	}
/**
 * Time Complexity:

The time complexity of this algorithm is O(n), where n is the length of the chars array. It processes each character once.

Space Complexity:

The space complexity is O(1) because it performs the compression in-place without using any additional data structures that depend on the input size.*/

}
