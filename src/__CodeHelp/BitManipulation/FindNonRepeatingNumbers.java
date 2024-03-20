package __CodeHelp.BitManipulation;

public class FindNonRepeatingNumbers {
// https://practice.geeksforgeeks.org/problems/finding-the-numbers0215/1
	public static void main(String[] args) {
	

	}
	
	public int[] singleNumber(int[] nums) {
	    int temp = 0;

	    // Step 1: XOR all numbers in the array to find the XOR result of the two non-repeating numbers.
	    for (int i : nums) {
	        temp = temp ^ i;
	    }

	    int indexofOne = 0;

	    // Step 2: Find the rightmost set bit (1) in the XOR result.
	    for (int i = 0; i < 32; i++) {
	        if ((temp & 1) != 1) {
	            temp = temp >> 1;  // Right-shift to check the next bit.
	            indexofOne++;
	        } else {
	            break;
	        }
	    }

	    int first = 0;
	    int second = 0;

	    // Step 3: Split the numbers into two groups based on the rightmost set bit.
	    for (int i : nums) {
	        if (((i >> indexofOne) & 1) == 1) {
	            first = first ^ i;   // XOR with the first group.
	        } else {
	            second = second ^ i; // XOR with the second group.
	        }
	    }

	    // Step 4: Return the result in ascending order.
	    return first > second ? new int[]{second, first} : new int[]{first, second};
	}


}
