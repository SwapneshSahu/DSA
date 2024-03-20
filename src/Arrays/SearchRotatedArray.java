package Arrays;

public class SearchRotatedArray {

	public static void main(String[] args) {
		int [] arr= new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
		System.out.println(binarySearch(arr, 2));

	}

	  public static boolean binarySearch(int[] nums ,int target){
		  int low = 0, high = nums.length - 1;

		  while (low <= high) {
		      int mid = (low + high) / 2;
		      if (nums[mid] == target) return true;

		      if (nums[low] == nums[mid]) {
		          // If the elements at the current low and mid indices are the same,
		          // we increment the low index to skip duplicates and continue the loop.
		          low++;
		          continue;
		      }

		      if (nums[low] <= nums[mid]) {
		          // If the elements from low to mid are in increasing order (i.e., left half is sorted),
		          // we check if the target lies within this sorted range.
		          if (nums[low] <= target && target <= nums[mid]) {
		              // If yes, then we narrow the search to the left half by updating the high index.
		              high = mid - 1;
		          } else {
		              // If the target doesn't lie in the left half, we narrow the search to the right half.
		              low = mid + 1;
		          }
		      } else {
		          // If the elements from mid to high are in increasing order (i.e., right half is sorted),
		          // we check if the target lies within this sorted range.
		          if (nums[mid] <= target && target <= nums[high]) {
		              // If yes, then we narrow the search to the right half by updating the low index.
		              low = mid + 1;
		          } else {
		              // If the target doesn't lie in the right half, we narrow the search to the left half.
		              high = mid - 1;
		          }
		      }
		  }

		  // If the loop exits without finding the target, return false.
		  return false;
		      
	     }

	  

	    
}
