package DSASheet251.Arrays;

public class O4_EquilibriumIndex {
/**Problem link */ 
// https://www.codingninjas.com/codestudio/problems/equilibrium-index_893014?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=1	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//tricky cases   0 0 0 0 0 0 0   output 0
	//               18 2 9 2 18     output 2   if you check rightSum == leftSum on beggining it will give ans as 1 which is wrong
	// T(n + n )  S(1)
	public static int arrayEquilibriumIndex(int[] arr){ 
	    int rightSum =0;
		int leftSum =0;
		for (int i : arr) rightSum +=i;  // will take total sum


		for(int i =0 ; i<arr.length;i++){
            rightSum -=arr[i];               // this index is equilibrium then we have exclude it from rightSum 
			if (rightSum == leftSum) return i;
			leftSum +=arr[i]; // if it is note then this index is part of left one and so we already removed from right
		}
		 return -1;
	}

}
