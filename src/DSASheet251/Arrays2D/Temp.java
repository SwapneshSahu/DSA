package DSASheet251.Arrays2D;

import java.util.Arrays;

public class Temp {
	
	public static void main(String[] args) {
        int[][] matrix = new int[50][50];

        // fill the matrix with random values between 1 to 100
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 100) + 1;
            }
        }

        // print the matrix in the specified format
        System.out.print("[");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(Arrays.toString(matrix[i]));
            if (i != matrix.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

}
