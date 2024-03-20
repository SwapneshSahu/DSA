package String_Char;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Lexicographically_Smallest_Equivalent_String {

	public static void main(String[] args) {
		String s1 ="eachghbdabchffhaadfcdfdceacaebaghdhbdcehbbbgabagff";
		String s2 = "gdchgcgbhbaahdeddaeafdcaceeabgbeefcdahedfbbghcecaf";
		String baseStr ="pacwwgbkcengcwxerkxqlwtetqwkqjrzsqmcsuhoexbacnveyi";
		System.out.println(smallestEquivalentString(s1, s2, baseStr).equals("paawwaakaanaawxarkxqlwtatqwkqjrzsqmasuaoaxaaanvayi"));
	}

	public static String smallestEquivalentString(String s1, String s2, String baseStr) {

		List<HashSet<Character>> list = new ArrayList<>();
		HashMap<Character ,Integer> map  = new HashMap<>();
		HashSet<Character>	hs = new HashSet<>();
		int count =0;
		for (int i =0 ; i<s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			if (map.containsKey(c1) ||map.containsKey(c2) ) {
			if (map.containsKey(c1)) {
				hs = new HashSet<>();
				int j = map.get(c1);
				hs =list.get(j);
				hs.add(c2);
				map.put(c2,j);
			}
			if (map.containsKey(c2)) {
				hs = new HashSet<>();
				int j = map.get(c2);
				hs =list.get(j);
				hs.add(c1);
				map.put(c1,j);
			}
			}
			else {
			hs = new HashSet<>();
		  hs.add(c1);
		  hs.add(c2);
		  
		
			list.add(hs);
			map.put(c1, count);
			map.put(c2, count);
			count++;
			}
		}
		
		
		return help(list, baseStr);

	}
	
	public static String help(List<HashSet<Character>> list ,String baseStr) {
		
		StringBuilder ans =new StringBuilder();
		
		for (int i =0  ; i<baseStr.length() ;i++) {
			boolean b = false;
			for (HashSet hh  : list) {
				if (hh.contains(baseStr.charAt(i))) {
					
					 List<Character> ll = new ArrayList<Character>(hh);
				        Collections.sort(ll);
				        ans.append(ll.get(0));
				     b = true;
				     break;
				}
			}
			if (!b) ans.append(baseStr.charAt(i));
			
		}
	String a = new String (ans);
		
		return a;
	}
	
	
}
