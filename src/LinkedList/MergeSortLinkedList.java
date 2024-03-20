package LinkedList;

import org.w3c.dom.NodeList;

import LinkedList.BasicOperations.BasicOperationsSingly;
import LinkedList.BasicOperations.ListNode;

public class MergeSortLinkedList {

	public static void main(String[] args) {

		ListNode head = ListNode.getLinkedList();

		System.out.println("Before Merge Sort");
		BasicOperationsSingly.print(head);
		System.out.println("After Merge Sort");
		BasicOperationsSingly.print(mergeSort(head));

	}

	public static ListNode mergeSort(ListNode head) {

		// Base Case

		if (head == null || head.next == null)
			return head;

		// Break in left and right
		ListNode mid = getmid(head);

		// do recursive call
		ListNode left = head;
		ListNode right = mid.next;
		mid.next = null; // to disconnect left and right part

		left = mergeSort(left);
		right = mergeSort(right);

		// merger both sorted left and right
		ListNode ans = mergeList(left, right);

		return ans;

	}

	private static ListNode mergeList(ListNode left, ListNode right) {
		ListNode ansHead = new ListNode(-1);
		ListNode ansTail = ansHead;

		while (left != null || right != null) {
			if (left == null) {
				ansTail.next = right;
				right = right.next;
			} else if (right == null) {
				ansTail.next = left;
				left = left.next;
			} else if (left.val <= right.val) {
				ansTail.next = left;
				left = left.next;
			} else {
				ansTail.next = right;
				right = right.next;
			}
			ansTail = ansTail.next;
		}
		return ansHead.next;
	}

	private static ListNode getmid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			// if (fast != null )fast = fast.next;
		}
		return slow;
	}
}
