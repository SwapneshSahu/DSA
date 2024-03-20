package String_Char;

import java.util.ArrayList;
import java.util.List;

public class String_Compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] chars = new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' ,'c', 'c', 'c','c', 'c', 'c' ,'c', 'c', 'c'};

		System.out.println(compress(chars));
	}

	   public static int compress(char[] chars) {
	        
	        int [] count = new int[26];
	     
	        for(char cc :chars){
	            count[cc-'a']++;
	        }
	    char prev = ' ';
			String ans = "";
			for (int i = 0; i < chars.length; i++) {
				if (prev == chars[i]) {
					continue;
				} else {
					ans += (chars[i]);
					if (count[(chars[i] - 'a')] > 1) {
						if (count[(chars[i] - 'a')] >= 10) {
							ans += (count[(chars[i] - 'a')] / 10);
							ans += (count[(chars[i] - 'a')] % 10);
						} else {
							ans += (count[(chars[i] - 'a')]);
						}
					}
					
					prev = chars[i];
				}
				

			}
			System.out.println(ans);
			for (int i = 0; i < ans.length(); i++) {
				chars[i] = ans.charAt(i);
			}
			//for (char cc: chars) System.out.println(cc);

			return ans.length();
	        
	    }
}
