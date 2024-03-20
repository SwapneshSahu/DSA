package String_Char;

public class DetectCapital {
	//520. Detect Capital
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bb = detectCapitalUse("USA");
		boolean bbb = detectCapitalUse("Google");
		boolean b = detectCapitalUse("leet");

		System.out.println(bb + " " + bbb + " " + b);
	}

	public static boolean detectCapitalUse(String word) {
		if (word.toUpperCase().equals(word)) {
			// all letters are capital
			return true;
		} else if (word.toLowerCase().equals(word)) {
			// all letters are not capital
			return true;
		} else if (Character.isUpperCase(word.charAt(0)) && word.substring(1).toLowerCase().equals(word.substring(1))) {
			// first letter is capital and the rest are not
			return true;
		}
		return false;
	}
}
