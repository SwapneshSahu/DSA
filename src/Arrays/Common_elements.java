package Arrays;

import java.util.ArrayList;

public class Common_elements {
	
	/*
	 * Given three arrays sorted in increasing order. Find the elements that are
	 * common in all three arrays. Note: can you take care of the duplicates without
	 * using any additional Data Structure?
	 */

	public static void main(String[] args) {
		int [] A = new int []{-97 ,-96 ,-89 ,-88 ,-53 ,-35 ,3 ,9 ,9 ,13 ,50};
		int [] B = new int []{-67 ,-67 ,-57 ,-49 ,-47 ,-17 ,-12 ,-6 ,34};
		int [] C = new int []{-78 ,-78 ,-73 ,-72 ,-68 ,-65 ,-61 ,-60 ,-59 ,-44 ,-41 ,-30 ,-25 ,-24 ,-22 ,-17 ,-14 ,-2 ,0 ,4 ,7 ,8 ,12 ,15 ,16 ,19 ,26 ,27 ,33 ,38 ,43};
	
		ArrayList<Integer> list = commonElements(A,B,C,A.length,B.length,C.length);
		
		System.out.println(list.size());
	}

	public static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0, j = 0, k = 0;

		while (i < n1 && j < n2 && k < n3) {
			int bIndex = check(B, A[i], j);
			int cIndex = check(C, A[i], k);

			if (bIndex != -1 && cIndex != -1) {
				if (!list.contains(A[i])) {
					list.add(A[i]);
				}
				j = bIndex;
				k = cIndex;

			}

			i++;

		}
		// if (list.size() == 0) return -1;
		return list;
	}

	public static int check(int arr[], int key, int start) {
		int end = arr.length;

		int mid = start + (end - start) / 2;

		while (start<=end && mid <arr.length) {

			if (key == arr[mid])
				return mid;

			if (key > arr[mid])
				start = mid + 1;
			else {
				end = mid - 1;

			}
			mid = start + (end - start) / 2;
		}

		return -1;
	}

}
