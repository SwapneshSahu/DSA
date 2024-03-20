package Arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class SumOfAbsoluteDifference {

//Lt-1685
	// formula
	// nums[i] * (numberof element in left) - totalSum of left part + totalSum of
	// right including i - nums[i]* (number of element in right including i)
	public static void main(String[] args) {

	}

	public int[] getSumAbsoluteDifferences(int[] nums) {

		// int totalSum =Arrays.stream(nums).sum(); // impact the runtime alot
		int totalSum = 0;
		for (int i : nums)
			totalSum += i;
		int totalLeft = 0;
		int length = nums.length;
		int[] ans = new int[length];

		for (int i = 0; i < nums.length; i++) {
			ans[i] = nums[i] * i - totalLeft + (totalSum - totalLeft) - nums[i] * (length - i);
			totalLeft += nums[i];
		}

		return ans;
	}
}
