package LinkedList.BasicOperations;

public class DoublyListNode {
	
	public int val;
	public DoublyListNode next;
	public DoublyListNode prev;
	
	public DoublyListNode(int val) {
		
		this.val = val;
		this.next = null;
		this.prev = null;
	}
	
	public static DoublyListNode getLinkedList() {
		DoublyListNode new1 = new DoublyListNode(1);
		DoublyListNode new2 = new DoublyListNode(2);
		DoublyListNode new3 = new DoublyListNode(3);
		DoublyListNode new4 = new DoublyListNode(4);
		DoublyListNode new5 = new DoublyListNode(5);
		DoublyListNode new6 = new DoublyListNode(6);
		DoublyListNode new7 = new DoublyListNode(7);
		DoublyListNode new8 = new DoublyListNode(8);
		 
		new1.prev =null;
		new1.next = new2 ;
		new2.prev = new1;
		
		new2.next = new3;
		new3.prev = new2;
		
		new3.next = new4;
		new4.prev = new3;
		
		new4.next = new5 ;
		new5.prev = new4;
		
		new5.next = new6;
		new6.prev = new5;
		
		new6.next = new7;
		new7.prev = new6;
		
		new7.next = new8;
		new8.prev = new7;
		
		new8.next =null;
		
		return new1;
	}
	
	

}
