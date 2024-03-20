package Arrays;

import java.util.PriorityQueue;
import java.util.Stack;

public class ArrayWinner {

	public static void main(String[] args) {
		int[] arr = new int[] { 4,1,2,5,3 };

		//System.out.println(getWinner(arr, 3));
		
		 SeatManager sb = new SeatManager(5);
		System.out.println(sb.reserve()); 
		System.out.println( sb.reserve());
	}

	public static int getWinner(int[] A, int k) {
		   PriorityQueue<Integer> pq  = new PriorityQueue<>();

		int cur = A[0], win = 0;
		for (int i = 1; i < A.length; ++i) {
			if (A[i] > cur) {
				cur = A[i];
				win = 0;
			}
			if (++win == k)
				break;
		}
		return cur;
	}

}

class SeatManager {
    PriorityQueue<Integer>  pq  = new PriorityQueue<>();
    public SeatManager(int n) {
      
        int i =1;
        while ( i<n){
           pq.add(i++);
        }
    }
    
    public int reserve() {
      
        return pq.poll();
    }
    
    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}
