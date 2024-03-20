package Array_2D;

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval {
	//57. Insert Interval
	public static void main(String[] args) {
		//int [][] intervals = new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int [][] intervals = new int[][] {{1,3},{6,8}};
		int [] newInterval = new int[] {2,5};
		int [][]   list = insert(intervals, newInterval);
		 
		 for (int [] i : list) {
			 System.out.print("[");
			 System.out.print(i[0] + "," + i[1]);
			 System.out.println("]");
		 }
		

	}
	
	 public static int [][] insert(int[][] intervals, int[] newInterval) {
	       
	        
	        List <int[]>  list  = new ArrayList<>();
	       for (int[] curr : intervals) {
	    	   
	    	   if (curr[1]<newInterval[0]) {
	    		   list.add(curr);
	    	   }
	    	   else if (curr[0] > newInterval[1]) {
	    		   list.add(newInterval);
	    		   newInterval = curr;
	    	   }
	    	   else {
	    		   newInterval[0] = Math.min(newInterval[0], curr[0]);
	    		   newInterval[1] = Math.max(newInterval[1], curr[1]);
	    		   
	    	   }
	    	   
	    	   
	       }
	       list.add(newInterval);
	       
	        
	        return  list.toArray(new int [list.size()][]);
	    }
	 
	

}
