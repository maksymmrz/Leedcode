package maksym.preparation.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEvents {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int first = 100000;
        int last = 0;
        for (int[] e : events) {
            first = Math.min(e[0], first);
            last = Math.max(e[1] + 1, last);
        }

        int idx = 0;
        int count = 0;

        for (int d = first; d <= last; d++) {
            while (!pq.isEmpty() && pq.peek() < d) pq.poll();

            while (idx < events.length && d == events[idx][0]) {
                pq.add(events[idx][1]);
                idx++;
            }

            if (!pq.isEmpty() && pq.peek() >= d) {
                pq.poll();
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaximumNumberOfEvents o = new MaximumNumberOfEvents();
        int[][] events = new int[][]{{1, 2}, {2, 4}, {3, 4}, {3, 4}, {4, 4}};
        System.out.println(o.maxEvents(events));
    }
}
