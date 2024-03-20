package Array_2D;

import java.util.Arrays;

public class FindMinArrowShots {

	public static void main(String[] args) {
		int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
		
	    int minArrows = findMinArrowShots(points);
	    System.out.println("Minimum number of arrows needed: " + minArrows);
	}
	
	 public static int  findMinArrowShots(int[][] points) {

         Arrays.sort(points, (int[] row1, int[] row2) -> row1[0] - row2[0]);
      /*   int min= Integer.MAX_VALUE;
         int count =0;
         for (int i =0 ; i <points.length-1;i++){
              if (points[i+1][0] >= points[i][0] 
               && points[i+1][0] <= points[i][1]
               &&  points[i+1][0] <= min){
                      min = Math.min(min,Math.min(points[i][1] ,points[i+1][1] ));
              }
              else{
                  count++;
                  min=Integer.MAX_VALUE;
              }
         }
       return count+1;
    } */
         if (points.length == 0) {
      return 0;
    }

    // sort the array in ascending order based on the start point of each balloon
    Arrays.sort(points, (int[] point1, int[] point2) -> point1[0] - point2[0]);

    // initialize the minimum number of arrows needed to burst all balloons
    int minArrows = 1;
    // initialize the ending point of the current balloon
    int end = Integer.MAX_VALUE;;

    for (int i = 1; i < points.length; i++) {
      // if the start point of the current balloon is less than or equal to the ending point of the current balloon,
      // update the ending point of the current balloon
      if (points[i][0] <= end && points[i][0] >= points[i-1][1] ) {
        end = Math.min(end, points[i][1]);
      }
      // if the start point of the current balloon is greater than the ending point of the current balloon,
      // increment the minimum number of arrows needed and update the ending point of the current balloon
      else {
        minArrows++;
        end = Integer.MAX_VALUE;;
      }
    }

    return minArrows;
         
    } 

}
