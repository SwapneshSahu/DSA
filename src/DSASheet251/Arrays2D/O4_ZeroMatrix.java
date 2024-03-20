package DSASheet251.Arrays2D;

public class O4_ZeroMatrix {
/**Problem link**/
	
// https://www.codingninjas.com/codestudio/problems/set-matrix-zeros_3846774?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=1
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * The time complexity of this algorithm is O(mn), where m and n are the
	 * dimensions of the input matrix, as the algorithm iterates over each element
	 * of the matrix twice, once to identify the rows and columns that need to be
	 * set to zero, and then again to actually set those elements to zero.
	 * 
	 * The space complexity of this algorithm is O(1), as it does not use any
	 * additional data structures or arrays to store information about the matrix.
	 * Instead, it uses the first row and first column of the matrix to keep track
	 * of which rows and columns need to be set to zero, and then iterates over the
	 * matrix to set those elements to zero in-place.
	 */
	public static void setZeros(int matrix[][]) {
		boolean firstRowZero = false;
		boolean firstColZero = false;

		// Check if first row needs to be set to zero
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				firstRowZero = true;
				break;
			}
		}

		// Check if first column needs to be set to zero
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstColZero = true;
				break;
			}
		}
		// we use first row and column as a marker
		// Use first row and first column to keep track of which rows and columns need
		// to be set to zero
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// now we itreate over 1st row and 1st column and make corresponding
		// column zero

		// Set rows to zero
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				setRowZeros(matrix, i);
			}
		}

		// Set columns to zero
		for (int i = 1; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				setColumnZeros(matrix, i);
			}
		}

		// Set first row to zero if necessary
		if (firstRowZero) {
			setRowZeros(matrix, 0);
		}

		// Set first column to zero if necessary
		if (firstColZero) {
			setColumnZeros(matrix, 0);
		}
	}

	public static void setRowZeros(int matrix[][], int row) {
		// Traverse the row and set each element to zero
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}

	public static void setColumnZeros(int matrix[][], int col) {
		// Traverse the column and set each element to zero
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

}
