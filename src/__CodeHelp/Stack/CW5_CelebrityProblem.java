package __CodeHelp.Stack;

import java.util.Stack;

public class CW5_CelebrityProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int celebrity(int M[][], int n) {
		Stack<Integer> celebStack = new Stack<>();

		for (int i = 0; i < n; i++) {
			celebStack.push(i);
		}

		while (celebStack.size() != 1) {
			int first = celebStack.pop();
			int second = celebStack.pop();
			celebStack.push(M[first][second] == 1 ? second : first);

		}
		int temp = celebStack.pop();
		for (int i = 0; i < n; i++) {
			if (M[temp][i] == 1)
				return -1;
		}
		for (int i = 0; i < n; i++) {
			if (M[i][temp] == 0 && i != temp)
				return -1;
		}

		return temp;
	}
}
