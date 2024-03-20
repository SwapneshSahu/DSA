package Moye_Moye;

import LinkedList.BasicOperations.ListNode;

public class DeleteNodeLinkedList_237 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public void deleteNode(ListNode node) {
	        
	        ListNode prev =null;
	        ListNode curr = node;
	        while (curr.next !=null){
	             curr.val = curr.next.val;
	             prev=curr;
	             curr=curr.next;
	        }
	        prev.next=null;
	    }
}
