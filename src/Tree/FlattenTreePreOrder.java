package Tree;

import java.util.List;

public class FlattenTreePreOrder {
	
	public static void main(String[] args) {
		
		TreeNode root = TreeNode.preBuild();
		 
	
		TreeNode ans =	flatten(root);
		
		while (ans !=null) {
			System.out.println(ans.val);
			ans= ans.right;
		}
		

	}
	
	public static TreeNode flatten(TreeNode root) {
		
		TreeNode curr = root;
		
		
		while(curr !=null) {
			
			if (curr.left !=null) {
				
				TreeNode leftNode = curr.left;
				
				TreeNode rightNode = getRightMostNode(leftNode, curr);
				
				rightNode.right = curr.right;
				
				curr.right = curr.left;
				curr.left =null;
			
			}
			curr = curr.right;
		}
		
		return root;
		
	}
	
	 public static TreeNode getRightMostNode(TreeNode left , TreeNode curr){

	        while(left.right != null && left.right != curr){
	            left = left.right;
	        }

	        return left;
	    }


}
