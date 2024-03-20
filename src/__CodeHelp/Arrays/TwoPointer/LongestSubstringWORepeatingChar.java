package __CodeHelp.Arrays.TwoPointer;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWORepeatingChar {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("dvdf"));

	}

	public static int lengthOfLongestSubstring(String s) {

		int max = 0;
		int i = 0;
		int j = 0;
		Set<Character> set = new HashSet<>();
		while (j < s.length()) {

			if (!set.add(s.charAt(j))) {
				max = Math.max(max, j - i);

				while (!set.add(s.charAt(j))) {
					set.remove(s.charAt(i));
					i++;
				}

			}
			j++;

		}

		return Math.max(max, j - i);
	}

}
