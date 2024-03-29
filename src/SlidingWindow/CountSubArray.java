package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class CountSubArray {
//Leetcode 2962
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Approach1
	 public long countSubarrays(int[] nums, int k) {
	        
	        long count =0 ;
	        int i =0 ;
	        int j =0 ;
	        int n = nums.length;
	        int maxNum = 0;
	        int maxCount = 0;
	        
	        for (int m : nums){
	             maxNum = Math.max(m,maxNum);
	        }


	        while (j < n){
	            
	            if (nums[j] == maxNum ) maxCount ++;

	              while(maxCount == k && i <= j){
	                    count += n-j;
	                 if (nums[i] == maxNum ) maxCount --;
	                    i++;
	              }

	              j++;
	        }

	        return count;
	    }

	 //Approach2
	 public long countSubarrays2(int[] nums, int k) {
	        
	        long count =0 ;
	        int i =0 ;
	        int n = nums.length;
	        int maxNum = 0;
	        List <Integer>  indexes = new ArrayList<>();
	        
	        for (int m : nums){
	             maxNum = Math.max(m,maxNum);
	        }

	        while( i <n){

	            if (nums[i] == maxNum ) indexes.add(i);

	            if (indexes.size() >=k){
	                 count += indexes.get(indexes.size()-k)+1; 
	            }

	            i++;
	        }



	        return count;
	    }
}
