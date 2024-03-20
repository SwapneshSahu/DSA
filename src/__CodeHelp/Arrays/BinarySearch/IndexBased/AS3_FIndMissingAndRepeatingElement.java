package __CodeHelp.Arrays.BinarySearch.IndexBased;

public class AS3_FIndMissingAndRepeatingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// T(N)
	public static int[] missingAndRepeatingSwapping(int[] arr) {
		// Create an array to store the missing and repeating elements
		int[] ans = new int[2];

		// Iterate through the input array

		/***
		 * The inner while loop swaps elements until the current element is at its
		 * correct position, but each element is swapped at most once during the entire
		 * process. Since each element is moved to its correct position during the
		 * course of these loops, and no element is moved more than once, the total
		 * number of operations is still linear with respect to the size of the input
		 * array. Thus, the overall time complexity remains O(n), not O(n^2).
		 */
		for (int i = 0; i < arr.length; i++) {
			// Swap elements until the current element is at its correct position
			while (arr[i] != arr[arr[i] - 1]) {
				int temp = arr[i];
				arr[i] = arr[temp - 1];
				arr[temp - 1] = temp;
			}
		}

		// Find the missing and repeating elements
		for (int i = 0; i < arr.length; i++) {
			if (i + 1 != arr[i]) {
				ans[0] = i + 1; // Missing element
				ans[1] = arr[i]; // Repeating element
			}
		}

		// Return the result
		return ans;
	}

	// T(N)
	public static int[] missingAndRepeatingNegMarking(int[] arr) {
		// Create an array to store the missing and repeating elements
		int[] ans = new int[2];

		// Iterate through the input array
		for (int i = 0; i < arr.length; i++) {
			int temp = Math.abs(arr[i]) - 1; // Calculate the index to mark (subtract 1 for zero-based indexing)

			if (arr[temp] < 0) {
				// If the element at the calculated index is negative, it's a duplicate element
				ans[1] = temp + 1; // Repeating element
			} else {
				arr[temp] *= -1; // Mark the element as seen by making it negative
			}
		}

		// Find the missing element (the index with a positive value)
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				ans[0] = i + 1; // Missing element
			}
		}

		// Return the result
		return ans;
	}

}
