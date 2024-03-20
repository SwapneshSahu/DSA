package __CodeHelp.String;

public class AS7_DecodeMessage {

	public static void main(String[] args) {
		 String key = "the quick brown fox jumps over the lazy dog";
		 String message = "vkbs bs t suepuv";
		 
		// System.out.println('c' -'a');
		 
		 System.out.println(decodeMessage(key, message));
	}

	public static String decodeMessage(String key, String message) {

		Character[] mapping = new Character[26];
		
		char mapped = 'a';
		for (char ch : key.toCharArray()) {
			if (ch !=' ' &&  mapping[ch-'a'] == null) {
				mapping[ch-'a'] = mapped;
				mapped++;
			}
			
		}
		
		StringBuilder decodeString = new StringBuilder();
		for (char ch : message.toCharArray()) {
			if (ch == ' ') decodeString.append(' ');
			else{
				decodeString.append(mapping[(int)(ch-'a')]);
			}
		}

		return decodeString.toString();

	}

}
