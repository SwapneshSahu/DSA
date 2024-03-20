package Binary_Search;

public class PeakIndexInMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LeetCode 852. Peak Index in a Mountain Array
		int[] arr = new int[] { 0,10,15,2};
		
		System.out.println("Peak index is : "+peakIndexInMountainArray(arr));
	}

	public static int peakIndexInMountainArray(int[] arr) {

		// WIll USE Binary Search Operation to solve it in O(logN)

		int start = 0;
		int end = arr.length - 1;
		int mid = start + (end - start) / 2;// To avoid int over flow

		while (start < end) {
			if (arr[mid] < arr[mid + 1]) {
				start = mid + 1;
			} else {
				end = mid;
			}
			mid = start + (end - start) / 2;
		}
		return start;
	}

}
