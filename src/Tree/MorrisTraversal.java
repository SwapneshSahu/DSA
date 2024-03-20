package Tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeNode.preBuild();
		 List<Integer> ans =inorderTraversal(root);
		for (int i :ans) {
			System.out.println(i);
		}

	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while(curr !=null){
          TreeNode leftNode = curr.left;

          if (leftNode ==null){
              ans.add(curr.val);
              curr = curr.right;
          }else{
              TreeNode rightMost = getRightMostNode(leftNode,curr);

              if(rightMost.right == null){ //link creator
                  rightMost.right = curr;
                  curr = curr.left;
              }
              else{ //link detacher
                  ans.add(curr.val);
                 curr = curr.right ;
                  rightMost.right =null ;
              }
          }


        }

        return ans;

    }

    public static TreeNode getRightMostNode(TreeNode left , TreeNode curr){

        while(left.right != null && left.right != curr){
            left = left.right;
        }

        return left;
    }

}
