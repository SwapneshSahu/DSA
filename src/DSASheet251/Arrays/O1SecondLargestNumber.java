package DSASheet251.Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class O1SecondLargestNumber {
	/**Problem link */ 
//  https://www.codingninjas.com/codestudio/problems/second-largest-element-in-the-array_873375?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube
	public static void main(String[] args) {

	}

	public static int findSecondLargest(int n, int[] arr) {

		// return usingPriorityQueue(arr); //T(nlogn) S(n);
		return usingVariable(arr); // T(n) S(1)
	}

	public static int usingPriorityQueue(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i : arr) {
			// To remove Duplicates
			if (!pq.contains(i))
				pq.offer(i);

		}
		pq.poll();
		return pq.size() > 0 ? pq.peek() : -1;
		/**
		 * The time complexity of this method is O(nlogn), where n is the length of the
		 * input array. This is because inserting each element into the priority queue
		 * takes O(logn) time, and we do this for n elements. Removing duplicates using
		 * the contains() method also takes O(nlogn) time in the worst case.
		 * 
		 * The space complexity is O(n) in the worst case, as we store each element of
		 * the input array in the priority queue. However, if there are duplicates in
		 * the array, then the size of the priority queue will be less than n, and the
		 * space complexity will be less than O(n).
		 * 
		 * The poll() method is used twice in this code, but since it takes O(logn)
		 * time, its impact on the time complexity is negligible compared to the other
		 * operations.
		 **/
	}

	public static int usingVariable(int[] arr) {
		int first = arr[0];
		int second = Integer.MIN_VALUE;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > first) {
				second = first;
				first = arr[i];
			} else if (arr[i] > second && arr[i] != first) {
				second = arr[i];
			}

		}
		return second == Integer.MIN_VALUE ? -1 : second;
	}
}
