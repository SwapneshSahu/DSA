package DSASheet251.TwoPointers;

public class O1_PairSum {
	/***Problem Link**/
// https://www.codingninjas.com/codestudio/problems/pair-sum_1171154?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=1
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int pairSum(int arr[], int n, int target) {
		int left = 0;
		int right = n - 1;
		int count = 0;
		while (left < right) {
			int ans = arr[left] + arr[right];

			if (ans == target) {
				count++;
				left++;
				right--;
			} else if (ans < target)
				left++;
			else {
				right--;
			}
		}

		return count != 0 ? count : -1;
	}
}
