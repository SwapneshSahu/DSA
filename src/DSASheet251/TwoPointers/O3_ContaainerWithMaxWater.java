package DSASheet251.TwoPointers;

public class O3_ContaainerWithMaxWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// T(N) S(1)
	public static int maxAreaTwoPointer(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int ans = 0;
		while (left < right) {

			int temp = Math.min(height[left], height[right]) * (right - left);

			if (temp > ans)
				ans = temp;

			if (height[left] > height[right])
				right--;
			else {
				left++;
			}

		}

		return ans;
	}

	// T(N2) S(1)
	public static int maxArea(int[] height) {
		int area = 0;

		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {

				int temp = Math.min(height[i], height[j]) * (j - i);

				if (temp > area)
					area = temp;

			}
		}

		return area;
	}

}
