package Arrays;

import java.util.HashMap;

public class FindSingleNumber {

	public static void main(String[] args) {
		int [] nums = new int[] {2,2,1,1,4,4,3,6,6,100,100};
		
		System.out.println(singleNumber(nums));

	}
	
	public static int singleNumber(int[] nums) {
		int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }

}
