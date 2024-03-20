package Stack;

import java.util.Stack;

public class CelebrityProblem {

	/*
	 * A celebrity is a person who is known to all but does not know anyone at a
	 * party. If you go to a party of N people, find if there is a celebrity in the
	 * party or not. A square NxN matrix M[][] is used to represent people at the
	 * party such that if an element of row i and column j is set to 1 it means ith
	 * person knows jth person. Here M[i][i] will always be 0. Note: Follow 0 based
	 * indexing.
	 */
	public static void main(String[] args) {
		int[][] M = new int[][] { { 0, 1, 1, 1, 1 }
		                        , { 0, 0, 0, 0, 0 }, 
		                          { 0, 1, 0, 1, 1 }, 
		                          { 0, 0, 0, 0, 1 },
				                  { 0, 1, 1, 0, 0 } };

		System.out.println(celebrity(M, 5));

	}

	public static int celebrity(int M[][], int n) {
		Stack<Integer> ss = new Stack<>();

		// push all the candidate order is not mandatory
		for (int i = 0; i < n; i++) {
			ss.push(i);
		}
		// will keep running this loop until only 1 potential candidate is not left
		while (ss.size() > 1) {

			int a = ss.pop();
			int b = ss.pop();

			if (M[a][b] == 1) { // if a knows b defintely a is not celebrity
				ss.push(b);
			} else { // there will be no case where a dont know b as well as b dont know a because if
						// it happens it will break the rule of question celebrity is known by everyone
						// and celebrity know no one and there will be only 1 celeb in a party
				ss.push(a);
			}
		}

		int candidate = ss.peek();
		boolean rowCheck = true;
		// row check - all must be 0;
		for (int i = 0; i < n; i++) {
			if (M[candidate][i] != 0) {
				rowCheck = false;
				break;
			}
		}
		boolean columnCheck = true;
		// column check all must be 1 except candidate=i
		for (int i = 0; i < n; i++) {
			if (candidate != i && M[i][candidate] != 1) {
				columnCheck = false;
				break;
			}
		}
		if (columnCheck && rowCheck)
			return candidate;

		return -1;
	}

}
