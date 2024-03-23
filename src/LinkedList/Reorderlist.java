package LinkedList;

import LinkedList.BasicOperations.ListNode;

public class Reorderlist {
//leetcode  143
	public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;
        
        ListNode  slow = head; 
        ListNode  fast = head; 
        ListNode prev = null;

        // TO find mid
        while (fast !=null && fast.next !=null){             
                prev =slow;
                fast = fast.next.next; 
                slow = slow.next;                                    
        }

        prev.next = null;
        ListNode prevRev = null;
        ListNode newSlow = slow;
        // to reverse the second half
        while (newSlow != null) {  
            ListNode temp = newSlow.next;
            newSlow.next = prevRev;
            prevRev = newSlow;
            newSlow = temp;
        }
       
       ListNode tail1 = head;
       ListNode tail2 = prevRev;
       // to create  reorder list
        while (tail1 != null && tail2 != null){

            ListNode temp1 = tail1.next; 
            ListNode temp2= tail2.next; 
            
            tail1.next=tail2;

           if (temp1 != null) tail2.next = temp1;
   
            tail1= temp1;
            tail2 =temp2;

        }
      
    }
}
