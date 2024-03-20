package __CodeHelp.Arrays.TwoPointer;

public class SeprateNegaPosit {

	/*
	https://www.codingninjas.com/studio/problems/move-all-negative-numbers-to-beginning-and-positive-to-end_1112620?leftPanelTab=0
	*/

	public static int[] separateNegativeAndPositive(int a[]) {

	       //Approach 1 Sort In  S(NlogN)  S (N) 

	       //Approach 2 Dutch National Flag / Two Pointer T(N) S(1)
	       
	       int low = 0 , high =a.length-1;
	       
	       while (high > low){
	           
	           if (a[low] <0){
	               low++;
	           }
	           else if(a[high] > 0){
	               high--;
	           }
	           else {
	               //swap both
	               int temp = a[low];
	               a[low]= a[high];
	               a[high] = temp;
	           }
	       }
	       return a;
	    }
}
