package Stack;

import java.util.Stack;

public class ValidParenthesis2 {

	//leetcode  2116
	public static void main(String[] args) {
		
		String str ="())()))()(()(((())(()()))))((((()())(())";
		String locker ="1011101100010001001011000000110010100101";
		
		//System.out.print(valid(str, locker));
		
		String haystack ="eshswapnesh" ;
				String needle ="pp";
				System.out.print(haystack.indexOf(needle));
				//haystack.contains(needle);
 
	}

	public static  boolean valid(String str, String locker) {
		
		if (str.length() <2) return false;

		Stack<Integer> stack = new Stack<>();


		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (ch == '(') {
				stack.push(i);
			
			} else if (!stack.isEmpty() && str.charAt(stack.peek()) == '(') {
				stack.pop();
				
			} else {
				stack.push(i);
			
			}
		}
		if (stack.isEmpty()) return true;

	
		while(!stack.isEmpty()) {
			
//			Agar open aya  to check kro us index ko badal skte hai k ni 
//			agar ni badal skte -> false 
//			agar badal skte hai  to use pop kro or next peek dekhta hai agr 
//			open hai to wapis pop kro
//			agr close hai to check kro us index ko badal skte hai k ni 
//			agar ni badal skte false
			if (str.charAt(stack.peek()) == '(') {
				if (locker.charAt(stack.peek()) == '1') return false;
				  stack.pop();
				if ( stack.peek() == '(') {
					stack.pop();
				} 
				else {
					if (locker.charAt(stack.peek()) == '1') return false;
					stack.pop();
				}
			}
//			Agar vo close hai to pop kro or next ko dekho agr badal skte hai to pop kro 
//			or nahi to false ;
			else {
				  stack.pop();
				if (locker.charAt(stack.peek()) == '1') return false;
				  stack.pop();
				
			}
		}
        return true;
	}

}
