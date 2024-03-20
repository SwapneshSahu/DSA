package __CodeHelp.Arrays.TwoPointer;

public class AS1_PivotElement {

	//Lt -724
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

  //O(N) O(1)	
	public int pivotIndex(int[] nums) {
	    // Store the total sum of all elements in 'rightSum'
	    int rightSum = 0;

	    // Calculate the total sum of all elements in the array
	    for (int num : nums) {
	        rightSum += num;
	    }

	    // Initialize a variable to keep track of the sum of elements on the left side
	    int leftSum = 0;

	    // Iterate through the array to check if the current index is a pivot or not
	    for (int i = 0; i < nums.length; i++) {
	        // Since the current index is considered as the pivot, subtract its value from 'rightSum'
	        rightSum -= nums[i];

	        // Check if the current index is a pivot by comparing the left and right sums
	        if (leftSum == rightSum) {
	            // If they are equal, return the current index as the pivot index
	            return i;
	        }

	        // If we reached here, it means the current index is not a pivot index
	        // Therefore, add its value to 'leftSum' as it is part of the left side sum
	        leftSum += nums[i];
	    }

	    // If no pivot index is found, return -1 to indicate that there is no pivot index
	    return -1;
	}

}
