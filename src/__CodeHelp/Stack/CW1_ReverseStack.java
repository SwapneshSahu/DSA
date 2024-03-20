package __CodeHelp.Stack;

import java.util.Stack;

public class CW1_ReverseStack {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		
		stack.add(10);
		stack.add(20);
		stack.add(30);
		stack.add(40);
		stack.add(50);

     System.out.println(stack.toString());
 
     stackReverse(stack);
     
     System.out.println(stack.toString());
     
	}

	private static void stackReverse(Stack<Integer> stack) {
		
		if (stack.isEmpty())return;
		
		//Pehla pop kr k rkh liya 
		int temp = stack.pop();
		
		//ab pura reverse hojai ga man lo
		stackReverse(stack);
		
		//now insert that element at the end 
		insertAtBottom(stack,temp);
		
		
	}

	private static void insertAtBottom(Stack<Integer> stack, int element) {
		
	if (stack.isEmpty()) {
	 
		stack.add(element);
		return;
	}
		
      int temp = stack.pop();
		
      insertAtBottom(stack,element);
      
      stack.push(temp);
		
	}

}
