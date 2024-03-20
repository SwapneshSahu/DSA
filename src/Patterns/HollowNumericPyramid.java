package Patterns;

public class HollowNumericPyramid {

	public static void main(String[] args) {
		
		int n =5 ; 
		
		for (int row = 0 ; row <n ; row++) {
			
			//space 
			for (int col =0 ; col <n-row-1 ;col++) {
				System.out.print(" ");
			}
			
			//number
			if (row < n-1) {
			for (int col =0 ; col <2*row+1 ;col++) {
				if (col==0)System.out.print("1");
				else
				if (col == 2*row) System.out.print(row+1);
				else
				if (row == n-1) System.out.print(col+1);
				else {
					System.out.print(" ");
				}
			}
			}else {
				for (int col =0 ; col < n ;col++) {
					 System.out.print(col+1 + " ");
					
				}
			}
			
			
			System.out.println();
		}
		
	}
}
