package Arrays;

import java.util.Arrays;

public class MostFrequentEvenElement {

	public static void main(String[] args) {
	  int [] nums= new int[] {8267,8727,2649,7359,2142,7824,7399,3424,8868,476,9769,4631,6631,4205,9178,7920,4748,5523,74,5550,516,6448,3475,7867,7041,5896,4382,2066,8101,674,67,9311,4308,1693,4586,3959,2973,2158,5067,9060,2988,1147,1746,9722,8550,9126,3029,1677,4154,5473,6589,5381,1486,8699,792,8349,6773,496,4505,6163,6843,1232,4809,4432,6251,7658,4949,1419,7005,3815,6295,
			  4635,7785,4891,6941,6952,7218,134,2718,7409,9551};
	  
	  System.out.println(mostFrequentEven(nums));
	}

	public static int mostFrequentEven(int[] nums) {
        
	       if (nums.length == 1) return nums[0];
	       
	        int count1 = 0 ;
	        int element1 = 0;
	        int count2 = 0 ;
	        int element2 = 0;
           Arrays.sort(nums);
	        for (int i = nums.length -1 ; i >=0;i--){
	           if (nums[i] %2 ==0){ 
	        	   System.out.println("element " + nums[i]);
	            if ( element1 == nums[i] && element2 != nums[i]){
	                  
	                  count1++;
	            }
	            else if ( element2 == nums[i]){
	                
	                  count2++;
	            }
	            else if (count1 == 0) {
	            	element1 = nums[i];
	            }
	            else if (count2 == 0) {
	            	  element2 = nums[i];
	            }
	            else{
	                count1--;
	                count2--;
	            }
	           }

	        }  

	         count1 = 0 ;
	          count2 = 0 ;
	        for (int ele : nums){
	            if (ele == element1){
	                count1++;
	            }
	            else if(ele == element2){
	                count2++;
	            }
	        }
	        if (count1 == 0 && count2 == 0) return-1;
	        System.out.println("count1 " + count1);
	        System.out.println("count2 " + count2);
	        System.out.println("element1 " + element1);
	        System.out.println("element2 " + element2);
	      //   count1 == count2 ? Math.min(element1,element2) : count1 > count2 ? element1 :element2;
	       
	       return count1 == count2 ? Math.min(element1,element2) : count1 > count2 ? element1 :element2;
	    }
}
