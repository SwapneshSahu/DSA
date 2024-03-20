package DP;

public class KnightMove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(knightProbability(3, 2, 0, 0));
	}
	
	static int sum=0;
    public static double knightProbability(int n, int k, int row, int column) {

        if (n ==1 || k==0) return 1;

        int [][] dp = new int[n][n];
       dp[row][column] =-1;
        
        helpRecursion(n,k,row,column,dp);
        
        // for (int i =0 ; i <n ; i++){
        //     for (int j =0 ; j <n ; j++){
        //      if (dp[i][j] !=0) sum+=dp[i][j];
        // }
        // }

        return (double)sum/Math.pow(8,k);
    }

    public static void helpRecursion (int n , int k , int row, int col , int[][] dp ){
          
          if (row < 0 || row >=n || col < 0 || col >=n || k <0 ) return ;

        ///  dp[row][col] +=1;
          if (k == 0) sum += 1;


          // now will move in all

          //topLeft 1
          helpRecursion(n,k-1,row-1,col-2,dp);
         //topLeft2
          helpRecursion(n,k-1,row-2,col-1,dp);

          //toright 1
          helpRecursion(n,k-1,row-1,col+2,dp);

          helpRecursion(n,k-1,row-2,col+1,dp);

           helpRecursion(n,k-1,row+1,col+2,dp);

          helpRecursion(n,k-1,row+2,col+1,dp);

          helpRecursion(n,k-1,row+1,col-2,dp);

          helpRecursion(n,k-1,row+2,col-1,dp);
           




    }

}
