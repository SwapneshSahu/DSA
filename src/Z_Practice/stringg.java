package Z_Practice;

public class stringg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(mergeAlternately("ab", "pqrs"));
		
	}
	
	 public static String mergeAlternately(String word1, String word2) {
	        
	        StringBuilder ans= new StringBuilder();

	        int i =0;
	        int j =0;
	        while (i < word1.length() || j < word2.length()){

	            if (i < word1.length()){
	                ans.append(word1.charAt(i));
	                i++;
	            }

	             if (j < word2.length()){
	                ans.append(word2.charAt(j));
	                j++;
	            }
	        }
	      return ans.toString();
	    }

}
