package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextHighestTemprature {

	public static void main(String[] args) {
		int [] temp = new int[] {73,74,75,71,69,72,76,73};
		int [] ans = dailyTemperatures(temp);
		
		List<Integer> list = new ArrayList<>();
		list.sort((a,b) -> b-a);
		
	
		System.out.println((dailyTemperatures(temp)).toArray().toString());
	}

	 public static int[] dailyTemperatures(int[] temp) {
		 int [] ans = new int [temp.length] ;
		 Stack<Integer> stack = new Stack<>();
		 
		 for(int i =0 ; i <temp.length ;i++) {
			 
			 while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
				  int idx = stack.pop();
				  
				  ans[idx] = i -idx;
			 }
			 
			 stack.push(i);
		 }
		return ans;
		 
	 }
}



