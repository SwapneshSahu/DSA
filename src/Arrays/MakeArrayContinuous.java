package Arrays;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MakeArrayContinuous {

	public static void main(String[] args) {
		
		System.out.println(minOperations(new int [] {41,33,29,33,35,26,47,24,18,28}));
	}
	
	public static int minOperations(int[] nums) {
		
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i : nums) {
			min.add(i);
			max.add(i);
		}
		
		int target = nums.length-1;
		
		int startIndex =target+min.peek();
		int count =0;
		HashSet<Integer> set = new HashSet<>();
		
		for (int i : nums) {
			if (set.contains(i)) {
				 while(set.contains(startIndex)) {
					 startIndex--;
				 }
				 set.add(startIndex);
				 max.remove(i);
				 min.remove(i);
				 max.add(startIndex);
				 min.add(startIndex);
				 startIndex--;
			     count++;
			}
			else {
				set.add(i);
			}
		}
		
		while (max.peek() - min.peek() != target) {
			
			while(set.contains(startIndex)) {
				 startIndex--;
			 }
			set.add(startIndex);
			max.poll();
			max.add(startIndex);
			min.add(startIndex);
			startIndex--;
			
		    count++;
			
		}
		
		
 		return count;
        
		
    }
}
