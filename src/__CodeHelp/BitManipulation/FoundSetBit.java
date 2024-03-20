package __CodeHelp.BitManipulation;

public class FoundSetBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int findPosition(int N) {

		boolean found = false;
		int index = 0;
		while (N != 0) {

			if ((N & 1) == 1) {
				if (!found) {
					found = true;
				} else {
					return -1;
				}
			}
			N = N >> 1;
			index++;

		}

		return found ? index : -1;
	}

}
