package maksym.preparation.medium.sweepline;

import maksym.preparation.util.Util;

import java.util.*;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        final int n = intervals.length;

        List<int[]> acc = new ArrayList<>();
        int i = 0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            acc.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        acc.add(newInterval);

        while (i < n) {
            acc.add(intervals[i]);
            i++;
        }

        int[][] res = new int[acc.size()][];

        for (int j = 0; j < acc.size(); j++) {
            res[j] = acc.get(j);
        }

        return res;
    }

    public static void main(String[] args) {
        InsertInterval instance = new InsertInterval();

        int[][] intervals1 = new int[][]{{1, 3}, {6, 9}};
        Util.show2d(instance.insert(intervals1, new int[]{2, 5}));

        int[][] intervals2 = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        Util.show2d(instance.insert(intervals2, new int[]{4, 8}));
    }
}
