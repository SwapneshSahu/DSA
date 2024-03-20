package Tree;

import java.util.ArrayList;
import java.util.List;

public class SumRootOfLeafNumber {

	
	static int maxSum =0;
	public static void main(String[] args) {
		TreeNode root = TreeNode.preBuild();
		help(root, root.val );
		System.out.println(ans);

	}

	
	static int ans = 0;
	public static void help(TreeNode root, int sum) {
	
		if (root == null ) return ;
		if (root.left == null && root.right==null) {
			ans +=sum;
		}
		
if (root.left !=null) help(root.left , sum*10 + root.left.val);
if (root.right !=null)help(root.right , sum*10 + root.right.val);
		
	}
}
