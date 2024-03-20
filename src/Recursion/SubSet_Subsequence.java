package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSet_Subsequence {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };

		// List<List<Integer>> ans = subsets(nums);
		
		  List<List<Integer>> ans = new ArrayList<List<Integer>>();
		  subsetsRecursive(nums, ans, new ArrayList<>(), 0); for (int i =0 ; i <
		  ans.size() ;i++) { System.out.print("["); for (int j = 0 ; j
		  <ans.get(i).size() ;j++) {
		  
		  System.out.print(ans.get(i).get(j)); } System.out.println("]"); }
		 

		String s = "abc";
		List<List<String>> aa = new ArrayList<List<String>>();
		subsequencesRecursive(s, aa, new ArrayList<>(), 0);

		for (int i = 0; i < aa.size(); i++) {
			System.out.print("[");
			for (int j = 0; j < aa.get(i).size(); j++) {

				System.out.print(aa.get(i).get(j));
			}
			System.out.println("]");
		}
	}

	public static void subsetsRecursive(int[] nums, List<List<Integer>> ans, List<Integer> curr, int index) {

		ans.add(new ArrayList<>(curr));

		for (int i = index; i < nums.length; i++) {
			curr.add(nums[i]);
			subsetsRecursive(nums, ans, curr, i + 1);
			curr.remove(curr.size() - 1);
		}

	}

	// Itreative Method O(n * 2^n)
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for (int n : nums) {
			int size = result.size();
			for (int i = 0; i < size; i++) {
				List<Integer> subset = new ArrayList<>(result.get(i));
				subset.add(n);
				result.add(subset);
			}
		}
		return result;
	}

	public static void subsequencesRecursive(String s, List<List<String>> ans, List<String> curr, int index) {
		if (curr.size() > 0) {
			ans.add(new ArrayList<>(curr));
		}
		for (int i = index; i < s.length(); i++) {

			curr.add(String.valueOf(s.charAt(i)));
			subsequencesRecursive(s, ans, curr, i + 1);
			curr.remove(curr.size() - 1);
		}

	}

}
