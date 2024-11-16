package maksym.preparation.medium.dp;

public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        final int m = nums1.length;
        final int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
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
        UncrossedLines o = new UncrossedLines();
        System.out.println(o.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
    }
}
