package BackTracking;

import java.util.Arrays;

public class Sudoku {

	public static void main(String[] args) {
//		int [][] grid = new int[][] {{3,0,6,5,0,8,4,0,0},
//			{5,2,0,0,0,0,0,0,0},
//			{0,8,7,0,0,0,0,3,1,},
//			{0,0,3,0,1,0,0,8,0},
//			{9,0,0,8,6,3,0,0,5},
//			{0,5,0,0,9,0,6,0,0},
//			{1,3,0,0,0,0,2,5,0},
//			{0,0,0,0,0,0,0,7,4},
//			{0,0,5,2,0,6,3,0,0}} ;
//			
		int[][] grid = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 7, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 8, 0, 0, 0, 0, 0, 2, 0, 0, }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 3, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 9, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		long start = System.currentTimeMillis();
		SolveSudoku(grid);

		System.out.println(Arrays.deepToString(grid));
		long end = System.currentTimeMillis();

		System.out.println(end - start);
	}

	// Function to find a solved Sudoku.
	static boolean SolveSudoku(int grid[][]) {
		for (int i = 0; i < grid.length; i++) { // 2 loops to traverse along grid
			for (int j = 0; j < grid.length; j++) {

				if (grid[i][j] == 0) { // that means we have to fill number

					for (int val = 1; val < 10; val++) {

						if (isSafe(grid, val, i, j)) {
							grid[i][j] = val;
							boolean ageJaSakte = SolveSudoku(grid);
							if (ageJaSakte) {
								return true;
							} else {
								// backtrack
								grid[i][j] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	// Function to print grids of the Sudoku.
	static void printGrid(int grid[][]) {
		for (int i = 0; i < grid.length; i++) { // 2 loops to traverse along grid
			for (int j = 0; j < grid.length; j++) {

				System.out.print(grid[i][j] + " ");

			}

		}

	}

	static boolean isSafe(int grid[][], int val, int row, int col) {

		// check for row
		for (int i = 0; i < grid.length; i++) {
			if (grid[row][i] == val)
				return false;
		}

		// check for column
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][col] == val)
				return false;
		}

		// check in subset

		for (int i = 0; i < grid.length; i++) {
			int tempRow = 3 * (row / 3) + i / 3;
			int tempCol = 3 * (col / 3) + i % 3;
			if (grid[tempRow][tempCol] == val)
				return false;
		}

		return true;

	}

	/***
	 * The time complexity of the SolveSudoku function is O(9^(n*n)), where n is the
	 * size of the grid. This is because there are n*n empty cells that can be
	 * filled with 9 different numbers. The worst-case scenario is that all empty
	 * cells have to be filled with the numbers from 1 to 9, so the total number of
	 * possibilities is 9^(n*n).
	 * 
	 * The space complexity of the SolveSudoku function is O(n*n), which is the
	 * space taken by the grid.
	 * 
	 * The time complexity of the printGrid function is O(n*n), as it needs to
	 * traverse the entire grid.
	 * 
	 * The time complexity of the isSafe function is O(n), as it needs to traverse
	 * the entire row, column, and the 3x3 sub-grid to check for the presence of a
	 * value.
	 * 
	 * The space complexity of the isSafe function is O(1), as it only needs to
	 * store a few variables to check for the presence of a value.
	 * 
	 * Overall, the time complexity of the program is dominated by the SolveSudoku
	 * function, which is O(9^(n*n)). The space complexity of the program is O(n*n),
	 * which is the space required to store the grid.
	 ***/
}
