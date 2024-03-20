package __CodeHelp.String;

import java.util.ArrayList;
import java.util.List;

public class AS8_GroupAnagram {
// 49. Group Anagrams
	public static void main(String[] args) {
		
		System.out.println(groupAnagrams(new String[] {""}));
          
	}
	
//	    Time Complexity:
//
//		In the groupAnagrams function, you have a loop that iterates through each input string, and for each string, it calls the checkAnagram function.
//		The checkAnagram function has a loop that iterates through the existing groups of anagrams.
//		The time complexity of the code is O(n * k), where n is the length of the input string array strs, and k is the number of groups of anagrams.
//		
//		Space Complexity:
//
//		The space complexity is O(n) where n is the length of the input string array strs. This is the space required to store the result list, and it grows with the number of input strings.

	public static List<List<String>> groupAnagrams(String[] strs) {
	    // Initialize a list to store the result (groups of anagrams)
	    List<List<String>> result = new ArrayList<List<String>>();

	    // Iterate through the input strings
	    for (String ss : strs) {
	        // If the result list is empty or the current string is not an anagram of any group
	        if (result.size() == 0 || !checkAnagram(result, ss)) {
	            // Create a new group and add the current string to it
	            List<String> group = new ArrayList<>();
	            group.add(ss);
	            result.add(group);
	        }
	    }
	    return result;
	}

	private static boolean checkAnagram(List<List<String>> groupAnagram, String ss) {
	    // Iterate through the existing groups of anagrams
	    for (int i = 0; i < groupAnagram.size(); i++) {
	        // Get the first string in the current group
	        String currString = groupAnagram.get(i).get(0);

	        // If the lengths of the current string and the target string are not equal, they can't be anagrams
	        if (currString.length() != ss.length()){
	            continue;
	          }

	        // Initialize an array to store the count of each character (assuming lowercase English alphabet)
	        int[] charCount = new int[26];

	        // Count the characters in the target string (ss)
	        for (int j = 0; j < ss.length(); j++) {
	            charCount[ss.charAt(j) - 'a']++;
	        }

	        // Decrement the count for characters in the current string (currString)
	        for (int j = 0; j < currString.length(); j++) {
	            charCount[currString.charAt(j) - 'a']--;
	        }

	        // Initialize a check flag
	        boolean check = false;

	        // Check if all character counts are zero, indicating an anagram
	        for (int num : charCount) {
	            if (num != 0) {
	                check = true;
	                break;
	            }
	        }

	        // If check is false (i.e., the strings are anagrams), add the current string to the group
	        if (!check) {
	            groupAnagram.get(i).add(ss);
	            return true;
	        }
	    }

	    // If no group matched the current string, return false
	    return false;
	}

}
