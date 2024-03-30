package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDifferentElement {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 1, 3, 6, 6, 7, 5, 1 };
/****
 * Lets say K =3  
 * with classical SLW approach we count all the sub array  which is equal to or less then k 
 * so we calculate for K -1 also 
 * 
 * 
 */
	

	}

	public int subarraysWithKDistinct(int[] nums, int k) {

		return slidingWindow(nums, k) - slidingWindow(nums, k - 1);
	}

	public int slidingWindow(int[] nums, int k) {
		int i = 0;
		int j = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		while (j < nums.length) {

			map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

			while (map.size() > k && i < j) {
				map.put(nums[i], map.get(nums[i]) - 1);
				if (map.get(nums[i]) == 0)
					map.remove(nums[i]);

				i++;
			}

			if (map.size() <= k) {
				// number of subArrays ending at index j
				count += j - i + 1;
			}

			j++;

		}
		return count;
	}
}
