package maksym.preparation.hard;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        final int n = startTime.length;
        int[] dp = new int[n];
        int max = 0;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));

        for (int i = n - 1; i >= 0; i--) {
            int includeIdx = bs(jobs, i + 1, jobs[i][1]);
            int excludeIdx = bs(jobs, i + 1, jobs[i][0]);

            int include = includeIdx != -1 ? jobs[i][2] + dp[includeIdx] : jobs[i][2];
            int exclude = excludeIdx != -1 ? dp[excludeIdx] : 0;

            dp[i] = Math.max(include, exclude);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    private int bs(int[][] js, int l, int end) {
        if (l >= js.length) return -1;

        int r = js.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (js[mid][0] >= end) r = mid;
            else l = mid + 1;
        }
        return js[r][0] >= end ? r : -1;
    }

    public static void main(String[] args) {
        MaximumProfitInJobScheduling o = new MaximumProfitInJobScheduling();
        System.out.println(o.jobScheduling(
                new int[]{6, 15, 7, 11, 1, 3, 16, 2},
                new int[]{19, 18, 19, 16, 10, 8, 19, 8},
                new int[]{2, 9, 1, 19, 5, 7, 3, 19}
        ));
        System.out.println(o.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
    }
}
