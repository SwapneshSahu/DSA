package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FindArraySum {

	public static void main(String[] args) {
		int[] a = new int[] { 8, 5, 3, 9 };
		int[] b = new int[] { 3, 3, 4 };
		int[] ans = findArraySum(a, 4, b, 3);

		for (int i : ans)
			System.out.print(i);

	}

	public static int[] findArraySum(int[] a, int n, int[] b, int m) {
		ArrayList<Integer> ll = new ArrayList<>();
		int carry = 0;
		int i = n - 1;
		int j = m - 1;

		while (i >= 0 && j >= 0) {
			int ans = a[i--] + b[j--] + carry;
			if (ans < 10) {
				ll.add(ans);
				carry = 0;
			} else {
				carry = ans / 10;
				ll.add(ans % 10);

			}
		}
		while (i >= 0) {
			int ans = a[i--] + carry;
			if (ans < 10) {
				ll.add(ans);
				carry = 0;
			} else {
				carry = ans / 10;
				ll.add(ans % 10);

			}

		}
		while (j >= 0) {
			int ans = b[j--] + carry;
			if (ans < 10) {
				ll.add(ans);
				carry = 0;
			} else {
				carry = ans / 10;
				ll.add(ans % 10);

			}
		}

		if (carry > 0)
			ll.add(carry);

		int[] ans = new int[ll.size()];
		for (int k = 0; k < ll.size(); k++) {
			ans[ll.size() - 1 - k] = ll.get(k);
		}

		return ans;
	}

}
