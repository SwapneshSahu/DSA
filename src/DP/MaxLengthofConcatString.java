package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaxLengthofConcatString {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<>();
		arr.add("bb");
		
		System.out.println(maxLength(arr));

	}

	public static int maxLength(List<String> arr) {
		if (arr.size() == 1)
			return checkValid(arr.get(0))? arr.get(0).length():0;
		Map<String, Integer> map = new HashMap<>();
		return helperRec(arr, 0, "", 0, map);
	}

	public static int helperRec(List<String> arr, int index, String ss, int ans, Map<String, Integer> map) {

		if (index > arr.size())
			return ans;

		if (map.containsKey(ss))
			return map.get(ss);

		if (ss.length() > ans && checkValid(ss)) {
			ans = ss.length();
		}
		for (int i = index; i < arr.size(); i++) {
			if (arr.get(i).length() > ans && checkValid(arr.get(i))) {
				ans = arr.get(i).length();
			}
			int include = helperRec(arr, index + 1, ss + arr.get(i), ans, map);
			int exclude = helperRec(arr, index + 1, ss, ans, map);
			ans = Math.max(ans, Math.max(include, exclude));
		}
		map.put(ss, ans);
		return ans;
	}

	public static boolean checkValid(String ss) {
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < ss.length(); i++) {
			if (!set.add(ss.charAt(i)))
				return false;
		}

		return true;
	}
}
