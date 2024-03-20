package __CodeHelp.String;

public class AS1_ValidAnagram {

	// LT 242
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	T(N + 26) S(1)
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] charCount = new int[26];

		for (int i = 0; i < s.length(); i++) {
			charCount[s.charAt(i) ]++;
			charCount[t.charAt(i)]--;
		}
		for (int i : charCount) {
			if (i != 0)
				return false;
		}
		return true;
	}

}
