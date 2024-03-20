package String_Char;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CountofSmallStringPermutation {

	public static void main(String[] args) {
		String s = "abab";
		String p = "ab";
		
		List<Integer>  list = findAnagrams(s, p);
		
		for (int l : list) System.out.println(l);
		
		
		
		
	}
	
	 public static List<Integer> findAnagrams(String s, String p) {
	      int []  pMap = new int [26];
	      int []  sMap =  new int [26];

	        //create pMap
	        for (int i =0 ; i <p.length() ;i++){
	            pMap[p.charAt(i) -'a']++;
	        }
	       List<Integer> listofIndex = new LinkedList<>();
	       for (int i =0 ; i <s.length() ;i++){
	              
	              if (i < p.length()){
	            	  sMap[s.charAt(i) -'a']++;
	                   continue;
	              }

	            if (checkAnagram(pMap,sMap)) listofIndex.add(i-p.length());
	            
	            sMap[s.charAt(i-p.length()) - 'a']-- ;
	            
	            sMap[s.charAt(i) - 'a']++ ;

	       }
	       if (checkAnagram(pMap,sMap)) listofIndex.add(s.length()-p.length());
	      return listofIndex;
	    }
	 
	 

	    public static boolean checkAnagram(  int []  pMap  , int [] sMap ){

	          for (int i =0 ; i <pMap.length ;i++){
	                
	                if (pMap[i] != sMap[i])return false;
	          }

	          return true;
	    }
}
