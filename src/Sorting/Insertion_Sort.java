package Sorting;

public class Insertion_Sort {

	public static void main(String[] args) {

		int[] arr = new int[] { 19, 4, 2, 10, 8, 4, 1, 5, 33, 11, 9, 3, 11, 6 };

		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;

			while (j >= 0) {
				if (arr[j] > temp) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
               j--;
			}
			arr[j+1] = temp;

		}

		for (int i:arr) System.out.print(i + " ");
	}

}
