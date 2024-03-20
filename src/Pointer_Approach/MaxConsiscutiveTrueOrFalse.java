package Pointer_Approach;

public class MaxConsiscutiveTrueOrFalse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxConsecutiveAnswers(String str, int k) {
		int max = 0;
		int left = 0;
		int right = 0;
		int count = 0;

		while (right < str.length()) {

			if (str.charAt(right) == 'F')
				count++;

			while (count > k) {

				if (str.charAt(left) == 'F')
					count--;
				left++;
			}
			max = Math.max(max, right - left + 1);
			right++;
		}

		left = 0;
		right = 0;
		count = 0;
		while (right < str.length()) {

			if (str.charAt(right) == 'T')
				count++;

			while (count > k) {

				if (str.charAt(left) == 'T')
					count--;
				left++;
			}
			max = Math.max(max, right - left + 1);
			right++;
		}

		return max;
	}

}
