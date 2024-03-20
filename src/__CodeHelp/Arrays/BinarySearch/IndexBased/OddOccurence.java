package __CodeHelp.Arrays.BinarySearch.IndexBased;

public class OddOccurence {

	//This code will work fine even if array is not Sorted but pair logic remain intact

    /**Intution */
    /**As per problem constraints, identical elements appear in pairs in the array,
     *  and there cannot be more than two consecutive occurrences of any element. So,
     *   there must be a single occurrence of the odd element somewhere in the array. 
     *   We can find this odd occurrence using the binary search algorithm.

Consider the following array with their positions:

nums[] = { 2, 2, 1, 1, 3, 3, 2, 2, 4, 4, 3, 1, 1 }
pos[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }
 
If we carefully observe, each pair of the element before the odd occurring element has the first occurrence at an even index and the second occurrence at an odd index. And, each pair of the element after the odd occurrence has the first occurrence at the odd index and the second occurrence at the even index.

We can use the above observation to determine which side of the mid-index the odd occurring element lies. Now, two cases arise:

The mid-index is odd: If the element before the mid-index is the same as the middle element, the odd element lies on the right side; otherwise, it lies on the left side.
The mid-index is even: If the element next to the mid-index is the same as the middle element, the odd element lies on the right side; otherwise, it lies on the left side. */

   

    public int singleNonDuplicate(int[] nums) {
    // Initialize pointers for binary search
    int left = 0; 
    int right = nums.length - 1;

    // Perform binary search until the pointers meet
    while (left <= right) {
        // If left and right pointers are at the same position, we found the answer
        if (left == right) 
            return nums[left]; 

        // Calculate the middle index
        int mid = left + (right - left) / 2;

        // Check if the middle index is even
        if (mid % 2 == 0) {
            // If the current number is equal to the next number, it means we are on the left side
            // of the unique element, so we move to the right side
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2; // Move two steps to the right as we know mid+1 is not the answer
            } else {
                // If the current number is not equal to its immediate odd neighbor, we are on the 
                // right side of the unique element, so we move to the left side
                right = mid; // We keep mid because it might be our answer
            }
        } else { // When mid is odd
            // If the current number is equal to the next number, we are on the right side of
            // the unique element, so we move to the left side
            if (nums[mid] == nums[mid + 1]) {
                right = mid - 1; // Move one step to the left as we know mid is not the answer
            } else {
                // If the current number is not equal to its immediate odd neighbor, we are on the 
                // left side of the unique element, so we move to the right side
                left = mid + 1;
            }
        }
    }
    
    // This line is unreachable in the given context
    return -1;
}
}
