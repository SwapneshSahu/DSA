package LinkedList;

import LinkedList.BasicOperations.BasicOperationsSingly;
import LinkedList.BasicOperations.ListNode;

public class SplitCircularListIn2 {
	
	//Pending -> ye nahi hua hai

	public static void main(String[] args) {
		
		ListNode head = ListNode.getCircularLinkedList()
		System.out.println(checkCircularAndSplit(head));

	}

	public static boolean checkCircularAndSplit(ListNode head) {

		if (head == null)
			return true;

		ListNode temp = head.next;
		
		int count =0;
		while (temp != null && temp != head) {
			temp = temp.next;
			count++;
			
		}
		ListNode slow = head;
		ListNode fast = head;
		
		while(count/2> 0 ) 
		{
			slow = slow.next;
			fast = fast.next;
			if (fast!=null) {
				fast = fast.next;
			}
			count--;
		}
		
		ListNode tt = slow.next;
		slow.next =head;
		fast.next = tt;
		System.out.println(tt.val);
		System.out.println(head.val);

		return true;

	}
}
