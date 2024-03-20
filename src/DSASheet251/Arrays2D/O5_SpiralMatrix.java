package DSASheet251.Arrays2D;

public class O5_SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void spiralPrint(int matrix[][]) {
		if (matrix.length == 0)
			return;
		int row = matrix.length;
		int col = matrix[0].length;

		int startRow = 0;
		int endRow = row - 1;

		int startCol = 0;
		int endCol = col - 1;

		int total = row * col;
		int count = 0;

		while (count < total) {

			// left to right start col to end col in start row

			for (int i = startCol; i <= endCol && count < total; i++) {
				count++;
				System.out.print(matrix[startRow][i] + " ");
			}
			startRow++;

			// top to bottom start row to end row in end col

			for (int i = startRow; i <= endRow && count < total; i++) {
				count++;
				System.out.print(matrix[i][endCol] + " ");
			}
			endCol--;

			// right to left endCol to start col in end row

			for (int i = endCol; i >= startCol && count < total; i--) {
				count++;
				System.out.print(matrix[endRow][i] + " ");
			}
			endRow--;

			// bottom to up endrow to startrow in start colum

			for (int i = endRow; i >= startRow && count < total; i--) {
				count++;
				System.out.print(matrix[i][startCol] + " ");
			}
			startCol++;

		}

	}

}
