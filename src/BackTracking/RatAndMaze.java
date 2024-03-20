package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatAndMaze {

	public static void main(String[] args) {
	int m[][] = {{1, 0, 0, 0},
		         {1, 1, 0, 1}, 
		         {1, 1, 0, 0},
		         {0, 1, 1, 1}} ;
	
	System.out.println(findPath(m, 4).toString());

	}
	
	public static ArrayList<String> findPath(int[][] arr, int n) {
        ArrayList<String> result = new ArrayList<>();
       if (arr[0][0] == 0) return result;
      
      boolean[] [] isVisited = new boolean[n][n];
       
    
      paths(arr,isVisited,0,0 ,result,"",n);
      
      return result;
   }
   
   public static void paths(int [][] arr , 
                 boolean [][] isVisited , int row , int column , List<String> result , String path ,int n){
       //base case 
       if (row == n-1 && column == n-1) 
    	   result.add(path);
       
       isVisited[row][column] = true;
       
       //checkdown
       if (isSafe(arr,isVisited ,row+1 ,column ,n) ){
         paths(arr,isVisited,row+1,column ,result,path+ 'D' ,n);
       }
        //checkLeft
       if (isSafe(arr,isVisited ,row ,column-1 ,n) ){
         paths(arr,isVisited,row,column-1 ,result,path+ 'L' ,n);
       }
        //checkRight
       if (isSafe(arr,isVisited ,row ,column+1 ,n) ){
         paths(arr,isVisited,row,column+1 ,result,path+ 'R' ,n);
       }
        //checkUp
       if (isSafe(arr,isVisited ,row-1 ,column ,n) ){
         paths(arr,isVisited,row-1,column ,result,path+ 'U' ,n);
       }
       
       isVisited[row][column] = false;
   }
   
   public static boolean isSafe(int [][] arr , 
                 boolean [][] isVisited , int row , int column ,int n){
       
       if (row <n && row >=0 && column <n && column >=0 && !isVisited[row][column] && arr[row][column] == 1
                )              
                   return true;  
                   
                   
       return false;            
     }    
   

}
