package Stack;

import java.util.Stack;

public class Patrern132 {

	public static void main(String[] args) {
		int arr[] = createArray();
		
		System.out.println(checkPatter(arr));

	}
	
	
	public static boolean checkPatter(int [] arr ) {
		if (arr.length < 3) return false;
		
		int [] minArr = new int [arr.length];
		
		minArr[0] = arr[0];
		for (int i = 1; i <arr.length ;i++) {
			minArr[i] = Math.min(arr[i], minArr[i-1]);
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = arr.length-1 ; i >=0 ;i--) {
			int currNum = arr[i]; //arr[k]
			int currMin = minArr[i]; // arr[i]
			
			if (currNum > currMin) {  //we statisfied arr[i] < arr[k]
				
				while (!stack.isEmpty() && stack.peek() <= currMin) {
					stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() < currNum) {
//					System.out.println("i " + currMin  + " k " + stack.peek()  + " j " + currNum );
//					stack.pop();
					return true;
					  // //we statisfied arr[k] < arr[j]
				}
				
			}
			
			stack.push(currNum);
		}
		
		return false;
	}

	private static int[] createArray() {
		int [] arr = new int[] {26,16,36,36,10,6};
		return arr;
	}

}
