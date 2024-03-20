package BackTracking;

import java.util.ArrayList;

public class NQueen {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		System.out.println((3.143/4)*14);
	//	ArrayList<ArrayList<Integer>> result = nQueen(17);
//		for (ArrayList<Integer> list : result) {
//		    System.out.println(list);
//		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

	static ArrayList<ArrayList<Integer>> nQueen(int n) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> ans = new ArrayList<>();

		int[][] grid = new int[n][n];
		helper(grid, result, ans, 0, n);
		return result;
	}

	public static void helper(int[][] grid, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> ans, int column,
			int n) {
		if (column == n) {
			result.add(new ArrayList<>(ans)); // add new ArrayList to store positions
			return;
		}

		for (int row = 0; row < n; row++) {
			if (isSafe(grid, row, column)) {
				grid[row][column] = 1;
				ans.add(row + 1); // add 1 to row to get 1-indexed position
				helper(grid, result, new ArrayList<>(ans), column + 1, n); // pass new ArrayList to recursive call
				grid[row][column] = 0; // backtracking
				ans.remove(ans.size() - 1); // removing last added value
			}
		}
	}
	
	public static boolean isSafe(int[][] grid, int row, int col) {
		int n = grid.length;

		// check rows
		for (int i = 0; i < col; i++) {
			if (grid[row][i] == 1) {
				return false;
			}
		}
		// column we dont need to check as we are adding from staring column

		// checking upward diagonal
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (grid[i][j] == 1) {
				return false;
			}
		}

		// checking downward direction
		for (int i = row, j = col; i < n && j >= 0; i++, j--) {
			if (grid[i][j] == 1) {
				return false;
			}
		}

		return true;

		// we can optimise this solution by using hasmaps here we have to go thorough n
		// column using hashmap can
		// reduce it to O(1)
	}

	/**
	 * Sure, here's a breakdown of the time and space complexity at each part of the
	 * code:
	 * 
	 * nQueen function:
	 * 
	 * Time complexity: O(N!) The algorithm generates all possible permutations of
	 * the N columns, and for each permutation, it checks if it is a valid solution
	 * by iterating over all N rows and checking if a queen can be placed in that
	 * row. Space complexity: O(N^2) The function uses a 2D grid of size N x N to
	 * represent the board and an ArrayList of size N to store the positions of the
	 * queens in each solution. The function also calls the helper function, which
	 * uses an ArrayList of size N for each level of the recursion. helper function:
	 * 
	 * Time complexity: O(N!) The function generates all possible permutations of
	 * the N columns, and for each permutation, it checks if it is a valid solution
	 * by iterating over all N rows and checking if a queen can be placed in that
	 * row. The function is called recursively for each valid column position, so
	 * the total time complexity is O(N!). Space complexity: O(N) The function uses
	 * an ArrayList of size N to store the positions of the queens at each level of
	 * the recursion. isSafe function:
	 * 
	 * Time complexity: O(N) The function checks if a queen can be placed in a given
	 * row and column position by iterating over all the previous columns and
	 * checking if there is a queen in the same row or diagonal. The maximum number
	 * of iterations is N, so the time complexity is O(N). Space complexity: O(1)
	 * The function uses a constant amount of space to store its variables. In
	 * summary, the time complexity of the algorithm is dominated by the nQueen and
	 * helper functions, which have a time complexity of O(N!), while the isSafe
	 * function has a time complexity of O(N). The space complexity is dominated by
	 * the size of the solutions ArrayList, which can contain up to N! solutions, so
	 * the space complexity of the algorithm is O(N! * N).
	 **/
}
