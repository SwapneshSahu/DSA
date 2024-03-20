package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArthmeticSequence {

	public static void main(String[] args) {
		
		int []  nums = new int[] {4,6,5,9,3,7};
		int []  l =  new int[] {0,0,2};
		int [] 	r =new int[] {2,3,5};
		System.out.println(checkArithmeticSubarrays(nums, l, r));
		
	}

	public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> list = new ArrayList<>();
		int i = 0;
		while (i < l.length) {
			int[] tempArr = new int[r[i] - l[i] + 1];
			int k = 0;
			for (int j = l[i]; j <= r[i]; j++) {
				tempArr[k++] = nums[j];

			}
			Arrays.sort(tempArr);

			list.add(checkSorted(tempArr));
			i++;
		}
		return list;
	}

	public static boolean checkSorted(int[] tempArr) {

		int diff = tempArr[1] - tempArr[0];

		for (int i = 1; i < tempArr.length-1; i++) {

			if (tempArr[i + 1] - tempArr[i] != diff)
				return false;
		}

		return true;
	}

}
