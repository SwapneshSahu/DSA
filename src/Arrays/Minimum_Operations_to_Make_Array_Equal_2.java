package Arrays;

public class Minimum_Operations_to_Make_Array_Equal_2 {
//2541. Minimum Operations to Make Array Equal II
	public static void main(String[] args) {
		int[] nums1 = new int[] { 4, 3, 1, 4 };

		int[] nums2 = new int[] { 1, 3, 7, 1 };
		System.out.print(minOperations(nums1, nums2, 2198));// 1952083
	}

	public static long minOperations(int[] nums1, int[] nums2, int k) {
		int totalSum = 0; // TO track ans is possible or not

		// To track only positivesum it will help to find ans as well as to determine
		// the array is allready sorted or not
		long posSum = 0;
		for (int i = 0; i < nums1.length; i++) {
			int temp = nums1[i] - nums2[i];
			if (k > 0 && temp % k != 0)
				return -1; // if temp%k != 0 that means no matter we add or subtract we will never able to
							// make them equal
			if (temp > 0)
				posSum += temp;
			totalSum += temp;
		}
		if (totalSum != 0)
			return -1; // if totalsum is not negative thats means we can not balance out the two
						// operation add and sub simulatanously
		if (totalSum == 0 && posSum == 0)
			return 0; // if both are 0 then it means array is allready equal
		if (k == 0)
			return -1;

		return posSum / k; // divided by k to determine the operations
	}

}
