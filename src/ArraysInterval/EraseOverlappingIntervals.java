package ArraysInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EraseOverlappingIntervals {

	public static void main(String[] args) {

		int[][] intervals = new int[][] { { -52, 31 }, { -73, -26 }, { 82, 97 }, { -65, -11 }, { -62, -49 }, { 95, 99 },
				{ 58, 95 }, { -31, 49 }, { 66, 98 }, { -63, 2 }, { 30, 47 }, { -40, -26 } };

		System.out.println(eraseOverlapIntervals(intervals));
		
		List<test> ll = new ArrayList<>();
		
		ll.add(new test(10, 9));
		ll.add(new test(101, 19));
		ll.add(new test(110, 91));
		
		for(test tt : ll) {
			
			if (tt.abc == 101) {
				ll.remove(tt);
			}
		}
		
		System.out.println(ll);
		
	}

	public static int eraseOverlapIntervals(int[][] intervals) {
		// Arrays.sort(intervals,(int [] nums1 ,int[] nums2) -> nums1[0] - nums2[0] );

		Arrays.sort(intervals, (int[] nums1, int[] nums2) -> nums1[0] != nums2[0] ?
				nums1[0] - nums2[0] : nums1[1] - nums2[1] );

		int count = 0;
		int[] prev = intervals[0];

		for (int i = 1; i < intervals.length; i++) {

			if (intervals[i][0] < prev[1]) { // overlap
				count++;

				if (intervals[i][1] < prev[1])
					prev = intervals[i];
			} else {
				prev = intervals[i];
			}

		}
		return count;
	}

}
