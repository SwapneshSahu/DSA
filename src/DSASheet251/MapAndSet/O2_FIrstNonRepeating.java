package DSASheet251.MapAndSet;

import java.util.HashMap;
import java.util.Map;

public class O2_FIrstNonRepeating {

	public static void main(String[] args) {
		System.out.println(firstNonRepeatingCharacter("aDcadhc"));

	}
	
	public static char firstNonRepeatingCharacter(String str) {

		Map<Character,Integer> map= new HashMap<>();

		for (int i =0 ; i <str.length() ;i++){
			char ch  = str.charAt(i);
			if (map.containsKey(ch)){
				map.put(ch, Integer.MAX_VALUE);
			}else{
				map.put(ch, i);
			}
		}
		if (map.isEmpty()) return str.charAt(0);
        int min=Integer.MAX_VALUE;
        for (int i : map.values()) {
        	if (min > i) min=i;
        }
		

       return str.charAt(min);
	}

}
