package Queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskSchedular {

	public static void main(String[] args) {
	//	char[] tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
		char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
		System.out.println(leastInterval(tasks, 2));
	}

	public static int leastInterval(char[] tasks, int p) {
		int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freq) {
            if (f > 0) pq.offer(f);
        }

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int cnt = pq.poll() - 1;

                if (cnt != 0) {
                    q.offer(new Pair(cnt, time + n));
                }
            }

            if (!q.isEmpty() && q.peek().getValue() == time) {
                pq.offer(q.poll().getKey());
            }
        }

        return time;
    }

  
}
