package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class UniqueElementsAfterRemoval {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 1,2,2,2, 2, 2, 3, 3,3 };
	//	System.out.println(findLeastNumOfUniqueIntsComparator(arr, 3));
		
		System.out.println(findLeastNumOfUniqueIntsPriorityQ(arr, 3));

	}

	public static int findLeastNumOfUniqueIntsPriorityQ(int[] arr, int k) {
		
		Map<Integer, Integer> countMap = new HashMap<>();
		// Count occurrences of each element
		for (int num : arr) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}
		List<Integer> list = new ArrayList<>();
		
		for (int i : countMap.values()) {
			list.add(i);
		}
		
		list.sort((a,b) -> a-b);
		
		int count=0;
		int i =0 ;
		while ( k > 0) {
			k -= list.get(i);
			
			if (k >=0) count++;
			i++;
		}

		return list.size()-count;
		
	}
	public static int findLeastNumOfUniqueIntsComparator(int[] arr, int k) {
		Map<Integer, Integer> countMap = new HashMap<>();

		// Count occurrences of each element
		for (int num : arr) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(countMap.values());
		// Custom comparator to sort based on count
		Comparator<Integer> countComparator = (num1, num2) -> {
			int count1 = countMap.get(num1);
			int count2 = countMap.get(num2);
			if (count1 == count2) {
				return num1 - num2; // If counts are equal, sort based on element value
			}
			return count1 - count2; // Sort based on count
		};

		// Sort the array based on count using custom comparator
		Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		Arrays.sort(boxedArr, countComparator);


		for (int i = 0; i < boxedArr.length && k > 0; i++) {

			int key = boxedArr[i];

			k -= countMap.getOrDefault(key,0);

			if (k >= 0)
				countMap.remove(key);
		}

		return countMap.size();
	}

}
