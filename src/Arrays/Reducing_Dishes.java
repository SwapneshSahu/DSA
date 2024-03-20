package Arrays;

import java.util.Arrays;

public class Reducing_Dishes {

	public static void main(String[] args) {
	int [] arr = new int[] {-9,-7,-1,0,5};
	
	System.out.println(maxSatisfaction(arr));

	}
	
	 public static  int maxSatisfaction(int[] satisfaction) {
	        Arrays.sort(satisfaction);
	        int postSum=0,cur=0,res=0;
	        for(int i=satisfaction.length-1; i>=0; i--){
	            postSum += satisfaction[i];
	            cur += postSum;
	            res = Math.max(res, cur);
	        }
	        return res;
	    }

}
