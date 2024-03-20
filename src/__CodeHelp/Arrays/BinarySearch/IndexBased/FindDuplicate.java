package __CodeHelp.Arrays.BinarySearch.IndexBased;

class FindDuplicate {
//LT -287
	public static void main(String[] args) {
		// int [] nums = new int [] {1,2,3,4,5,6,7,8,9,9};
		int[] nums = new int[] { 9, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		System.out.println(findDuplicate(nums));
		
		System.out.println(Math.round(44.0894));

	}

	public static int findDuplicate(int[] nums) {
		/*
		 * //Approach 1 Sort the Array T(NlogN) S(N) //problem Space and time complexity
		 * //Sort array and check if i == i+1 that means it is a duplicate element
		 * Arrays.sort(nums);
		 * 
		 * for (int i =0 ; i <nums.length-1 ;i++){ if( nums[i] ==nums[i+1]) return
		 * nums[i]; } return -1;
		 */

		/*****************************************/

		/*
		 * //Approach 2 Create a Boolean array to check Visited T(N) S(N) // we use this
		 * statement /*each integer is in the range [1, n] inclusive. // so we consider
		 * each element as a index and mark it as true and if we land on same index
		 * //that means it is duplicate so we return it as ans
		 * 
		 * //Problem Time Complexity is come to N But we still taking Extra space
		 * boolean [] check= new boolean [nums.length];
		 * 
		 * for (int i : nums){ if (check[i]) return i; else{ check[i] =true; } } return
		 * -1;
		 */

		/*****************************************/

		// Approach 3 Negative marking index T(N) S(1)

		// We get element and go to that index and mark that index element as number and
		// if again
		// we reach that index and if it is negative element that means it is duplicate
		// For example [1,3,4,2,2] at index 3 we have element 2 so we go on index 2
		// which has element 4
		// we mark 4 as negative now when we go to index 4 we have element 2 so we go to
		// index 2 and find 4 as already negative that means it is duplicate .

		// problem this is the best time and space complexity which we can achieve but
		// we are modifying
		// array which is not allowed as per question

//		         for (int i =0 ; i <nums.length ; i++){
//		             int index = Math.abs(nums[i]); 
//		             //taking abs because it might be visited and marked negative

//		             //it means that index is already visited so foun duplicate
//		             if (nums[index] <0) return index;

//		              //marking visited 
//		              nums[index] *=-1;
//		         }

//		      return -1;

		/*****************************************/

		// Approach 4 Binary Search
		int low = 1;
		int high = nums.length - 1; // Since the range is [1, n]

		while (low < high) {
			int mid = low + (high - low) / 2;
			int count = 0;

			for (int num : nums) {
				if (num <= mid) {
					count++;
				}
			}

			if (count > mid) {
				// The repeated number must be in the range [low, mid]
				high = mid;
			} else {
				// The repeated number must be in the range [mid+1, high]
				low = mid + 1;
			}
		}

		return low;

	}

	/***
	 * If count > mid: If the count of elements in the array that are less than or
	 * equal to the current mid-point (mid) is greater than mid, then this means
	 * that there are more elements in the array that fall within the range [1, mid]
	 * than there should be if each number from 1 to mid were unique. This implies
	 * that the repeated number must be in the range [1, mid], as there are more
	 * occurrences of this number than any other number in that range.
	 * 
	 * If count <= mid: If the count of elements in the array that are less than or
	 * equal to the current mid-point (mid) is less than or equal to mid, then this
	 * means that there are fewer or equal elements in the array that fall within
	 * the range [1, mid] than there should be if each number from 1 to mid were
	 * unique. This implies that the repeated number must be in the range [mid+1,
	 * high], as the count of occurrences of this number must be greater in that
	 * range to account for the missing occurrences in the previous range.
	 */
}
