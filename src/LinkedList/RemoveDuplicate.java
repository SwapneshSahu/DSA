package LinkedList;

import java.util.HashMap;

import LinkedList.BasicOperations.BasicOperationsSingly;
import LinkedList.BasicOperations.ListNode;

public class RemoveDuplicate {

	// TO remove duplicate from unsorted array we can have 3 solution
	// 1) By 2 loops T(n2) S(1)
	// 2) By sorting T(nlogn) S(1)
	// 3) By Map T(n) S(n)
	public static void main(String[] args) {

		ListNode head = ListNode.getLinkedList();
		System.out.println("List Before removing duplicate");
		BasicOperationsSingly.print(head);
		System.out.println("List After removing duplicate");
		BasicOperationsSingly.print(byLoop(head));

	}

	public static ListNode byLoop(ListNode head) {

		if (head == null)
			return null;
		ListNode curr = head;

		while (curr != null) {

			ListNode temp = curr.next;
			ListNode prev = curr;
			while (temp != null) {

				if (temp.val == curr.val) {
					ListNode temp1 = temp;
					temp = temp.next;
					prev.next = temp;
					temp1.next = null;
					BasicOperationsSingly.print(temp1);
				} else {

					prev = temp;
					temp = temp.next;

				}
			}
			curr = curr.next;
		}
       return head;
	}

	public static ListNode byMap(ListNode head) {

		if (head == null)
			return null;

		HashMap<Integer, Boolean> map = new HashMap<>();

		ListNode curr = head;
		ListNode prev = null;

		while (curr != null) {

			if (map.containsKey(curr.val)) {
				ListNode temp = curr;
				curr = curr.next;
				prev.next = curr;
				temp.next = null;
				BasicOperationsSingly.print(temp);
			} else {
				map.put(curr.val, true);
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}

}
