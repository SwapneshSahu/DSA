package Arrays;

public class FindDuplicate {
//287. Find the Duplicate Number
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 1, 2, 3, 4, 3 };
	System.out.println(	findDuplicate(a));
	}
	public static int findDuplicate(int[] nums) {
        boolean [] check= new boolean  [nums.length];

        for (int i : nums){
            if (check[i]) return i;
            else{
                check[i] =true;
            }
        }
        return -1;
    }
/*	public static int findDuplicate(int[] nums) {
        if(nums.length ==0 )
            return 0;
        int slow=0, fast=0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            if(slow == nums[slow])
                return slow;
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast){
            if(slow == nums[slow])
                return slow;
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    } */
}
