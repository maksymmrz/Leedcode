package maksym.preparation.medium;

import maksym.preparation.util.Util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};

        List<int[]> result = new LinkedList<>();

        int idx = 0;
        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            result.add(intervals[idx]);
            idx++;
        }

        int[] axillary = Arrays.copyOf(newInterval, newInterval.length);

        while (idx < intervals.length && intervals[idx][0] <= axillary[1]) {
            axillary[0] = Math.min(intervals[idx][0], axillary[0]);
            axillary[1] = Math.max(intervals[idx][1], axillary[1]);
            idx++;
        }
        result.add(axillary);

        while (idx < intervals.length) {
            result.add(intervals[idx]);
            idx++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval instance = new InsertInterval();

        int[][] intervals1 = new int[][]{{1, 3}, {6, 9}};
        Util.show2d(instance.insert(intervals1, new int[]{2, 5}));

        int[][] intervals2 = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        Util.show2d(instance.insert(intervals2, new int[]{4, 8}));
    }
}
