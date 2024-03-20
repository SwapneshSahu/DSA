package __CodeHelp.Stack;

import java.util.Stack;

import DSASheet251.String.O1_ReverseString;

public class CW9_DecodeString {

	public static void main(String[] args) {  
		String s = "31[a]2[bc]";
		
System.out.println(decodeString(s));
	}

	public static String decodeString(String s) {
		 String ans ="";
	        Stack<String> stack = new Stack<>();

	        for (int i =0 ;i <s.length() ;i++){
	              
	              String currS =String.valueOf(s.charAt(i));
	              
	              if (currS.equals("]")) {
	            	    
	            	  String temp ="";
	            	  while (!stack.peek().equals("[")) {
	            		  temp = stack.pop()+temp;
	            	  }
	            	  stack.pop();
	            	  
	            	  String countString ="";
	            	  
	            	  while(!stack.empty()  && isNumber(stack.peek())) {
	            		  countString +=  stack.pop();
	            	  }
	            	  
	            	  int count = reverseString(countString);
	            	  System.out.println(count);
	            	  String temp2 ="";
	            	  while(count!=0) {
	            		  temp2 +=temp;
	            		  count--;
	            	  }
	            	 
	            	  currS = temp2;
	              }
	            	  stack.push(currS); 
    
	        }
	        String sb  = "";
	        
	        while(!stack.isEmpty()) {
	        	sb = stack.pop() + sb;
	        }
			return sb;
	}
	
	static int reverseString(String ss) {
		StringBuilder sb = new StringBuilder();
		for (int i = ss.length() - 1; i >= 0; i--) {
			sb.append(ss.charAt(i));
			
		}
		return Integer.parseInt( sb.toString());
	}

	private static boolean isNumber(String str) {
		if (str == null || str.isEmpty()) {
            return false;
        }

        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
	}

}
