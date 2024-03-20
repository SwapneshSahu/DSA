package Tree;

public class SumOFLongestPath {
	static  int maxSum = Integer.MAX_VALUE;
    static  int maxLen = 0 ;
	public static void main(String[] args) {
		TreeNode root = TreeNode.preBuild();
     
		System.out.println(root.toString());
		System.out.println("sum");
		solve(root, 0, 1);
	System.out.println(maxLen+ " " + maxSum);

	}
	
	//pair 0 = sum 
	//pair 1 = length
	 
	public static void solve(TreeNode root,int sum ,int len ) {
		if (root== null) {
			
			if (len >maxLen) {
				maxLen = len;
				maxSum = sum;
			}
			else if (len == maxLen) {
				maxSum = Math.max(sum, maxSum);
			}
			 return ;
		}
		sum += root.val;
		
		solve(root.left, sum, len+1 );
		solve(root.right, sum,  len+1);
		
		
		
	}

}
