package __CodeHelp.String;

import java.util.Arrays;

public class AS3_LongestCommonPrefix {
//LT-14
	public static void main(String[] args) {
		String[] strs = new String[] { "flower", "flow", "flight" };
		System.out.println(longestCommonPrefix2(strs));
	}

	/**
	 * Time Complexity:
	 * 
	 * Sorting the array takes O(N*log(N)) time, where N is the number of strings.
	 * Finding the common prefix takes O(M) time, where M is the length of the
	 * common prefix. Therefore, the overall time complexity is O(N*log(N) + M).
	 * Space Complexity:
	 * 
	 * The space complexity is O(1) because no extra data structures are used,
	 * except for a few variables. 
	 * 
	 * Reason for Sorting The reason why we sort the input array of strings and
	 * compare the first and last strings is that the longest common prefix of all
	 * the strings must be a prefix of the first string and a prefix of the last
	 * string in the sorted array. This is because strings are ordered based on
	 * their alphabetical order (Lexicographical order). For example, consider the
	 * input array of strings {"flower", "flow", "flight"}. After sorting the array,
	 * we get {"flight", "flow", "flower"}. The longest common prefix of all the
	 * strings is "fl", which is located at the beginning of the first string
	 * "flight" and the second string "flow". Therefore, by comparing the first and
	 * last strings of the sorted array, we can easily find the longest common
	 * prefix.
	 * 
	 */

	public static String longestCommonPrefix2(String[] strs) {

		Arrays.sort(strs);
		String s1 = strs[0];
		String s2 = strs[strs.length - 1];
		int idx = 0;
		while (idx < s1.length() && idx < s2.length()) {
			if (s1.charAt(idx) == s2.charAt(idx)) {
				idx++;
			} else {
				break;
			}
		}
		return s1.substring(0, idx);
	}

	/**
	 * Time Complexity:
	 * 
	 * The worst-case time complexity is O(N*M), where N is the number of strings,
	 * and M is the length of the shortest string. Space Complexity:
	 * 
	 * The space complexity is O(M), where M is the length of the first string.
	 */

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 1)
			return strs[0];
		StringBuilder prefix = new StringBuilder(strs[0]);

		for (int i = 1; i < strs.length; i++) {
			if (strs[i].length() == 0)
				return "";
			if (prefix.length() > strs[i].length())
				prefix = new StringBuilder(prefix.substring(0, strs[i].length()));
			int j = 0;
			String temp = strs[i];
			while (j < prefix.length()) {
				if (prefix.charAt(j) != temp.charAt(j)) {
					prefix = new StringBuilder(prefix.substring(0, j));
					break;
				}
				j++;
			}
		}

		return prefix.toString();
	}

}
