package Arrays;

import java.util.Arrays;

public class MinimumRounds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tasks = new int[] {2,2,3,3,2,4,4,4,4,4};
		System.out.println(minimumRounds(tasks));
	}

	public static int minimumRounds(int[] tasks) {
		Arrays.sort(tasks);
		int count = 1;
		int ans = 0;
		for (int i = 1; i < tasks.length; i++) {
			if (tasks[i] == tasks[i - 1])
				count++;
			else {
				if (count == 1)
					return -1;
				else if (count == 2)
					ans++;
				else {
					if (count % 3 == 0)
						ans += count / 3;
					else if (count % 3 == 1)
						ans += (count / 3 + count % 3);
					else if (count % 3 == 2)
						ans += (count / 3 + count % 3 - 1);
				}
				count = 1;
			}

		}
		
		
			if (count == 1)
				return -1;
			else if (count == 2)
				ans++;
			else {
				if (count % 3 == 0)
					ans += count / 3;
				else if (count % 3 == 1)
					ans += (count / 3 + count % 3);
				else if (count % 3 == 2)
					ans += (count / 3 + count % 3 - 1);
			}
		
		
		return ans;
	}

}
