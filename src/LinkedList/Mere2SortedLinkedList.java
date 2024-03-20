package LinkedList;

import java.util.List;

import LinkedList.BasicOperations.BasicOperationsSingly;
import LinkedList.BasicOperations.ListNode;

public class Mere2SortedLinkedList {

	
	public static void main(String[] args) {
		
		ListNode first = ListNode.getLinkedList();
		
		ListNode second = new ListNode(12);
		ListNode new2 = new ListNode(13);
		ListNode new3 = new ListNode(15);
		ListNode new4 = new ListNode(17);
		
		second.next = new2;
		new2.next = new3;
		new3.next = new4;
		
		System.out.println("Before sorting");
		BasicOperationsSingly.print( first);
		BasicOperationsSingly.print( second);
		
		System.out.println("After sorting");
		
		// we will go forward with the list having less starting value then we try to add second list numbers in between
		if (first.val > second.val) BasicOperationsSingly.print( sort(second,first)); 
		else {
			BasicOperationsSingly.print( sort(first,second)); 
			
		}
		
		
		
	}
	
	public static ListNode sort(ListNode first , ListNode second) {
		
		// when any of the list is empty we dont have to process sorting
		if (first == null) return second;
		if (second == null) return first;
		
		// if first list is on 1 size we can directly patch 2 list 
		if(first.next == null) {
			first.next = second;
			return first;
		}
		
		//creating pointers
		ListNode curr1 = first;
		ListNode next1 = first.next;
		ListNode curr2 = second;
	//	ListNode next2 = second.next;
		
		
		while(next1 != null  && curr2 != null) {
			
			//will check second list curr2 val can be fitted in between curr and next of first 
			if (curr1.val <= curr2.val && curr2.val <=next1.val) {
				
				 //storing curr2 pointer
				ListNode next2 = curr2.next;
				
				// adding curr2 in between curr1 and next1
				  curr1.next = curr2;
				  curr2.next = next1;
				  
				 //changing pointers  
				  curr1= curr2;
				  curr2 = next2;
				
				
			}
			else {
				curr1 = next1;
				next1 = next1.next;
				// if we reached to end of first list we have to add remaining of second list as it is and return
				if (next1 == null) {
					curr1.next = curr2;
					return first;
				}
			}
		}
		// if we reached here that means second list is come to end that means sorting is done
		return first;
	}
}
