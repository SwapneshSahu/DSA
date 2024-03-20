package Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimizeTheMaximumElement {

	public static void main(String[] args) {
		 int zero = 8;
		 
		 zero = zero>>3;
		 System.out.println(zero);
		
		
		
		int arr[] = new int [] {3,7,1,6};
		
	//	System.out.println(miniMaxElement(arr, 3));
	}
	
   public static int miniMaxElement(int [] arr , int k ) {
	   
	   PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
	   
	   for (int i : arr) {
		   pq.add(i);
	   }
	 
	   
	   while (k >0) {
		  int first = pq.poll();
		  
		  int count =0;
		  while( !pq.isEmpty() && first == pq.peek()) {
			 count++;
			 pq.poll();
		  }
		  
		  if (pq.isEmpty()) return first;
		  
		  int second =pq.peek();
		  while (count >0) {
			  pq.add(first);
			  count--;
		  }
		  
		  
		  int temp = first - second;
		  
		  
		  pq.add(second);
		  pq.add(temp);
		  k--;
	   }
		
	   return pq.peek();
	}
}
