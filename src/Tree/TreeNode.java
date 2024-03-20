package Tree;

import java.util.Scanner;

public class TreeNode {

    
     public TreeNode left;
     public TreeNode right;
     public int val ;
     
	public TreeNode(int val) {
		this.val = val;
		this.left =null;
		this.right=null;
				
	}
    
	public  static TreeNode buildTree(TreeNode root) {
		Scanner scanner = new Scanner(System.in);
		if (root.val == -1) {
			return null;
		}
		
		System.out.println("Enter Data for " + root.val + " left");
		int data = scanner.nextInt();
		root.left =  data != -1 ?  buildTree(new TreeNode(data)) :  null;
		System.out.println("Enter Data for " + root.val + " Right");
		data = scanner.nextInt();
		root.right =  data != -1 ?  buildTree(new TreeNode(data)) :  null;
				
		return root;
		
	}
	


	
	public static TreeNode preBuild() {
//		TreeNode a = new TreeNode(1);
//		TreeNode b = new TreeNode(2);
//		TreeNode c = new TreeNode(3);
//		
//		TreeNode d = new TreeNode(4);
//		TreeNode e = new TreeNode(5);
//		TreeNode f = new TreeNode(7); 
//		TreeNode g = new TreeNode(8);  
//		
//		TreeNode h = new TreeNode(6); 
//		TreeNode i = new TreeNode(9); 
//		TreeNode j = new TreeNode(10); 
//	
//		a.left = b;
//		a.right = c;
//		 
//		b.left = d;
//		b.right =e;
//		
//		e.left = f;
//		e.right =g;
//		
//		c.right = h;
//		h.right =i;
//		i.right =j;
//				
//		
//		return a;
		
		TreeNode a = new TreeNode(10);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(15);
		
		TreeNode d = new TreeNode(11);
		
		TreeNode e = new TreeNode(7);
		TreeNode f = new TreeNode(3);
		
		
		a.left = b;
		a.right = c;
		c.left = d;
		
		b.right = e;
		b.left =f;
		
		
		
		return a;
		
		
	}


	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}

	
	
}
