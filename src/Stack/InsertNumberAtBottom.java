package Stack;

import java.util.Stack;

public class InsertNumberAtBottom {

	public static void main(String[] args) {
		Stack<Integer>  ss = new Stack<>();
		
		ss.push(5);
		ss.push(6);
		ss.push(7);
		ss.push(8);
		
		System.out.println("Stack Before Adding Number In bottom");
		System.out.println(ss.toString());

		
		System.out.println("Stack After Adding Number In bottom");
	    enterNumberAtBottom(ss,4);
	
		System.out.println(ss.toString());
	}

	

	public static void enterNumberAtBottom(Stack<Integer> ss , int num) {
		
		if (ss.isEmpty()) {
			ss.push(num);
			return ;
		}
		
		int temp = ss.pop();
		enterNumberAtBottom(ss, num);
		ss.push(temp);
		
	}
     
	
}
