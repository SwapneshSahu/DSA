package __CodeHelp.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import LinkedList.BasicOperations.ListNode;

public class CW6_NextGreaterElementLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// W/O Reversing LL Converting it into list
	 public int[] nextLargerNodesApp2(ListNode head) {
	        List<Integer> ll = getArray(head);
	         Stack<Integer> stackLL = new  Stack<>();
	        stackLL.push(Integer.MAX_VALUE);

	         int [] nextgreater = new int[ll.size()];

	         for (int i = ll.size()-1 ; i>=0 ;i--){
	               
	               while(stackLL.peek() <= ll.get(i)){
	                      stackLL.pop();
	               }

	         nextgreater[i] = stackLL.peek() == Integer.MAX_VALUE ? 0 : stackLL.peek();
	         stackLL.push(ll.get(i));
	         }

	         return nextgreater;
	    }

	    public List<Integer> getArray(ListNode head){

	      List<Integer> ll = new ArrayList<>();
	        ListNode curr= head;

	        while (curr != null){
	          ll.add(curr.val);
	          curr= curr.next;
	        } 
	        return ll;
	    }
	
	//Approach One
	int count =0;
    public int[] nextLargerNodes(ListNode head) {
        ListNode newHead = reverseLL(head);
        ListNode curr= newHead;
         Stack<Integer> stackLL = new  Stack<>();
        stackLL.push(Integer.MAX_VALUE);
         int [] nextgreater = new int[count];

         while (curr !=null){
               
               while(stackLL.peek() <= curr.val){
                      stackLL.pop();
               }

         nextgreater[--count] = stackLL.peek() == Integer.MAX_VALUE ? 0 : stackLL.peek();
         stackLL.push(curr.val);
         curr = curr.next;
         }

         return nextgreater;
    }

    public ListNode reverseLL(ListNode head){

        ListNode prev=null;
        ListNode curr= head;

        while (curr != null){
          count++;
           ListNode next  = curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
        } 
        return prev;
    }

}
