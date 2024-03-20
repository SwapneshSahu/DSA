package LinkedList;

import LinkedList.BasicOperations.BasicOperationsSingly;
import LinkedList.BasicOperations.ListNode;

public class ReverseLinkedListInKGroup {

	public static void main(String[] args) {
		ListNode new1 = ListNode.getLinkedList();

		System.out.println("List before reversing ");

		BasicOperationsSingly.print(new1);
		System.out.println();

		System.out.println("List After reversing ");
		BasicOperationsSingly.print(new1);

	}

	public static ListNode reverseInKGroup(ListNode head, int k) {

		if (head == null)
			return null;

		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		int count = 0;

		while (curr != null && count < k) {

			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if (next != null)
			head.next = reverseInKGroup(next, k);

		return prev;

	}

}
