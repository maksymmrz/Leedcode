package maksym.preparation.medium;

import maksym.preparation.util.Util;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> pairs = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (end < currStart) {
                pairs.add(new int[]{start, end});
                start = currStart;
                end = currEnd;
            } else {
                end = Math.max(currEnd, end);
            }
        }
        pairs.add(new int[]{start, end});
        int[][] result = new int[pairs.size()][];
        for (int i = 0; i < pairs.size(); i++) {
            result[i] = pairs.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        MergeIntervals instance = new MergeIntervals();

        int[][] intervals1 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Util.show2d(instance.merge(intervals1));
    }
}
