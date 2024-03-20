package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MinTimeToBurnTree {


	public static void main(String[] args) {
		TreeNode root = TreeNode.preBuild();
		
		TreeNode target = findingNode(root, 5);
		System.out.println(burn(target));

	}
	
	//Step 1 to create Mapping for Parent and Node
	
	static HashMap <TreeNode,TreeNode>  parent = new HashMap<>();
	static HashMap<TreeNode, Boolean> visited  = new HashMap<>();
	
	// Step2 Find Target and mapping parent
	
	public static TreeNode findingNode(TreeNode root , int target) {
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		TreeNode targetNode = null;
		que.add(root);
		parent.put(root,root);
		
		while (!que.isEmpty()) {
			TreeNode temp =  que.poll();
			visited.put(temp, false);
			
			if (temp.val == target) {
				targetNode = temp;
			}
			
			if (temp.left !=null) {
				parent.put(temp.left , temp);
				que.add(temp.left);
			}
			
			if (temp.right !=null) {
				parent.put(temp.right , temp);
				que.add(temp.right);
			}
		}
		
		return targetNode;
	}
	
	//Step 3 Burn From Target

	static int time =0;
	 
	public static int burn(TreeNode node ) {
		
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(node);
	
		while (!que.isEmpty()) {
			boolean flag = false;
			TreeNode root = que.poll();
			
			// check left
			if (root.left != null && !visited.get(root.left)) {
				visited.put(root.left, true);
				que.add(root.left);
				flag = true;
			}
			// check right
			if (root.right != null && !visited.get(root.right)) {
				visited.put(root.right, true);
				que.add(root.right);
				flag = true;
			}
			// check parent
			if (!visited.get(parent.get(root))) {
				visited.put(parent.get(root), true);
				que.add(parent.get(root));
				flag = true;
			}
			
			if (flag)
				time++;

		}
		
		return time; 
	}
	
	
}
