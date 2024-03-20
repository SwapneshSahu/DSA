package __CodeHelp.Arrays.Basic;

import java.util.PriorityQueue;

public class AS2_MissingNumber {
//LT-268
	public static void main(String[] args) {
	

	}

	public int missingNumber(int[] nums) {

		// // Approach 1 sorting T(NlogN) S(N)
		// Arrays.sort(nums);

		// for (int i = 0 ; i <nums.length ;i++){
		// if (nums[i] != i) return i;
		// }
		// return nums.length;

		/************************************************/
		// Appraoch 2 Sum apporach

		// int sum = nums.length;

		// for (int i =0 ; i <nums.length ;i++){
		// sum +=i-nums[i];
		// }
		// return sum;

		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i] - i;
		}
		return nums.length - sum;

		/************************************************/
		// //Approch 3 Mark Visited This approach will not work because of 0 we will not
		// able to // find if 0 is missing or not If range is [1,n] then it will work
		// fine

		// for (int i =0 ; i <nums.length ;i++){
		// int index = Math.abs(nums[i]);

		// if (index < nums.length){
		// nums[index] *=-1;
		// }
		// }

		// for (int i =0 ; i <nums.length ;i++){
		// if (nums[i] > 0) return i;
		// }
		// return nums.length;

	}

}
