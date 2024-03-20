package __CodeHelp.BitManipulation;

public class ReverseBits {

	/*
	 * Inside the loop, you perform two operations:
	 * 
	 * res << 1: This left-shifts the bits in the res variable by one position to
	 * the left. This effectively makes room for the next bit. (n & 1): This
	 * performs a bitwise AND operation between the least significant bit (LSB) of n
	 * and 1. It extracts the LSB of n. The | operator combines the result of the
	 * left shift and the extracted bit, effectively setting the corresponding bit
	 * in res to the LSB of n.
	 * 
	 * So, in each iteration of the loop, you're taking the least significant bit of
	 * n, shifting the result one bit to the left, and then updating res with this
	 * new bit. After 32 iterations, you will have reversed all the bits of n.
	 */

	public static void main(String[] args) {

		int n = 19;

		int res = 0;
		for (int i = 0; i < 32; i++) {

			res = (res << 1) | (n & 1);
			n = n >> 1;

		}
		System.out.println(res);
		
		printBinary(11);
	}

	public static void printBinary(int number) {
		// int number = 43261596;

		// Create a StringBuilder to store the binary representation
		StringBuilder binary = new StringBuilder();

		// Convert the integer to binary and append leading zeros if necessary
		for (int i = 31; i >= 0; i--) {
			int bit = (number >> i) & 1;
			binary.append(bit);
		}

		// Print the binary representation
		System.out.println(binary.toString());
	}

}
