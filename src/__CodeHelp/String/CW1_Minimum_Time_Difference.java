package __CodeHelp.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CW1_Minimum_Time_Difference {

	public static void main(String[] args) {

		// System.out.println(multiplyUsingBits(10, 11));
		List<String> ll = new ArrayList<>();
		ll.add("17:10");
		ll.add("11:50");
		ll.add("12:01");
		ll.add("21:00");

		System.out.println(findMinDifference2(ll));

	}
	
	
	public static int findMinDifference2(List<String> timePoints) {
		Integer [] arr = new Integer[timePoints.size()];
		int maxMin = 24 * 60;
		int i = 0;
		for (String time : timePoints) {
			String[] ch = time.split(":");
			int mins = Integer.valueOf(ch[0]) * 60 + Integer.valueOf(ch[1]);

			if (maxMin - mins  < mins) {
				arr[i] = (maxMin - mins ) *-1;
			}
			else {
				arr[i] = mins;
			}
			i++;

		}
		Arrays.sort(arr, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));
		 //Arrays.sort(arr, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));
		for (int j = 0; j < arr.length - 1; j++) {
			arr[j] = Math.abs ( arr[j + 1] - arr[j]);
		}
		arr[arr.length-1] = Integer.MAX_VALUE;
		Arrays.sort(arr);
		return arr[0];

	}
	
	 public static void sortArrayByAbsoluteValue(Integer[] arr) {
	        Arrays.sort(arr, new Comparator<Integer>() {
	            @Override
	            public int compare(Integer a, Integer b) {
	                // Compare by absolute values
	                return Integer.compare(Math.abs(a), Math.abs(b));
	            }
	        });
	    }

	public static int findMinDifference(List<String> timePoints) {
		int[] arr = new int[timePoints.size()];
		int[] diff = new int[timePoints.size()];
		Arrays.fill(diff, Integer.MAX_VALUE);
		int maxMin = 24 * 60;
		int i = 0;
		for (String time : timePoints) {
			String[] ch = time.split(":");
			int mins = Integer.valueOf(ch[0]) * 60 + Integer.valueOf(ch[1]);

			arr[i] = mins;
			i++;

		}
		Arrays.sort(arr);
		for (int j = 0; j < arr.length - 1; j++) {
			diff[j] = Math.min(diff[j], Math.min(arr[j + 1] - arr[j], maxMin - arr[j + 1] + arr[j]));
		}
		diff[0] = Math.min(diff[0], Math.min(arr[arr.length - 1] - arr[0], maxMin - arr[arr.length - 1] + arr[0]));
		Arrays.sort(diff);
		return diff[0];

	}

}
