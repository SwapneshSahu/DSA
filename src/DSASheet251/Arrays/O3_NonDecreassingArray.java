package DSASheet251.Arrays;

public class O3_NonDecreassingArray {
	/**Problem link */ 
// https://www.codingninjas.com/codestudio/problems/non-decreasing-array_699920?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube	
	public static void main(String[] args) {
		int[] arr = new int[] { 62, -70, -54, -47, -10, 7, 20, 23, 39, 62 };

		System.out.println(isPossible(arr, arr.length));
	}

	// T(N ) S(1)
	public static boolean isPossible(int[] arr, int n) {

		int count = 0;
		int prev = Integer.MIN_VALUE;

		for (int i = 1; i < n; i++) {
			if (arr[i - 1] > arr[i]) {
				count++;
				if (count > 1)
					return false;

				if (prev > arr[i]) { // for input like -77 -57 -54 -41 2 212 -157 34 68
					arr[i] = arr[i - 1];
				} else { // for input like 62, -70, -54, -47, -10, 7, 20, 23, 39, 62
					arr[i - 1] = arr[i];
				}

			}
			prev = arr[i - 1];
			if (count == 2)
				return false;

		}
		return true;
	}

}
