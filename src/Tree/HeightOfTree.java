package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HeightOfTree {

	public static void main(String[] args) {
		
		TreeNode root = TreeNode.preBuild();
		
		System.out.println("Binary Tree");
		Traversels.levelOrder(root);
		System.out.println("Max Height of Binary Tree" + heightOfTree(root));

	}

	//TC - O(N) 
	public static int heightOfTree(TreeNode root) {
		//base case 
		if (root == null) return 0;
		
		//Find Left and Right height 
		
		int left = heightOfTree(root.left);
		int right = heightOfTree(root.right);
		
		 
		return Math.max(left, right)+1;
	}
	
	public List<Integer> largestValues(TreeNode root) {
	      List<Integer> ans = new ArrayList<>();
	      if (root == null) return ans; 
	        
	        Queue<TreeNode> mainQueue = new LinkedList<>();
	        Queue<TreeNode> childQueue = new LinkedList<>();
	          mainQueue.add(root);
	        int level = 1;
	        while(!mainQueue.isEmpty()){
	              TreeNode temp = mainQueue.poll();
	              if (temp.val > ans.get(level)) ans.add(level,  temp.val);

	              if(temp.left !=null) childQueue.add(temp.left);
	              if(temp.right !=null) childQueue.add(temp.right);

	            if (mainQueue.isEmpty()){
	                mainQueue = childQueue;
	                childQueue = new LinkedList<>();
	                level++;

	            }
	        }
	      return ans;
	    }
}
