package Arrays;

public class CanCompleteCircuit {
//134. Gas Station

	/****
	 * This solution uses a greedy approach. It keeps track of the current sum of
	 * gas, and if the sum becomes negative at any point, it updates the starting
	 * position to be the next station. At the end, if the total sum of gas is
	 * non-negative, then it means that it is possible to complete the circuit. If
	 * the total sum is negative, then it is not possible to complete the circuit,
	 * and the function returns -1.
	 ****/
	public static void main(String[] args) {
		int[] gas = new int[] { 2, 3, 4 };
		int[] cost = new int[] { 3, 4, 3 };

		System.out.println(canCompleteCircuit(gas, cost));
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		int total = 0;
		int sum = 0;
		int start = 0;
		for (int i = 0; i < n; i++) {
			total += gas[i] - cost[i];
			sum += gas[i] - cost[i];
			if (sum < 0) {
				start = i + 1;
				sum = 0;
			}
		}
		return total >= 0 ? start : -1;
	}

}
