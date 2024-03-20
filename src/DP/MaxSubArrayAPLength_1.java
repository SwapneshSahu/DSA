package DP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class MaxSubArrayAPLength_1 {

	public static void main(String[] args) {
		int [] arr = new int [] {-11,8,8,-13,-4,6,7,-3 ,8,4,-9,-7,13,-15,9};
		
		System.out.println(longestSubsequence(arr, 9));

		 HashMap<Integer,Integer[]> map = new HashMap<>();
		 Stack<Integer> que = new Stack<>();
		 que.contains(que);
	
	}

	
	 
	 public static int longestSubsequence(int[] arr, int difference) {
	        
	     HashMap<Integer,Integer> map = new HashMap<>();
	    int ans =1;
	     for (int i : arr){

	         if (!map.isEmpty() && map.containsKey(i-difference)){
	             map.put(i,map.get(i-difference)+1);
	             ans= Math.max(ans,map.get(i));
	         }else{
	             map.put(i,1);
	         }

	     }
	     return ans;

	    }
}
