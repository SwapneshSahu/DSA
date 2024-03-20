package Arrays;

import java.util.HashMap;
import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {

	public static void main(String[] args) {
		String[] tokens = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		//String[] tokens = new String[]{"4","-2","/","2","-3","-","-"};
	int i = evalRPN(tokens);
	System.out.println(i);
		
	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		stack.add(0);
		for (int i = 0; i < tokens.length; i++) {
			int temp = 0;
			if (tokens[i].equals("+")) {
				temp = stack.pop();
				stack.add(stack.pop() + temp);
			} else if (tokens[i].equals("-")) {
				temp = stack.pop();
				stack.add(stack.pop() - temp);

			} else if (tokens[i].equals("*")) {
				temp = stack.pop();
				stack.add(stack.pop() * temp);

			} else if (tokens[i].equals("/")) {
				temp = stack.pop();
				int div = stack.pop() / temp;
				
				stack.add(div);
			}
			else {
				stack.add(Integer.parseInt(tokens[i]));
			}
		}

		return stack.peek();
	}
}
