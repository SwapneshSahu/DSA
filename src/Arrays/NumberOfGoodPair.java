package Arrays;

import java.util.PriorityQueue;

public class NumberOfGoodPair {

	public static void main(String[] args) {
		int[] nums = new int[] {2,2,1,5,1,5,5,2,3,1,1,5,3,2,3,3,3,1,3,3,4,3,1,3,1,4,5,5,2,2,1,3,5,2,2,4,3,2,5,3,1,1,3,3,2,5,2,1,2,4,3,4,4,3,2,4,4,1,3,3,3,5,5,5,4,1,1,2,3,3,2,5,3,4,5,3,1,2,5,4,5,2,3,3,1,5,2,4,2,4,4,3,1,3};

		System.out.println(numIdenticalPairs(nums));
		
	}

	// /535 885
	public static int numIdenticalPairs(int[] nums) {
		int[] count = new int[100 + 1];

		for (int i : nums) {
			count[i]++;
		}
		long ans = 0;
		for (int i : count) {
			if (i > 1)
				//ans += (calculateFactorial(i) / (2 * calculateFactorial(i - 2)));
				//can be replaced by
				ans += i * (i-1)/2;
		}
		return (int)ans;
	}

	public static long calculateFactorial(int n) {
		if (n == 0 || n == 1 || n==2) {
			return 1;
		} else {
			return n * calculateFactorial(n - 1);
		}
	}

}
