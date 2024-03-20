package Tree;

public class SumOfNode {

	public static void main(String[] args) {
		TreeNode root = TreeNode.preBuild();

		System.out.println(sumTreeFast(root)[0] == 1);
	}
	

	public static int[] sumTreeFast(TreeNode root){
	    
	    if (root == null){
	        int [] pair  = new int[]{1,0};
	        return pair;
	    }
	    // for leaf node we dont have to check
	    if (root.left == null && root.right ==null){
	        int [] pair  = new int[]{1,root.val};
	        return pair;
	    }
	     
	     int [] leftPair  = sumTreeFast(root.left);
	     int [] rightPair  = sumTreeFast(root.right);
	      
	      boolean left = leftPair[0] ==1 ;
	      boolean right = rightPair[0] ==1 ;
	      
	      boolean currSum = (leftPair[1] + rightPair[1] ) == root.val;
	      
	      int [] ans =  new int[]{0,0};
	     
	      if ( currSum && left&& right) {
	          ans[0] = 1;
	          ans[1] = root.val * 2;
	      }
	    
	    return ans;
	}

}
