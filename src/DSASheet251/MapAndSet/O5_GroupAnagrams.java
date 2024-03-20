package DSASheet251.MapAndSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class O5_GroupAnagrams {
	/*** Problem Link **/
	// https://www.codingninjas.com/codestudio/problems/group-anagrams_800285?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=1
	public static void main(String[] args) {
		String[] words = { "cat", "act", "dog", "god", "bat", "tab", "race", "care", "acre" };

		ArrayList<String> list = new ArrayList<>(Arrays.asList(words));

		ArrayList<ArrayList<String>> ans = getGroupedAnagrams(list);
		ans.forEach(innerList -> innerList.forEach(element -> System.out.println(element)));

	}

	public static ArrayList<ArrayList<String>> getGroupedAnagrams(ArrayList<String> inputStr) {
		// Create a HashMap that maps each unique frequency map to a list of anagrams
		HashMap<HashMap<Character, Integer>, ArrayList<String>> bigMap = new HashMap<>();

		// Iterate over each input string
		for (String str : inputStr) {
			// Create a frequency map for the current string
			HashMap<Character, Integer> freqMap = new HashMap<>();
			for (int i = 0; i < str.length(); i++) {
				// Increment the count for the current character in the frequency map
				if (freqMap.containsKey(str.charAt(i))) {
					freqMap.put(str.charAt(i), freqMap.get(str.charAt(i)) + 1);
				} else {
					freqMap.put(str.charAt(i), 1);
				}
			}

			// Add the current string to the list of anagrams corresponding to its frequency
			// map
			ArrayList<String> temp = new ArrayList<>();
			if (bigMap.containsKey(freqMap)) {
				temp = bigMap.get(freqMap);

			} else {
				temp = new ArrayList<>();

			}
			temp.add(str);
			bigMap.put(freqMap, temp);
		}

		// Create a new ArrayList containing the lists of anagrams for each unique
		// frequency map
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		for (ArrayList<String> list : bigMap.values()) {
			ans.add(list);
		}

		return ans;
	}
}
