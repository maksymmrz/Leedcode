package maksym.preparation.hard.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsIII {
    public int mostBooked(int n, int[][] meetings) {
        int[] meetingCount = new int[n];
        var usedRooms = new PriorityQueue<long[]>((a, b) -> {
            if (a[0] != b[0]) {
                return (int) Math.signum(a[0] - b[0]);
            } else {
                return (int) Math.signum(a[1] - b[1]);
            }
        });

        var availableRooms = new PriorityQueue<Long>();

        for (int i = 0; i < n; i++) {
            availableRooms.offer((long) i);
        }

        Arrays.sort(meetings, Comparator.comparingInt(arr -> arr[0]));

        for (int[] meet : meetings) {
            int start = meet[0];
            int end = meet[1];

            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                availableRooms.offer(usedRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                long room = availableRooms.poll();
                meetingCount[(int) room]++;
                usedRooms.offer(new long[]{end, room});
            } else {
                var record = usedRooms.poll();
                var from = record[0] + end - start;
                var room = record[1];
                meetingCount[(int) room]++;
                usedRooms.offer(new long[]{from, room});
            }
        }

        int max = 0;
        int maxIdx = -1;

        for (int i = 0; i < n; i++) {
            if (max < meetingCount[i]) {
                max = meetingCount[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        var o = new MeetingRoomsIII();
        System.out.println(o.mostBooked(2, new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}}));
        System.out.println(o.mostBooked(3, new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}}));
        System.out.println(o.mostBooked(4, new int[][]{{18, 19}, {3, 12}, {17, 19}, {2, 13}, {7, 10}}));
    }
}
