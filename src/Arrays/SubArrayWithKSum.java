package Arrays;

import java.util.HashMap;

public class SubArrayWithKSum {
//560. Subarray Sum Equals K

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//both Solution is based on cumlative sum

	// Appraoch 2 faster  O(N) O(N)
	public int subarraySumHashMap(int[] nums, int k) {
		int sum = 0;
		int ans = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int j = 0; j < nums.length; j++) {
			sum += nums[j];
			if (map.containsKey(sum - k)) {
				ans += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return ans;
	}

	// Approach 1  O(N2)  two nested loop  O(N) 
	public int subarraySumArray(int[] nums, int k) {
		int count = 0;

		int[] sum = new int[nums.length + 1];
		sum[0] = 0;
		for (int i = 1; i <= nums.length; i++)
			sum[i] = sum[i - 1] + nums[i - 1];

		for (int start = 0; start < sum.length; start++) {
			for (int end = start + 1; end < sum.length; end++) {
				if (sum[end] - sum[start] == k)
					count++;
			}
		}

		return count;
	}
}

/** Appraoch 1
 * Use an array to store the sum accumulated from the beginning to a certain
 * position.
 * 
 * Example:
 * 
 * nums = [1, 2, 3 ] sum = [1, 1+2, 1+2+3] How to create array "sum" ?
 * 
 * sum[i] = sum[i - 1] + nums[i] Q : If i == 0, the index is out of range. How
 * to solve this problem ?
 * 
 * A : Set the first element of the array "sum" to 0, and initialize the array
 * "sum" from index 1 rather than 0.
 * 
 * nums = [1, 2, 3 ] sum = [0, 1, 1+2, 1+2+3] // Also, the length of "sum" is
 * one more than "nums"
 * 
 * sum[i] = sum[i - 1] + nums[i - 1] // Java Version int[] sum = new
 * int[nums.length + 1];
 * 
 * sum[0] = 0; for (int i = 1; i < (nums.length + 1); i++) sum[i] = sum[i - 1] +
 * nums[i - 1]; Using array "sum" to calculate the sum of a subarray
 * 
 * sumOfSubarray = sum[end] - sum[start]; For example :
 * 
 * Caculate the sum of "nums" means using the last element of "sum" minus the
 * first element of "sum" which is 0.
 * 
 * nums[0] + nums[1] + nums[2] = sum[3] - sum[0] = 6 - 0 Using array "sum" to
 * caculate all possibilities .
 * 
 * for (int start = 0; start < sum.length; start++) { for (int end = start + 1;
 * end < sum.length; end++) { if (sum[end] - sum[start] == k) count++; } }
 */
