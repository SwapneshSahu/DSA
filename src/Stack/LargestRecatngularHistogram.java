package Stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRecatngularHistogram {
//LETCODE 84 IMP
	public static void main(String[] args) {
		int[] arr = new int[] { 2, 1, 5, 6, 2,3  };

		System.out.println("Array Before");
		Arrays.stream(arr).forEach(System.out::println);

		System.out.println("Largest Area is : " + largestRec(arr));

	}

	private static int largestRec(int[] arr) {
		int n = arr.length;
		int[] nextSmaller = nextSmallerIndex(arr.clone(), n);
		int[] prevSmaller = prevSmallerIndex(arr.clone(), n);

		int area = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int h = arr[i];
			if (nextSmaller[i] == -1) {
				nextSmaller[i] = n;
			}
			int b = nextSmaller[i] - prevSmaller[i] - 1;

			int newArea = h * b;
			area = Math.max(newArea, area);
		}

		return area;
	}

	private static int[] prevSmallerIndex(int[] arr, int n) {
		Stack<Integer> ss = new Stack<>();
		int [] ans = new int[n];

		for (int i = 0; i < n; i++) {
			int curr = arr[i];
			while (!ss.isEmpty() && arr[ss.peek()] >= curr) {
				ss.pop();
			}
			
			if (ss.isEmpty()) {
				ans[i] = -1;
			}else {
				ans[i]= ss.peek();
			}
			
			ss.push(i);

		}

		return ans;
	}

	private static int[] nextSmallerIndex(int[] arr, int n) {

		Stack<Integer> ss = new Stack<>();
		int [] ans = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			int curr = arr[i];
			while (!ss.isEmpty() && arr[ss.peek()] >=curr) {
				ss.pop();
			}
			if (ss.isEmpty()) {
				ans[i] = -1;
			}else {
				ans[i]= ss.peek();
			}
			
			ss.push(i);
		}

		return ans;
	}

}
