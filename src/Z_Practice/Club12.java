package Z_Practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Club12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//   System.out.println(invet12Return(20000,0));
	//	pankajLadha(350000, 0);
		
		System.out.println(Arrays.toString(topKFrequent(new int[] {1,2}, 2)));
	}

	public static double invet12Return(double startingAmount, int days) {
		if (days >= 90)
			return startingAmount;

		int count = 0;
		double intrest = (startingAmount * 0.12) / 365;
		double intrestSum = 0;
		while (count + days <= 90) {

			intrestSum += intrest;

			count++;

			if (count == 30) {
				intrestSum += 1500.00;
				break;
			}

			if (intrestSum % 1 == 0)
				break;

		}

		return invet12Return(startingAmount + intrestSum, days + count);
	}

	public static void pankajLadha(double openingBalance, int months) {

		double intrest = 0;
		double rate = 8.0 / 1200.0;
		while (months <= 36) {

			intrest += (openingBalance + 14500) * rate;
			months++;
			openingBalance = (openingBalance + 14500) * (rate + 1);

		}
		System.out.println("Intrest: " + intrest);
		System.out.println("Pay: " + (350000 + 14500 * 36));
		System.out.println("Total: " + openingBalance);

	}

 	public static int[] topKFrequent(int[] nums, int k) {

 		ConcurrentHashMap<Integer, Integer> freqMap = new ConcurrentHashMap<>();

		for (int i : nums) {
			if (freqMap.containsKey(i)) {
				freqMap.put(i, freqMap.get(i) + 1);
			} else {
				freqMap.put(i, 1);
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int[] ans = new int[k];

		for (int i : freqMap.values())
			pq.offer(i);

		while (k > 0) {
			int toFind =0;
			if (!pq.isEmpty()) toFind = pq.poll();

			for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
				if (entry.getValue() == toFind) {
					int keyFound = entry.getKey();
					freqMap.remove(keyFound);
					ans[k - 1] = keyFound;
					break;
				}
			}
		 k--;
		}
		return ans;

	}
}
