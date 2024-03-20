package __CodeHelp.Arrays.TwoPointer;

public class CW1_SortColors {

	// Lt-75
	public static void main(String[] args) {
		// Approach 1 -> Arrays.sort T(NLogN) S(N)

	}

	// Approach 2-> Counting Numbers T(N) S(1) //counting zero one and two
	public void sortColorsApp2(int[] nums) {

		// We have to solve it in place but we are overriding the array not swapping it

		int zero = 0, one = 0, two = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zero++;
			} else if (nums[i] == 1) {
				one++;
			} else {
				two++;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (zero > 0) {
				nums[i] = 0;
				zero--;
			} else if (one > 0) {
				nums[i] = 1;
				one--;
			} else {
				nums[i] = 2;
				two--;
			}
		}

	}

	// Approach 3 To Swap 0 1 2 in each pass T(N) S(1)
	public void sortColorsApp3(int[] nums) {

		// Here we are using two loops it is not in one pass ek ek bar me zero or one ko
		// apni position pr la diya

		// for zero
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				int temp = nums[index];
				nums[index] = nums[i];
				nums[i] = temp;
				index++;
			}
		}
		// for one
		for (int i = index; i < nums.length; i++) {
			if (nums[i] == 1) {
				int temp = nums[index];
				nums[index] = nums[i];
				nums[i] = temp;
				index++;
			}
		}
	}

	// Approach 4 2 pointer Approach T(N) S(1)
	public void sortColorsApp4(int[] nums) {

		// Basic idea is hm 0 or 2 ko unki position pr dal re hai to 1 automaticly apni
		// sahi
		// postion pr ajayega

		int forOne = 0, index = 0, forTwo = nums.length - 1;

		// index <=forTwo q ki jesa jesa forTwo kam hoga right side allready sort ho
		// chuka hoga
		while (index <= forTwo) { // why using equal dry run {2,0,1}

			if (nums[index] == 0) {
				// we found 0 so we will swap with forOne
				int temp = nums[index];
				nums[index] = nums[forOne];
				nums[forOne] = temp;
				forOne++;
				index++;
				// yaha pr index ++ isliya kiya q ki hm sure hai yaha pr pr swap hokr 0/1 hi
				// ayega
				// q ki left side se are hai to agr koi 2 hota idhr to hm allready swap kr chuke
				// hote

			} else if (nums[index] == 2) {
				// swap high with mid
				int temp = nums[index];
				nums[index] = nums[forTwo];
				nums[forTwo] = temp;
				forTwo--;
				// yaha pr index ++ isliya nahi kiya q ki yaha pr swap hokr kuch bhi askta hai
				// 0/1/2
				// to use bhi check krna hoga
			} else {
				// 1 k case me
				index++;
				// kuch swap krne ki jarurat ni
			}
		}
	}

}
