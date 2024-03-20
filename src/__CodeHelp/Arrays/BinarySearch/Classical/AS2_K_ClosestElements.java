package __CodeHelp.Arrays.BinarySearch.Classical;

import java.util.ArrayList;
import java.util.List;

public class AS2_K_ClosestElements {
//LT 658. Find K Closest Elements
	public static void main(String[] args) {
		int[] arr = new int[] { 0, 0, 1, 2, 3, 3, 4, 7, 7, 8 };

		System.out.println(findClosestElements(arr, 3, 5));
	}
	
	public static List<Integer> findClosestElements(int[] arr, int k, int x) {

	    List<Integer> list = new ArrayList<>();

	    // If the desired number of elements is equal to the length of the array,
	    // simply add all elements to the list and return it.
	    if (arr.length == k) {
	        for (int i : arr)
	            list.add(i);
	        return list;
	    }

	    // Find the index of 'x' or the nearest element using binary search.
	    int index = findIndexBs(arr, x);

	    int left = index;
	    int right = index + 1;

	    // Continue expanding the range around 'x' until we have 'k' elements in the list.
	    while (right - left <= k) {
	        // If 'right' is out of bounds, move 'left' to the left.
	        if (right >= arr.length) {
	            left--;
	        }
	        // If 'left' is out of bounds, move 'right' to the right.
	        else if (left < 0) {
	            right++;
	        }
	        // If the element at 'right' is closer to 'x' than the element at 'left',
	        // move 'right' to the right.
	        else if (arr[right] - x < x - arr[left]) {
	            right++;
	        } else {
	            // Otherwise, move 'left' to the left.
	            left--;
	        }
	    }
	 // left +1  or right smaller than k sath  q ki jb bhi while loop se bahar aaye honge vo index range se 
//		bahar  hogya hoga  
	    // Add the elements within the range [left+1, right-1] to the list.
	    for (int i = left + 1; i < right; i++) {
	        list.add(arr[i]);
	    }
	    return list;
	}

	public static int findIndexBs(int[] arr, int x) {
	    int low = 0;
	    int high = arr.length - 1;
	    int index = -1;

	    // Binary search to find the index of 'x' or the nearest element to 'x'.
	    while (low <= high) {
	        int mid = low + (high - low) / 2;

	        if (arr[mid] == x)
	            return mid;
	        if (arr[mid] < x) {
	            // Update the 'index' to the current 'mid' and search in the right half.
	            index = mid;
	            low = mid + 1;
	        } else {
	            // Search in the left half.
	            high = mid - 1;
	        }
	    }
	    return index;
	}


}
