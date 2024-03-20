package SlidingWindow;

import Tree.TreeNode;

public class BinarySubArraySum {
	
public int diameterOfBinaryTree(TreeNode root) {
        
        if (root == null) return 0;

        //left 
        int left = 1+  diameterOfBinaryTree(root.left);
      //  System.out.println("left " + left);
        //right
         int right =1 + diameterOfBinaryTree(root.right);
 // System.out.println("right " + right);
         return  Math.max(left,right);
    }
	
//LT930
	public static void main(String[] args) {

		int[] nums = new int[] { 1, 0, 1, 0, 1 };

		System.out.println(numSubarraysWithSum(nums, 2));

	}

	// Sliding WIndow Reduced Space
	public static int numSubarraysWithSum(int[] nums, int goal) {

		int count = 0;
		int currSum = 0;

		int i = 0;
		int j = 0;
		int zero_count = 0;
		while (j < nums.length) {
			currSum += nums[j];

			while (i < j && (nums[i] == 0 || currSum > goal)) {
				if (nums[i] == 0)
					zero_count++;
				else {
					zero_count = 0;
				}

				currSum -= nums[i];
				i++;

			}

			if (currSum == goal) {
				count++;
				count += zero_count;
			}

			j++;

		}

		return count;
	}
}
