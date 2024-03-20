package __CodeHelp.Arrays.BinarySearch.Classical;

public class CW1_SearchInRotatedSortedArray {
//LT-33
	public static void main(String[] args) {
		int [] arr=  new int[] {22,25};
		
		int target = 25;
		System.out.println(findTargetIndexBS(arr,target));
		//findTargetIndexBS(arr,target);

	}
	
	
	
	public static int findTargetIndexBS(int[] arr, int target) {
	    // We know the given array is sorted but in a rotated form.
	    // First, we try to find the index from where it is rotated,
	    // and then we consider it as two sorted arrays.

	    int pivotIndex = findpivotIndexBS(arr);

	    if (target >= arr[0] && target <= arr[pivotIndex]) {
	        // The target is within the range of the first sorted subarray.
	        return binarySearch(0, pivotIndex, target, arr);
	    } else {
	        // The target is within the range of the second sorted subarray.
	        return binarySearch(pivotIndex + 1, arr.length - 1, target, arr);
	    }
	}

	// Example: {10,12,16,2,3,4,9}
	// Line A {10,12,16} Sorted
	// Line B {2,3,4,9} Sorted
	// {16,2} is the only place where our binary search logic may fail,
	// that's why we handle this case in findpivotIndexBS.

	public static int findpivotIndexBS(int[] arr) {
	    int low = 0;
	    int high = arr.length - 1;

	    while (low <= high) {
	        int mid = low + (high - low) / 2;

	        // When we have a single element, it's the pivot.
	        if (low == high) {
	            return low;
	        } else if (mid - 1 >= 0 && arr[mid - 1] > arr[mid]) {
	            // If the element before mid is greater than mid, mid is the pivot.
	            return mid - 1;
	        } else if (mid < arr.length && arr[mid] > arr[mid + 1]) {
	            // If the element after mid is greater than mid, mid is the pivot.
	            return mid;
	        } else if (arr[mid] < arr[0]) {
	            // We are on Line A, so the pivotIndex is on the right.
	        	  high = mid - 1;
	          
	        } else {
	            // We are on Line B, so the pivotIndex is on the left.
	        	  low = mid + 1;
	        }
	    }
	    return -1; // No pivot found.
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

	//Another way to find pivot
	
//	 public  int pivot(int []arr) {
//			int start = 0 ;
//			int end = arr.length-1;
//			
//			int mid = start + (end - start) / 2;
//			
//			while(start<end) {
//				if (arr[mid] >= arr[0]) {
//					start = mid+1;
//				}
//				else {
//					end = mid;
//				}
//				 mid = start + (end - start) / 2;
//			}
//			return start;
//			
//			
//		}
	

}
