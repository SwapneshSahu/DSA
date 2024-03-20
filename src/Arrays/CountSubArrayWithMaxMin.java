package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CountSubArrayWithMaxMin {

	/**
	 * lleetcode 2444 Intuition of this Problem: This solution works by iterating
	 * over the given array nums and keeping track of the most recent positions of
	 * the minimum value minK and the maximum value maxK in the array, as well as
	 * the most recent index leftBound outside the range [minK, maxK].
	 * 
	 * For each element in the array, if it falls within the range [minK, maxK], the
	 * code updates the most recent positions of minK and maxK, calculates the
	 * number of subarrays that can be formed between the most recent positions of
	 * minK and maxK, and adds this count to the answer.
	 * 
	 * If the current element falls outside the range [minK, maxK], the code updates
	 * the leftBound index to the current index i, and resets the most recent
	 * positions of minK and maxK to -1.
	 * 
	 * In the end, the code returns the total count of valid subarrays.
	 * 
	 * Approach for this Problem: The approach used in the given code can be
	 * classified as a two-pointer approach. We are maintaining two pointers,
	 * lastMin and lastMax, that track the most recent occurrences of minK and maxK,
	 * respectively. The variable leftBound represents the left endpoint of the
	 * current subarray being considered. By comparing the values of lastMin,
	 * lastMax, and leftBound, we are able to determine the number of valid
	 * subarrays within the range [minK, maxK].
	 * 
	 * Explanation of code point wise :
	 * 
	 * int n = nums.size(); : This statement initializes a variable n with the size
	 * of the input vector nums. int leftBound = -1; : This statement initializes a
	 * variable leftBound to -1. This variable represents the index of the left
	 * endpoint of the current subarray being considered. Initially, there is no
	 * subarray being considered, so we set leftBound to -1. int lastMin = -1,
	 * lastMax = -1; : These statements initialize two variables lastMin and lastMax
	 * to -1. These variables represent the indices of the most recent occurrences
	 * of minK and maxK, respectively. Initially, there are no occurrences of minK
	 * and maxK, so we set both variables to -1. long long count = 0; : This
	 * statement initializes a variable count to 0. This variable represents the
	 * count of valid subarrays that we will be computing. for (int i = 0; i < n;
	 * i++) { ... } n : This statement starts a loop that iterates over each element
	 * of the input vector nums. if (nums[i] >= minK && nums[i] <= maxK) { ... } :
	 * This statement checks if the current element nums[i] is within the range
	 * [minK, maxK]. lastMin = (nums[i] == minK) ? i : lastMin; : This statement
	 * updates lastMin to the current index i if nums[i] is equal to minK, otherwise
	 * it leaves lastMin unchanged. lastMax = (nums[i] == maxK) ? i : lastMax; :
	 * This statement updates lastMax to the current index i if nums[i] is equal to
	 * maxK, otherwise it leaves lastMax unchanged. count += max(0, min(lastMin,
	 * lastMax) - leftBound); : This statement computes the number of valid
	 * subarrays that end at the current index i and adds it to the total count. The
	 * number of valid subarrays is equal to the number of subarrays whose minimum
	 * and maximum elements are both in the range [minK, maxK].
	 **/
	public static void main(String[] args) {
		int[] arr = new int[] { 4, 2, 3, 5 };

		System.out.println(countSubarraysOn2(arr, 1, 5)); // give TLE
		System.out.println(countSubarrayOn(arr, 2, 5)); // fast

	}

	// give TLE
	public static long countSubarraysOn2(int[] nums, int minK, int maxK) {

		List<Integer> ll = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			// first check number is in between both max and min
			if (checkNumber(nums[i], minK, maxK)) {
				ll = new ArrayList<>();
				ll.add(nums[i]);
				if (maxK == minK) {
					count++;
				}
			} else {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (checkNumber(nums[j], minK, maxK)) {
					ll.add(nums[j]);
					if (checkValid(ll, minK, maxK)) { // to check if list contains both max and min
						count++;
					}
				} else {
					break;
				}

			}
		}
		return count++;
	}

	private static boolean checkValid(List<Integer> ll, int minK, int maxK) {
		if (ll.contains(minK) && ll.contains(maxK))
			return true;
		return false;
	}

	private static boolean checkNumber(int i, int minK, int maxK) {
		if (minK <= i && maxK >= i)
			return true;
		return false;
	}

	public static long countSubarrayOn(int[] nums, int minK, int maxK) {
		int n = nums.length;
		int leftBound = -1;
		int lastMin = -1, lastMax = -1;
		long count = 0;

		for (int i = 0; i < n; i++) {
			if (nums[i] >= minK && nums[i] <= maxK) {
				lastMin = (nums[i] == minK) ? i : lastMin;
				lastMax = (nums[i] == maxK) ? i : lastMax;
				count += Math.max(0, Math.min(lastMin, lastMax) - leftBound);
			} else {
				leftBound = i;
				lastMin = -1;
				lastMax = -1;
			}
		}

		return count;
	}

}
