package Arrays;

import java.util.Arrays;

public class EliminateMonster {
//1921. Eliminate Maximum Number of Monsters
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int eliminateMaximum(int[] dist, int[] speed) {
		// 1. Calculate the time it takes for each monster to reach you and update the
		// 'dist' array.
		for (int i = 0; i < dist.length; ++i) {
			dist[i] = (dist[i] - 1) / speed[i];
		}

		// 2. Sort the 'dist' array to have monsters in increasing order of time to
		// reach you.
		Arrays.sort(dist);

		// 3. Iterate through the 'dist' array and find the first monster that reaches
		// you before its corresponding index in the array.
		for (int i = 0; i < dist.length; ++i) {
			if (i > dist[i]) {
				// 4. If a monster reaches you before its corresponding index, return the index
				// as the number of eliminated monsters.
				return i;
			}
		}

		// 5. If no monster reaches you before its corresponding index, return the total
		// number of monsters as all of them are eliminated.
		return dist.length;
	}

	/***
	 * The subtraction of 1 from dist[i] in the line (dist[i] - 1) / speed[i] is
	 * likely done to account for the fact that you want to calculate the time it
	 * takes for a monster to reach a specific point, which is likely one unit
	 * closer to you than its actual position. This adjustment is common when
	 * dealing with scenarios where you want to calculate the time to reach a
	 * destination or target point.
	 * 
	 * Here's the reasoning behind it:
	 * 
	 * Suppose a monster is at a distance of dist[i] and it's moving at a speed of
	 * speed[i]. If you calculate the time it takes for the monster to reach exactly
	 * dist[i] without subtracting 1, you're assuming that the monster is already at
	 * the destination point when the time starts counting. In other words, the
	 * calculation doesn't account for the fact that the monster is initially one
	 * unit away from you.
	 */
}
