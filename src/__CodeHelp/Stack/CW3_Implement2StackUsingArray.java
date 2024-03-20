package __CodeHelp.Stack;

import java.util.Arrays;
import java.util.stream.Stream;

public class CW3_Implement2StackUsingArray {

	public static void main(String[] args) {
		CoustomStack stack = new CoustomStack(5);
	    
	    stack.printStack();
	    stack.push1(10);
	    stack.push2(9);
	    stack.printStack();
       System.out.println(stack.peek1());
	}
	
}

class CoustomStack{
	
	int[] arrayStack ;
	int firstStackIndex;
	int secondStackIndex;
	
	void printStack() {
		Arrays.stream(arrayStack).forEach(i -> System.out.print(i + " ,"));
		System.out.println();
	}
	
	public CoustomStack(int n){
		this.arrayStack = new int[n];
		firstStackIndex=-1;
		secondStackIndex =n;
	}
	
	void push1(int i) {
		if (secondStackIndex - firstStackIndex ==1) {
			System.out.println("Overflow");
			return ;
		}
		firstStackIndex++;
		arrayStack[firstStackIndex] = i;
	}
	
	void push2(int i) {
		if (secondStackIndex - firstStackIndex ==1) {
			System.out.println("Overflow");
			return ;
		}
		secondStackIndex--;
		arrayStack[secondStackIndex] = i;
	}
	
	void pop1() {
		if ( firstStackIndex == -1) {
			System.out.println("UnderFlow");
			return ;
		}
		arrayStack[firstStackIndex] =0 ;
		firstStackIndex--;
	}
	

	void pop2() {
		if ( secondStackIndex == arrayStack.length) {
			System.out.println("UnderFlow");
			return ;
		}
		arrayStack[secondStackIndex] =0 ;
		secondStackIndex++;
	}
	
	int peek1() {
		if ( firstStackIndex == -1) {
			System.out.println("No Elements in First Stack");
			return -1;
		}
		return arrayStack[firstStackIndex];
	}
	
	int peek2() {
		if ( secondStackIndex == arrayStack.length) {
			System.out.println("No Elements in Second Stack");
			return -1;
		}
		return arrayStack[secondStackIndex];
	}
}