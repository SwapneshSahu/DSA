package Array_2D;

public class Search_Matrix2 {
//	240. Search a 2D Matrix II
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30} };

		System.out.println(searchMatrix(matrix, 5));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		int startRow = 0;
		int startCol = matrix[0].length - 1;

		while (startRow < matrix.length && startCol >= 0) {
			int element = matrix[startRow][startCol];

			if (element == target)
				return true;

			if (element < target)
				startRow++;
			else {
					startCol--;
			}

		}
		return false;
	}

}
