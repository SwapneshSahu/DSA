package Stack;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {

		System.out.print(checkValidString(
				"(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));

	}

	public static boolean checkValidString(String str) {

		Stack<Integer> ssOpen = new Stack<>();
		Stack<Integer> ssStar = new Stack<>();

		// Will have two stack one for open bracket one for star if we found close
		// bracket will check open stack first then star stack and if both the stack
		// empty return false.

		//This for loop only solve quetion for close bracket
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '*')
				ssStar.push(i);
			else if (ch == '(') {
				ssOpen.push(i);

			} else if (!ssOpen.isEmpty()) {
				ssOpen.pop();

			} else if (!ssStar.isEmpty())
				ssStar.pop();
			else {
				return false;
			}

		}
		// we dont need to check any other combination
		if (ssOpen.isEmpty() ) return true;
		
		// now Open stack is not empty that means each open stack index should come after star index 
		while(!ssOpen.isEmpty() && !ssStar.isEmpty()) {
			if (ssStar.peek() < ssOpen.peek()) return false;
			ssStar.pop();
			ssOpen.pop();
		}
		
		return ssOpen.isEmpty();

	}

}
