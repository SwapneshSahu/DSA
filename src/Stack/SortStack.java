package Stack;

import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> ss = new Stack<>();
		ss.push(5);
		ss.push(-6);
		ss.push(17);
		ss.push(-8);

		System.out.println("Stack Before Reversing Number");
		System.out.println(ss.toString());

		System.out.println("Stack After Reversing Number");
		sortStack(ss);
		System.out.println(ss.toString());
	}

	public static void sortStack(Stack<Integer> ss) {
		if (ss.isEmpty()) {
			return;
		}

		int temp = ss.pop();
		sortStack(ss);
		sortedOrder(ss, temp);
	}

	public static void sortedOrder(Stack<Integer> ss, int element) {
		if (ss.isEmpty() || ss.peek() <= element) {
			ss.push(element);
			return;
		}
		
			int store = ss.pop();
			sortedOrder(ss, element);
			ss.push(store);
		
	}

}
