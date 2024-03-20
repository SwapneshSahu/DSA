package Arrays;

import java.util.HashSet;

public class UnionOfArrays {

	public static void main(String[] args) {
		 int [] a = new int [] {-1, 2, -3, 4, 5, 6, -7, 8, 9};
			int [] b = new int []	{ 1, 2,  -4, -5, 2, -7, 3,
	            2, -6, -8, -9, 3, 2,  1 };
			
			System.out.println(doUnion(a,b));

	}
	
	 public static int doUnion(int a[], int b[]) 
	    {
	        HashSet<Integer> set = new HashSet<>();
	        
	       for (int i:a) set.add(i);
	       for (int i:b) set.add(i);
	     
	     
	     return set.size();
	       
	    }

}
