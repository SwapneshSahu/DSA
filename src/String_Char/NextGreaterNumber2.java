package String_Char;

public class NextGreaterNumber2 {

	public static void main(String[] args) {

		int n = 2147483476;
		//int n=21;

		System.out.println(nextGreater(n));
	}

	public static int nextGreater(int number) {
		String num = Integer.toString(number);

		int nextSmallerNumber = num.length() - 2;
		int[] countNumber = new int[10];

		while (nextSmallerNumber > 0 && num.charAt(nextSmallerNumber) >= num.charAt(nextSmallerNumber + 1)) {
			nextSmallerNumber--;
		}

		for (int i = nextSmallerNumber; i < num.length(); i++) {
			if (i != nextSmallerNumber+1)
			countNumber[num.charAt(i) - '0']++;
		}
		StringBuilder sb = new StringBuilder(num.substring(0, nextSmallerNumber));
		 sb.append(num.charAt(nextSmallerNumber+1));
		for (int i = 0; i < countNumber.length; i++) {

			while (countNumber[i] > 0) {
				sb.append(i);
				countNumber[i]--;
			}
		}
		if (Long.parseLong(sb.toString()) > Integer.MAX_VALUE || Long.parseLong(sb.toString()) <= number)
			return -1;

		return Integer.parseInt(sb.toString());
	}

}
