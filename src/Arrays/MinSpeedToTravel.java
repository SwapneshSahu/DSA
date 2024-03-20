package Arrays;

public class MinSpeedToTravel {

	public static void main(String[] args) {
		int[] dist = new int[] { 1, 3, 2 };

		System.out.println(minSpeedOnTime(dist, 2.7));

		// System.out.println(1.00%1 == 0);
		
		

	}

	public static int minSpeedOnTime(int[] dist, double hour) {
		// Check if it's impossible to finish the journey within the given time
		if (dist.length - 1 > hour)
			return -1;

		// Initialize the search space for binary search
		int left = 1; // The minimum possible speed is 1.
		int right = (int) 1e7; // The maximum possible speed is 10^7.

		// Initialize the answer variable to keep track of the valid speed
		int ans = -1;

		// Perform binary search to find the minimum valid speed
		while (left <= right) {
			// Calculate the middle speed to check if it's valid
			int mid = left + (right - left) / 2;
			double currHour = 0;

			// Simulate the journey at the current speed to calculate the time taken
			for (int i = 0; i < dist.length && currHour <= hour; i++) {
				// If not the last segment, use ceil to account for rounding up the division
				// result
				if (i != dist.length - 1) {
					currHour += Math.ceil(dist[i] * 1.0 / mid);
				} else {
					// For the last segment, no need to use ceil, as we don't want to exceed the
					// hour.
					currHour += dist[i] * 1.0 / mid;
				}
			}

			// Compare the time taken with the available hour
			if (currHour > hour) {
				// If the current speed results in more than the available hour, increase the
				// speed (search in the right half)
				left = mid + 1;
			} else {
				// If the current speed results in less than or equal to the available hour,
				// update the answer and decrease the speed (search in the left half)
				ans = mid;
				right = mid - 1;
			}
		}

		// Return the minimum valid speed that allows finishing the journey within the
		// given hour
		return ans;
	}

}
