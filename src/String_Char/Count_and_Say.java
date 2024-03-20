package String_Char;

import java.util.HashMap;

public class Count_and_Say {
//38. Count and Say
	public static void main(String[] args) {
		int n =14;
		HashMap<Integer, String> mapping = new HashMap<>();
		for (int i = 1; i <= 9; i++) {
			mapping.put(i, Integer.toString(i));
		}
		String ans =help(n ,mapping );
		ans = ans.substring(0, ans.length()-1);
		System.out.println(ans);
	}

	private static String help(int n, HashMap<Integer, String> mapping) {
		
		if (n==1) {
			return "1 ";
		}
		
		String temp = help(n-1,mapping);
		int count =1;
		StringBuilder ans =new StringBuilder();

		for (int i =1; i <temp.length();i++) {
			
			if ( String.valueOf(temp.charAt(i)).equals(String.valueOf(temp.charAt(i-1)))) {
				count++;
			}
			else {
				
				ans.append(mapping.get(count));
				ans.append(temp.charAt(i-1));
				
				count =1;
				
				
			}
		
		}
		
		ans.append(" ");
		return new String(ans);
	}
	

}
