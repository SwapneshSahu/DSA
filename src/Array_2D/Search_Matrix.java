package Array_2D;

public class Search_Matrix {
//74. Search a 2D Matrix
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };

		System.out.println(searchMatrix(matrix, 3));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		// USING Binary Search

		int row = matrix.length;
		int col = matrix[0].length;

		int end = row * col - 1;
		int start = 0;

		int mid = start + (end - start) / 2;

		while (start <= end) {
			int element = matrix[mid / col][mid % col];

			if (element == target)
				return true;

			if (element < target) {
				start = mid + 1;

			} else {
				end = mid - 1;
			}
			mid = start + (end - start) / 2;
		}
		return false;
	}

}
