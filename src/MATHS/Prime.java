package MATHS;

import java.util.ArrayList;

public class Prime {

	public static void main(String[] args) {
		System.out.println(SegmentedSieve(10, 1300));
		System.out.println(SieveofEratosthenes(1300).size());
	}

	public static int SegmentedSieve(int L, int R) {
		int count = 0;
		ArrayList<Integer> listOfPrime = SieveofEratosthenes((int) Math.sqrt(R));

		boolean[] notPrime = new boolean[(R - L) + 1];

		for (int j : listOfPrime) {
			int temp = 0;
			if (L % j != 0) {
				temp = j - L % j;
			}

			for (int i = L + temp; i <= R; i = i + j) {
				if (i == j)
					continue;
				if (i % j == 0) {
					notPrime[i - L] = true;
				}
			}

		}

		for (int j = 0; j <= (R - L); j++) {
			if (!notPrime[j]) {
				// System.out.println(j + L);
				count++;
			}
		}

		return count;
	}

//The Sieve of Eratosthenes is an algorithm for finding all the prime numbers up to a given integer. It works by building a list of all the integers from 2 to the given integer, and then iteratively marking as composite (i.e., not prime) the multiples of each prime, starting with the first prime number, 2.
	public static ArrayList<Integer> SieveofEratosthenes(int n) {
		boolean[] notPrime = new boolean[n + 1];
		ArrayList<Integer> ans = new ArrayList<Integer>();

		// because we dont consider 0 and 1 as a prime
		notPrime[0] = true;
		notPrime[1] = true;
		int i = 2;
		while (i <= n) {

			if (!notPrime[i]) {
				for (int j = 2; j * i <= n; j++) {
					notPrime[j * i] = true;
				}

			}
			i++;
		}
		int count = 0;
		for (int j = 0; j <= n; j++) {
			if (!notPrime[j]) {
				ans.add(j);
				count++;
			}
		}
		return ans;
	}

}
