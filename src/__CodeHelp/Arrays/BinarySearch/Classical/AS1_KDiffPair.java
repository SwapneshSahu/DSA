package __CodeHelp.Arrays.BinarySearch.Classical;

import java.util.*;

public class AS1_KDiffPair {
	
	//LT-532
	
	/**
	 * The primary reason Approach 2 is slower than Approach 1 

Approach 1 (Two Pointers):

Sort the array: O(n*log(n)), where n is the size of the array.
Iterate through the sorted array using two pointers: O(n).
Approach 2 (Binary Search):

Sort the array: O(n*log(n)), where n is the size of the array.
Iterate through the sorted array: O(n).
For each element, perform a binary search: O(log(n)).
The overall time complexity of Approach 2 is higher because it performs multiple binary searches within the loop, while Approach 1 simply iterates through the sorted array once and stores pairs with the desired difference. In this particular scenario, the two-pointer approach is more efficient.





*/

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 1, 1, 1 };

		System.out.println(finddPairTwoPointer(nums, 0));

	}

	// Approach 1
	public static int finddPairTwoPointer(int[] arr, int diff) {
		Arrays.sort(arr);

		Map<Integer, Integer> map = new HashMap<>();

		int i = 0;
		int j = 1;

		while (j < arr.length) {
			int currDiff = arr[j] - arr[i];

			if (currDiff == diff) {
				map.put(arr[i], arr[j]);
				i++;
				j++;
			} else if (currDiff > diff) {
				// currDiff is greater that means we have to increase left index to reduce
				// difference
				i++;
			} else {
				j++;

			}
			// As per quetion i and j should be different
			if (i == j)
				j++;
		}
		return map.size();
	}

	// Approach 2
	public static int findPairBinarySearch(int[] arr, int diff) {
		Arrays.sort(arr);

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			int currTarget = arr[i] + diff; // arr[j] - arr[i] =diff

			if (binarySearch(i + 1, arr.length - 1, currTarget, arr) != -1) {
				map.put(arr[i], arr[i] + diff);
			}

		}
		return map.size();

	}

	public static int binarySearch(int low, int high, int target, int[] arr) {
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] == target) {
				// Target found at index mid.
				return mid;
			} else if (arr[mid] < target) {
				// Target is in the right subarray.
				low = mid + 1;
			} else {
				// Target is in the left subarray.
				high = mid - 1;
			}
		}
		return -1; // Target not found in the array.
	}

}
