package Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class TotalCostToHireKWorkers {

	public static void main(String[] args) {
		int[] costs = new int[] { 28, 35, 21, 13, 21, 72, 35, 52, 74, 92, 25, 65, 77, 1, 73, 32, 43, 68, 8, 100, 84, 80,
				14, 88, 42, 53, 98, 69, 64, 40, 60, 23, 99, 83, 5, 21, 76, 34 };
		System.out.println(totalCost(costs, 32, 12));
	}

	public static long totalCost(int[] costs, int k, int candidates) {
		long ans = 0;

		if (k == costs.length) {
			// If k is equal to the length of costs array, add all the costs to the answer
			for (int i : costs) {
				ans += i;
			}
			return ans;
		}

		if (candidates * 2 >= costs.length) {
			// If the number of candidates is at least half of the total costs array length,
			// sort the costs array and add the first k elements to the answer
			Arrays.sort(costs);
			int i = 0;
			while (k != 0) {
				ans += (long) costs[i];
				i++;
				k--;
			}
			return ans;
		}

		Queue<Integer> que1 = new PriorityQueue<>();
		Queue<Integer> que2 = new PriorityQueue<>();

		int count = 0;
		for (int i = 0; i < candidates; i++) {
			// Create a min heap (PriorityQueue) with the first candidates elements
			que1.offer(costs[i]);
			count++;
		}

		for (int i = costs.length - 1; i > costs.length - candidates - 1; i--) {
			// Create a min heap (PriorityQueue) with the last candidates elements
			que2.offer(costs[i]);
			count++;
		}

		int left = candidates;
		int right = costs.length - candidates - 1;
		while (k != 0) {
			if (que2.isEmpty() || (!que1.isEmpty() && que1.peek() <= que2.peek())) {
				// If que2 is empty or que1 has a smaller or equal value at the top, take the
				// element from que1
				ans += (long) que1.poll();
				if (count < costs.length) {
					// If there are remaining costs, add the next cost from the left side to que1
					que1.offer(costs[left]);
					left++;
				}
			} else {
				// If que2 has a smaller value at the top, take the element from que2
				ans += (long) que2.poll();
				if (count < costs.length) {
					// If there are remaining costs, add the next cost from the right side to que2
					que2.offer(costs[right]);
					right--;
				}
			}
			count++;

			k--;
		}

		return ans;
	}

}
