package __CodeHelp.Stack;

import java.util.Stack;

public class CW11_MaxRectangle {

	public static void main(String[] args) {
		char [][] matrix =  new char[][] {

{'1','0','1','0','0'}, 
{'1','0','1','1','1'},
{'1','1','1','1','1'},
{'1','0','0','1','0'}
		};

		System.out.println(maximalRectangle(matrix));
	}

	public static int maximalRectangle(char[][] matrix) {
		// char to int
		int[][] arr = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				arr[i][j] = matrix[i][j] - '0';
			}
		}

		int maxArea = 0;
		int[] temp = new int[matrix[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {

				if (arr[i][j] == 0)
					temp[j] = 0;
				else {
					temp[j] += arr[i][j];
				}
			}
			int abc = calculateArea(temp);
			if (abc > maxArea)
				maxArea = abc;
		}
		return maxArea;
	}

	public static int calculateArea(int[] arr) {
		int[] right = largestElementToRight(arr);
		int[] left = largestElementToLeft(arr);
		int max = 0;
		for (int i = 0; i < right.length; i++) {
			int temp = (right[i] - left[i] - 1) * arr[i];
			if (temp > max) {
				max = temp;
			}
		}

		return max;
	}

	public static int[] largestElementToRight(int[] elements) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int[] ans = new int[elements.length];
		for (int i = elements.length - 1; i >= 0; i--) {

			while (stack.peek() != -1 && elements[stack.peek()] >= elements[i]) {
				stack.pop();
			}
			ans[i] = stack.peek();
			stack.push(i);
		}

		for (int i = ans.length - 1; i >= 0; i--) {
			if (ans[i] == -1) {
				ans[i] = ans.length;
			}
		}
		return ans;
	}

	public static int[] largestElementToLeft(int[] elements) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int[] ans = new int[elements.length];
		for (int i = 0; i < elements.length; i++) {

			while (stack.peek() != -1 && elements[stack.peek()] >= elements[i]) {
				stack.pop();
			}
			ans[i] = stack.peek();
			stack.push(i);
		}
		return ans;
	}
}
