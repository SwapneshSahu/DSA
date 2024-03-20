package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhone {

	public static void main(String[] args) {

		// List<List<Integer>> ans = subsets(nums);

		List<String> ans = letterCombinations("23");
		
		for (int i = 0; i < ans.size(); i++) {
			System.out.print("[");
			//for (int j = 0; j < ans.get(i).size(); j++) {

				System.out.print(ans.get(i));
			//}
			System.out.println("]");
		}

	}

	public static List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<String>();
		if (digits.length() == 0)
			return ans;

		String[] mapping = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		help(digits, mapping, ans, new StringBuilder(), 0);

		return ans;

	}

	public static void help(String digits, String[] mapping, List<String> ans, StringBuilder curr, int index) {

		if (index >= digits.length()) {
			ans.add(new String (curr));
			return ;
		}

		int i = digits.charAt(index) - '0';
		String value = mapping[i];

		for (int j = 0; j < value.length(); j++) {
			//System.out.println(j+ "  " + value.charAt(j));
			
			curr.append(value.charAt(j));
			help(digits, mapping, ans, curr, index + 1);
			curr.deleteCharAt(curr.length()-1);
		}

	}

}
