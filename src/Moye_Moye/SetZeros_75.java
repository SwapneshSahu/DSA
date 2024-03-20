package Moye_Moye;

import java.util.HashSet;
import java.util.Set;

public class SetZeros_75 {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 0, 7, 8 }, { 0, 10, 11, 12 }, { 13, 14, 15, 0 } };

		setZeroesOp(matrix);
	}

	

	public static void setZeroesOp(int[][] matrix) {
	    // colZeroRow is used to track whether the first column itself should be zeroed out
	    int colZeroRow = 1;

	    // First Loop: Marking Rows and Columns
	    for (int i = 0; i < matrix.length; i++) {
	        // If the element in the first column is zero, set colZeroRow to 0
	        if (matrix[i][0] == 0) colZeroRow = 0;

	        // Start from j=1 to avoid modifying the first column in this loop
	        for (int j = 1; j < matrix[0].length; j++) {
	            // If the current element is zero, mark the corresponding row's first element
	            // and the first column's element as zero
	            if (matrix[i][j] == 0) {
	                matrix[i][0] = 0;
	                matrix[0][j] = 0;
	            }
	        }
	    }

	    // Second Loop: Filling Zeros Based on Markings
	    for (int i = matrix.length - 1; i >= 0; i--) {
	        // Start from the last column and move towards the first column
	        for (int j = matrix[0].length - 1; j >= 1; j--) {
	            // If either the corresponding element in the first column or the first row is zero,
	            // set the current element to zero
	            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
	                matrix[i][j] = 0;
	            }
	        }

	        // If colZeroRow is 0, set the first column of the current row to zero
	        if (colZeroRow == 0) matrix[i][0] = 0;
	    }
	}
/**
	First Loop (Marking Rows and Columns):

	The first loop iterates through each element in the matrix.
	If an element is zero, it marks the corresponding row's

	first element (matrix[i][0]) and the first column's element (matrix[0][j]) as zero to indicate that the entire row and column should be zeroed out later.
	colZeroRow is used to specifically track whether the first column itself should be zeroed out.
	Second

	Loop (Filling Zeros Based on Markings):

	The second loop starts from the bottom of the matrix and iterates upward.
	For each element in a row (excluding the first column), if either the corresponding element in the

	first column (matrix[i][0]) or the

	first row (matrix[0][j]) is zero, it sets the current element to zero.
	Additionally, if colZeroRow is zero, it means that the first column should be zeroed out, so the element in the first column of the

	current row (matrix[i][0]) is set to zero.
	This algorithm uses the first column and first row of the matrix to store information about whether a particular row or column should be zeroed out, and it efficiently performs this operation in-place without using additional space.
**/
	
	public static void setZeroes(int[][] matrix) {

		Set<Integer> zeroRows = new HashSet<>();
		Set<Integer> zeroCol = new HashSet<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == 0) {
					zeroRows.add(i);
					zeroCol.add(j);
				}
			}
		}

		for (int row : zeroRows) {
			for (int j = 0; j < matrix[0].length; j++) {

				matrix[row][j] = 0;

			}
		}

		for (int col : zeroCol) {
			for (int j = 0; j < matrix.length; j++) {

				matrix[j][col] = 0;
			}
		}
	}
}
