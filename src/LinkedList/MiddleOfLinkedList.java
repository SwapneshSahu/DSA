package LinkedList;

import LinkedList.BasicOperations.ListNode;

public class MiddleOfLinkedList {

	public static void main(String[] args) {
		ListNode new1 = ListNode.getLinkedList();

		System.out.println("List  ");
		ListNode toPrint = new1;
		
		while (toPrint != null) {
			System.out.print(toPrint.val);
			toPrint = toPrint.next;
		}
		System.out.println();
		System.out.println("Middle Node");
		toPrint = middle(new1);
		
			System.out.print(toPrint.val);
		

	}
	
	public static ListNode middle (ListNode head) {
		
		if (head == null || head.next == null) return head;
		
		ListNode fast = head.next;
		ListNode slow = head;
		
		while(fast != null) {
			fast = fast.next;
			if (fast !=null) {
				fast= fast.next;
			}
			
			slow = slow.next;
		}
		return slow;
	}

}
