package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		System.out.println(getRow(11));
	}
	
	 public static List<Integer> getRow(int rowIndex) {
         
		 List<Integer> ans = new ArrayList<Integer>(); ;
         if (rowIndex == 1) {
        	 
        	 ans.add(1);
        	 return ans;
         }
       
        	 ans.add(1);
        	 ans.add(1);
        	
         for (int i = 3 ; i <=rowIndex ; i++) {
        	 List<Integer> temp = new ArrayList<>();
        	 temp.add(1);
        	 for (int j =0 ; j<ans.size()-1 ;j++) {
        		 temp.add(ans.get(j) + ans.get(j+1));
        	 }
        	 temp.add(1);
        	 ans  = new ArrayList<Integer>(temp); 
         }
         
         return ans;
        
    }

}
