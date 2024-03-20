package DSASheet251.Arrays;

public class O2ReverseArrayByK {
	/**Problem link */ 
// https://www.codingninjas.com/codestudio/problems/rotate-array_1230543?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube	
	public static void main(String[] args) {
		rotateWithoutSpace(null, 0); // T(N) S(1);
		rotateUsingspace(null, 0); // T(N) S(N)
	}

	public static void rotateWithoutSpace(int[] nums, int k) {
		k = k % nums.length;

		reverse(nums, 0, nums.length - 1 - k); // rotate first Half before k element
		reverse(nums, nums.length - k, nums.length - 1);// rotate second Half after k element
		reverse(nums, 0, nums.length - 1);// rotate entire array

	}

	public static void reverse(int[] arr, int low, int high) {
		int temp = 0;
		while (low < high) {
			temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}

	}

	/**
	 * We can start by copying the last k elements of the original array into the
	 * beginning of the new array, and then copy the remaining elements of the
	 * original array to the remaining slots of the new array. Finally, we can copy
	 * the new array back into the original array to get the rotated array.
	 */
	public static void rotateUsingspace(int[] nums, int k) {
		int n = nums.length;
		int[] rotated = new int[n];
		for (int i = 0; i < k; i++) {
			rotated[i] = nums[n - k + i];
		}
		for (int i = k; i < n; i++) {
			rotated[i] = nums[i - k];
		}
		System.arraycopy(rotated, 0, nums, 0, n);
	}

}
