package MATHS;

import java.util.HashSet;
import java.util.Random;

public class RandomNumber {
	
	 public static void main(String[] args) {
	        Random rand = new Random();
	        HashSet<Integer> set = new HashSet<>();
	        while (set.size() < 15) {
	            int randomNum = rand.nextInt(15)+1;
	            if(!set.contains(randomNum)) {
	            System.out.print(randomNum + " ");
	            set.add(randomNum);
	            }
	        }
	       // System.out.println(set);
	    }

}
