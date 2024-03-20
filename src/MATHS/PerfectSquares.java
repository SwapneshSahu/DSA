package MATHS;

import java.util.Arrays;

public class PerfectSquares {

	public static void main(String[] args) {
		// 9+9+4
	//	System.out.println(numSquares(22));
		int i =0;
		while (i)		
		System.out.println(Math.round(10.5));
	}

	public static int numSquares(int n) {
		// int [] dp  = new int[n+1];
		// return numSquaresDp(n,dp);

        return numSquaresTab(n);
	}

    public static int numSquaresDp(int n ,int []dp) {

        if (n == 0) return 0;

        if (dp[n] != 0 ) return dp[n];

        int ans = n;
        for (int i =1 ; i * i<= n ; i++ ){
            int squre = i*i ;
            ans = Math.min(ans , 1 + numSquaresDp(n-squre,dp) );
        }
		return dp [n] = ans;
	}

    public static int numSquaresTab(int n ) {
       int [] dp  = new int[n+1];
       Arrays.fill(dp,Integer.MAX_VALUE);
        
        dp[0] =0;
        for (int i =1 ; i <= n ; i++ ){
            for (int j =1 ; j*j <= i ; j++ ){
            int squre = j*j ;

            if (i - squre  >=0)
            dp[i]= Math.min(dp[i] , 1 + dp[i-squre] );
            }
        }
		return dp [n] ;
	}
}
