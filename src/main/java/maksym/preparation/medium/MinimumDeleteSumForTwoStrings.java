package maksym.preparation.medium;

public class MinimumDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        final int m = s1.length();
        final int n = s2.length();
        int[] dp = new int[n + 1];
        int[] dp1 = new int[n + 1];

        for (int j = 1; j <= n; j++) {
            dp[j] = s2.charAt(j - 1) + dp[j - 1];
        }

        for (int i = 1; i <= m; i++) {
            dp1[0] = s1.charAt(i - 1) + dp[0];

            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j -1)) {
                    dp1[j] = dp[j - 1];
                } else {
                    dp1[j] = Math.min(s1.charAt(i - 1) + dp[j], s2.charAt(j - 1) + dp1[j - 1]);
                }
            }
            int[] tmp = dp;
            dp = dp1;
            dp1 = tmp;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        MinimumDeleteSumForTwoStrings o = new MinimumDeleteSumForTwoStrings();
        System.out.println(o.minimumDeleteSum("sea", "eat"));
    }
}
