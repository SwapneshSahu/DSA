package Arrays;

public class Rearrange_Array_bySign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int [] arr = new int [] {3,1,-2,-5,2,-4};
    int [] ans = rearrangeArray(arr);
    
    for (int i : ans)System.out.print(i + " ");
	}

	public static int[] rearrangeArray(int[] nums) {
		 int[] res = new int[nums.length];
	        int eIdx = 0;
	        int oIdx = 1;
	        
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] > 0) {
	                res[eIdx] = nums[i];
	                eIdx += 2;
	            } else {
	                res[oIdx] = nums[i];
	                oIdx += 2;
	            }
	        }
	        return res;
	}

	

}
