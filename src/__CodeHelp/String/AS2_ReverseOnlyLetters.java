package __CodeHelp.String;

public class AS2_ReverseOnlyLetters {
//LT 917
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
	}

	//Approach 1 T(N) S(N)
 	public static  String reverseOnlyLetters(String s) {
	        char[] ch = s.toCharArray();
	        

	        int i =0 , j =s.length()-1;

	        while (i <=j){
	         
	              while (!((ch[i] >='a' && ch[i] <='z') || (  ch[i]>='A' && ch[i] <='Z')) && i <=j) {
	            	  i++;
	              }
	              while (!((ch[j] >='a' && ch[j] <='z') || (  ch[j]>='A' && ch[j] <='Z')) && i <=j) {
	            	  j--;
	              }
	              
	              char temp = ch[i];
	              ch[i] = ch[j];
	              ch[j] = temp;
	              
	              i++;
	              j--;
	        }
//	         String ans ="";
//	         for (char c : ch) {
//	         	ans+=c;
//	         }
//	          Using String builder also increase the speed 
//	         StringBuilder sb  =new StringBuilder();
//	         for (char c : ch) {
//	         	sb.append(c);
//	         }
	        //it gives 100% faster solution
//	       return sb.toString();
	        
	       return String.valueOf(ch);
	    }

}
