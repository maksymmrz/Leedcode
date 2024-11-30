package maksym.preparation.medium.dp;

import java.util.Arrays;

public class WaysToBuildGoodStrings {
    public int countGoodStrings(int low, int high, int zero, int one) {
        final int MOD = 1000_000_007;
        final int MID = Math.max(zero, one);
        final int LEN = MID * 2;


        int[] dp = new int[LEN + 1];

        dp[0] = 1;
        int sum = 0;
        int i = 1;

        for (int l = 1; l <= high; l++) {
            if (i >= zero) {
                dp[i] = (dp[i] + dp[i - zero]) % MOD;
            }
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % MOD;
            }
            if (l >= low) {
                sum = (sum + dp[i]) % MOD;
            }

            i++;

            if (i > LEN) {
                System.arraycopy(dp, MID + 1, dp, 1, MID);
                Arrays.fill(dp, MID + 1, LEN + 1, 0);
                i = MID + 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        WaysToBuildGoodStrings o = new WaysToBuildGoodStrings();
        System.out.println(o.countGoodStrings(3, 3, 1, 1));
    }
}
