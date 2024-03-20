package Arrays;

import java.util.Arrays;

public class TallestBillbord {
	public static void main(String[] args) {

	}

	// TLE
	// [1,2,4,8,16,32,64,128,256,512,50,50,50,150,150,150,100,100,100,123]
	public int tallestBillboard(int[] rods) {
		int n = rods.length;
		if (n < 2)
			return 0;
		if (n == 2)
			return rods[0] == rods[1] ? rods[0] : 0;

		// return tallestBillboardRecursion(rods,0,0,0);

		// + 5001 because differnece range could be between -5000 < diff < 5000
		int[][] dp = new int[n + 1][(2 * 5000) + 1];

		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}

		return tallestBillboardRecursionMemorization(rods, 0, 0, dp);
	}

	public int tallestBillboardRecursionMemorization(int[] rods, int diff, int index, int[][] dp) {
		int n = rods.length;
		if (n == index) {
			if (diff == 0)
				return 0;
			return Integer.MIN_VALUE;
		}

		if (dp[index][diff + 5001] != -1)
			return dp[index][diff + 5001];

		// when we use it in left side
		int op1 = rods[index] + tallestBillboardRecursionMemorization(rods, diff + rods[index], index + 1, dp);

		// when we use it in right side
		int op2 = tallestBillboardRecursionMemorization(rods, diff - rods[index], index + 1, dp);
		// when we dont use it
		int op3 = tallestBillboardRecursionMemorization(rods, diff, index + 1, dp);

		return dp[index][diff + 5001] = Math.max(op1, Math.max(op2, op3));

	}

	public int tallestBillboardRecursion(int[] rods, int s1, int s2, int index) {
		int n = rods.length;
		if (n == index) {
			if (s1 == s2)
				return s1;
			return 0;
		}
		int ans = 0;
		int op1 = tallestBillboardRecursion(rods, s1, s2, index + 1);
		int op2 = tallestBillboardRecursion(rods, s1 + rods[index], s2, index + 1);
		int op3 = tallestBillboardRecursion(rods, s1, s2 + rods[index], index + 1);

		return ans = Math.max(op1, Math.max(op2, op3));

	}

}
