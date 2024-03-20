package Arrays;

import java.util.Arrays;

public class KoKo_Eating_Banana {

	// leetcode 875

	/**
	 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has
	 * piles[i] bananas. The guards have gone and will come back in h hours.
	 * 
	 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
	 * chooses some pile of bananas and eats k bananas from that pile. If the pile
	 * has less than k bananas, she eats all of them instead and will not eat any
	 * more bananas during this hour.
	 * 
	 * Koko likes to eat slowly but still wants to finish eating all the bananas
	 * before the guards return.
	 * 
	 * Return the minimum integer k such that she can eat all the bananas within h
	 * hours.
	 */
	public static void main(String[] args) {
		int[] arr = new int[] { 3, 6, 7, 11 };

		System.out.println(minEatingSpeed(arr, 8));

	}

	public static int minEatingSpeed(int[] piles, int h) {
		// If hour h = length then we have to go with the maximum number otherwise we
		// will not able to eat all bnana's
		if (h == piles.length) {
			Arrays.sort(piles);
			return piles[h - 1];
		}

		// Will go with binary search operation
		Arrays.sort(piles);
		int left = 1;
		int right = piles[piles.length - 1];
		int ans = Integer.MAX_VALUE;

		while (left < right) {
			int mid = left + (right - left) / 2;
			int hours = piles.length; // this is the mandatory time which will be consumed for each integer
			for (int j = 0; j < piles.length; j++) {
				int temp = (piles[j] / mid) - 1; // -1 we have done because we allready added 1 in hour for index
				if (piles[j] % mid > 0)
					temp++;
				if (temp + hours > h) { // will move left to forward because at current mid will not able to eat all the
										// bananas in given time
					left = mid + 1;
					break;
				} else if (temp + hours <= h && j == piles.length - 1) {
					ans = Math.min(ans, mid); // here we found one ans but will still look in making window close as we
												// need minimum number
					right = mid - 1;
				} else if (temp + hours <= h)
					hours += temp;
			}

		}
		return ans;
	}

}
