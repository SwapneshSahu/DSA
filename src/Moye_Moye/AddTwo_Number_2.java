package Moye_Moye;

import LinkedList.BasicOperations.ListNode;

public class AddTwo_Number_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode head = null;
	      ListNode curr = null;
	        int carry =0;

	        while (l1 !=null ||  l2!=null){

	               int temp =carry ;

	               if (l1 !=null){
	                  temp +=l1.val;
	                  l1= l1.next;
	               }

	               
	               if (l2 !=null){
	                  temp +=l2.val;
	                    l2= l2.next;
	               }

	               if (temp>9){
	                  temp = temp%10;
	                  carry =1;
	               }else{
	                 carry=0;
	               }

	               if (head==null){
	                  head = new ListNode(temp);
	                  curr=head;
	               }
	               else{                 
	                  curr.next = new ListNode(temp);
	                  curr = curr.next;
	               }
	        }

	        if (carry !=0)  curr.next = new ListNode(carry);
	        return head;

	    }
}
