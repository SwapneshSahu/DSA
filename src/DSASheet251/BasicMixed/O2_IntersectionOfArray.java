package DSASheet251.BasicMixed;

import java.util.ArrayList;

public class O2_IntersectionOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2,
			int m) {
		int i = 0;
		int j = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		while (i < n && j < m) {
			if (arr1.get(i) == arr2.get(j)) {
				ans.add(arr1.get(i));
				i++;
				j++;
			} else if (arr1.get(i) > arr2.get(j)) {
				j++;
			} else {
				i++;
			}

		}

		return ans;
	}

}
