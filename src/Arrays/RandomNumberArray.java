package Arrays;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberArray {
	


	public static void main(String[] args) {
	        int n = 1000;  // Number of random numbers
	        int max = (int) Math.pow(10, 5);  // Maximum value for random numbers
	        
	        int[] nums = generateRandomNumbers(n, max);
	        
	        
	        System.out.print("[");
	        
	        // Print the generated random numbers
	        for (int num : nums) {
	            System.out.print(num + ",");
	        }
	        System.out.print("]");
	    }
	    
	    public static int[] generateRandomNumbers(int n, int max) {
	        int[] nums = new int[n];
	        Random rand = new Random();
	        
	        for (int i = 0; i < n; i++) {
	            nums[i] = rand.nextInt(max) + 1;
	        }
	        
	        return nums;
	    }
}
