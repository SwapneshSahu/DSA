package LinkedList;

import LinkedList.BasicOperations.BasicOperationsSingly;
import LinkedList.BasicOperations.ListNode;

public class CheckPlaindrome {

	public static void main(String[] args) {
		ListNode head = ListNode.getLinkedList();
		
		System.out.println ("Given List");
		BasicOperationsSingly.print(head);
		System.out.println ("List is palindrome: " + checkPalindrome(head));
		
		

	}

	public static boolean checkPalindrome(ListNode head) {
	    if (head == null || head.next == null)
	        return true;
	    
	    // Step 1: Find middle
	    ListNode middle = getMiddle(head);

	    // Step 2: Reverse second half of the list
	    ListNode secondHalf = reverse(middle.next);
	    
	    // Step 3: Check for palindrome
	    ListNode curr = head;
	    ListNode half = secondHalf;
	    while (half != null) {
	        if (curr.val != half.val)
	            return false;
	        curr = curr.next;
	        half = half.next;
	    }
	    
	    return true;
	}

	private static ListNode reverse(ListNode head) {
	    ListNode curr = head;
	    ListNode prev = null;
	    ListNode next = null;
	    
	    while (curr != null) {
	        next = curr.next;
	        curr.next = prev;
	        prev = curr;
	        curr = next;
	    }
	    
	    return prev;
	}

	private static ListNode getMiddle(ListNode head) {
	    ListNode slow = head;
	    ListNode fast = head.next;

	    while (fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    
	    return slow;
	}

	
}
