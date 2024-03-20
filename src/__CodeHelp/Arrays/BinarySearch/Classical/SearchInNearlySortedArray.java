package __CodeHelp.Arrays.BinarySearch.Classical;

public class SearchInNearlySortedArray {

	
//	Given a nearly sorted array such that each of the n elements may be misplaced by no more than one position from the correct sorted order, search a given element in it efficiently. Report if the element is not present in the array.
//
//	An element at index i in a correctly sorted order can be misplaced by the ± 1 position, i.e., it can be present at index i-1 or i or i+1 in the input array.
//
//	 
//	For example,
//
//	Input:
//	 
//	nums = [2, 1, 3, 5, 4, 7, 6, 8, 9]
//	target = 5
//	 
//	Output: Element 5 found at index 3


	// Function to search an element `target` in a nearly sorted array `nums`
	    public static int searchElement(int[] nums, int target)
	    {
	        // search space is nums[left…right]
	        int left = 0;
	        int right = nums.length - 1;
	 
	        // loop till the search space is exhausted
	        while (left <= right)
	        {
	            // find middle index `mid` and compare nums[mid-1], nums[mid],
	            // and nums[mid+1] with the target number
	            int mid = (left + right) / 2;
	 
	            // return `mid` if the middle element is equal to the target number
	            if (nums[mid] == target) {
	                return mid;
	            }
	 
	            // return `mid-1` if nums[mid-1] is equal to target number
	            else if (mid - 1 >= left && nums[mid - 1] == target) {
	                return mid - 1;
	            }
	 
	            // return `mid+1` if nums[mid+1] is equal to target number
	            else if (mid + 1 <= right && nums[mid + 1] == target) {
	                return mid + 1;
	            }
	 
	            // if the middle element is less than the target number,
	            // reduce search space to the right subarray nums[mid+2…right]
	            else if (target > nums[mid]) {
	                left = mid + 2;
	            }
	 
	            // if the middle element is greater than the target number,
	            // reduce search space to the right subarray nums[left…mid-2]
	            else {
	                right = mid - 2;
	            }
	        }
	 
	        // invalid input or number is not present in the array
	        return -1;
	    }
}
