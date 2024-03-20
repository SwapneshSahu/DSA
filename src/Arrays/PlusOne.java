package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {

	public static void main(String[] args) {
		
		int[] digits = new int [] {9,8,9};
		
		int[] ans = plusOne(digits);
		 for(int i = 0;i<ans.length ;i++ ){
		      
			 System.out.print(ans[i]+ " ,");

	        }
				
	}

	 public static int[] plusOne(int[] digits) {
		 int n = digits.length;
		    for(int i=n-1; i>=0; i--) {
		        if(digits[i] < 9) {
		            digits[i]++;
		            return digits;
		        }
		        
		        digits[i] = 0;
		    }
		    
		    int[] newNumber = new int [n+1];
		    newNumber[0] = 1;
		    
		    return newNumber;
	    }

}
