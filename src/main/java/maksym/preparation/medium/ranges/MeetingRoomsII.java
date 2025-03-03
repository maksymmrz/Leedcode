package maksym.preparation.medium.ranges;

import java.util.Arrays;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        final int n = intervals.length;

        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int j = 0;
        int rooms = 0;

        for (int i = 0; i < n; i++) {
            while (ends[j] <= starts[i]) j++;

            rooms = Math.max(i - j + 1, rooms);
        }

        return rooms;
    }

    public static void main(String[] args) {
        MeetingRoomsII o = new MeetingRoomsII();
        int[][] m = new int[][]{{1, 4}, {3, 5}, {3, 4}, {5, 6}};
        System.out.println(o.minMeetingRooms(m));
    }
}
