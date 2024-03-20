package Arrays;

public class BestTimeToBuyStocksWithFee {

	public static void main(String[] args) {
		int[] prices = new int[] { 11, 3, 7, 5, 10, 3 };

		System.out.println(maxProfit(prices, 3));

	}

	public static int maxProfit(int[] prices, int fee) {
		int[] dp = new int[prices.length + 1];
		//return maxProfitRecursionMemorization(prices, fee, 0, 0, dp);
		return maxProfitWithVariable(prices,fee);
		
		
	}
	
	public static int maxProfitWithVariable(int[] prices, int fee) {
        int profit =0;
        int effectiveBuyPrice= prices[0];

        for (int i =1 ; i< prices.length ;i++){

            profit = Math.max(profit , prices[i]-effectiveBuyPrice-fee);
            effectiveBuyPrice = Math.min(effectiveBuyPrice,prices[i]-profit);
        }

        return profit;
    }

	public static int maxProfitRecursion(int[] prices, int fee, int index, int total) {
		int ans = total;
		for (int i = index; i < prices.length; i++) {
			for (int j = index + 1; j < prices.length; j++) {

				if (prices[j] - prices[i] - fee > 0 && i < j) {

					// inclusive
					int inclusive = maxProfitRecursion(prices, fee, j + 1, total + prices[j] - prices[i] - fee);

					int exclusive = maxProfitRecursion(prices, fee, j + 1, total);

					ans = Math.max(ans, Math.max(inclusive, exclusive));
				}

			}

		}
		return ans;
	}

	public static int maxProfitRecursionMemorization(int[] prices, int fee, int index, int total, int[] dp) {

		if (index == prices.length)
			return total;

		if (dp[index] != 0)
			return dp[index];

		for (int i = index; i < prices.length; i++) {
			for (int j = index + 1; j < prices.length; j++) {

				if (prices[j] - prices[i] - fee > 0 && i < j) {

					// inclusive
					int inclusive = maxProfitRecursionMemorization(prices, fee, j + 1, total + prices[j] - prices[i] - fee, dp);

					int exclusive = maxProfitRecursionMemorization(prices, fee, j + 1, total, dp);

					dp[index] = Math.max(dp[index], Math.max(inclusive, exclusive));
				}

			}

		}
		return Math.max(total, dp[index]);
	}
	
	
	public static int maxProfitTabulation(int[] prices, int fee) {
	    int n = prices.length;
	    int[] dp = new int[n + 1];
	    
	    // Base case: no stocks bought or sold
	    dp[n] = 0;
	    
	    
	    // Iterate from right to left, filling the DP array
	    for (int i = n - 1; i >= 0; i--) {
	        for (int j = i + 1; j < n; j++) {
	            int profit = prices[j] - prices[i] - fee;
	            
	            // Calculate the maximum profit if the stock is sold at index j
	            int inclusive = profit + dp[j];
	            
	            // Calculate the maximum profit if the stock is not sold at index j
	            int exclusive = dp[j];
	            
	            // Choose the maximum between inclusive and exclusive profits
	            dp[i] = Math.max(dp[i],Math.max(exclusive, inclusive));
	            
	        }
	    }
	    
	    // Return the maximum profit at index 0 (starting point)
	    return dp[0];
	}
//	In the tabulation approach, the dp[i][0] represents the maximum profit if a stock is bought at index i, and dp[i][1] represents the maximum profit if no stock is bought at index i.
//
//	By iterating from right to left, the DP array is filled iteratively based on the values calculated in the recursive calls. Finally, the maximum profit at index 0 is returned as the result.







}
