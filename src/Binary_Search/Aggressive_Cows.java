package Binary_Search;

import java.util.Arrays;

public class Aggressive_Cows {

	public static void main(String[] args) {
         // Leetcode 1552. Magnetic Force Between Two Balls
		/*
		 * Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The
		 * stalls are located along a straight line at positions x1 ... xN (0 <= xi <=
		 * 1,000,000,000).
		 * 
		 * His C (2 <= C <= N) cows don't like this barn layout and become aggressive
		 * towards each other once put into a stall. To prevent the cows from hurting
		 * each other, FJ wants to assign the cows to the stalls, such that the minimum
		 * distance between any two of them is as large as possible. What is the largest
		 * minimum distance?
		 */
		
		int[] arr = new int[] { 1, 2, 8, 4, 9 };

		Arrays.sort(arr);
		System.out.println(aggressiveCows(arr, 3));

	}

	public static int aggressiveCows(int[] stages, int cows) {
		int max = 0;

		for (int i : stages)
			max = Math.max(max, i);

		int start = 0;
		int end = max;
		int mid = start + (end - start) / 2;
		int ans = 0;

		while (start <= end) {

			if (isPossible(stages, cows, mid)) {
				ans = mid;
				System.out.println(mid);

				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = start + (end - start) / 2;

		}

		return ans;
	}

	public static boolean isPossible(int[] arr, int cows, int mid) {

		int co = 1;
		int lastIndex = arr[0];

		for (int i : arr) {

			if (i - lastIndex >= mid) {
				co += 1;
				if (co == cows)
					return true;

				lastIndex = i;

			}

		}

		return false;
	}
}
