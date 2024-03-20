package __CodeHelp.String;

public class CW2_Garbage_Collection {

	public static void main(String[] args) {
		String[] garbage = new String[] { "MMM", "PGM", "GP" };
		int[] travel = new int[] { 3, 10 };

		System.out.println(garbageCollection(garbage, travel));
	}

	public static int garbageCollection(String[] garbage, int[] travel) {
		boolean pTravel = true;
		boolean mTravel = true;
		boolean gTravel = true;

		for (int i = 1; i < travel.length; i++) {
			travel[i] += travel[i - 1];
		}
		int totalTime = 0;
		for (int i = garbage.length - 1; i >= 0; i--) {

			for (char ch : garbage[i].toCharArray()) {
				if (i != 0) {
					if (ch == 'M' && mTravel) {
						totalTime += travel[i - 1];
						mTravel = false;

					} else if (ch == 'P' && pTravel) {
						totalTime += travel[i - 1];
						pTravel = false;
					} else if (ch == 'G' && gTravel) {
						totalTime += travel[i - 1];
						gTravel = false;
					}
				}
				totalTime++;
			}
		}

		return totalTime;

	}

}
