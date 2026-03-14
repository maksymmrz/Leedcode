package maksym.preparation.medium.dp;

import java.util.stream.IntStream;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        final int N = nums.length;
        final int S = IntStream.of(nums).sum();

        if (S % 2 != 0) {
            return false;
        }
        final int T = S / 2;

        boolean[][] dp = new boolean[N + 1][T + 1];
        dp[0][0] = true;

        for (int i = 1; i <= N; i++) {
            var num = nums[i - 1];

            for (int s = 1; s <= T; s++) {
                if (num <= s) {
                    dp[i][s] = dp[i - 1][s - num] || dp[i - 1][s];
                } else {
                    dp[i][s] = dp[i - 1][s];
                }
            }
        }

        return dp[N][T];
    }

    public static void main(String[] args) {
        var o = new PartitionEqualSubsetSum();
        System.out.println(o.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(o.canPartition(new int[]{1, 5, 11, 5}));
    }
}
