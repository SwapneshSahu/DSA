package DSASheet251.String;

import java.util.LinkedList;
import java.util.Queue;

public class O2_EncodeString {
	/***Problem Link**/
// https://www.codingninjas.com/codestudio/problems/encode-the-message_699836?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=1
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(encode("abbdcaaaa")); // T(N) S(N)
		System.out.println(encodeUsingQueue("abbdcaaaa")); // T(N) S(N) but Approach 1 is more efficient

		/**
		 * In general, the first implementation using a loop and a StringBuilder is
		 * likely to be faster and more efficient than the second implementation using a
		 * Queue. Here are a few reasons why:
		 * 
		 * Queue is an interface in Java, which means that its concrete implementation
		 * may vary depending on the specific data structure you choose. In contrast,
		 * the StringBuilder is a specific class that is optimized for building strings.
		 * 
		 * The first implementation only loops through the input string once, while the
		 * second implementation requires looping through the input string and the queue
		 * multiple times.
		 * 
		 * The StringBuilder is mutable, which means that you can modify its contents
		 * without having to create a new object each time. In contrast, a Queue
		 * requires adding and removing elements to its underlying data structure, which
		 * can be more time-consuming.
		 */
	}

	/**
	 * The time complexity of the given encode method is O(n), where n is the length
	 * of the input message. The method iterates through the characters of the input
	 * string exactly once, and performs a constant amount of work for each
	 * character, so the time complexity is linear with respect to the length of the
	 * input.
	 * 
	 * The space complexity of the method is also O(n), since it creates a new
	 * StringBuilder to hold the encoded output string. The size of the output
	 * string could be as large as twice the size of the input string in the worst
	 * case, if each character of the input string is unique, so the space
	 * complexity is proportional to the length of the input.
	 **/ // T(N) S(N)
	public static String encode(String message) {
		int left = 0;
		int right = 1;
		StringBuilder sb = new StringBuilder();

		while (right < message.length()) {

			if (message.charAt(left) == message.charAt(right)) {
				right++;
			} else {
				sb.append(message.charAt(left));
				sb.append(right - left);
				left = right;
				right++;
			}
		}
		if (left < message.length()) { // to cater cases last character "abbdcaaaas"
			sb.append(message.charAt(left));
			sb.append(right - left);
		}
		return sb.toString();
	}

	/**
	 * In general, using a queue data structure is less time consuming when we need
	 * to maintain the order of elements and perform operations at both ends of the
	 * collection. Queues support two main operations, adding elements to the back
	 * of the queue (enqueue) and removing elements from the front of the queue
	 * (dequeue), which makes them efficient for handling tasks in a
	 * First-In-First-Out (FIFO) manner.
	 * 
	 * Some common use cases of queues include task scheduling, buffering in network
	 * protocols, and printing queues. However, the performance of a queue depends
	 * on the implementation and usage context. For example, if we need to
	 * frequently access elements at random positions, an array or list data
	 * structure may be more efficient. Similarly, if we need to prioritize elements
	 * based on certain criteria, a priority queue or heap data structure may be
	 * more appropriate.
	 */
	public static String encodeUsingQueue(String message) {
		Queue<Character> que = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		que.offer(message.charAt(0));
		for (int i = 1; i < message.length(); i++) {
			char ch = message.charAt(i);
			if (ch == que.peek()) {
				que.offer(ch);
			} else {
				int count = 0;
				sb.append(que.peek());
				while (!que.isEmpty()) {
					count++;
					que.poll();
				}
				sb.append(count);
				que.offer(ch);
			}
		}
		int count = 0;
		sb.append(que.peek());
		while (!que.isEmpty()) {
			count++;
			que.poll();
		}
		sb.append(count);

		return sb.toString();
	}
}
