package __CodeHelp.Stack;

import java.util.*;

import __CodeHelp.Stack.StudyBannerDetail.StudyStatusEnum;

public class CW4_NextSmallerElement {

	public static void main(String[] args) {
		
		Map<StudyBannerDetail.StudyStatusEnum, Long> vendorQcMap = new  EnumMap<>(StudyBannerDetail.StudyStatusEnum.class);
	//	getOrDefault
		vendorQcMap.put(StudyStatusEnum.CA_ASSIGNED ,100L);

	
		 System.out.println(vendorQcMap.getOrDefault(StudyStatusEnum.CA_COMPLETED ,0L)/10);  
		 
		
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(3);
		ans.add(4);
		ans.add(1);
		ans.add(3);
		ans.add(6);
		ans.add(4);
		
		ArrayList<Integer> res = nextSmallerElement(ans,ans.size());
		
		for (int i  : res) {
			System.out.println(i);
		}
		
	}

	static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {

		int[] resultArray = new int[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);

		for (int i = n - 1; i >= 0; i--) {

			while (stack.peek() >= arr.get(i)) {
				stack.pop();
			}
			resultArray[i] = stack.peek();
			stack.push(arr.get(i));
		}

		ArrayList<Integer> ans = new ArrayList<>();
		for (int value : resultArray) {
			ans.add(value);
		}
		return ans;
	}
}
