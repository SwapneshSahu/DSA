package __CodeHelp.Arrays.TwoPointer;

public class MinSubArraySum {

	public static void main(String[] args) {
		int [] arr = new int [] {3,1,2,4};
		
		System.out.println(sumSubarrayMins(arr));
	}
	
//	Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
//	Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
//	Sum is 17.
	 public static int sumSubarrayMins(int[] arr) {
		 int sum = 0;

	        for (int i =0 ; i < arr.length ;i++){
	             sum +=arr[i];
	        }
	        
	        for (int i =0 ; i < arr.length -1;i++){  
	        	int maxMin = Integer.MAX_VALUE;
	                maxMin = Math.min(maxMin , arr[i]);          
	          for (int j =i+1 ; j < arr.length ;j++){
	                maxMin = Math.min(maxMin , arr[j]); 
	                
	                sum = (sum + maxMin) ;

	          }
	        }

	        return sum;
	    }

	    public static int minCreate(int [] arr , int left , int right){         
	          int min =Integer.MAX_VALUE ;
	        for (int i =left ; i <= right;i++){                       
	             min = Math.min(arr[i],min);
	        }
	 
	         return min; 
	    }

}
