package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum5 {

	static int ans =0;
	public static void main(String[] args) {
		
	int ans =combinationsDP(new int[] {1,2,3}, 4, 0, new int[5]);
	System.out.println("Ans" + ans);
		
	}
	
	
   public static  int combinationsDP(int [] arr , int target , int sum , int [] dp ) {
		System.out.println(Arrays.toString(dp));
	   
		if (target == sum ) {
			return ans++ ;
		}
		
		if (dp[sum] != 0)return ans;
		
		for (int i : arr) {
			
			if (i + sum <= target) {
			
			dp[sum] = combinationsDP(arr, target, sum+i, dp );
				
			}
		}
		return dp[target];
	}
	
	public static  void combinations(int [] arr , int target , int sum , List <Integer> com) {
		
		if (target == sum ) {
			System.out.println(com.toString());
			ans++;
			return ;
		}
		
		for (int i : arr) {
			
			if (i + sum <= target) {
				List<Integer> temp = new ArrayList<>(com);
				temp.add(i);
				combinations(arr, target, sum+i, temp);
				
			}
		}
	}
}
