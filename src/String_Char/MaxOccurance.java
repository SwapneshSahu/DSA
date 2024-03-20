package String_Char;

public class MaxOccurance {
  // https://practice.geeksforgeeks.org/problems/maximum-occuring-character-1587115620/1
	public static void main(String[] args) {
		
		String ss = "tesasdfghjhgfuuus09876tttttttttttdszxcvbnmjhgfdsl.   ,cvmbnhjyitroeps;l,mcvnbhjugifodsdoiuhgnvmcdlerjtt";
		
		int arr[] = new int[26];
		
		for (int i = 0 ; i<ss.length();i++) {
			
			
			char ch = ss.charAt(i);
			if (ch >='a' && ch <='z') {
			int index = ch-'a';
			arr[index]++;
			}
		}
          int max=0; int ans=0;
		for (int i = 0 ; i<26;i++) {
			if (max<arr[i]) {
				max = arr[i];
				ans = i;
				
			}
		}
		
		char an = (char) (ans+'a');
		
		System.out.println(an);
			
	}

}
