package __CodeHelp.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CW3_ReplacePattern {
//LT-890
	public static void main(String[] args) {
		String[] words = new String[] { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
		String pattern = "spp";
		
		System.out.println(findAndReplacePattern(words, pattern).toString());

	}

//	T(N*M)
//	where n is the number of words and m is the average length of a word in the words array.
//	S(n), where n is the number of words in the words
	public static List<String> findAndReplacePattern(String[] words, String pattern) {
	    // Create an array to store the words with replaced patterns
	    String[] replacedWords = new String[words.length];

	    // Iterate through the words array
	    for (int i = 0; i < words.length; i++) {
	        // Replace the pattern in each word and store it in the replacedWords array
	        replacedWords[i] = replacePattern(words[i]);
	    }

	    // Replace the pattern in the input pattern string
	    pattern = replacePattern(pattern);

	    // Create a list to store matched words
	    List<String> matchedPattern = new ArrayList<>();

	    // Iterate through the words array again
	    for (int i = 0; i < words.length; i++) {
	        // Check if the word's replaced pattern matches the input pattern
	        if (replacedWords[i].equals(pattern)) {
	            // If they match, add the original word to the list of matched words
	            matchedPattern.add(words[i]);
	        }
	    }

	    // Return the list of matched words
	    return matchedPattern;
	}

	// Helper method to replace characters in a word with a pattern
	private static String replacePattern(String string) {
	    // Create a mapping to store character replacements
	    Map<Character, Character> mapping = new HashMap<>();

	    // Initialize a character to map to
	    char mapped = 'a';

	    // Iterate through the characters of the input word
	    for (char ch : string.toCharArray()) {
	        // If the character is not in the mapping, add it with a mapped character
	        if (!mapping.containsKey(ch)) {
	            mapping.put(ch, mapped);
	            mapped++;
	        }
	    }

	    // Create a StringBuilder to build the replaced pattern
	    StringBuilder replacedPattern = new StringBuilder();

	    // Iterate through the characters of the input word again
	    for (char ch : string.toCharArray()) {
	        // Append the mapped character to the replaced pattern
	        replacedPattern.append(mapping.get(ch));
	    }

	    // Return the replaced pattern as a string
	    return replacedPattern.toString();
	}
	
	/***
	Here's an explanation of each part:

	The findAndReplacePattern method takes an array of words and a pattern as input and returns a list of words that match the pattern.

	It first creates an array replacedWords to store the words with replaced patterns.

	It then iterates through the words array, calling the replacePattern method to replace each word's characters with a pattern and stores the result in replacedWords.

	Next, it replaces the characters in the input pattern string with a pattern using the replacePattern method.

	It initializes an empty list matchedPattern to store matched words.

	The code then iterates through the words array again, comparing the replaced pattern of each word with the pattern of the input pattern. If they match, the original word is added to the matchedPattern list.

	Finally, the list of matched words is returned as the result.

	The replacePattern method takes a string as input and replaces its characters with a pattern.

	It creates a mapping of characters to mapped characters using a HashMap.

	It iterates through the characters of the input string, assigning a mapped character to each unique character and storing the mapping in the mapping map.

	It then builds a replaced pattern using a StringBuilder, mapping each character in the input string to its mapped character.

	The replaced pattern is returned as a string.
	***/

}
