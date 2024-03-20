package __CodeHelp.Arrays.BinarySearch.SearchSpace;

public class AS1_BookAllocation {
// Coding Ninja   https://www.codingninjas.com/studio/problems/allocate-books_1090540?leftPanelTab=1
	public static void main(String[] args) {
		int[] A = new int[] { 13, 31, 37, 45, 46, 54, 55, 63, 73, 84, 85 };

		System.out.println(findPages(A, 11, 9));
	}

	// Function to find minimum number of pages.
	public static int findPages(int[] A, int N, int M) {
		if (N < M)
			return -1;

		int totalBook = 0;
		for (int i : A) {
			totalBook += i;
		}

		int low = 0;
		int high = totalBook;
		int ans = -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (allocationPossible(mid, A, M)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static boolean allocationPossible(int sol, int[] A, int M) {
		int student = 1;
		int currSum = 0;

		for (int i = 0; i < A.length && student <= M; i++) {
			if (A[i] > sol)
				return false; // Imp if index value is greater then current solution their is no point in
								// checking further we will not able to allocate in this way S
			if (currSum + A[i] <= sol) {
				currSum += A[i];
			} else {
				currSum = A[i];
				student++;
			}
		}

		return student <= M;

	}

}
