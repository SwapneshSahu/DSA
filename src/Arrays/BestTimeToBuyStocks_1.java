package Arrays;

public class BestTimeToBuyStocks_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 7,1,5,3,6,4 };
		System.out.println(maxProfit(a));
	}

	public static int maxProfit(int[] p) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		

		for (int i = 0; i < p.length; i++) {

			if (min > p[i])
				min = p[i];
			else if (p[i] - min > max)
				max = p[i] - min;

		}
		
		return max;
	}

}
