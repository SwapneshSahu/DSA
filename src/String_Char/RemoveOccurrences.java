package String_Char;

public class RemoveOccurrences {
  //LeetCode 1910. Remove All Occurrences of a Substring
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "aabababa";
		String part = "aba";
		System.out.println(removeOccurrences1(s, part));  //FAST
		System.out.println(removeOccurrences2(s, part));  //SLOW
		System.out.println(removeOccurrences3(s, part));  //SLOWEST
	}

	public static String removeOccurrences1(String s, String part) {

		// FAST
		int index = s.indexOf(part);
		while (index != -1) {
			s = s.substring(0, index) + s.substring(index + part.length());
			index = s.indexOf(part);
		}
		return s;

	}

	public static String removeOccurrences2(String s, String part) {

		// SLOW
		int pl = part.length();

		while (s.length() > 0 && s.length() >= pl && s.contains(part)) {

			s = s.replaceFirst(part, "");
		}
		return s;

	}

	public static String removeOccurrences3(String s, String part) {
         //Slowest
		while (s.length() > 0 && s.length() >= part.length() && s.contains(part)) {
			String temp = "";
			s = s.replaceFirst(part, "_");

			if (s.contains("_")) {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) != '_') {
						temp = temp + s.charAt(i);
					}
				}
				s = temp;
			}

		}
		System.out.println(s);
		return s;
	}

}
