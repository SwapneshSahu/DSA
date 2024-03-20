package Arrays;

import java.util.Arrays;

public class InversionCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 static long inversionCount(long arr[], long N)
	    {
	        int count =0;
	        long [] temp = new long [(int)N];
	        for (int i = 0 ; i<N ;i++) temp[i] = arr[i];
	        
	        Arrays.sort(temp);
	        if (temp.equals(arr)) return 0;
	        for (int i = 0 ; i<N ; i++){
	            int j  = check(arr[i] ,temp);
	            
	            if (j > i){
	                count += (j-i);
	            }
	            
	        }
	        return count;
	        
	    }
	    
	    
	    static int check(long key , long [] temp){
	        
	        int start = 0 ; 
	        int end = temp.length-1;
	        
	        int mid = start + (end-start)/2;
	        
	        while(start<=end){
	            
	            if (key == temp[mid]) return mid;
	            
	            if (key > temp[mid]) start=mid+1;
	            else{
	                end = mid-1;
	            }
	            
	            mid = start + (end-start)/2;
	        }
	        
	    return -1;
	     
	    }

}
