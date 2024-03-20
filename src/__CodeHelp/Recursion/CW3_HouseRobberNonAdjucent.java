package __CodeHelp.Recursion;

public class CW3_HouseRobberNonAdjucent {

	public static void main(String[] args) {
     
		int [] nums = new int [] {2,3,2};
		System.out.println(rob(nums));
	}

	public static int rob(int[] nums) {

		if (nums.length == 1)
			return nums[0];

		return houseRobberNonAdjacentSum(nums, 0, false);

	}

	public static int houseRobberNonAdjacentSum(int[] nums, int index, boolean firstIndex) {

		if (index >= nums.length || (index == nums.length - 1 && !firstIndex))
			return 0;

		int include = nums[index] + houseRobberNonAdjacentSum(nums, index + 2, index == 0 ? true : firstIndex);

		int exclude = houseRobberNonAdjacentSum(nums, index + 1, firstIndex);

		return Math.max(include, exclude);
	}
}
