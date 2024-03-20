package Sorting;

public class Selection_Sort {

	public static void main(String[] args) {
		/* Time Complexity - O(n2) Used where array size is small */

		/*
		 * 1 4 2 1 8 4 1 5 33 11 9 1 1 2 4 8 4 1 5 33 11 9 1 1 1 4 8 4 2 5 33 11 9 1 1 1
		 * 2 8 4 4 5 33 11 9 1 1 1 2 4 8 4 5 33 11 9 1 1 1 2 4 4 8 5 33 11 9 1 1 1 2 4 4
		 * 5 8 33 11 9 1 1 1 2 4 4 5 8 33 11 9 1 1 1 2 4 4 5 8 9 11 33 1 1 1 2 4 4 5 8 9
		 * 11 33
		 */

		int[] arr = new int[] { 1, 4, 2, 1, 8, 4, 1, 5, 33, 11, 9 };

		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[j] < arr[minIndex])
					minIndex = j;
			}

			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
           for (int k :arr) System.out.print(k);
           System.out.println();
		}

	}

}


