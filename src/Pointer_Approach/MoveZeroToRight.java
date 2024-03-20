package Pointer_Approach;

public class MoveZeroToRight {

	// LeetCode 283. Move Zeroes
	public static void main(String[] args) {


		int[] nums = new int[] { 1, 0, 8, 3, 1, 0, 0, 3, 1, 11 };

	//	moveZeroes(nums);

		for (int i : nums)
			System.out.print(i + " ");

	}

	public static void moveZeroes(int[] nums) {

		int nonZero = 0;

		for (int j = 0; j < nums.length; j++) {

			if (nums[j] != 0) {
				int temp = nums[j];
				nums[j] = nums[nonZero];
				nums[nonZero] = temp;
				nonZero++;
			}
		}

	}

	

}
