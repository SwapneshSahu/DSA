package __CodeHelp.BitManipulation;

public class CountSetBitsofNnaturalNumbers {

	public static void main(String[] args) {
		
     System.out.println(countBits(41));
	}
	
	public static int countBits(int n) {
	    if (n == 0) return 0;
	    
	    // Find the position of the most significant set bit.
	    int maxPow = maxPower(n);
	    
	    // Calculate the total count of set bits in the range [1, n].
	    int ans = (1 << (maxPow - 1)) * maxPow + n - (1 << maxPow) + 1 + countBits(n - (1 << maxPow));
	    
	    return ans;
	}


	public static int maxPower(int n) {
	    int count = 0;
	    
	    // Calculate the position of the most significant set bit.
	    while (n != 0) {
	        count++;
	        n = n >> 1; // Right-shift `n` to check the next bit.
	    }
	    
	    return count - 1;
	}

}
