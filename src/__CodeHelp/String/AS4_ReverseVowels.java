package __CodeHelp.String;

public class AS4_ReverseVowels {
//LT-345
	public static void main(String[] args) {
		System.out.println(reverseVowels("leetcode"));

	}

	public static String reverseVowels(String s) {
		char[] ch = s.toCharArray();

		int i = 0, j = s.length() - 1;

		while (i <= j) {
			// if (ch[i] != ch[j] ){
			while (i < j && !checkVowels(ch[i])) {
				i++;
			}
			while (i <j && !checkVowels(ch[j])) {
				j--;
			}

			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			// }
			i++;
			j--;
		}
		StringBuilder ans = new StringBuilder();
		for (char c : ch) {
			ans.append(c);
		}
		// it gives 100% faster solution
		return ans.toString();

	}

	public static boolean checkVowels(char ch) {
		if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O'
				|| ch == 'u' || ch == 'U')
			return true;

		return false;

	}

}
