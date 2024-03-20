package String_Char;

import java.util.Stack;

public class ValidParenthesis {
 //20. Valid Parentheses
	public static void main(String[] args) {
		String s = "(((}}{}{(}){(}{)}({)}}";
		System.out.println(isValid(s));

	}

	public static boolean isValid(String s) {
		
		Stack<Character> que = new Stack<>();

		int i = 0;
		while (i < s.length()) {
			char cc = s.charAt(i);
			// We add All open Bracket
			if (cc == '(' || cc == '{' || cc == '[') {
				que.add(cc);
			} else {
				if (!que.isEmpty()) { // To check if we dont have any open bracket and we come to a point having close
										// bracket then it is a False scenario
					char openBracket = que.pop();
					if (cc == ')' && openBracket != '(' || cc == '}' && openBracket != '{'
							|| cc == ']' && openBracket != '[') {
						return false;
					}
				} else {
					return false;
				}
			}
			i++;
		}
		if (que.isEmpty()) // At the end stack should be empty then only we can say we have all the valid
							// parenthesis
			return true;

		return false;
	}
}
