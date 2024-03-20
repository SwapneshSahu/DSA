package DSASheet251.String;

import java.util.LinkedList;
import java.util.Queue;

public class O3_Parentheses {
/*Problem link*/
	// https://www.codingninjas.com/codestudio/problems/mnfrj_1075018?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=1
	public static void main(String[] args) {

	}
    //t(N)  S(1)
	public static int minimumParenthesesWithNoSpace(String pattern) {

		int open = 0;
		int close = 0;
		for (int i = 0; i < pattern.length(); i++) {

			char ch = pattern.charAt(i);

			if (ch == '(') {
				open++;
			} else {
				if (open > 0)
					open--;
				else {
					close++;
				}

			}

		}
		return open + close;
	}

	  //t(N)  S(N)
	public static int minimumParenthesesWithExtraSpace(String pattern) {

		Queue<Character> que = new LinkedList<Character>();
		int count = 0;
		for (int i = 0; i < pattern.length(); i++) {

			char ch = pattern.charAt(i);

			if (ch == ')') {
				if (que.isEmpty() || que.peek() != '(') {
					count++;
				} else {
					que.poll();
				}

			} else {
				que.add(ch);
			}

		}
		return count + que.size();
	}
}
