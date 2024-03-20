package Arrays;

public class MaxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { -1, 5, -2, -3, -2, 15 };

		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;

		for (int i : arr) {
			currSum += i;
			if (currSum > maxSum)
				maxSum = currSum;
			if (currSum < 0)
				currSum = 0;
		}
		System.out.print(maxSum);
	}

}
