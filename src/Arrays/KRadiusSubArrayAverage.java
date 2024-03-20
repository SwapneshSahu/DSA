package Arrays;

import java.util.Arrays;

public class KRadiusSubArrayAverage {

	//leetcode 2090. K Radius Subarray Averages

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] getAverages(int[] nums, int k) {
		int[] ans = new int[nums.length];
		Arrays.fill(ans, -1);
//using this if statement to optimize the solution a bit we need
// sum as long  when k > 1000 because of which sum will not face
		// integer overflow and in other case int will work fine and take
//less space  
		if (k > 1000) {
			long sum = 0;

			for (int i = 0; i < nums.length; i++) {
				sum += (long) nums[i];
				if (i >= 2 * k) {
					ans[i - k] = (int) (sum / (2 * k + 1));
					sum -= (long) nums[i - 2 * k];
				}

			}
			return ans;
		}

		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (i >= 2 * k) {
				ans[i - k] = (sum / (2 * k + 1));
				sum -= nums[i - 2 * k];
			}

		}
		return ans;

	}

}
