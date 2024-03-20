package __CodeHelp.Arrays.BinarySearch.ExponantialBS;

import java.util.*;

public class ExpoBS {

	/**
	 * Exponential search will run in O(log i) time, where i is the index of the
	 * element being searched for in the list, whereas binary search would run in
	 * O(log n) , where n is the number of elements in the list
	 *
	 * 
	 * Exponential Binary Search is an algorithm used to find the index of an
	 * element in a sorted array when the size of the array is unknown. It starts
	 * with a small range and exponentially increases the range until it includes
	 * the desired element.
	 */
	public static void main(String[] args) {
		int[] arr = new int [1000000]  ;
		
		for (int i = 0 ; i<arr.length ;i++) {
			  Random random = new Random();

		        // Generate a random number within the specified range
			  arr[i] = random.nextInt(Integer.MAX_VALUE) + 1;
			
					
		}
		
		Arrays.sort(arr);
		int target = 1278;

		int result = exponentialBinarySearch(arr, target);

		if (result != -1) {
			System.out.println("Element found at index " + result);
		} else {
			System.out.println("Element not found in the array.");
		}
	}

	// Exponential Binary Search function
	public static int exponentialBinarySearch(int[] arr, int target) {
	
		
		if (arr[0] == target) return 0;
		int bound = 1;
		// Find the upper bound for the range
		while (bound < arr.length && arr[bound] < target) {
			bound *= 2;
		}

		// Perform a binary search within the found range
		int left = bound / 2;
		int right = Math.min(bound, arr.length - 1);

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == target) {
				return mid; // Element found at index 'mid'
			} else if (arr[mid] < target) {
				left = mid + 1; // Search in the right half
			} else {
				right = mid - 1; // Search in the left half
			}
		}

		return -1; // Element not found
	}

}
