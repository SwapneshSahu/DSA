package Patterns;

public class FancyPattern {
	public static void main(String[] args) {
		
		int n =5;
		
		for (int row =0 ; row < n ;row++ ) {
			//Stars
			for (int col =0 ; col <n+3-row ;col++) {
				System.out.print("*");
			}
			//Number 
			for (int col =0 ; col <row+1 ;col++) {
				System.out.print(row+1);
				if (col !=row )System.out.print("*");
			}
			
			//Stars
			for (int col =0 ; col <n+3-row ;col++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
