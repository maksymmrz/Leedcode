package maksym.preparation.medium.ranges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        var pq = new PriorityQueue<Integer>();

        var maxRooms = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            while (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.add(end);

            maxRooms = Math.max(pq.size(), maxRooms);
        }

        return maxRooms;
    }

    public static void main(String[] args) {
        MeetingRoomsII o = new MeetingRoomsII();
        int[][] m = new int[][]{{1, 4}, {3, 5}, {3, 4}, {5, 6}};
        System.out.println(o.minMeetingRooms(m));
    }
}
