package Binary_Search;

public class Pivot_SortedRotatedArray {

	public static void main(String[] args) {
		// Similary we can find element in Sorted Rotated Array also finding pivot and
		// by comparing pivot and target.

		int[] arr = new int[] { 6, 7, 8, 11, 12, 3, 4 };

		System.out.println("Pivot index is : " + pivot(arr));
	}

	public static int pivot(int arr[]) {

		int start = 0;
		int end = arr.length - 1;

		int mid = start + (end - start) / 2;

		while (start < end) {

			if (arr[mid] > arr[0]) {
				start = mid + 1;
			} else {
				end = mid;
			}
			mid = start + (end - start) / 2;
		}

		return start;
	}

}
