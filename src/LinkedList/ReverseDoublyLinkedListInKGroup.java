package LinkedList;

import LinkedList.BasicOperations.DoublyListNode;

public class ReverseDoublyLinkedListInKGroup {

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
		toPrint= reverseDoublyByK(new1,2);
		
		while (toPrint != null) {
			System.out.print(toPrint.val + " ");
			toPrint = toPrint.next;
		}// TODO Auto-generated method stub

	}
	
	public static DoublyListNode  reverseDoublyByK(DoublyListNode head ,int k) {
		
		DoublyListNode temp =null;
		int count =0;
		while(head != null && k>count) {
			temp = head.prev;
		    head.prev = head.next;
			head.next = temp;
			head = head.prev;
			count++;
			
		}
//	//	System.out.println(temp.val + " " + head.val);
//		DoublyListNode    toPrint= temp.prev;
//		
//		while (toPrint != null) {
//			System.out.print(toPrint.val + " ");
//			toPrint = toPrint.next;
//		}
		if (head != null) {
			DoublyListNode tt =reverseDoublyByK(head,k );
			temp.next= tt;
			tt.prev= temp;
			
		}
		
		
		
		return temp;
	}

}
