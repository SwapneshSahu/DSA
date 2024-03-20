package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Count_Nice_Pair {

	public static void main(String[] args) {
		int[] nums = new int[] { 42, 111, 1, 97 ,15};
		System.out.println(countNicePairsOg(nums));
		selectionSort(nums);
		
		for (int i: nums)
		 System.out.println(i);
	}
	
	 public static void selectionSort(int[]nums){

	      for (int i =1 ; i<nums.length ;i++){

	               int left =1;
	               int right=2;
	               while (right <=nums.length-i){
	                      
	                      if (nums[left] > nums[right]){
	                             int temp =nums[left];
	                             nums[left]= nums[right];
	                             nums[right] = temp;
	                      }
	                      left++;
	                      right++;
	               }
	      }
	    }

	static long mod = (long) (Math.pow(10, 9) + 7);

	public static int countNicePairsOg(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			int temp = i > 9 ? i - revOg(i) : 0;

			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}

		long count = 0;
		for (int i : map.keySet()) {
			int temp = map.get(i);

			if (temp > 1) {
				count += ((temp % mod) * ((temp - 1) % mod)) / 2;
				count = count % mod;
			}
		}

		return (int) count;
	}

	private static int revOg(int i) {
		int reversed = 0;

		while (i != 0) {
			int digit = i % 10;
			reversed = reversed * 10 + digit;
			i /= 10;
		}

		return reversed;
	}

	public static int countNicePairs(int[] nums) {

		Arrays.sort(nums);
		int[] numsrev = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			numsrev[i] = rev(nums[i]);
		}
		int count = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + numsrev[j] == nums[j] + numsrev[i]) {
					count++;
				}
			}
		}

		return count;

	}

	private static int rev(int i) {
		String ss = String.valueOf(i);

		char[] ch = ss.toCharArray();

		for (int j = 0; j < ch.length / 2; j++) {

			char temp = ch[j];
			ch[j] = ch[ch.length - 1 - j];
			ch[ch.length - 1 - j] = temp;
		}

		StringBuilder sb = new StringBuilder();

		for (char c : ch) {
			sb.append(c);
		}

		return Integer.valueOf(sb.toString());
	}

}
