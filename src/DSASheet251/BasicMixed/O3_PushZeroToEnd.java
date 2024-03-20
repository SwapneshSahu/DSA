package DSASheet251.BasicMixed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O3_PushZeroToEnd {

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(0);
		arr.add(4);
		arr.add(1);
		arr.add(3);
		arr.add(0);
		arr.add(28);

		int[] arrd = new int[] { 2, 0, 4, 1, 3, 0, 28 };
		System.out.println(Arrays.toString(arrd));
		pushZerosAtEnd(arrd);
		System.out.println(Arrays.toString(arrd));

	}

	public static void pushZerosAtEnd(int[] arr) {
		int trackNum = 0;
		int trackZero = 0;

		while (trackNum < arr.length - 1 && trackZero < arr.length) {

			while (arr[trackZero] != 0) {
				trackZero++;
				break;
			}

			while (arr[trackNum] == 0) {
				trackNum++;
				break;
			}

			if (trackNum < trackZero)
				trackNum++;
			else {
				// swap

				arr[trackZero] = arr[trackNum];
				arr[trackNum] = 0;

			}
		}
	}

}
