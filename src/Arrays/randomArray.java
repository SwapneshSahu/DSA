package Arrays;

import java.util.Arrays;
import java.util.Random;

public class randomArray {
	public static void main(String[] args) {

		
		
	        int[] array = new int[100];
	        Random random = new Random();

	        for (int i = 0; i < array.length; i++) {
	            array[i] = random.nextInt(125) + 1;
	        }

	        String arrayString = Arrays.toString(array).replaceAll("\\[|\\]", "");
	        System.out.println(arrayString);
	    
	}
}
