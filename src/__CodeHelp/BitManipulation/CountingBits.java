package __CodeHelp.BitManipulation;

import java.util.Arrays;

public class CountingBits {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(countingBitesOptimise(5)));
	}

	/**
	 * if i is even, you set ans[i] to be equal to ans[i/2]. This is because if a
	 * number is even, its binary representation ends in '0', and shifting it one
	 * position to the right (i.e., dividing by 2) does not change the count of set
	 * bits.
	 * 
	 * If i is odd, you set ans[i] to be equal to ans[i/2] + 1. This is because if a
	 * number is odd, its binary representation ends in '1', and shifting it one
	 * position to the right (i.e., dividing by 2) reduces the count of set bits by
	 * one. Adding 1 accounts for the '1' at the LSB (least significant bit) of the
	 * new binary representation.
	 * 
	 *  even 4 = 100 (1)   4/2 =2 =  10  (1)   n = n/2
	 *  odd  11 = 1011 (3)  11/2 =5  = 101  (2)   n = n/2+1   
	 */
  //T(N)
	public static int[] countingBitesOptimise(int n) {
		int[] ans = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {// even

				ans[i] = ans[i / 2];

			} else {// odd
				ans[i] = ans[i / 2] + 1;
			}
		}

		return ans;
	}

	// T(32*N)
	public static int[] countingBitesBruetForce(int n) {
		int[] ans = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			int num = i;
			int count = 0;
			for (int j = 0; j < 32; j++) {
				int temp = 1;
				if ((num & 1) == 1) {
					count++;
				}

				num = num >> 1;
			}

			ans[i] = count;
		}

		return ans;
	}

}
