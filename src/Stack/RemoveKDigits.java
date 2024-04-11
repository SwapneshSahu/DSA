package Stack;

import java.util.Stack;

public class RemoveKDigits {

	public static void main(String[] args) {
		String num= "1432219";
		
		System.out.println(removeKdigits(num, 3));

	}
	
	public static String removeKdigits(String num, int k) {
		Stack<Integer> stack = new Stack<>();
	       
	       for(int i =0 ; i< num.length() ;i++){
	            int temp = num.charAt(i) - '0';
	            while (!stack.isEmpty() && stack.peek() > temp && k >0){
	                   stack.pop();
	                   k--;
	            }
	            if (!stack.isEmpty() ){
	                stack.push(temp);
	            }else if(num.charAt(i) != '0'){
	                stack.push(temp);
	            }
	       }
	        while(!stack.isEmpty() && k > 0){
	            stack.pop();
	            k--;
	       }
	       StringBuilder sb = new StringBuilder();
	       while(!stack.isEmpty()){
	            sb.append(String.valueOf(stack.pop()));
	       }

	     return sb.length() == 0 ? "0" : sb.reverse().toString() ;
	    }

}
