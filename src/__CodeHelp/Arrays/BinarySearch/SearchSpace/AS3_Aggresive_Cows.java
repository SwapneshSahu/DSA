package __CodeHelp.Arrays.BinarySearch.SearchSpace;

import java.util.Arrays;

public class AS3_Aggresive_Cows {

	public static void main(String[] args) {
		int [] arr = new int [] {1,2,5,7,10};
		
		System.out.println(aggresiveCows(arr, 3));

	}
	
	public static int aggresiveCows(int[] arr , int cows) {
		
		Arrays.sort(arr);
		
		int low =1;
		int high = arr[arr.length-1];
		int ans=-1;
		
		while(low<=high) {
			int mid = low + (high-low)/2 ;
			int count = possible(arr,mid) ;
			if ( count >= cows) {
				ans =mid ;
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		
		return ans;
	}

	public static int possible(int[] arr, int mid) {
		int c =1;
		int lastPlaced =0;
		
		for(int i =1 ; i <arr.length ;i++) {
			if (arr[i] - arr[lastPlaced] >= mid) {
				c++;
				lastPlaced=i;
			}
		}
		return c;
	} 

}
