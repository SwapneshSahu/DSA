package DSASheet251.LinkedList;

import org.w3c.dom.Node;

import LinkedList.BasicOperations.ListNode;

public class EXLinkedList {
	public static void main(String[] args) {
		int[] values = { 452, 225, 671, 76, 911, 748, 403, 646, 272, 586, 481, 389, 345, 841, 325, 563, 452, 46, 540,
				821, 924, 568, 121, 924, 100, 795, 181, 324, 384, 229, 142, 177, 795, 675, 260, 472, 804, 720, 1, 858,
				401, 445, 193, 999, 542, 35, 318, 390, 794, 506, 514, 388, 521, 38, 900, 728, 840, 301, 368, 289, 464,
				172, 11, 527, 672, 402, 868, 985, 292, 863, 356, 688, 396 };

		ListNode head = createLinkedList(values);
		
		printLinkedList(head);

	}

	public static ListNode createLinkedList(int[] values) {
		ListNode head = null;
		ListNode tail = null;

		for (int value : values) {
			ListNode newNode = new ListNode(value);

			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
		}
		tail.next=head;

		return head;
	}

	public static void printLinkedList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				ListNode meet = slow;

				if (meet == null) {
					return ;
				}

				ListNode start = head;
				ListNode prev = null;

				while (start != meet) {
					prev = meet;
					start = start.next;
					meet = meet.next;
				}

				prev.next = null;
				
				ListNode current = head;

				while (current != null) {
					System.out.print(current.val + " ");
					current = current.next;
				}

			}
		}

		

	}

}
