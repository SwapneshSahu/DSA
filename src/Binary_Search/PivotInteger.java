package Binary_Search;

public class PivotInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		System.out.println(pivotIntege(214747));
		long end = System.currentTimeMillis();
		
		System.out.println("Total time Taken " + (end - start));
	}
	

	 public static int pivotInteger(int n) {
			/* int count=0; */
	        int totalSum = n * (n + 1) / 2;
	        for (int i = 1; i <= n; i++) {
				
	            int sum = i * (i + 1) / 2;            
	            if (sum == totalSum - sum + i) {
	                return i;
	            }
	        }
	        return -1;
	    }
	 
	 public static int pivotIntege(int n) {

	        if (n==1) return 1;
	        int start = 0 ;
	        int end = n;
	        
	        int mid = start +(end-start)/2;
	    
	        while(start<end){
	        	
	            int LHS = 0;
	            int RHS =0;
	            int temp=mid;
	            while(temp>=0){
	                LHS += temp;
	                temp--;
	            }
	            temp=mid;
	            while( temp <= n){
	                 RHS += temp; 
	                 temp++;
	            }

	           if (LHS == RHS) return mid;
	           else if ( LHS < RHS){
	                 start = mid+1;
	           }
	           else{
	               end = mid-1;
	           }
	            
				mid = start + (end - start) / 2;
	        }
	        
	        return -1;
	    }
}
