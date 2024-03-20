package String_Char;

public class BackSpaceStringComp {

	public static void main(String[] args) {
		System.out.println(backspaceCompare2("abb##c", "adc##c"));
		
		Long aa = 55324;
		
		System.out.println(aa);

	}
	
	
	public static  boolean backspaceCompare2(String s, String t) {
        int i =s.length()-1;
        int j =t.length()-1;

        while ( i >=0 && j >=0){
             
        	int countHash =0;
             while (s.charAt(i) == '#'){
              countHash++;
              i--;
             }
             i-=countHash;
             countHash =0;
             while (t.charAt(j) == '#'){
            	 countHash++;
            	 j--;
             }
             j -= countHash;
             if (i>=0 && j>=0 &&s.charAt(i) != t.charAt(j) ) return false;
             i--;
             j--;
        }

        if ( i >=0  || j>=0) return false;

        return true;
  }

    public static boolean backspaceCompare(String s, String t) {
    	  StringBuilder sb = new StringBuilder();
          for (char ch : s.toCharArray()){
                  if (ch == '#' && sb !=null){
                    sb.deleteCharAt(sb.length()-1);
                  }else {
                	  sb.append(ch);
                  }
          }
          
          StringBuilder st = new StringBuilder();
          for (char ch : t.toCharArray()){
                  if (ch == '#' && st !=null){
                    st.deleteCharAt(st.length()-1);
                  }else {
                	  st.append(ch);
                  }
          }
          
          return sb.toString().equals(st.toString()) ;
    }

}
