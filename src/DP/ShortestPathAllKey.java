package DP;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathAllKey {

	public static void main(String[] args) {
		String[] str = new String[] { "@..aA", "..B#.", "....b" };

		Character[][] charArr = new Character[str.length][str[0].length()];
		List<Character> list = new ArrayList<>();
		int j = 0;
        int k =0;
		for (String s : str) {

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) >= 'a' && s.charAt(i) <= 'f') {
                       k++;
					list.add(s.charAt(i));
				}
					
				charArr[j][i] = s.charAt(i);
			}
			j++;
		}
        System.out.println(helper(charArr, 0, 0, list, 0,k));
	}

//	index i j 
//	listchahiye jisme key ho 
//	path 
	public static int helper(Character [][]charArr , int i , int j , List<Character>list , int path ,int k) {
		int x = charArr.length;
		int y = charArr[0].length;
		//index out of bound
		if (i < 0 || i >= x || j <0 || j >= y ) {
			return Integer.MAX_VALUE;
		}
		
		
		char ch = charArr[i][j];
		
		// wall
		if (ch == '#') return Integer.MAX_VALUE;
		
		//found Lock
		if (ch >= 'A' && ch <='F') {
			if ( list.isEmpty() || !list.contains(Character.toLowerCase(ch)) ) return Integer.MAX_VALUE;
			
		}
		
		//found key
		if (ch >= 'a' && ch <='f') {
			list.add(ch);
			k--;
		}
		if( k ==0) return path;
		
		//left
		
		int right = helper(charArr, i, j+1, list, path+1,k);
		
		int down = helper(charArr, i+1, j, list, path+1,k);
		int left = helper(charArr, i, j-1, list, path+1,k);
		int up = helper(charArr, i-1, j, list, path+1,k);
		
		
		return Math.min( Math.min(up, down),Math.min(left, right));
		
		
	}

}
