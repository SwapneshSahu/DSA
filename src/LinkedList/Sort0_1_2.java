package LinkedList;

import java.util.List;

import LinkedList.BasicOperations.BasicOperationsSingly;
import LinkedList.BasicOperations.ListNode;

public class Sort0_1_2 {

	public static void main(String[] args) {

		ListNode head = ListNode.getLinkedList();

		System.out.println("List before Sorting");
		BasicOperationsSingly.print(head);
		System.out.println("List After Sorting");
		BasicOperationsSingly.print(sort(head));
	}

	public static ListNode sort(ListNode head) {

		ListNode zeroHead = new ListNode(-1);
		ListNode zeroTail = zeroHead;
		ListNode oneHead = new ListNode(-1);
		ListNode oneTail = oneHead;
		ListNode twoHead = new ListNode(-1);
		ListNode twoTail = twoHead;

		ListNode curr = head;

		// To Get numbers of 0 1 2 in different linked list
		while (curr != null) {

			if (curr.val == 0) {
				zeroTail.next = new ListNode(curr.val);
				zeroTail = zeroTail.next;
			} else if (curr.val == 1) {
				oneTail.next = new ListNode(curr.val);
				oneTail = oneTail.next;
			} else if (curr.val == 2) {
				twoTail.next = new ListNode(curr.val);
				twoTail = twoTail.next;
			}

			curr = curr.next;
		}

		// merge List in sorted form

		if (oneHead.next != null) {
			zeroTail.next = oneHead.next;
			oneTail.next = twoHead.next;
		} else {
			zeroTail.next = twoHead.next;
		}

		// changing head

		head = zeroHead.next;

		oneHead.next = null;
		twoHead.next = null;

		return head;

	}

}
