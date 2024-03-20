package Heap;

import java.util.Arrays;

import Tree.TreeNode;

public class Merge2MaxHeap {
	
	public static void main(String[] args) {
	int [] a = new int [] {5, 5, 5, 5, 5};
	int [] b = new int [] {10, 8, 6, 4, 2};
	
	System.out.println(Arrays.toString(mergeHeaps(a, b, a.length, b.length)));
	//10, 8, 6, 5, 5, 5, 5, 4, 2]
	}

	public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
		// step 1 merge both array in one

		int[] ans = new int[n + m];

		for (int i = 0; i < n; i++)
			ans[i] = a[i];

		for (int i = 0; i < m; i++)
			ans[n + i] = b[i];

		// now we use heapify function
	
		int size = n + m; 
		// we are using 0 based indexing
		for (int i = ((size / 2) - 1); i >= 0; i--) {
			heapify(ans, i);
		}

		return ans;
	}

	public static void heapify(int[] arr, int index) { // O (n)
		int largest = index;
		int left = 2 * index + 1; // finding chlid using 0 based ondexing
		int right = 2 * index + 2;
		int n = arr.length;

		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != index) { // that means root is smaller then child
			int temp = arr[largest];
			arr[largest] = arr[index];
			arr[index] = temp;
			heapify(arr, largest); // recursive call to check again the new elemet is at correct postion or not
		}

	}
	

}
