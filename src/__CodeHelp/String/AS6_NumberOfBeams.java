package __CodeHelp.String;

public class AS6_NumberOfBeams {
//2125. Number of Laser Beams in a Bank
	public static void main(String[] args) {
		System.out.println(numberOfBeams(new String[] {}));

	}

//	T(N*M) Space(N*M)
	public static int numberOfBeams(String[] bank) {
		int prev = 0;
		int totalBeam = 0;
		for (String ss : bank) {
			int laserCount = 0;
			for (char ch : ss.toCharArray()) {
				if (ch == '1') {
					laserCount++;
				}
			}
			if (laserCount != 0) {
				totalBeam += prev * laserCount;
				prev = laserCount;
			}

		}

		return totalBeam;
	}
}
