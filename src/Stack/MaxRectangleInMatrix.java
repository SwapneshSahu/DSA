package Stack;

import java.util.Stack;

public class MaxRectangleInMatrix {

	public static void main(String[] args) {
		int[][] M = new int[][]  {{0 ,1, 1, 0},
	                              {1 ,1 ,1 ,1},
	                              {1 ,1 ,1 ,1},
	                              {1 ,1 ,0 ,0}};
	           
   System.out.println(rectangle(M));
	}
	
	public static int rectangle(int[][] M) {
		int len = M.length;
		int [] arr = new int[len];
		//Step 1 Will slice it down the rows from top to bottom one by one then will find largest area of histogram
		int area = Integer.MIN_VALUE;
		for (int i=0 ; i<len ;i++) {
			for (int j=0 ; j<len ;j++) {
				if (M[i][j] == 0) {
					arr[j] = 0;
				}else {
					arr[j] += M[i][j]; 
				}
			}
			area = Math.max(area, largestAreaOfHistogram(arr));
			
		}
	
		return area;
		
	}

	private static int largestAreaOfHistogram(int[] arr) {
		
		int [] nextSmaller = nextSmallerElement(arr.clone());
		int [] prevSmaller = prevSmallerElement(arr.clone());
		int area = Integer.MIN_VALUE;
		for (int i = 0 ; i < arr.length ;i++) {
			int h = arr[i];
			
			while(nextSmaller[i] ==-1) {
				nextSmaller[i]= arr.length;
			}
			int b = nextSmaller[i] - prevSmaller[i] -1;
			area = Math.max(area, h*b);
			
		}
		return area;
	}

	private static int[] prevSmallerElement(int[] clone) {
		Stack<Integer> ss = new Stack<>();
		int []ans = new int [clone.length];
		for (int i = 0 ; i <clone.length ;i++) {
			int curr = clone[i];
			while(!ss.isEmpty()&& clone[ss.peek()] >= curr) {
				ss.pop();
			}
			if (ss.isEmpty()) {
				ans[i] =-1;
			}else {
				ans[i] = ss.peek();
			}
			ss.push(i);
		}
		return ans;
	}

	private static int[] nextSmallerElement(int[] clone) {
		Stack<Integer> ss = new Stack<>();
		int []ans = new int [clone.length];
		for (int i = clone.length-1 ; i >=0 ;i--) {
			int curr = clone[i];
			while(!ss.isEmpty()&& clone[ss.peek()] >= curr) {
				ss.pop();
			}
			if (ss.isEmpty()) {
				ans[i] =-1;
			}else {
				ans[i] = ss.peek();
			}
			ss.push(i);
		}
		return ans;
	}

	
	
}
