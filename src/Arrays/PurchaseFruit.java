package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PurchaseFruit {

	public static void main(String[] args) {
		
		Map <Integer , Integer>  map = new HashMap<>();
		map.put(1,10);
		 System.out.println(map.get(11));
		
		int [] arr = new int [1000];
		
		 Random random = new Random();

	        for (int i = 0; i < 1000; i++) {
	            arr[i] = random.nextInt(100000) + 1; // Generates a random value between 1 and 100000 (inclusive)
	        }

		int[] prices = new int[] {27,17,29,45,3,39,42,26};

		System.out.println(minimumCoins(prices));

	}

	public static int minimumCoins(int[] prices) { 
	      int []dp = new int[prices.length+1]; 
	      Arrays.fill(dp,-1);
		        return minDp(prices, prices[0],1, dp);      
	    }

	     public  static int minDp(int[] prices,int coin,  int index, int []dp) {
	    	 
	    	  if (index >= prices.length) {
	              return coin;
	          }

	          if (dp[index] != -1) {
	              return dp[index];
	          }

	          // Exclude the current index
	          int exclude = minDp(prices,coin, index + 1, dp);

	          // Include the current index
	          int include = minDp(prices,coin, 2 * (index + 1), dp) + prices[index];

	          // Update dp array with the minimum value
	          dp[index] = Math.min(exclude, include);

	          return dp[index];
			
//			 if (nextPurchaseIndex >= prices.length || index >= prices.length)  return coins ;      
//	      if (dp[index] != Integer.MAX_VALUE)  return dp[index]; 
//
//					int	exclude = index == nextPurchaseIndex ?Integer.MAX_VALUE : 
//						      minDp(prices, coins, index + 1, nextPurchaseIndex,dp);
//				
//					int include = minDp(prices, coins + prices[index], index + 1, 2 * (index + 1) ,dp);
//					dp[index]  =Math.min(exclude,include);	
//			return  Math.min(exclude,include);
		}
}
