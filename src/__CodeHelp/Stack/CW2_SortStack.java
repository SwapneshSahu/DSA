package __CodeHelp.Stack;

import java.util.Stack;

public class CW2_SortStack {

	public static void main(String[] args) {
	Stack<Integer> stack = new Stack<>();
	
		stack.add(50);
		stack.add(41);
		stack.add(30);
		stack.add(21);
		stack.add(10);
	
		
		

     System.out.println(stack.toString());
 
     sortStack(stack);
     
     System.out.println(stack.toString());
	}

	private static void sortStack(Stack<Integer> stack) {
		
		if (stack.empty())return;
		
		int temp = stack.pop();
		
		sortStack(stack);
		
		putAtCorrectPlace(stack,temp);
		
	}

	private static void putAtCorrectPlace(Stack<Integer> stack, int element) {
		
		if (stack.isEmpty() || stack.peek()<= element ) {
			stack.add(element);
			return;
		}
		
		int temp= stack.pop();
		
		putAtCorrectPlace(stack, element);
		
		stack.add(temp);
	}
	
	

}
