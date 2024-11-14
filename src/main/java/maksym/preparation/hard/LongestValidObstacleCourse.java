package maksym.preparation.hard;

import maksym.preparation.util.Util;

public class LongestValidObstacleCourse {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        final int n = obstacles.length;
        int[] seq = new int[n];
        int lim = 0;
        int[] lens = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                seq[0] = obstacles[0];
                lim++;
                lens[i] = lim;
            } else {
                if (seq[lim - 1] <= obstacles[i]) {
                    seq[lim] = obstacles[i];
                    lim++;
                    lens[i] = lim;
                } else {
                    int j = bs(seq, lim - 1, obstacles[i]);
                    seq[j] = obstacles[i];
                    lens[i] = j + 1;
                }
            }
        }
        return lens;
    }

    private int bs(int[] arr, int to, int target) {
        int l = 0;
        while (l < to) {
            int m = (l + to) / 2;
            if (arr[m] <= target) l = m + 1;
            else to = m;
        }
        return l;
    }

    public static void main(String[] args) {
        LongestValidObstacleCourse o = new LongestValidObstacleCourse();
        Util.show(o.longestObstacleCourseAtEachPosition(new int[]{2, 2, 1}));
        Util.show(o.longestObstacleCourseAtEachPosition(new int[]{1, 2, 3, 2}));
        Util.show(o.longestObstacleCourseAtEachPosition(new int[]{3, 1, 5, 6, 4, 2}));
    }
}
