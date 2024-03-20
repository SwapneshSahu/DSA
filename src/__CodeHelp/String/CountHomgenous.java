package __CodeHelp.String;

public class CountHomgenous {
// 1759. Count Number of Homogenous Substrings
//	For "a" : 1
//	For "aa": 3 (1 + 2)
//	For "aaa": 6 (1 + 2 + 3)
//	So, we incease cnt if the previous character is the same (and reset it to 1 otherwise).
//
//	Then, we add cnt to the result.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    String s = "abbcccaa" ;
    
    System.out.println(countHomogenous(s));
	}

	public  static int countHomogenous(String s) {
		
		 int cnt = 0, res = 0;
		    for (int i = 0; i < s.length(); ++i) {
		        if (i > 0 && s.charAt(i - 1) == s.charAt(i))
		            ++cnt;
		        else
		            cnt = 1;
		        res = (res + cnt) % 1000000007;
		    }
		    return res;

	}


}
