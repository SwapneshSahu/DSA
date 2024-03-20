package Tree;

public class MinAbsoluteDiffInBST {

	// Leetcode 530. Minimum Absolute Difference in BST
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Inorder Traversal : The inorder traversal of a BST is always in increasing
	 * order and the minimum absolute difference can occur b/w 2 consecutive
	 * elements in this order. eg: 1,2,3,4,6 The min diff is 1
	 */

	int prev = Integer.MAX_VALUE;
	int ans = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		inOrder(root);
		return ans;
	}

	public void inOrder(TreeNode root) {
		if (root.left != null)
			inOrder(root.left);
		ans = Math.min(ans, Math.abs(root.val - prev));
		prev = root.val;
		if (root.right != null)
			inOrder(root.right);
	}

}
