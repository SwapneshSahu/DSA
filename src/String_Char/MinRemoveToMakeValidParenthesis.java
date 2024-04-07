package String_Char;

import java.util.ArrayList;
import java.util.List;

public class MinRemoveToMakeValidParenthesis {

	public static void main(String[] args) {
		String s = "lee(t(c)o)de)";
		System.out.println(minRemoveToMakeValid(s));

	}
	
	public static String minRemoveToMakeValid(String s) {
        List<Integer>  invalidIndex = new ArrayList<>();

        for (int i =0 ; i < s.length() ;i++){
             char ch = s.charAt(i);
             if (ch == '('){
                invalidIndex.add(i) ;   
             }
             else if (ch ==')' ){
                if (invalidIndex.size() > 0){
                   invalidIndex.remove(invalidIndex.size()-1);
                }else{
                    invalidIndex.add(i) ;
                }
               
             }
        }
      StringBuilder sb = new StringBuilder(); 
        for (int i =0 ; i < s.length() ;i++){
            if(!invalidIndex.contains(i)){
                sb.append(s.charAt(i));
            } 
        }

        return sb.toString();
    }
    // public String minRemoveToMakeValid(String s) {


    //     Stack<Character> stack = new Stack<>();
    //     int openCount =0;
    //     int i =0 ;
    //     int totalOpenCount=0;

    //     while (i <s.length()){
    //          char ch = s.charAt(i);

    //        if (ch != '(' && ch !=')'){
    //          stack.push(ch);
    //        }
    //        else if (ch == '('){
    //           openCount++;
    //           totalOpenCount++;
    //            stack.push(ch);
    //        }
    //        else if (openCount > 0){
    //            stack.push(ch);
    //            openCount--;
    //        }
    //     i++;
         
    //     }
    //    StringBuilder sb = new StringBuilder();
    //    // totalOpenCount - openCount;
    //     for (char ch  : stack){
    //         if (ch == '(' && totalOpenCount - openCount > 0 ){
    //           sb.append(ch);
    //           totalOpenCount--;
    //         }
    //         else if (ch != '(') {
    //             sb.append(ch);
    //         }
    //     }
    // return sb.toString();
    // }

}
