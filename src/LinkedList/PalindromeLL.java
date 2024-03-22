package LinkedList;

import LinkedList.BasicOperations.ListNode;

public class PalindromeLL {
	
	
	//Leetcode - 234
	public static void main(String[] args) {
/*****************
		Approach 1  Convert LL to Array 
		
		Approach 2  Use Slow and fast approach to find mid and then break
		 LL into two reverse second half and then check for palindrome 
		 
		 
		Approach 3  Use Slow and fast approach and on a same itreation reverse first half of ll
		
		Approach 4 Which is done here use recursion and global variable to compare  
		
		
		****************/
	}

	ListNode curr;

	public boolean isPalindrome(ListNode head) {
		curr = head;
		return isCheckPalindrome(head);
	}

	public boolean isCheckPalindrome(ListNode head) {

		if (head == null)
			return true;

		boolean ans = isCheckPalindrome(head.next);
		if (curr.val != head.val)
			return false;
		curr = curr.next;
		return ans;
	}

	// public void isCheckPalindrome(ListNode head){

	// if (head == null) return ;

	// isCheckPalindrome(head.next);
	// if (curr.val != head.val) return;
	// curr = curr.next;
	// }

	// public ListNode reverseList(ListNode head){
	// ListNode curr =head;
	// ListNode prev =null;
	// ListNode next =null;

	// while (curr !=null){
	// next=curr.next;
	// curr.next =prev;
	// prev=curr;
	// curr=next;

	// }

	// return prev;
	// }
}
