package Array_2D;

import java.util.Set;
import java.util.TreeSet;

public class MinEnclaves {

	public static void main(String[] args) {
		int [][] grid = new int [][] {{0,0,0,0},
			                         {1,0,1,0},
			                         {0,1,1,0},
			                         {0,0,0,0}};
			                        
	System.out.println(numEnclaves(grid));		
	
	
	}
	 public static int[] numEnclaves(int[][] grid) {
	        
	        int row = grid.length;
	        int column = grid[0].length;
	        int ans =0;
	        int Count =0 ;
	         for (int i =0 ; i < row ; i++){
	              for (int j = 0 ; j<column ;j++ ){
	                    if (grid[i][j] ==1){
	                         Count ++;
	                        if (i == row-1 || j == column-1 || i ==0 || j==0 ||  checkEnclaves(grid ,i ,j)){
	                            ans++;
	                        }
	                        
	                    }
	              }
	         }
	        
	    }

	    public static boolean checkEnclaves(int [][] grid ,int row , int column){
	        
	        if (grid[row][column] ==0 || row < 0 || row >=grid.length 
	         || column <0 || column >= grid[0].length) 
	         return false;
            
	        if ( grid.length-1 == row || grid[0].length-1 == column ||  row ==0 || column==0 ) return true;
	  
	        return checkEnclaves(grid,row,column-1) || 
	               checkEnclaves(grid,row,column+1) ||
	               checkEnclaves(grid,row-1,column) ||
	              checkEnclaves(grid,row+1,column);

	        
	    }

}
