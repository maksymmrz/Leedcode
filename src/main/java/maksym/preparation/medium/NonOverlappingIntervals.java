package maksym.preparation.medium;

import java.util.*;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int end = -1 << 31;

        for (int[] interval : intervals) {
            int s = interval[0];
            int e = interval[1];

            if (end <= s) {
                end = e;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals o = new NonOverlappingIntervals();
        System.out.println(o.eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
        System.out.println(o.eraseOverlapIntervals(new int[][]{{1, 3}, {2, 9}, {3, 7}, {5, 9}, {7, 8}}));
    }
}
