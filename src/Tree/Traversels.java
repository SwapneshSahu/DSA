package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class Traversels {

	public static void main(String[] args) {
		TreeNode root = TreeNode.preBuild();

		System.out.println(root);
		System.out.println("Inorder");
		inOrder(root);
		System.out.println("PostOrder");
		postOrder(root);
		System.out.println("PreOder");
		preOrder(root);

		System.out.println("LevelOrder");
		levelOrder(root);

		System.out.println("ZigZagLevelOrder");

		System.out.println(ZigZagLevelOrder(root).toString());

		System.out.println("Boundary Traversel");
		System.out.println(traverseBoundary(new TreeNode(1)).toString());

		System.out.println("Vertical Traversel");
		System.out.println(verticalTraversal(root).toString());
		
		System.out.println("Top View");
		System.out.println(topView(root).toString());
	}

	// LNR
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

	// LRN
	public static void postOrder(TreeNode root) {

		// base case
		if (root == null)
			return;

		// Left call;
		postOrder(root.left);

		// RightNode
		postOrder(root.right);

		// Node Print
		System.out.print(root.val + " ");

	}

	// NLR
	public static void preOrder(TreeNode root) {

		// base case
		if (root == null)
			return;

		// Node Print
		System.out.print(root.val + " ");

		// Left call;
		preOrder(root.left);

		// RightNode
		preOrder(root.right);

	}

	public static void levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {

			TreeNode tempNode = queue.poll();

			if (tempNode == null) {
				System.out.println();
				if (!queue.isEmpty()) {
					queue.add(null);
				}
			} else {
				System.out.print(tempNode.val + " ");

				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}

				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			}
		}

	}

	public static List<Integer> ZigZagLevelOrder(TreeNode root) {
		Stack<TreeNode> main = new Stack<>();
		Stack<TreeNode> child = new Stack<>();
		main.push(root);
		int level = 1;
		ArrayList<Integer> ans = new ArrayList<>();
		while (!main.isEmpty()) {
			TreeNode temp = main.pop();

			ans.add(temp.val);

			if (level % 2 != 0) { // odd L to R even R to L
				if (temp.left != null)
					child.push(temp.left);
				if (temp.right != null)
					child.push(temp.right);
			} else {
				if (temp.right != null)
					child.push(temp.right);
				if (temp.left != null)
					child.push(temp.left);
			}

			if (main.isEmpty()) {
				level++;
				main = child;
				child = new Stack<>();
			}

		}

		return ans;

	}

	public static ArrayList<Integer> traverseBoundary(TreeNode root) {
//	  //Approach 1) we print left tree first  excluding leaf node
//		         2) then leaf node
//	             3) right tree in reverse direction

		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		ans.add(root.val);

		// Traverse and store left sub tree
		traverseLeft(root.left, ans);

		// traverse and store leaf node for both sub tree left and right
		traverseLeaf(root.left, ans);
		traverseLeaf(root.right, ans);

		// traverse and store right sub tree but in reverse order
		traverseRight(root.right, ans);

		return ans;
	}

	public static void traverseRight(TreeNode root, ArrayList<Integer> ans) {
		// check for base case and leaf node
		if (root == null || (root.left == null && root.right == null))
			return;

		if (root.right == null) {// go in left
			traverseLeft(root.right, ans);

		} else {
			traverseLeft(root.left, ans);
		}
		ans.add(root.val); // add value when we come back to because we need to reverse

	}

	public static void traverseLeaf(TreeNode root, ArrayList<Integer> ans) {
		// check for base case and leaf node
		if (root == null)
			return;

		if ((root.left == null && root.right == null)) {
			ans.add(root.val);
			return;
		}

		// go in left
		traverseLeaf(root.left, ans);

		// go in right

		traverseLeaf(root.right, ans);

	}

	public static void traverseLeft(TreeNode root, ArrayList<Integer> ans) {
		// check for base case and leaf node
		if (root == null || (root.left == null && root.right == null))
			return;

		ans.add(root.val);
		if (root.left != null) {// go in left
			traverseLeft(root.left, ans);

		} else {
			traverseLeft(root.right, ans);
		}
	}

	public static ArrayList<Integer> verticalTraversal(TreeNode root) {
		if (root == null)
			return null;

		Queue<Pair> queue = new LinkedList<Pair>(); // for levelOrder traversal
		Map<Integer, ArrayList<Integer>> map = new TreeMap<>(); // to store values according to hd level
		queue.add(new Pair(0, root));
		while (!queue.isEmpty()) {

			Pair temp = queue.poll();

			// to store values in map
			if (map.containsKey(temp.hd)) {
				map.get(temp.hd).add(temp.root.val);
			} else {
				ArrayList<Integer> tt = new ArrayList<>();
				tt.add(temp.root.val);
				map.put(temp.hd, tt);
			}

			// for levelorder traversel

			if (temp.root.left != null) {
				queue.add(new Pair(temp.hd - 1, temp.root.left));
			}

			if (temp.root.right != null) {
				queue.add(new Pair(temp.hd + 1, temp.root.right));
			}

		}

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i : map.keySet()) {
			ans.addAll(map.get(i));
		}

		return ans;

	}

	public static ArrayList<Integer> topView(TreeNode root) {
		if (root == null)
			return null;

		Queue<Pair> queue = new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();

		queue.add(new Pair(0, root));
		while (!queue.isEmpty()) {

			Pair temp = queue.poll();
           // we store only one value
			if (!map.containsKey(temp.hd)) {
				map.put(temp.hd, temp.root.val);   
			}
			
			//Note :- For bottom view  - We just have to remove if condition and directly write
			// map.put(temp.hd, temp.root.val); as we need last values 

			// for levelorder traversel

			if (temp.root.left != null) {
				queue.add(new Pair(temp.hd - 1, temp.root.left));
			}

			if (temp.root.right != null) {
				queue.add(new Pair(temp.hd + 1, temp.root.right));
			}

		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i :map.keySet()) {
			ans.add(map.get(i));
		}
		
		return ans ;
	}

}

class Pair {

	int hd;
	TreeNode root;

	public Pair(int hd, TreeNode root) {
		super();
		this.hd = hd;
		this.root = root;
	}

	@Override
	public String toString() {
		return "Pair [hd=" + hd + ", root=" + root + "]";
	}
}
