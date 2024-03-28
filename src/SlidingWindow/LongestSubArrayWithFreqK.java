package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithFreqK {
//LT -2958
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int maxSubarrayLength(int[] nums, int k) {
	        
	        Map<Integer,Integer> map = new HashMap<>();

	        int i =0 ;
	        int j =0;
	        int count =0;

	        while (j <nums.length){

	             map.put(nums[j] , map.getOrDefault(nums[j],0)+1 );

	             while(i< j && map.get(nums[j]) > k){
	                  map.put(nums[i] , map.get(nums[i]) -1); 
	                  i++;
	             }

	             count = Math.max(count , j-i+1);
	             j++;

	        }

	        return count;
	    }

}
