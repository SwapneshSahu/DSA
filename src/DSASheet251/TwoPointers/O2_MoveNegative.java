package DSASheet251.TwoPointers;

public class O2_MoveNegative {

	/**Pron=blemLink**/
	// https://www.codingninjas.com/codestudio/problems/move-all-negative-numbers-to-beginning-and-positive-to-end_1112620?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=1
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] separateNegativeAndPositive(int a[]) {
		int pos = 0;
		int neg = a.length - 1;

		while (pos < neg) {

			while (a[pos] < 0 && pos < neg)
				pos++;
			while (a[neg] > 0 && pos < neg)
				neg--;

			// will swap now
			int temp = a[pos];
			a[pos] = a[neg];
			a[neg] = temp;

		}
		return a;
	}

}
