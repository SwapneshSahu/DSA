package Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinStoneSum {
	//1962. Remove Stones to Minimize the Total
	 //Using Array will consume more time and give TLE
	public static void main(String[] args) {
		int[] piles = new int[] { 5,4,9 };
		System.out.println(minStoneSum(piles, 2));

	}

	public static int minStoneSum(int[] piles, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i : piles) {
			pq.offer(i);
		}

		while (k > 0) {
			int temp = pq.poll();
			if (temp != 1) {
				if (temp % 2 == 1) {
					pq.offer((temp / 2) + 1);
				} else {
					pq.offer(temp / 2);
				}
				k--;
			} else {
				return piles.length;
			}
		}
		int sum=0;
		while(!pq.isEmpty()) {
			sum+=pq.poll();
		}
		

		return sum;
	}
	
	/*
	 * public static int minStoneSum(int[] piles, int k) { Arrays.sort(piles);
	 * PriorityQueue<Integer> pq = new PriorityQueue<>(); int i = piles.length-1;
	 * while(k>0){ if (piles[i]%2 ==1){ piles[i] = piles[i]/2 +1; } else{ piles[i] =
	 * piles[i]/2 ; } k--; i--; } int sum =0; for (int j :piles) sum+=j ;
	 * 
	 * return sum; }
	 */
}
