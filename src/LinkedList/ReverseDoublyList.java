package LinkedList;

import java.util.List;

import LinkedList.BasicOperations.DoublyListNode;

public class ReverseDoublyList {
	

	public static void main(String[] args) {
		DoublyListNode new1 = DoublyListNode.getLinkedList();
	
		System.out.println("Before Reversing");
		DoublyListNode toPrint = new1;
		while (toPrint != null) {
			System.out.print(toPrint.val + " ");
			toPrint = toPrint.next;
		}
		System.out.println();
		System.out.println("After Reversing");
		toPrint= reverse(new1);
		
		while (toPrint != null) {
			System.out.print(toPrint.val + " ");
			toPrint = toPrint.next;
		}// TODO Auto-generated method stub

	}
	
	public static DoublyListNode reverse (DoublyListNode head) {
		
		DoublyListNode temp =null;
		while(head != null) {
			temp = head.prev;
		    head.prev = head.next;
			head.next = temp;
			head = head.prev;
		}
		
		
		
		return temp;
	}

}
