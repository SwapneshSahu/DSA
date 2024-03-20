package Arrays;

public class Coin_Change2 {

	public static void main(String[] args) {
		
		int [] coins = new int[] {1,2,5};
		change(5, coins);
		
		var x = 10;
		

		System.out.println(ans);
	}

	static int ans = 0;

	public static int change(int amount, int[] coins) {
		recursive(amount, coins, 0,0);
		return ans;
	}

	public static void recursive(int target, int[] coins, int current,int index) {

		

		if (current == target) {
			ans++;
			return;
		}

		for (int i = index; i < coins.length; i++) {
			if(current + coins[i] > target) break;
			recursive(target, coins, current + coins[i],i);
		}
	}

}
