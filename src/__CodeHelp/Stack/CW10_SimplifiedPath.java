package __CodeHelp.Stack;

import java.util.Stack;

public class CW10_SimplifiedPath {

	public static void main(String[] args) {
		String ss = "/home/..////a/b/.//l/o/";
		System.out.println(simplifyPath(ss));

	}
	public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        for (int i =0 ;i <path.length();i++){
            int start =i;
            int end =i+1;

            while (end <path.length() &&path.charAt(end) != '/'){
              end++;
            }

            String currDir = path.substring(start,end);
            i =end-1;
            if(currDir.equals("/.") || currDir.equals("/") ){
              continue;
            }

            if (!currDir.equals("/..") ){
                stack.push(currDir);
            }else if (!stack.isEmpty()){
            	stack.pop();
            }
        }
            String ans = stack.isEmpty() ? "/" :"";
            
           while (!stack.isEmpty()) {
        	   ans = stack.pop() +ans;
           }
           return ans;
        
    }

//    public static  String buildStringStack(String ans , Stack<String> stack){
//       
//       if (stack.isEmpty()){
//         return "";
//       }
//
//       String ss = stack.pop();
//       buildStringStack(ans,stack);
//        return ans+=ss;
//    }

}
