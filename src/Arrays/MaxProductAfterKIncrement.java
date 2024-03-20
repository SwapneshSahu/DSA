package Arrays;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxProductAfterKIncrement {

	public static void main(String[] args) {
	 int [] arr = new int[] {6,3,3,2};
	 
	 System.out.println(maximumProduct(arr, 2));

	}

	public static int maximumProduct(int[] nums, int k) {

		Queue<Integer> que = new PriorityQueue<>();

		for (int i : nums) {
			que.offer(i);
		}

		while (k > 0) {

			int i = que.poll();
			i++;
			que.offer(i);		
			k--;

		}

		long ans = 1;
		while (!que.isEmpty()) {
			ans *= que.poll();
		}

		return (int) (ans % (Math.pow(10, 9) + 7));
	}
}
