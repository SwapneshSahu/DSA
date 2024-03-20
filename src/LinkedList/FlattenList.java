package LinkedList;

import LinkedList.BasicOperations.BasicOperationsSingly;
import LinkedList.BasicOperations.ListNode;

public class FlattenList {

	
	public static void main(String[] args) {
		ListNode new1 = new ListNode(3);
		ListNode new2 = new ListNode(5);
 	    ListNode new3 = new ListNode(22);
 		ListNode new4 = new ListNode(26);
		ListNode new5 = new ListNode(39);
		
 	    new1.next = new2;
		new2.next = new3;
		new3.next = new4;
		new4.next = new5;
		
		new1.child =  new ListNode(4);
		new1.child.child = new ListNode(6);
		
		new2.child =  new ListNode(11);
		new2.child.child = new ListNode(14);
		
		
		new3.child =  new ListNode(25);
		new4.child =  new ListNode(28);
		
		BasicOperationsSingly.print(flattenLinkedList(new1));
	
	}
	public static ListNode flattenLinkedList(ListNode start) {

		ListNode head = new ListNode(-1);
		ListNode tail = head;
		
		ListNode curr = start;
		ListNode next = start.next;
		
		while (curr !=null) {
			tail.next = curr;
			tail = tail.next;
			ListNode childNode = curr.child;
			while(childNode != null) {
				tail.next =childNode;
				tail = tail.next;
				childNode= childNode.child;
			}
			curr= next;
			if (next !=null)
			next = next.next;
			
		}
		
		BasicOperationsSingly.print(head);
		return mergeSort(head.next);
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
