package Arrays;

public class CanJump {
	// 55. Jump Game
// //Idea is to work backwards from the last index. Keep track of the smallest index that can "jump" 
	//to the last index. Check whether the current index can jump to this smallest index.
	public static void main(String[] args) {
		int[] nums = new int[] { 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5 };

		System.out.print(canJump(nums));

	}

	public static boolean canJump(int[] nums) {
		int last = nums.length - 1, i;
		for (i = nums.length - 2; i >= 0; i--) {
			int temp = nums[i];
			if (i + temp >= last)
				last = i;
		}
		return last <= 0;
	}

}
