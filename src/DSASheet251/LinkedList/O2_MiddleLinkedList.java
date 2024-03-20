package DSASheet251.LinkedList;

import LinkedList.BasicOperations.ListNode;

public class O2_MiddleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode middleNode(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

		}
		return slow;
	}

}
