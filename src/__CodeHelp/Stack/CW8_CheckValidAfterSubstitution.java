package __CodeHelp.Stack;

import java.util.Stack;

public class CW8_CheckValidAfterSubstitution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//better Approach
	//Time Complexity: O(n)
	//Space Complexity: O(n)
	public boolean isValid2(String s) {
	    // Pehla character 'a' nahi hai to hum kabhi bhi "abc" sequence se nahi bana sakte
	    if (s.charAt(0) != 'a') return false;

	    Stack<Character> stack = new Stack<>();

	    for (int i = 0; i < s.length(); i++) {
	        char ch = s.charAt(i);
	        
	        // Agar character 'a' hai, toh use stack mein push karo
	        if (ch == 'a') {
	            stack.push(ch);
	        }
	        // Agar character 'b' hai
	        else if (ch == 'b') {
	            // 'b' ke liye stack ka top element 'a' hona chahiye, warna invalid hai
	            if (!stack.isEmpty() && stack.peek() == 'a') {
	                stack.push(ch);
	            } else {
	                return false;
	            }
	        }
	        // Agar character 'c' hai
	        else {
	            // 'c' ke liye stack mein pehle 'b' aur fir 'a' hona chahiye
	            if (!stack.isEmpty() && stack.peek() == 'b') {
	                stack.pop(); // 'b' ko pop karo
	                if (!stack.isEmpty() && stack.peek() == 'a') {
	                    stack.pop(); // 'a' ko pop karo
	                } else {
	                    return false;
	                }
	            } else {
	                return false;
	            }
	        }
	    }

	    // Stack ko check karo ki kuch bacha toh nahi, agar bacha hai toh invalid hai
	    return stack.isEmpty();
	}

	//Time Complexity: O(n^2)
	//Space Complexity: O(n)
	 public boolean isValid(String s) {
	        if (s.length() == 0) return true;
	        int index = s.indexOf("abc");

	        if (index == -1) return false;

	        return isValid(s.substring(0,index) +s.substring(index+3));
	    }

}
