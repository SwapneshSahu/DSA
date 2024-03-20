package Tree;

public class KthSmallest {
	public static void main(String[] args) {
        TreeNode root = TreeNode.preBuild();
        
      // inOrder(root);
        
        System.out.println(kthSmall(root, 2));
        
	}
	public static void inOrder(TreeNode root) {

		// base case
		if (root == null)
			return;

		// Left call;
		inOrder(root.left);

		// Node Print
		System.out.print(root.val + " ");

		// RightNode
		inOrder(root.right);

	}
	
	public static int kthSmall(TreeNode root , int k) {
		
		

			// base case
			if (root == null)
				return -1;

			// Left call;
			int left =kthSmall(root.left,k);

		if (left != -1) {
			System.out.println(left);
			return left;
		}
		k--;
		if (k ==0) return root.val;

			// RightNode
			return kthSmall(root.right,k);
	}
		
	
}
