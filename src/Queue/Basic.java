package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Basic {

	public static void main(String[] args) {
		int [] arr = new int [] {2, 3, 8, 14, 15};
		
		System.out.println(timeRequiredToBuy(arr, 2));

	}

	 public static int timeRequiredToBuy(int[] tickets, int k) {
	      int res = 0;
	        for(int i = 0;i<tickets.length;i++){
	            if(i <= k){
	                res += Math.min(tickets[k],tickets[i]);
	            }else{
	                res += Math.min(tickets[k] - 1,tickets[i]);
	            }
	        }
	        return res;
	    
	    }
}
