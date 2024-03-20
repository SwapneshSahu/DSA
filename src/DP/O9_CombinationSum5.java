package DP;

public class O9_CombinationSum5 {

	public static void main(String[] args) {
	int [] num = new int [] {1,2,3,5};
	
	System.out.println(findWays(num, 7));

	}

	public static int findWays(int num[], int tar) {

		// return findWaysRecursion(num, tar, 0);
		// int [] dp = new int [tar+1];
		// return findWaysRecursionMemo(num, tar,dp);
		return findWaysTab(num, tar);
	}

	public static int findWaysTab(int num[], int tar) {
		int[] dp = new int[tar + 1];
		dp[0] = 1;

		for (int i = 1; i < dp.length; i++) {

			for (int j = 0; j < num.length; j++) {
				if (i - num[j] >= 0)
					dp[i] += dp[i - num[j]];
			}

		}

		return dp[tar];
	}

	public static int findWaysRecursionMemo(int num[], int tar, int[] dp) {
		if (tar == 0)
			return 1;

		if (tar < 0)
			return 0;

		if (dp[tar] != 0)
			return dp[tar];
		int temp = 0;
		for (int i : num) {
			temp += findWaysRecursionMemo(num, tar - i, dp);
		}

		dp[tar] = temp;
		return temp;
	}

	public static int findWaysRecursion(int num[], int tar, int ans) {
		if (tar == 0)
			return 1;

		if (tar < 0)
			return 0;
		int temp = 0;
		for (int i : num) {
			temp += findWaysRecursion(num, tar - i, ans);
		}
		ans += temp;
		return ans;
	}

}
