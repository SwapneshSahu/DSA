package DSASheet251.LinkedList;

import LinkedList.BasicOperations.ListNode;

public class O1_ReverseLinkedList {

	public static void main(String[] args) {

	}

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {

			ListNode nex = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nex;

		}

		return prev;
	}
}
