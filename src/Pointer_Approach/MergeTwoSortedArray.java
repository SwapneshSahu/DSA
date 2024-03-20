package Pointer_Approach;

public class MergeTwoSortedArray {
 
	//LeetCode 88. Merge Sorted Array and sort it in arr1 only
	 
	public static void main(String[] args) {

		int[] nums1 = new int[] { 1,2,13,0,0,0 };
		int[] nums2 = new int[] {12,15,16 };

		int[] nums3 = merge(nums1, 3, nums2, 3);

		for (int i : nums3)
			System.out.print(i + " ");

	}

	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

		int i = m - 1;
		int j = n - 1;
		int k = nums1.length - 1;

		if (m == 0) {
			while (j >= 0) {

				nums1[k--] = nums2[j--];
			}
		}

		while (j >= 0 && i >= 0) {
			if (nums1[i] < nums2[j]) {
				nums1[k--] = nums2[j--];
			} else {
				nums1[k--] = nums1[i--];
			}

		}

		while (j >= 0) {

			nums1[k--] = nums2[j--];
		}

		return nums1;
	}
}
