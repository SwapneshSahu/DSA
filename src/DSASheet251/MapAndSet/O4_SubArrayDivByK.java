package DSASheet251.MapAndSet;

import java.util.HashMap;
import java.util.Map;

public class O4_SubArrayDivByK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int subarraysDivByK(int[] nums, int k) {
		// Initialize a hash map to store remainders and their frequencies
		Map<Integer, Integer> map = new HashMap<>();
		// Store the initial remainder 0 with frequency 1 in the map
		map.put(0, 1);
		// Initialize the count of subarrays to 0
		int count = 0;
		// Initialize the sum to 0
		int sum = 0;
		// Initialize the remainder to 0
		int rem = 0;
		// Iterate over each element in the array
		for (int i : nums) {
			// Add the current element to the sum
			sum += i;
			// Compute the remainder of the current sum with respect to k
			rem = sum % k;
			// If the remainder is negative, add k to make it positive
			if (rem < 0)
				rem += k;
			// If the map already contains the remainder, update the count and increment its
			// frequency in the map
			if (map.containsKey(rem)) {
				count += map.get(rem);
				map.put(rem, map.get(rem) + 1);
			}
			// If the remainder is not in the map, add it with frequency 1
			else {
				map.put(rem, 1);
			}
		}
		// Return the count of subarrays with sum divisible by k
		return count;
	}

}
