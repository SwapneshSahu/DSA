package __CodeHelp.Arrays.BinarySearch.IndexBased;

import java.util.Arrays;

public class HIndex {
//274. H-Index
	public static void main(String[] args) {
		//System.out.println(hIndex(new int[] { 1, 3, 1 }));

	}

	public int hIndex(int[] citations) {
		// Arrays.sort(citations);

		int left = 0;
		int right = 1000; // citations[citations.length - 1];
		int ans = Integer.MIN_VALUE;
		while (left <= right) {
			int mid = left + (right - left) / 2;

			// int midIndex = findIndex(mid, citations);
			int temp = findCount(mid, citations);  // this is much faster without using Arrays.sort
			// int temp = citations.length - midIndex;

			if (temp < mid) {

				right = mid - 1;
			} else {
				if (mid > ans)
					ans = mid;
				left = mid + 1;
			}
		}

		return ans;

	}

	public int findCount(int num, int[] citations) {
		int count = 0;

		for (int i : citations) {
			if (i >= num)
				count++;
		}
		return count;
	}

	public int findIndex(int num, int[] citations) {
		int left = 0;
		int right = citations.length - 1;
		int ans = -1;
		while (left <= right) {

			int mid = left + (right - left) / 2;

			if (citations[mid] == num || citations[mid] > num) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return ans;

	}
}
