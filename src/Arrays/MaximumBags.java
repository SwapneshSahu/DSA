package Arrays;

import java.util.PriorityQueue;

public class MaximumBags {

	public static void main(String[] args) {
		int [] capacity = new int [] {91,54,63,99,24,45,78};
		int[] rocks = new int [] {35,32,45,98,6,1,25};
		System.out.print(maximumBags(capacity, rocks, 17));
				
		}

	

	public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < rocks.length; i++) {
			pq.offer(capacity[i] - rocks[i]);
		}

		while (additionalRocks > 0 && !pq.isEmpty()) {
			int temp = pq.poll();
			if (additionalRocks - temp >= 0) {
				additionalRocks -= temp;
			} else {
				pq.offer(temp);
				break;
			}

		}

		return capacity.length - pq.size();

	}
}
