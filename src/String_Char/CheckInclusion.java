package String_Char;

import java.util.HashMap;

public class CheckInclusion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkInclusion("ab","dooobbbbbbbbbbbbbba"));
		//System.out.println('d' -'a'- 2);
	
	}

	
	public static boolean checkInclusion(String s1, String s2) {
		
		int[] s11 = new int[26];
		int[] s22 = new int[26];
		int i = 0;
		while (i < s1.length()) {
			s11[s1.charAt(i) - 'a']++;
			s22[s2.charAt(i) - 'a']++;
			i++;
		}
		if (check(s11, s22, s1))
			return true;

		while (i < s2.length()) {
			
			s22[(s2.charAt(i-s1.length()) - 'a') ]--;
			s22[s2.charAt(i) - 'a']++;
			if (check(s11, s22, s1))
				return true;
			i++;
		}

		return false;
	}

	public static boolean check(int[] s11, int[] s22, String s1) {
		int i = 0;
		while (i < s1.length()) {
			if (s11[s1.charAt(i) - 'a'] != s22[s1.charAt(i) - 'a'])
				return false;
			i++;
		}
		return true;
	}

}
