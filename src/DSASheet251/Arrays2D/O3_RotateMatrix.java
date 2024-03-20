package DSASheet251.Arrays2D;

import java.util.Arrays;

public class O3_RotateMatrix {
	/**Problem Link*/
	
	// https://www.codingninjas.com/codestudio/problems/inplace-rotate-matrix-90-degree_839734?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=1
	public static void main(String[] args) {
		int [][] arr = new int [][] {{1,2,3},{4,5,6},{7,8,9}};
		
		System.out.println(Arrays.deepToString(arr));
		inplaceRotate(arr, 0);
		System.out.println(Arrays.deepToString(arr));

	}
	
	public static void inplaceRotate(int[][] arr, int n) {
		rotateColumnToRow(arr,0,0);
		System.out.println(Arrays.deepToString(arr));
		rotateColumn(arr,0);
	}

	//rotate column 

 public static void rotateColumnToRow(int[][] matrix , int row , int col) {
       //base case

       if (row == matrix.length && col == matrix[0].length ) return;
       
        int i = row;
        int j = col;

        while(i < matrix.length-1 &&   j <matrix[0].length-1 ){
            int temp = matrix[i+1][col];
			matrix[i+1][col] = matrix[row][j+1] ;
			matrix[row][j+1] = temp;
            i++;
            j++;
        }   
   
        rotateColumnToRow(matrix, row+1, col+1);
    }

	public static void rotateColumn( int[][] matrix , int col){
          //base case
		  if (col == matrix.length) return ;
		for (int i =0 ; i <matrix.length/2 ; i++){
			int temp = matrix[i][col];
			matrix[i][col] = matrix[matrix.length - i-1][col];
			matrix[matrix.length - i-1][col] = temp;
		}
		rotateColumn(matrix ,col+1);
	}

}
