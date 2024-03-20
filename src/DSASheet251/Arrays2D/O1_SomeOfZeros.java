package DSASheet251.Arrays2D;

import java.util.ArrayList;

public class O1_SomeOfZeros {
/*Problem Statement**/
	// https://www.codingninjas.com/codestudio/problems/array-sum_893287?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//T(N*M)  S(1)
	public static Integer coverageOfMatrix(ArrayList<ArrayList<Integer>> mat) {

		int count = 0;

		for (int row = 0; row < mat.size(); row++) {
			for (int col = 0; col < mat.get(row).size(); col++) {

				if (mat.get(row).get(col) == 0) {
					// checkleft col --
					if (col - 1 >= 0 && mat.get(row).get(col - 1) == 1)
						count++;

					// checkright col ++
					if (col + 1 < mat.get(row).size() && mat.get(row).get(col + 1) == 1)
						count++;

					// checktop row --
					if (row - 1 >= 0 && mat.get(row - 1).get(col) == 1)
						count++;

					// checktop row ++
					if (row + 1 < mat.size() && mat.get(row + 1).get(col) == 1)
						count++;

				}
			}

		}
		return count;
	}

}
