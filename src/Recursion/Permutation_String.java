package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation_String {

	public static void main(String[] args) {
		String s = "abc";
		List<String> ans = permutationString(s);

		for (String aa: ans) {
			System.out.print("[");
			System.out.print(aa);
			System.out.println("]");
		}
	

	}
	
	public static List<String> permutationString(String s){
		 List<String> list = new ArrayList<>();
		 
		 help(list,s,0);
		
		return list; 
	}

	private static void help(List<String> list, String s, int index) {
		
		if (index>=s.length()) {
			list.add(new String(s));
			return;
		}
		
		for (int i =index ;i <s.length();i++) {
			s =swap(s,index,i);
			help(list, s, index+1);
			s=swap(s,index,i);
		}
		
	}

	private static String swap(String str, int index, int i) {
		char[] charArray = str.toCharArray();
	    char temp = charArray[i];
	    charArray[i] = charArray[index];
	    charArray[index] = temp;
	    return new String(charArray);
	}

}
