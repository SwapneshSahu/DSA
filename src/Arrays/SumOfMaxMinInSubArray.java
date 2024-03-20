package Arrays;

public class SumOfMaxMinInSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 5, -1, 7, -3, -1, -2};
		int k = 4;
		System.out.println(maxMin(arr, k));
	}

	
	public static int maxMin(int [] arr ,int k) {
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0 ;
		for (int i =0 ; i <k ;i++) {
			if (arr[i] > max) max=arr[i];
			if (arr[i] < min) min=arr[i];
		}
		sum +=max + min;
		for (int i = k ; i <arr.length ;i++) {
			if (arr[i] > max) max=arr[i];
			if (arr[i] < min) min=arr[i];
			
			sum +=max + min;
			
			
		}
		
		return sum;
	} 
	
}
