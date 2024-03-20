package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FindCommanCharacter {

	public static void main(String[] args) {
		String [] words = new String[] {"bella","label","roller"};
		System.out.println(commonChars(words).toString());

	}

	public static List<String> commonChars(String[] words) {

		Map<Character, Integer> baseMap = new ConcurrentHashMap<>();

		String ss = words[0];
		for (int i = 0; i < ss.length(); i++) {
			char ch = ss.charAt(i);
			if (baseMap.containsKey(ch)) {
				baseMap.put(ch, baseMap.get(ch) + 1);
			} else {
				baseMap.put(ch, 1);
			}
		}

		for (int i = 1; i < words.length; i++) {
			Map<Character, Integer> childMap = new HashMap<>();
			String sc = words[i];
			for (int j = 0; j < sc.length(); j++) {
				char ch = sc.charAt(j);
				if (childMap.containsKey(ch)) {
					childMap.put(ch, childMap.get(ch) + 1);
				} else {
					childMap.put(ch, 1);
				}
			}
			compareMaps(baseMap, childMap);

		}
		List<String> ans = new ArrayList<>();
		for (char ch : baseMap.keySet()) {
			if (baseMap.get(ch) > 1) {
				int temp = baseMap.get(ch);
				while (temp != 0) {
					ans.add(String.valueOf(ch));
					temp--;
				}
			} else {
				ans.add(String.valueOf(ch));
			}
		}

		return ans;
	}

	public static void compareMaps(Map<Character, Integer> baseMap, Map<Character, Integer> childMap) {

		for (char ch : baseMap.keySet()) {
			if (!childMap.containsKey(ch))
				baseMap.remove(ch);
			else if (baseMap.get(ch) != childMap.get(ch)) {
				int temp = Math.min(baseMap.get(ch), childMap.get(ch));
				baseMap.put(ch, temp);
			}
		}

	}
	

}
