package __CodeHelp.Arrays.BinarySearch.Classical;

public class PeakIndexInMountainArray {

//	LeetCode - 852
	
	/**
	 * First occurence of target
       Last Occurence of target
       Total Occurence of target*/
	
	 public int peakIndexInMountainArray(int[] arr) {
	        //binary solution more readable and easy to understand
	        int left =0 ;
	        int right = arr.length-1;


	  //Left <= right or  left < right dono k hisab se while loop me thode change krne honge 
	  
	      while(left < right){ 
	          //Agar yaha equal ki condition lgayi to infinite loop me fas jayenga end=mid k case me 
	         int mid = left  + (right-left)/2;

	         if (arr[mid] < arr[mid+1] ){
	             //mtlb hm left line me hai or hmarapeak right side me hai
	             left= mid+1;
	         }
	         else{
	             //mtlb hm right line me hai or hmara peak left side me hai
	             right = mid;  // mid -1 isliya nahi kiya q ki ho skta hai mid he hmara peak ho 

	             //agar hm ye wala if block likhte to mid-1 kr skte tha 
	            //   if (mid>0 && mid < arr.length-1 && arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
	            //     return mid;
	            // }
	         }

	      }
	     //jb loop se bahar ayenga left to right dono peek pr hi honge
	    return left;

	     /*   while (left <=right){
	            int mid = left  + (right-left)/2;

	            if (mid>0 && mid < arr.length-1 && arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
	                return mid;
	            }
	            else if ( arr[mid] < arr[mid+1]){
	                left =mid+1;
	            }else{
	                right =mid-1;
	            }
	        }
	        

	        return -1;*/
	    }
}
