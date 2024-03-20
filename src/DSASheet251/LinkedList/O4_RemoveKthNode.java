package DSASheet251.LinkedList;

import LinkedList.BasicOperations.ListNode;

public class O4_RemoveKthNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode removeKthNode(ListNode head, int K) {
		ListNode temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		// If we have to remove 1st node
		if (count - K == 0)
			return head.next;

		temp = head;
		while (count - K != 1) {
			temp = temp.next;
			count--;
		}

		if (temp.next != null)
			temp.next = temp.next.next;

		return head;

	}

}
