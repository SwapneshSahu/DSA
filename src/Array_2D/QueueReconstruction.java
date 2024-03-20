package Array_2D;

import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstruction {

	public static void main(String[] args) {
		int [][] people = new int [][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		
		System.out.println(reconstructQueue(people));
	}

	public static int[][] reconstructQueue(int[][] people) {
		
		 Arrays.sort(people, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] a, int[] b) {
	                if (a[0] != b[0]) {
	                    // Sort by height in descending order
	                    return b[0] - a[0];
	                } else {
	                    // Sort by k value in ascending order
	                    return a[1] - b[1];
	                }
	            }
	        });
		 
		 for (int i = 1 ; i < people.length ;i++ ) {
			 
			 if (people[i][1] != i) {
				 int [] temp = people[i];
				 int index = i;
				 while (index != temp[1]) {
					 people[index] = people[index-1];
					 index--;
				 }
				 people[index] = temp;
			 }
		 }
		return people;

	}
}
