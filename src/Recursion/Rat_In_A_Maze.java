package Recursion;

import java.util.ArrayList;

public class Rat_In_A_Maze {

	public static void main(String[] args) {
		  
		int m[][] = new int[][] { { 1 ,0 ,1 ,0 }
		                         ,{ 1 ,0 ,0 ,1 }, 
		                          { 1 ,0, 0, 1 }, 
		                          { 1 ,1, 1, 1} };
		ArrayList<String> ans  =findPath(m);
		
		for (String s : ans ) {
			System.out.println(s);
		}

	}

	public static ArrayList<String> findPath(int[][] m) {
		ArrayList<String> ans = new ArrayList<>();


		boolean visited[][] = new boolean[m.length][m[0].length];

		help(ans, visited, m, "", 0, 0);

		return ans;

	}

	private static void help(ArrayList<String> ans, boolean[][] visited, int[][] m, String ss, int x, int y) {
		// base case
		if (x == m.length-1 && y == m[0].length-1) {
			ans.add(ss);
			return;
		}

		visited[x][y] = true;

		// Down Call
		int newX = x + 1; // row
	    int newY = y; // column
		if (isPossible(visited, m, newX, newY)) {
			ss+="D";
			help(ans, visited, m, ss, newX, newY);
			//Removing the Last added character to ensure going forward this character not repeat 
			ss = ss.substring(0, ss.length()-1);
		}

		// Left call
		newX = x; // row
		newY = y - 1; // column
		if (isPossible(visited, m, newX, newY)) {
			ss+="L";
			help(ans, visited, m, ss, newX, newY);
			ss = ss.substring(0, ss.length()-1);
		}
		// Right Call
		newX= x; // row
		newY= y + 1; // column
		if (isPossible(visited, m, newX, newY)) {
			ss+="R";
			help(ans, visited, m, ss, newX, newY);
			ss = ss.substring(0, ss.length()-1);
		}
		// Up Call
		newX = x - 1; // row
		newY = y; // column
		if (isPossible(visited, m, newX, newY)) {
			ss+="U";
			help(ans, visited, m, ss, newX, newY);
			ss = ss.substring(0, ss.length()-1);
		}
		
		// marking this not visited for future calls
		visited[x][y] = false;

	}

	private static boolean isPossible(boolean[][] visited, int[][] m, int x, int y) {
		if (x >= 0 && x < m.length && y >= 0 && y < m[0].length && m[x][y] == 1 && !visited[x][y]) {
			return true;
		}
		return false;
	}

}
