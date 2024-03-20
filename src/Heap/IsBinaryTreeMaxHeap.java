package Heap;

import Tree.TreeNode;

public class IsBinaryTreeMaxHeap {

	public static void main(String[] args) {                            
		TreeNode root = new TreeNode(10);
		
		TreeNode Firstleft = new TreeNode(20);
        TreeNode Firstright = new TreeNode(30);
		
		TreeNode secondLeft = new TreeNode(40);
		TreeNode secondRight = new TreeNode(50); 
		
		TreeNode thirdRight = new TreeNode(60); 
		
		root.left = Firstleft;
		root.right =Firstright;
		
		Firstleft.left = secondLeft;
		Firstleft.right =secondRight;
		
		Firstright.left = thirdRight;
		
		int count = count(root);
		System.out.println("actual count" + count);
		KthLargestNumber(root, 0);
		
     // System.out.println( isCBT(root,1,count) && isMaxHeap(root));
	}

	private static boolean isMaxHeap(TreeNode root) {
		if (root == null || (root.left ==null && root.right ==null)) return true; // when both null i.e lead node
		
		if (root.right == null) { // right is null so we only have to check for left 
			return root.left.val < root.val;
		}
	
		 return  root.left.val < root.val  &&  root.right.val <root.val  // to check current root
					&& isMaxHeap(root.left)  // to make recursive call to left
					&& isMaxHeap(root.right) ; // to make recursive call to right

	}

	private static boolean isCBT(TreeNode root, int index, int count) {
		if (root == null) return true;
		
		if (index > count) { // for 0 based indexing condition will be   index >= count
			return false;
		}else {          // for 0 based indexing left = 2*index +1 AND  right = 2*index +2
			return (isCBT(root.left,2*index , count) && isCBT(root.right, 2* index +1, count));
		}
		
	}

	private static int count(TreeNode root) {
	      if (root == null) return 0;
	      
	      int ans = 1 + count(root.left) +count(root.right);
		return ans;
	}
	
	static int leftCount =0;
	static int rightCount =0;
	static int count=0;
	public static int KthLargestNumber(TreeNode  root, int k) {
	 count =	countt(root);
		System.out.println(leftCount);
		System.out.println(rightCount);
		System.out.println(count);
		return 0;
	}

	public static int countt(TreeNode root){
		if (root == null) return 0;

		leftCount = count(root.left);
		rightCount = count(root.right);

		return 1+leftCount + rightCount;
	}
	
	
	

}
