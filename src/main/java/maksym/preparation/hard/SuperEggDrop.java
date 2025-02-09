package maksym.preparation.hard;

public class SuperEggDrop {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) dp[1][i] = i;

        for (int kk = 2; kk <= k; kk++) {
            int o = 1;

            for (int i = 1; i <= n; i++) {
                while (o < n && Math.abs(dp[kk - 1][o - 1] - dp[kk][i - o]) > Math.abs(dp[kk - 1][o] - dp[kk][i - o + 1]))
                    o++;

                dp[kk][i] = 1 + Math.max(dp[kk - 1][o - 1], dp[kk][i - o]);
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {
        SuperEggDrop o = new SuperEggDrop();
        System.out.println(o.superEggDrop(2, 6));
        System.out.println(o.superEggDrop(3, 14));
        System.out.println(o.superEggDrop(13, 8192));
    }
}
