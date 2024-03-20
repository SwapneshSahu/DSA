package Sorting;

public class Bubble_Sort {

	public static void main(String[] args) {
/* Average Time Complexity - O(n2)
 * Best Time Complexity - O(n)
 *  Used where array size is small */
		
	/*    4 2 10 8 4 1 5 19 11 9 3 11 6 33 
          2 4 8 4 1 5 10 11 9 3 11 6 19 33 
          2 4 4 1 5 8 10 9 3 11 6 11 19 33 
          2 4 1 4 5 8 9 3 10 6 11 11 19 33 
          2 1 4 4 5 8 3 9 6 10 11 11 19 33 
          1 2 4 4 5 3 8 6 9 10 11 11 19 33 
          1 2 4 4 3 5 6 8 9 10 11 11 19 33 
          1 2 4 3 4 5 6 8 9 10 11 11 19 33 
          1 2 3 4 4 5 6 8 9 10 11 11 19 33 
          1 2 3 4 4 5 6 8 9 10 11 11 19 33 
          1 2 3 4 4 5 6 8 9 10 11 11 19 33   */
		
		int [] arr = new int[] {19,4,2,10,8,4,1,5,33,11,9,3,11,6};
		
		for (int i = 0 ; i<arr.length-1 ;i++) {
			
			boolean swapped = false; // To get best time Complexity when array is sorted or partially sorted
			for (int j = 0 ; j <arr.length-1-i ; j++) {
				
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] =arr[j+1];
					arr[j+1] = temp;
					swapped =true;
				}
			}
			for (int k : arr) System.out.print(k + " ");
			System.out.println("");
			if (!swapped) break;
		}
		
		for (int i : arr) System.out.print(i + " ");
	}

}
