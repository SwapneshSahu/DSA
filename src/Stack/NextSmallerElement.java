package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 1, 4, 3 };

		System.out.println("Array Before");
		Arrays.stream(arr).forEach(System.out::println);

		System.out.println("Array After ");
		nextSmaller(arr);
		Arrays.stream(arr).forEach(System.out::println);
		
	}

	private static void nextSmaller(int[] arr) {

		Stack<Integer> ss = new Stack<>();
		ss.push(-1);

		for (int i = arr.length-1; i >= 0; i--) {
			int curr = arr[i];
			while (ss.peek() > curr) {
				ss.pop();
			}
			arr[i] =ss.peek();
			ss.push(curr);
			
		}
	}

}
