package Arrays;

import java.util.HashSet;

public class ContainsDuplicateII {

	public static void main(String[] args) {
		int [] arr = new int[] {1,2,3,1,2,3};
		 System.out.println( containsNearbyDuplicate(arr, 2));

	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {

		HashSet<Integer> window = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				window.remove(nums[i - k - 1]);
			}
			if (!window.add(nums[i])) {
				return true;
			}
		}

		return false;
	}

}
