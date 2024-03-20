package Arrays;

import java.util.Arrays;

public class NumberOfSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numSubseq(int[] arr, int target) {
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		int count = 0;
		long mod = (long) 1e9 + 7;
		while (left <= right) {
			if (arr[left] + arr[right] <= target) {
				count += powMod(2, right - left, mod);
				count = (int) (count % (Math.pow(10, 9) + 7));
				left++;
			} else {
				right--;
			}

		}
		return count;
	}

	public long powMod(long x, long n, long mod) {
		if (n == 0) {
			return 1;
		}
		long t = powMod(x, n / 2, mod);
		if (n % 2 == 0) {
			return (t * t) % mod;
		} else {
			return (((t * t) % mod) * x) % mod;
		}
	}

}
