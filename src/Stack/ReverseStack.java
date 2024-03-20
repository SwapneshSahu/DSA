package Stack;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> ss = new Stack<>();
		ss.push(5);
		ss.push(6);
		ss.push(7);
		ss.push(8);

		System.out.println("Stack Before Reversing Number");
		System.out.println(ss.toString());

		System.out.println("Stack After Reversing Number");
        reverseStack(ss);
		System.out.println(ss.toString());

	}

	private static void reverseStack(Stack<Integer> ss) {
		if (ss.isEmpty()) {
			
			return ;
		}
		int temp = ss.pop();
		reverseStack(ss);
		InsertNumberAtBottom.enterNumberAtBottom(ss, temp);
		
		
	}
}
