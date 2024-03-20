package DSASheet251.LinkedList;

import LinkedList.BasicOperations.ListNode;

public class O3_DetectAndRemoveCycle {
/**Problem Link*/
//  https://www.codingninjas.com/codestudio/problems/interview-shuriken-42-detect-and-remove-loop_241049?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=1	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode removeLoop(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		// Slow Pointer - This will be incremented by 1 Nodes.
		ListNode slow = head;

		// Fast Pointer - This will be incremented by 2 Nodes
		ListNode fast = head;

		while (true) {

			// We reached the end of the List and haven't found any Cycle
			if (fast == null || fast.next == null) {
				return head;
			}

			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}
		}

		// Cycle Found.
		fast = head;

		// start will point the starting node of cycle.
		ListNode start = null;

		while (fast != slow) {

			fast = fast.next;
			slow = slow.next;
		}

		start = slow;

		// Finding the previous node of 'start'.
		ListNode cur = start;

		while (true) {

			if (cur.next == start) {

				cur.next = null;
				return head;
			}

			cur = cur.next;
		}

	}

}
