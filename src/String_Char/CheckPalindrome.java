package String_Char;

public class CheckPalindrome {
   //Check Palindrome:https://bit.ly/3E55FvF
  // LeetCode 125
	public static void main(String[] args) {

		String s = "race a car";
		s = s.toLowerCase();
		s = s.replaceAll("[^a-z0-9]", ""); // veryImp
		System.out.println(s);
		System.out.println(help(s));
	}

	public static boolean help(String s) {

		int start = 0;
		int end = s.length() - 1;

		while (start <= end) {

			if (s.charAt(start) != s.charAt(end))
				return false;

			start++;
			end--;

		}

		return true;
	}
	
	

}
