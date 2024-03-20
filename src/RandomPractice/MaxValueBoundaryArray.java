package RandomPractice;

import java.util.Arrays;

public class MaxValueBoundaryArray {

	public static void main(String[] args) {
		System.out.println(maxValue(7, 5, 30));

	}
	public static int  maxValue(int n, int index, int maxSum) {

		int toLeft = index;
		int toRight= n-index-1;
		
		int start =0;
		int end = maxSum;
		
		while (start <= end) {
			
			int mid = start +(end-start)/2;
			
			int tempSum = maxSum;
			tempSum -= mid;
			
			
			
			
			if (tempSum == 0) return mid;
			else if (tempSum > 0) {
				start = mid+1;
			}
			else {
				end= mid-1;
			}
		}
		
		return -1;
    }

}
