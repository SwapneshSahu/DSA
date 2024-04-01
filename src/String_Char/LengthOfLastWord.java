package String_Char;

public class LengthOfLastWord {

	//LT  58
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int lengthOfLastWord(String s) {
	      s = s.trim();
	      int i =s.length()-1;

	      while ( i >=0){
	            
	            if( s.charAt(i) == ' '){
	                return s.length()-1 - i;
	            } 
	            i--;
	      } 

	      return s.length();
	    }

}
