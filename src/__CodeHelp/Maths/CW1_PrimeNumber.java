package __CodeHelp.Maths;

import java.util.ArrayList;
import java.util.List;

public class CW1_PrimeNumber {

	public static void main(String[] args) {
		
System.out.println(findPrime(10).toString());
	}
	
	public static List<Integer> findPrime(int n){
		
		List<Integer> setPrime = new ArrayList<>();
		
		for (int i =2 ; i < n ;i++) {
		    if (checkPrime(setPrime,i)) {
		    	setPrime.add(i);
		    }
			
		}
		return setPrime;
	}

	private static boolean checkPrime(List<Integer> setPrime, int n) {
		 if (n ==2) return true;
		 
		 for (int i =0 ; i < setPrime.size() && setPrime.get(i) <= Math.sqrt(n) ;i++) {
			  
			 if (n % setPrime.get(i) == 0) return false;
		 }
		return true;
	}

}
