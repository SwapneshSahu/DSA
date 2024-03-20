package DP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class O10_TicketBuying {
	public static void main(String[] args) {
           int [] days = new int [] {1, 3 ,4 ,5 ,7 ,8 ,10};
           int [] cost = new int [] {2,7,20};
           
           System.out.println( minimumCoinsOptimize( days, cost));
	}
	
	public static int minimumCoins(int n, int[] days, int[] cost) {

		// return minimumCoinsRec(n,days,cost,0);
		int[] dp = new int[n + 1];
		return minimumCoinsRecMemo(n, days, cost, 0, dp);
	}
	
	public static int minimumCoinsOptimize( int[] days, int[] cost) {
		int ans =0 ;
		
		Queue<int []> monthQue = new LinkedList<>();
		Queue<int []> weekQue = new LinkedList<>();
		
		for (int day : days) {
			
			while(!monthQue.isEmpty() && monthQue.peek()[0] +30  <= day ) {
				monthQue.poll();
			}
			
			while(!weekQue.isEmpty() && weekQue.peek()[0] + 7  >= day ) {
				weekQue.poll();
			}
			
			monthQue.offer(new int [] {day,ans+cost[2]});
			weekQue.offer(new int [] {day,ans+cost[1]});
			
			ans = Math.min(ans+cost[0],Math.min( monthQue.peek()[1] + cost[2] , weekQue.peek()[1] + cost[1]));
		}
		return ans;
	}
	
	
	//bottom up
	public static int minimumCoinsTab(int n, int[] days, int[] cost) {
		
		//Step 1 Intilalizing DP
		int[] dp = new int[n + 1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		
		//Step 2 base case
		dp[n] = 0;
		
		for (int j = n-1 ; j >= 0 ;j--) {
			// for 1 Day ticket
			int option1 = cost[0] + dp[ j + 1];

			// for 7 Day ticket
			int i = 0;
			for (i = j; i < n && days[i] < days[j] + 7; i++);
				
			int option2 = cost[1] + dp[i];

			// for 30 Day ticket
			i = 0;
			for (i = j; i < n && days[i] < days[j] + 30; i++)
				;
			int option3 = cost[2] + dp[i];

			dp[j] = Math.min(option1, Math.min(option2, option3));
			
		}
		
		return dp[0];
	}

	public static int minimumCoinsRecMemo(int n, int[] days, int[] cost, int index, int[] dp) {

		if (index >= n)
			return 0;

		if (dp[index] != 0)
			return dp[index];

		// for 1 Day ticket
		int option1 = cost[0] + minimumCoinsRecMemo(n, days, cost, index + 1, dp);

		// for 7 Day ticket
		int i = 0;
		for (i = index; i < n && days[i] < days[index] + 7; i++)
			;
		int option2 = cost[1] + minimumCoinsRecMemo(n, days, cost, i, dp);

		// for 30 Day ticket
		i = 0;
		for (i = index; i < n && days[i] < days[index] + 30; i++)
			;
		int option3 = cost[2] + minimumCoinsRecMemo(n, days, cost, i, dp);

		return dp[index] = Math.min(option1, Math.min(option2, option3));
	}

	public static int minimumCoinsRec(int n, int[] days, int[] cost, int index) {

		if (index >= n)
			return 0;

		// for 1 Day ticket
		int option1 = cost[0] + minimumCoinsRec(n, days, cost, index + 1);

		// for 7 Day ticket
		int i = 0;
		for (i = index; i < n && days[i] < days[index] + 7; i++)
			;
		int option2 = cost[1] + minimumCoinsRec(n, days, cost, i);

		// for 30 Day ticket
		i = 0;
		for (i = index; i < n && days[i] < days[index] + 30; i++)
			;
		int option3 = cost[2] + minimumCoinsRec(n, days, cost, i);

		return Math.min(option1, Math.min(option2, option3));
	}
}
