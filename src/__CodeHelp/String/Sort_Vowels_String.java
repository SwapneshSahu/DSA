package __CodeHelp.String;

import java.util.PriorityQueue;

public class Sort_Vowels_String {

	public static void main(String[] args) {
		System.out.println(PatientStudyStatus.AWAITING_DOCUMENTS.label);

	}

	public static String sortVowels(String s) {
	     PriorityQueue<Character> charPriorityQueue = new PriorityQueue<>();

	     char [] sChar = s.toCharArray();
	     
	     for (int i =0 ; i <sChar.length ;i++) {
	    	   
	    	 if (isVowel(sChar[i])) {
	    		 charPriorityQueue.add( sChar[i]);
	    		 sChar[i] = '@';
	    	 }
	     }
	     
	     for (int i =0 ; i <sChar.length ;i++) {
	    	   
	    	 if (sChar[i] == '@') {
	    		 
	    		 sChar[i] = charPriorityQueue.poll();
	    	 }
	     }
	     
	     StringBuilder sb = new StringBuilder();
	     for (char ch  :sChar) {
	    	 sb.append(ch);
	     }
	     
	   return sb.toString();
	    }

	public  static boolean isVowel(char c) {
	   
		if (c == 'a' || 
				c == 'e' ||
				c == 'i' ||
				c == 'o' ||
				c == 'u' ||
				c == 'A' ||
				c == 'E' ||
				c == 'I' ||
				c == 'O' ||
				c == 'U' ) {
			
		return true;
		}
		
		return false;
	}

}
