package LinkedList.BasicOperations;

public class BasicOperationDoubly {

	public static void main(String[] args) {
		
		DoublyListNode new1 = DoublyListNode.getLinkedList();
		
		
		DoublyListNode newNode = new DoublyListNode(10);
		DoublyListNode ans1 = addDoublyNode(new1, 4, newNode);
		while (ans1 != null) {
			System.out.print(ans1.val + " ");
			ans1 = ans1.next;
		}
		System.out.println();
		DoublyListNode ans2 = deleteDoublyNode(new1, 5);
		
		while (ans2 != null) {
			System.out.print(ans2.val + " ");
			ans2 = ans2.next;
		}
		

	}
	
	public static DoublyListNode addDoublyNode(DoublyListNode head , int position , DoublyListNode newNode) {
		
		if (position == 0) {
			newNode.next = head;
			head.prev = newNode;
		return newNode;
		}
		int count =0 ;
		DoublyListNode predecessor  = head;
		DoublyListNode successor = head.next;
		
		while(count<position ) {
			if (successor.next !=null) {
			predecessor = predecessor.next;
			successor = successor.next;
			count++;
			}
			else {
				successor.next = newNode;
				newNode.prev = successor;
				return head;
			}
		}
		
		predecessor.next = newNode;
		newNode.prev = predecessor;
		
		newNode.next = successor;
		successor.prev = newNode;
		
		
		
		return head;
	}
	
	public static DoublyListNode deleteDoublyNode(DoublyListNode head , int position) {
		
		if (position == 0) {
			DoublyListNode temp = head.next;
			head =null;
			temp.prev = null;
			return temp;
		}
		int count =0 ;
		DoublyListNode predecessor  = head;
		DoublyListNode successor = head.next;
		
		while(count < position -1 ) {
			if (successor.next !=null) {
			predecessor = predecessor.next;
			successor = successor.next;
			count++;
			}
			else {
				return head;
			}
		}
		
		predecessor.next = successor.next;
		successor.prev = predecessor;
		
		
		
		
		return head;
	}
	

}
