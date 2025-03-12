package maksym.preparation.medium.ranges;

import maksym.preparation.util.Util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        final int n = intervals.length;
        int[][] sorted = Arrays.copyOf(intervals, n);
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        int[] res = new int[n];
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < n; i++) indexes.put(intervals[i][0], i);

        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = n - 1;
            int end = intervals[i][1];
            while (l < r) {
                int m = (l + r) / 2;
                if (sorted[m][0] < end) l = m + 1;
                else r = m;
            }
            int startNext = sorted[l][0];

            if (end <= startNext) {
                res[i] = indexes.get(startNext);
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindRightInterval instance = new FindRightInterval();
        Util.show(instance.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}}));
        Util.show(instance.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}}));
    }
}
