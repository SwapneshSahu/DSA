package Tree;

public class DiameterOfTree {

	public static void main(String[] args) {
		TreeNode root = TreeNode.preBuild();

		System.out.println("Binary Tree");
		Traversels.levelOrder(root);
		System.out.println("Diameter Binary Tree" + diameterFromHeight(root) + "    " + diameter);
		System.out.println("Diameter Binary Tree" + diameter(root) + "    " );
	}

	static int  diameter = 0;  // represent diameter 
	// TC - O(N)
	public static int diameterFromHeight(TreeNode root) {
		// base case
		if (root == null)
			return 0;

		// Find Left and Right height

		int left = diameterFromHeight(root.left);
		int right = diameterFromHeight(root.right);

		diameter = Math.max(diameter, right +left +1); // same code as we have for height by adding this  we can calculate diameter at the same code 
		
		return  Math.max(left, right)+1;

	}

	// -O(N2)
	public static int diameter(TreeNode root) {

		if (root == null)
			return 0;

//		we have three option 1) Max dia is in left node 
//		                     2) Max dia is in right node
//                             3) Max dia is in both node which we can find by height

		int opt1 = diameter(root.left);
		int opt2 = diameter(root.right);
		int opt3 = HeightOfTree.heightOfTree(root);

		return Math.max(opt1, Math.max(opt2, opt3)) + 1;

	}

}
 