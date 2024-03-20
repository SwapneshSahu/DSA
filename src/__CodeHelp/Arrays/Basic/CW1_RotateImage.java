package __CodeHelp.Arrays.Basic;

public class CW1_RotateImage {

	public static void main(String[] args) {
		//int[][] exampleMatrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] exampleMatrix = {
		    {1, 2, 3, 4, 5, 6, 7, 8, 9},
		    {10, 11, 12, 13, 14, 15, 16, 17, 18},
		    {19, 20, 21, 22, 23, 24, 25, 26, 27},
		    {28, 29, 30, 31, 32, 33, 34, 35, 36},
		    {37, 38, 39, 40, 41, 42, 43, 44, 45},
		    {46, 47, 48, 49, 50, 51, 52, 53, 54},
		    {55, 56, 57, 58, 59, 60, 61, 62, 63},
		    {64, 65, 66, 67, 68, 69, 70, 71, 72},
		    {73, 74, 75, 76, 77, 78, 79, 80, 81}
		};

		System.out.println("Original Matrix");
		printMatrix(exampleMatrix);
		rotate(exampleMatrix);

	}

	// T(M*N)
	public static void rotate(int[][] matrix) {

		// First transpose interchange swap(matrix [row][col] ,matrix [col],[row])

		int row = matrix.length;
		int col = matrix[0].length;

		for (int r = 0; r < row; r++) {
			for (int c = r; c < col; c++) { //starting from c=r because if we start from c=0 
				                           //we will swap twice and we get the original matrix again

				int temp = matrix[r][c];
				matrix[r][c] = matrix[c][r];
				matrix[c][r] = temp;
			}
		}
		System.out.println("Matrix after Transpose ");
		printMatrix(matrix);
		
		//now we reverse each row 
		
		for (int r = 0; r < row; r++) {
			for (int c =0 ;  c < col/2 ;c++) { // col/2  to avoid swap twice and we get the original matrix again
				int temp =  matrix[r][c];
				matrix[r][c] = matrix[r][col-c-1]; //-1 to get 0 based indexing
				matrix[r][col-c-1]=temp;
			}
		}
		System.out.println("Matrix after Reverse ");
		printMatrix(matrix);
		

	}

	public static void printMatrix(int[][] matrix) {
		int numRows = matrix.length;
		int numCols = matrix[0].length;

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(); // Move to the next line after printing each row
		}
	}

}
