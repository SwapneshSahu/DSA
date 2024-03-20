package Arrays;

public class EqualPartition {

	public static void main(String[] args) {
		System.out.println(part());
		
		

	}
	
	public static int partrecursive(int []nums , int left , int right ) {
		
		if (left == right) return 0;
		
		int leftSum = 0;
		int rightSum =0;
		int start =left ;
		int end = right ;
		
		int ans =0 ;
		while (start <= end) {
			
			if (leftSum <=rightSum) {
				leftSum += nums[start];
				start++;
			}
			else{
				rightSum +=nums[end];
				end--;
			}
			
		}
		
		if (leftSum > rightSum) {
			ans = Math.max(ans ,rightSum  + partrecursive(nums, end+1,right ));
		}else if (leftSum < rightSum){
			ans = Math.max(ans ,leftSum  + partrecursive(nums, left,start-1 ));
		}
		else {
			 int temp = Math.max(Math.max(ans ,rightSum  + partrecursive(nums, end+1,right )),
					 Math.max(ans ,leftSum  + partrecursive(nums, left,start-1 )));
			 ans = Math.max(ans, temp);
		}
		
		
		return ans;
		
	
		
	}
	
	public static int part() {
		
		//int [] nums  = new int []{6,2,3,4,5,5};
		int [] nums  = new int []{6,8,11,15,20,25};
		
		return partrecursive(nums, 0, nums.length-1);
		
	/*	
		int i =0 ; 
		int j = nums.length-1;
		
		int ans =0 ;
		while (i != j) {
			
			int leftSum = 0;
			int rightSum =0;
			int start =i ;
			int end =j ;
			while (start <= end) {
				
				if (leftSum <=rightSum) {
					leftSum += nums[start];
					start++;
				}
				else{
					rightSum +=nums[end];
					end--;
				}
				
			}
			
			if (leftSum >= rightSum) {
				ans +=rightSum;
				i=end+1;
			}else {
				ans +=leftSum;
				j=start-1;
			}
			
			
		}
	
		return ans; */
		
	}

}
