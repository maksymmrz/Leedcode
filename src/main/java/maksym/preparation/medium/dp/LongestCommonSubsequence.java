package maksym.preparation.medium.dp;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        final int m = text1.length();
        final int n = text2.length();
        int[][] dp = new int[2][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[1][j] = dp[0][j - 1] + 1;
                } else {
                    dp[1][j] = Math.max(dp[0][j], dp[1][j - 1]);
                }
            }
            System.arraycopy(dp[1], 0, dp[0], 0, n + 1);
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence o = new LongestCommonSubsequence();
        System.out.println(o.longestCommonSubsequence("ab", "rta"));
    }
}
