package DSASheet251.BasicMixed;

import java.math.BigInteger;

public class O1_SquareRoot {

	public static void main(String[] args) {
		System.out.println(sqrtN(567442394));

	}

	public static int sqrtN(long N) {
		if (N == 0 || N == 1)
			return (int) N;
		int start = 0;
		int end = (int) N / 2;

		while (true) {

			int mid = start + (end - start) / 2;

			if (mid > N / mid) {
				end = mid - 1;
			} else {
				if (mid + 1 > N / (mid + 1))
					return mid;
				start = mid + 1;
			}

		}

	}

}
