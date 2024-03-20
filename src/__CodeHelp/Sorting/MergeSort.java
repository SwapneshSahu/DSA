package __CodeHelp.Sorting;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // No need to sort
        }
        int[] helper = new int[arr.length];
        mergeSort(arr, helper, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(arr, helper, low, middle); // Sort the left half
            mergeSort(arr, helper, middle + 1, high); // Sort the right half
            merge(arr, helper, low, middle, high); // Merge the sorted halves
        }
    }

    private static void merge(int[] arr, int[] helper, int low, int middle, int high) {
        // Copy both halves into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }

        int i = low; // Index for the left subarray
        int j = middle + 1; // Index for the right subarray
        int k = low; // Index for the merged array

        // Copy the smallest values from either the left or the right side back to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                arr[k] = helper[i];
                i++;
            } else {
                arr[k] = helper[j];
                j++;
            }
            k++;
        }

        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            arr[k] = helper[i];
            k++;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
