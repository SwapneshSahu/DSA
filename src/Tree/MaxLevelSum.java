package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
/*1161. Maximum Level Sum of a Binary Tree*/
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode.buildTree(root);
		System.out.println(maxLevelSum(root));

	}

	public static  int maxLevelSum(TreeNode root) {

		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		que.offer(null);

		int sum = 0;
		int max = Integer.MIN_VALUE;
		int level = 1;
		int ans = 0;

		while (!que.isEmpty()) {
			TreeNode temp = que.poll();

			if (temp != null) {
				sum += temp.val;
				if (temp.left != null)
					que.offer(temp.left);
				if (temp.right != null)
					que.offer(temp.right);
				continue;
			} else if (!que.isEmpty()) {
				que.offer(null);
			}
			if (sum > max) {
				max = sum;
				ans = level;
			}
			level++;
			sum = 0;
		}

		return ans;
	}
}
