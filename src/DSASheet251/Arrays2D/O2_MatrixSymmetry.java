package DSASheet251.Arrays2D;

public class O2_MatrixSymmetry {
/**Problem Link*/
	//https://www.codingninjas.com/codestudio/problems/matrix-is-symmetric_799361?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=0
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isMatrixSymmetric(int[][] matrix) {

		return isSymmetric(matrix, 0, 0);
	}

//	T(N*M) S(1)
	public static boolean isSymmetric(int[][] matrix, int row, int col) {
		// base case

		if (row == matrix.length - 1 && col == matrix[0].length - 1)
			return true;

		int i = row;
		int j = col;

		while (i < matrix.length - 1 && j < matrix[0].length - 1) {
			if (matrix[i + 1][col] != matrix[row][j + 1])
				return false;
			i++;
			j++;
		}

		return isSymmetric(matrix, row + 1, col + 1);
	}

}
