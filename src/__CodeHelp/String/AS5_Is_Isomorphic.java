package __CodeHelp.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AS5_Is_Isomorphic {

	public static void main(String[] args) {
	
System.out.println(isIsomorphic("paper", "title"));
	}
	
	public static boolean isIsomorphic(String s, String t) {
	    char[]  mapping  = new char[26];
	    Arrays.fill(mapping,'0');
	    boolean []checkMapped = new boolean[26];
	        
	        for (int i =0 ;  i < s.length() ;i++){
	            
	        	int index = s.charAt(i)-'a';
	           if (mapping[index] == '0') {
	        	   if (!checkMapped[t.charAt(i)-'a']) {
	        		    mapping[index] = t.charAt(i);
	        		    checkMapped[t.charAt(i)-'a'] = true;
	        	   }else {
	        		   return false;
	        	   }
	           }
	           else {
	        	   if (mapping[index] != t.charAt(i)) return false;
	           }
	        }
	        return true;
	    }

}
