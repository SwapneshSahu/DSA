package __CodeHelp.BitManipulation;

public class Count1Bit {

	public static void main(String[] args) {

	}

	// T(logN)
	static int countBitsOptimise(int N) {

		if (N == 0)
			return 0;

		if (N % 2 == 0) {
			return countBitsOptimise(N / 2);
		} else {
			return countBitsOptimise(N / 2) + 1;
		}
	}
	
	
	static int countBitsBruteForce(int N) {
		

		int count = 0;
		for (int i = 0; i < 32; i++) {
			int ans = 1;
			if ((N & 1) == 1) {
				count++;
			}

			N=  N>> 1;
		}

		return count;
	}

}
