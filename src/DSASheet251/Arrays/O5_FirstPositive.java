package DSASheet251.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O5_FirstPositive {
	/**Problem link */ 
	//   https://leetcode.com/problems/first-missing-positive/description/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer>  ans1 = new ArrayList<>();
		 ans1.add(10);
		 ans1.add(3);
		 ans1.add(2);
		 ans1.add(1);
		 ans1.add(31);
		System.out.println(ans1.toString());
		ans1.removeAll(ans1);
		System.out.println(ans1.indexOf(110));
		ans1.indexOf(10);
		int[] arr = new int[] { 2, 6, 3, 1, 5, 7, 4, 8, 9, 11 };
		
//		System.out.println(firstMissingPositiveLinearTime(arr));  // T(N) Linear  S(1) constant Space
//		System.out.println(firstMissingPositiveWithExtraTime(arr,arr.length)); // T(NLogN) (because of sorting)  S(1) constant Space
//		System.out.println(firstMissingPositiveWithExtraSpace(arr,arr.length)); // T(N) Linear  S(N) extra space for Boolean array
	}

	

	/** 
	 * Intutution The basic idea is to rearrange the array such that all positive
	 * integers from 1 to n (where n is the length of the array) are at their
	 * correct positions in the array. For example, the value 1 should be at index
	 * 0, the value 2 should be at index 1, and so on.
	 * 
	 * To do this, the code iterates through the array and checks each value. If the
	 * value is positive and falls within the range of 1 to n, and if it's not
	 * already in its correct position (i.e., if it's not equal to i+1), the code
	 * swaps it with the value at its correct position. This process continues until
	 * all positive integers from 1 to n are in their correct positions.
	 * 
	 * After the array has been rearranged, the code then iterates through the array
	 * again to find the first missing positive integer. If an integer is found that
	 * is not equal to i+1, that means i+1 is the smallest missing positive integer.
	 * If no missing positive integer is found, the code returns n+1.
	 **/ // T(N) Linear  S(1) constant Space
	public static int firstMissingPositiveLinearTime(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {

			if (arr[i] > 0 && arr[i] <= n // we don't care about negative number and number greater than n
					&& arr[i] != i + 1 // to check if number is at its correct postion
					&& arr[arr[i] - 1] != arr[i]) { // to check if number is allready seated on its correct postion this
													// we have in case of duplicate entry like [1,1]
				// will swap the numbers with current index and with the index
				// where this arr[i] should be there in sorted array

				// swap(arr[i] ,arr[arr[i]-1])

				int temp = arr[arr[i] - 1];
				arr[arr[i] - 1] = arr[i]; // -1 to take care of indexing
				arr[i] = temp;
				i--; // i-- because if want to itreate over same index again as the element at this
						// index is changed
			}

		}

		for (int i = 0; i < n; i++) {

			if (arr[i] != i + 1) // this will work even though we have all negative numbers because if their is
									// no 1 at index 0 in array thats mean 1 is our ans
				return i + 1;

		}
		return n + 1;
	}

	public static int firstMissingPositiveWithExtraTime(int[] arr, int n) {
		Arrays.sort(arr);
		int ans = 1;
		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				if (arr[i] != ans)
					return ans;
				ans++;
			}
		}
		return ans;
	}
	
	
	private static int firstMissingPositiveWithExtraSpace(int[] arr, int n) {
		
		boolean [] check = new boolean[n];
		
		for (int i : arr) {
			if (i >0 && i <=n) {
				check[i-1] = true;
			}
			
		}
		
		for (int i = 0 ; i <check.length ;i++) {
			if (!check[i] ) return i+1;
		}
		
		return n+1;
	}

}
