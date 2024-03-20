package LinkedList;

import LinkedList.BasicOperations.BasicOperationsSingly;
import LinkedList.BasicOperations.ListNode;

public class AddTwoNumber {

	public static void main(String[] args) {
		ListNode first = ListNode.getLinkedList();

		ListNode second = new ListNode(9);
		ListNode new2 = new ListNode(9);
		ListNode new3 = new ListNode(9);
		ListNode new4 = new ListNode(9);

		second.next = new2;
		new2.next = new3;
		new3.next = new4;

		System.out.println("Before Adding");
		BasicOperationsSingly.print(first);
		BasicOperationsSingly.print(second);

		System.out.println("After Adding");

		BasicOperationsSingly.print(sumOfTwo(first, second));

	}

	private static ListNode sumOfTwo(ListNode first, ListNode second) {

		// Step 1 reverse both list as we always add from right hand side
		first = reverse(first);
		second = reverse(second);

		// Step2 Add digit by digit and create a new list
		int carry = 0;
		ListNode newHead = new ListNode(0);
		ListNode newTail = newHead;
		while (first != null || second != null || carry != 0) {

			int val1 = 0;
			if (first != null) {
				val1 = first.val;
				first = first.next;
			}

			int val2 = 0;
			if (second != null) {
				val2 = second.val;
				second = second.next;
			}

			int sum = val1 + val2 + carry;

			int digit = sum % 10;
			// creating new node
			newTail.next = new ListNode(digit);

			// Updating Pointer

			newTail = newTail.next;

			carry = sum / 10;

		}

		// step3 reverse new list again
		newHead = reverse(newHead.next);

		return newHead;
	}

	private static ListNode reverse(ListNode head) {

		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}
		return prev;
	}

}
