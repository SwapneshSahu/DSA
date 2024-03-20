package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Non_Decreasing_Subsequences {

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 6, 7, 7 };
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		List<Integer> holder = new ArrayList<Integer>();

		A(res, holder, 0, nums);
		System.out.println(res);

	}

	public static void A(Set<List<Integer>> res, List<Integer> holder, int index, int[] nums) {
		if (holder.size() >= 2) {
			res.add(new ArrayList<Integer>(holder));
			System.out.println(res +" " +  index);
		}
		for (int i = index; i < nums.length; i++) {
			if (holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i]) {
				holder.add(nums[i]);
				A(res, holder, i + 1, nums);
				holder.remove(holder.size() - 1);
			}
		}
	}


}
