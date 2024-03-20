package LinkedList.BasicOperations;

import java.awt.image.SinglePixelPackedSampleModel;
import java.util.LinkedList;

public class BasicOperationsSingly {

	public static void main(String[] args) {

		ListNode new1 = ListNode.getLinkedList();

		ListNode ans = addNode(new1, 7, 5);

		 ans = deleteNode(ans, 21);
		while (ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}

	}

	public static ListNode addNode(ListNode head, int val, int position) {

		if (position == 0) {
			ListNode newNode = new ListNode(val, head);
			return newNode;

		}
		int i = 0;
		ListNode temp = head;
		while (i < position - 1 && temp.next != null) {
			temp = temp.next;
			i++;
		}
		ListNode newNode = new ListNode(val, temp.next);
		temp.next = newNode;

		return head;
	}

	public static ListNode deleteNode(ListNode head, int val) { //val or position
		 
		// incase we have to remove 1st element;
		if (head.val == val) {
			ListNode temp = head.next;
			head =null;
			return temp;
		}
		
		ListNode temp = head.next;
		ListNode prev = head;
		
		while(temp != null) {
			
			if (temp.val == val) {
				prev.next = temp.next;
				return head;
			}
		   prev = temp;
		   temp=temp.next;
			
		}

		 // in case the value was not their
		return head;
	}
	
	public static void  print(ListNode new1 ) {
		
		
		ListNode toPrint = new1;
		
		while (toPrint != null) {
			System.out.print(toPrint.val + " ");
			toPrint = toPrint.next;
		}
		System.out.println();
	}

}
