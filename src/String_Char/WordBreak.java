package String_Char;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		 String  s = "leetcode" ;
		 List<String>  wordDict = new ArrayList<>();
		 wordDict.add("leet");
		 wordDict.add("code");
		 
		 System.out.println(wordBreak(s, wordDict));

	}

	
	static boolean flag ;
	    public static  boolean wordBreak(String s, List<String> wordDict) {
	         printSubsequencesHelper(wordDict , 0 , s,"");

	         return flag;
	    }


	    private  static void printSubsequencesHelper( List<String> wordDict , int index , String s ,String  current) {
	        //base case 
	    	System.out.println(current);
	    	
	    	 if (current.equals(s) ) {
	             flag = true;
	        }
	        if (index >= wordDict.size() || !s.contains(wordDict.get(index)) || flag ) {
	             return ;
	        } 

	       

	            // Recursive case 1: Include the first character in the current subsequence
	            printSubsequencesHelper(wordDict , index+1 , s, current + wordDict.get(index));

	            // Recursive case 2: Exclude the first character from the current subsequence
	            printSubsequencesHelper(wordDict , index+1 , s, current);

	    }
}
