package __CodeHelp.BitManipulation;

public class CheckPowerof2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isPowerofTwo(long n) {
		if (n == 0)
			return false;
		long temp = 1;
		for (int i = 1; i < 64; i++) {
			if (temp == n)
				return true;

			if (temp > n)
				return false;

			temp = temp << 1;
		}

		return false;
	}

}
