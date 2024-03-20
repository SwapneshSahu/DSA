package Array_2D;

import java.util.ArrayList;
import java.util.List;

public class SpiralPrint {
//54. Spiral Matrix
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		
		System.out.println(spiralOrder(matrix).toString());

	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		int row = matrix.length;
		int col = matrix[0].length;

		int startRow = 0;
		int endRow = row - 1;
		int startCol = 0;
		int endCol = col - 1;

		int count = 0;
		int total = row * col;

		while (count < total) {

			// Starting Col to End Col for stating row

			for (int index = startCol; count < total && index <= endCol; index++) {
				ans.add(matrix[startRow][index]);
				count++;
			}
			startRow++;

			// StaringROw to endRow for end column

			for (int index = startRow; count < total && index <= endRow; index++) {
				ans.add(matrix[index][endCol]);
				count++;
			}
			endCol--;

			// Endcol to startcol for endRow

			for (int index = endCol; count < total && index >= startCol; index--) {
				ans.add(matrix[endRow][index]);
				count++;
			}
			endRow--;

			// End Row to Start row for startCOlum

			for (int index = endRow; count < total && index >= startRow; index--) {
				ans.add(matrix[index][startCol]);
				count++;
			}
			startCol++;

		}
		return ans;

	}

}
