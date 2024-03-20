package String_Char;

public class ReverseString3 {

	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));

	}
	
	public static String reverseWords(String ss) {
		int lastSpace =0;
		StringBuilder ans = new StringBuilder();
		for (int i =0 ; i < ss.length() ;i++) {
			  
			if (ss.charAt(i) == ' ' || i ==ss.length()-1) {
				StringBuilder temp = new StringBuilder(ss.substring(lastSpace, i+1));
				temp.reverse();
				ans.append(temp);
				//ans.append(" ");
				lastSpace =i;
			}
			
		}
		ans.trimToSize();
		return ans.toString();
	}

	

}
