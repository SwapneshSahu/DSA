package DP;

public class CoinChange {
	public static void main(String[] args) {
            int [] coins = new int [] {1};
            System.out.println(coinChange(coins,0));
            
	}

	public static int coinChange(int[] coins, int amount) {
		int ans = coinChangeA(coins, amount);
		System.out.println(ans);
		return ans != Integer.MAX_VALUE ? ans : -1;
	}

	public static int coinChangeA(int[] coins, int amount) {
		if (amount == 0)
			return 0;

		// if (amount < 0) return Integer.MAX_VALUE;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			int temp = 0;
			if (amount - coins[i] >= 0) {
				temp =  coinChangeA(coins, amount - coins[i]);
				if (temp  != Integer.MAX_VALUE)
				ans = Math.min(ans, temp+1);
			}

		}

		return ans;
	}
}
