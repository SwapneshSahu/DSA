package Stack;

import java.util.Stack;

public class longestValidParenthesis {

	public static void main(String[] args) {
		String str ="())()))()(()(((()";
	
		System.out.print(longestValidParentheses(str));

	}
	public static int longestValidParentheses(String s) {
	    Stack<Integer> stack = new Stack<>();
	    int ans = 0;
	    int lastInvalid = -1;
	    for (int i = 0; i < s.length(); i++) {
	        char ch = s.charAt(i);
	        if (ch == '(') {
	            stack.push(i);
	        } else {
	            if (!stack.isEmpty()) {
	                stack.pop();
	                if (!stack.isEmpty()) {
	                    ans = Math.max(ans, i - stack.peek());
	                } else {
	                    ans = Math.max(ans, i - lastInvalid);
	                }
	            } else {
	                lastInvalid = i;
	            }
	        }
	    }
	    return ans;
	}
	
	/* public static int longestValidParentheses(String s) {

	        Stack <Character> stack =  new Stack<>();
	        int valid =0;
	        int ans =0;
	        for (int i = 0 ; i<s.length(); i++){
	            char  ch = s.charAt(i);
	            if (ch == '('){
	                stack.push(ch);
	               // valid =0;
	            }else if (!stack.isEmpty() && stack.peek() =='('){
	                stack.pop();
	                valid +=2 ;
	            }else{
	               stack.push(ch);
	             //  valid =0;
	            }
	            ans = Math.max(ans,valid);
	        } 
	       return ans; 
	    }*/

}
