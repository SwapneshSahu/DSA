package __CodeHelp.BitManipulation;

public class AndOperation {

	public static void main(String[] args) {
		System.out.println(intToBinary(5));
	}
	
	public static String intToBinary(int num) {
	    StringBuilder binary = new StringBuilder();
	    int mask = 1 << 31;  // Start from the leftmost bit

	    for (int i = 0; i < 32; i++) {
	        binary.append((num & mask) == 0 ? '0' : '1');  // Check if the bit is set
	        num <<= 1;  // Shift to the next bit
	    }

	    return binary.toString();
	}
}
