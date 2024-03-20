package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SubSequenceSum {
	public static void main(String[] args) {
		// double[] arr = { 3.9, 3.7, 2.6, 2.3, 1.6, 1 };
		double[] arr = { 4, 3.3, 3, 2.6, 1.9, 0.8 };
		double target = 6;
		List<List<Double>> result = new ArrayList<List<Double>>();
		List<Double> combination = new ArrayList<>();

		for (int j = 0; j < arr.length; j++) {
			boolean found = false;

			if (result.size() != 0) {

				for (List ll : result) {
					if (combinationSumValid(ll, arr[j], target)) {
						ll.add(arr[j]);
						found = true;
						break;
					}

				}
			}
			if (!found) {
				combination = new ArrayList<>();
				combination.add(arr[j]);
				result.add(combination);
			}

		}

		System.out.println(result);
	}

	private static boolean combinationSumValid(List<Double> combination, double d, double target) {
		double sum = 0;
		for (double i : combination) {
			sum += i;

		}
		if (sum + d <= target)
			return true;

		return false;
	}

}
