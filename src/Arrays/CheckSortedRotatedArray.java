package Arrays;

public class CheckSortedRotatedArray {

	public static void main(String[] args) {
		
		int[] nums = new int[] { 5,4,1,2,3};

			System.out.print(check(nums));
	}
	
	 public static boolean check(int[] nums) {
	        int count=0;
	        for (int i = 1 ; i <nums.length ;i++ ){
	             if (nums[i-1]>nums[i])count++;


	        }
	        if (nums[nums.length-1] > nums[0]) count++;

	        return count <=1;
	    }

}
