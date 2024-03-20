package Binary_Search;

public class First_Last_Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LeetCode 34. Find First and Last Position of Element in Sorted Array
//      Find the first and last index of a target in a sorted array

		int[] arr = new int[] { 1, 1, 2, 3, 4, 5, 5, 6, 6, 6 };
		
		System.out.println("First index of target number is : "+first(arr,4));
		System.out.println("Last index of target number is : "+last(arr,4));
	}

	public static int first(int[] arr, int target) {

		int start = 0;
		int end = arr.length - 1;
		int ans = -1;

		int mid = start + (end - start) / 2;

		while (start <= end) {

			if (arr[mid] == target) {
				ans = mid;
				end = mid - 1;
			} else if (arr[mid] > target) {
				end = mid - 1;

			} else {
				start = mid + 1;
			}
			mid = start + (end - start) / 2;
		}

		return ans;
	}
	public static int last(int[] arr, int target) {

		int start = 0;
		int end = arr.length - 1;
		int ans = -1;

		int mid = start + (end - start) / 2;

		while (start <= end) {

			if (arr[mid] == target) {
				ans = mid;
				start= mid + 1;
			} else if (arr[mid] > target) {
				end = mid - 1;

			} else {
				start = mid + 1;
			}
			mid = start + (end - start) / 2;
		}

		return ans;
	}
}
