package LinkedList;

import LinkedList.BasicOperations.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		
		System.out.println((2*(-2147483648) - 2147483647));
		
		//(2*(-2147483648) - 2147483647)
		 
		ListNode new1 = ListNode.getLinkedList();

		System.out.println("List before reversing ");
		ListNode toPrint = new1;
		
		while (toPrint != null) {
			System.out.print(toPrint.val);
			toPrint = toPrint.next;
		}
		System.out.println();
		System.out.println("List After reversing ");
	//	toPrint = reverse(new1, null);
		
		while (toPrint != null) {
			System.out.print(toPrint.val);
			toPrint = toPrint.next;
		}
	}
	
	public static ListNode reverse(ListNode curr , ListNode prev) {
		
		if (curr == null)return prev;
		
		ListNode forward = curr.next;
		curr.next = prev;
		
		return reverse(forward, curr);
	
	}

}
