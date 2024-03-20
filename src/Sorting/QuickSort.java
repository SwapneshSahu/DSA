package Sorting;

import java.util.List;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] { 0,100, 4, 2, 1, 8, 4, 1, 5, 33, 11, 900,-1 };
		quickSort(arr,0,arr.length-1);
		
		for (int i: arr) System.out.print(i + " ");
	}
	
	/*
	 * Approach - we will choose one pivot number and then place it to a right
	 * Position by calculating count of number less then it and then place it at its
	 * Original index , not we will check all the elements to its right should be
	 * greater and on its left should be smaller if not then we will swap them So
	 * after each iteration we will get one number at its right position and in its
	 * left and right elements smaller and greater respectively Now with the similar
	 * logic by calling recursive function we sort arrays of left and right part
	 */
	public static void quickSort(int []arr , int start , int end) {
		
		if (start>=end) return;
		
		int pivot = partition(arr,start,end);
		
		// solving right and left part of pivot by recursive call;
		quickSort(arr,start,pivot-1);
		quickSort(arr,pivot+1,end);
		
		
	}

	private static int partition(int[] arr,int start ,int end) {
		
		int pivotNum = arr[start];
		
		int counMin = 0;
		
		// counting number less then pivot number
		for (int i =start+1  ; i <=end;i++) {
			if(arr[i] < pivotNum ) counMin++;
		}
		
		// Swaping pivot number to its orignal positon
		int pivotIndex =start+counMin ;
		int temp = arr[start];
		arr[start] = arr[pivotIndex];
		arr[pivotIndex] = temp;
		
		int i = start ; int j = end;
		
		// Making sure all the elements to left is small and right is larger and swaping accordingly
		while(i <pivotIndex && j> pivotIndex) {
			 
			while(arr[i] <pivotNum) {
				i++;
			}
			while(arr[j] >pivotNum) {
				j--;
			}
			
			if ( i <pivotIndex && j> pivotIndex) {
				int tempVar = arr[i];
				arr[i] = arr[j];
				arr[j] = tempVar;
			}
			i++;
			j--;
		}
		
		// passing pivot index so that we can solve left and right part of array 
		return pivotIndex ;
	}

}
