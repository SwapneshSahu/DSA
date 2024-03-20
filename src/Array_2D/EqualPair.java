package Array_2D;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EqualPair {
//leetcode 2352
	public static void main(String[] args) {
		int[][] grid = new int[][] { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } };

		//System.err.println(equalPairsOptimise(grid));

		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");

        // Format the current date according to the specified format
        String formattedDate = dateFormat.format(new Date());
		System.out.println(formattedDate);
	}
	
	//n^2
	public static int equalPairsOptimise(int[][] grid) {
		int n = grid.length;
	    int ans = 0;

	    // Map to store the count of each row pattern
	    Map<String, Integer> rowPatternCount = new HashMap<>();

	    // Iterate over each row to count row patterns
	    for (int i = 0; i < n; i++) {
	        StringBuilder rowPattern = new StringBuilder();
	        for (int j = 0; j < n; j++) {
	            rowPattern.append(grid[i][j]).append("_");
	        }
	        String pattern = rowPattern.toString();

	        // Update the count of the row pattern in the map
	        rowPatternCount.put(pattern, rowPatternCount.getOrDefault(pattern, 0) + 1);
	    }

	    // Iterate over each column to check for column patterns
	    for (int j = 0; j < n; j++) {
	        StringBuilder colPattern = new StringBuilder();
	        for (int i = 0; i < n; i++) {
	            colPattern.append(grid[i][j]).append("_");
	        }
	        String pattern = colPattern.toString();

	        // Check if the column pattern exists in the row pattern map
	        if (rowPatternCount.containsKey(pattern)) {
	            ans += rowPatternCount.get(pattern);
	        }
	    }

	    return ans;
	}

	//n^3
	public static int equalPairs(int[][] grid) {

		int[] rowArr = new int[grid.length];
		int[] colArr = new int[grid.length];

		// row col sum
		for (int i = 0; i < rowArr.length; i++) {
			int sumRow = 0;
			int sumCol = 0;
			for (int j = 0; j < rowArr.length; j++) {
				sumRow += grid[i][j];
				sumCol += grid[j][i];
			}

			rowArr[i] = sumRow;
			colArr[i] = sumCol;
		}
		int ans = 0;
		for (int i = 0; i < rowArr.length; i++) {
			for (int j = i; j < rowArr.length; j++) {

				if (rowArr[i] == colArr[j] && check(grid, i, j)) {
					ans++;
				}
			}

		}

		return ans;
	}

	public static boolean check(int[][] grid, int row, int col) {
		for (int i = 0; i < grid.length; i++) {

			if (grid[row][i] != grid[i][col]) {
				return false;
			}
		}
		return true;
	}

}
