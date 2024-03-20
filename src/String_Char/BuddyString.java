package String_Char;

import java.util.HashMap;
import java.util.Map;

public class BuddyString {

	//leetcode 859
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	

	}

	public boolean buddyStrings(String s, String goal) {

		if (s.length() != goal.length())
			return false;

		if (s.equals(goal)) {
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				if (!map.containsKey(s.charAt(i))) {
					map.put(s.charAt(i), 1);
					continue;
				}
				return true;
			}
			return false;
		}

		int first = -1;
		int second = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != goal.charAt(i)) {
				if (first == -1) {
					first = i;

				} else if (second == -1) {
					second = i;
				} else {
					// more then 2 indexes has d/f value
					return false;
				}
			}
		}
		// only one d/f value
		if (first == -1 || second == -1)
			return false;

		String ans = swapCharacters(s, first, second);

		return ans.equals(goal);
	}

	public String swapCharacters(String str, int i, int j) {
		// Convert the string to a character array
		char[] charArray = str.toCharArray();

		// Swap the characters at indices i and j
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;

		// Convert the character array back to a string
		String swappedString = new String(charArray);

		return swappedString;
	}

}
