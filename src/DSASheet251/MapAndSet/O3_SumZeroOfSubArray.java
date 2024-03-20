package DSASheet251.MapAndSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class O3_SumZeroOfSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * we iterate over the input ArrayList and keep track of the running sum of
	 * elements. We store the sum and its corresponding index in a HashMap. If we
	 * encounter a zero sum, we update the maxLength variable if the length of the
	 * current subarray is greater than the maxLength seen so far.
	 * 
	 * If we encounter a sum that we have seen before, then it means the subarray
	 * between the two indices has a zero sum. We calculate the length of the
	 * subarray and update maxLength if necessary.
	 * 
	 * This approach has a time complexity of O(n), where n is the size of the input
	 * ArrayList. This is because we traverse the array only once and use a HashMap
	 * to store and retrieve the sum and its corresponding index in constant time.
	 */

	public static int LongestSubsetWithZeroSumUsingMap(ArrayList<Integer> arr) {
		int maxLength = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.size(); i++) {
			sum += arr.get(i);

			// Zero sum found
			if (sum == 0) {
				maxLength = i + 1;
			}
			// Check if current sum was seen before
			else if (map.containsKey(sum)) {
				maxLength = Math.max(maxLength, i - map.get(sum));
			}
			// Store sum and index
			else {
				map.put(sum, i);
			}
		}
		return maxLength;
	}

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		int length = 0;
		for (int i = 0; i < arr.size(); i++) {
			int sum = 0;
			for (int j = i; j < arr.size(); j++) {
				sum += arr.get(j);
				if (sum == 0 && j - i + 1 > length) {
					length = j - i + 1;
				}
			}
		}
		return length;
	}

}
