package LinkedList.BasicOperations;

public class ListNode {

	public int val;
	public ListNode next;
	public ListNode child;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
		this.next = null;
		this.child =  null;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

	public static ListNode getLinkedList() {
		ListNode new1 = new ListNode(9);
		ListNode new2 = new ListNode(2);
 	    ListNode new3 = new ListNode(1);
 		ListNode new4 = new ListNode(7);
		ListNode new5 = new ListNode(9);
		ListNode new6 = new ListNode(6);
		ListNode new7 = new ListNode(2);
		ListNode new8 = new ListNode(1);
//		new1.next = new2;
//		new2.next = new3;
//		new3.next = new4;
//		new4.next = new5;
//		new5.next = new6;
//		new6.next = new7;
//		new7.next = new8;
//		
		return new1;
	}
	
	public static ListNode getCircularLinkedList() {
		ListNode new1 = new ListNode(1);
		ListNode new2 = new ListNode(2);
		ListNode new3 = new ListNode(3);
		ListNode new4 = new ListNode(4);
		ListNode new5 = new ListNode(5);
		ListNode new6 = new ListNode(6);
		ListNode new7 = new ListNode(7);
		ListNode new8 = new ListNode(8);
		new1.next = new2;
		new2.next = new3;
		new3.next = new4;
		new4.next = new5;
		new5.next = new6;
		new6.next = new7;
		new7.next = new8;
	    new8.next = new1; //for circular
//		
		return new1;
	}

}
