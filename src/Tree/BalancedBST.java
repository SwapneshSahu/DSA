package Tree;

public class BalancedBST {

	public static void main(String[] args) {
		TreeNode root = TreeNode.preBuild();

		System.out.println(isBalanced(root)[0] == 1);

	}
  //O(N)
	public static int[] isBalanced(TreeNode root) {
		if (root == null) {
			int[] pair = new int[] { 1, 0 }; // index 0 is for boolean balanced or not
												// index 1 is for height

			return pair;
		}

		int[] pairLeft = isBalanced(root.left);
		int[] pairRight = isBalanced(root.right);

		boolean left = pairLeft[0] == 1;
		boolean right = pairRight[0] == 1;

		boolean diff = Math.abs(pairLeft[1] - pairRight[1]) <= 1; // checking diff b/w left and right sub tree is less
																	// than = 1 or not

		int[] ans = new int[] { 0, 0 };
		ans[1] = Math.max(pairLeft[1], pairRight[1]) + 1; // storing height value

		if (left && right && diff) { // is the only case when we can say purticular root is balanced if left right of
										// root is balanced as well diff is less then = 1
			ans[0] = 1;
		}

		return ans;
	}
}
