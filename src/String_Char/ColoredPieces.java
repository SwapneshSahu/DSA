package String_Char;

import java.util.ArrayList;
import java.util.List;

public class ColoredPieces {

	public static void main(String[] args) {
		System.out.println(winnerOfGame("AAAABBBB"));

	}

	public static boolean winnerOfGame(String colors) {
	    int lastA =0;
	    int lastB=0;
	    
	    while(true) {
	    	
	    	int temp = colors.indexOf("AAA", lastA);
	    	if (temp == -1) return false;
	    	else {
	    		lastA=temp+1;
	    	}
	    	
	    	 temp = colors.indexOf("BBB", lastB);
	    	if (temp == -1) return true;
	    	else {
	    		lastB=temp+1;
	    	}
	    }

	}

	public static List<Integer> checkMove(String colors, char ch) {
		 List<Integer> list = new ArrayList<>();
		for (int i = 1; i < colors.length() - 1; i++) {

			if (colors.charAt(i) == ch) {
				if (colors.charAt(i) == colors.charAt(i - 1) && colors.charAt(i) == colors.charAt(i + 1)) {
                          list.add(i);				
				}
			}

		}
		return list;

	}

}
