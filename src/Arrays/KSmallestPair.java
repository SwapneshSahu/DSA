package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPair {

	//373
	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 1, 2 };
		int[] nums2 = new int[] { 1, 2, 3 };

		System.out.println(kSmallestPairs(nums1, nums2, 2));

	}

	public static  List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> ans = new ArrayList<>(); // Result list to store the pairs
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		
		//will put all the element of num1 pairing with 0 index of nums2 keeping their sum and index in priority queue
		
		for(int i : nums1) {	//sum		index
			pq.offer(new int[] {i+nums2[0],     0});
		}
		
		while(k >0 && !pq.isEmpty()) {
			
			int [] arr = pq.poll();
			
			List<Integer> list  = new ArrayList<>();
			int sum = arr[0];
			int prevIndex = arr[1];
			
			list.add(sum - nums2[prevIndex]); // this will give element from nums1
			list.add(nums2[prevIndex]); // this will give element from nums2
			ans.add(list);
			
			//now will add next candidate in a queue
			
			if (prevIndex+1 <nums2.length)
				                   // Element of nums1    next element fromnum2   updating index
				pq.offer(new int[] {sum - nums2[prevIndex] +nums2[prevIndex+1] ,prevIndex+1});
			
			k--;
			
			
		}
		return ans;
		

	}
}
