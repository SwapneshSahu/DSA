package Mock_Practice;

import java.util.HashMap;

public class Combination_Parenthesis {

	public static void main(String[] args) {
		System.out.println("Hello World");
        for(int i = 1; i <= 100; i++){
            System.out.println(i+"---  "+printCombination(i));
        }
        

    }
    private static long[][] dp;
    public static long printCombination(int pairs) {
        dp = new long[pairs+1][pairs+1];

        return printCombination(0, pairs);
    }

    public static long printCombination(int openBrackets, int pairs) {

        if (pairs == 0) {
            return 1;
        }
        if(dp[openBrackets][pairs] != 0)
            return dp[openBrackets][pairs];

        if (openBrackets == 0) {
           long comb = printCombination(1, pairs);
           dp[1][pairs] = comb;
           return comb;
        }
        long combination = 0;
        if (openBrackets < pairs) {
            combination = printCombination(openBrackets + 1, pairs);
        }
        long res = combination + printCombination(openBrackets - 1, pairs - 1);
        dp[openBrackets][pairs] = res;
        return res;
    }
}
