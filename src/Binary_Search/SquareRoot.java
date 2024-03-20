package Binary_Search;

public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(squarRoot(70));
		System.out.println(squareRootRecursive(70, 0, 70));
	}

	public static double squareRootRecursive(int n, int start, int end) {
		long mid = start + (end - start) / 2;
		double ans = 0;
		if (start >end) return ans;
		
		if (mid * mid <= n ) {
			ans = mid;

		}
		else if (mid * mid > n) {
			ans = squareRootRecursive(n, start, (int) mid - 1);
		} else {
			ans = squareRootRecursive(n, (int) mid + 1, end);
		}

		double res = 0;
		double factor = 1;
		for (int i = 0; i < 3; i++) {
			factor = factor / 10;

			for (double j = ans; j * j < n; j = j + factor) {
				res = j;
			}
		}

		return res;
	}

	public static double squarRoot(int n) {

		long start = 0;
		long end = n;
		double ans = 0;
		long mid = start + (end - start) / 2;

		while (start <= end) {
			// System.out.println(start + " " + end);

			if (mid * mid == n) {
				ans = mid;
				break;
			} else if (mid * mid > n) {
				end = mid - 1;
			} else {
				ans = mid;
				start = mid + 1;
			}
			mid = start + (end - start) / 2;
		}

		double res = 0;
		double factor = 1;
		for (int i = 0; i < 3; i++) {
			factor = factor / 10;

			for (double j = ans; j * j < n; j = j + factor) {
				res = j;
			}
		}

		return res;

	}

}
