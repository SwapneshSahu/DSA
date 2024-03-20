package LinkedList;

import java.util.LinkedList;

import LinkedList.BasicOperations.BasicOperationsSingly;
import LinkedList.BasicOperations.ListNode;

public class FindCircular {

	public static void main(String[] args) {

		ListNode new1 = ListNode.getCircularLinkedList();

		if (checkCircularInBetween(new1)) {
			System.out.println("List is Circular");

			ListNode ans = findStartingIndex(new1, false); // pass true if we want to remove circular list

			// BasicOperationsSingly.print(ans);
			System.out.println(ans.val);
		}

	}

	// itreative way to find list is circular or not
	public static boolean checkCircular(ListNode head) {

		if (head == null)
			return true;

		ListNode temp = head.next;
		while (temp != null && temp != head) {
			temp = temp.next;
		}
		if (temp == null)
			return false;

		return true;

	}

	// to check in between if list is circular
	public static boolean checkCircularInBetween(ListNode head) {

		if (head == null)
			return true;

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast != slow) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
		}
		if (slow == fast)
			return true;

		return false;

	}

	// to find the starting index from where list become circular and if we want to
	// remove the circular list pass remove as true
	// in that case it will return the head other wise the pointer from where all
	// this started
	public static ListNode findStartingIndex(ListNode head, boolean remove) {
		if (head == null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {

				ListNode meet = slow;

				if (meet == null) {
					return null;
				}

				ListNode start = head;
				ListNode prev = null;
				while (start != meet) {
					prev = meet;
					start = start.next;
					meet = meet.next;
				}
				if (remove) {
					prev.next = null;
					return head;
				}
				return slow;
			}
		}

		return null;
	}

}
