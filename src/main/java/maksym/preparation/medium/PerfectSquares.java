package maksym.preparation.medium;

public class PerfectSquares {
    public int numSquares(int n) {
        final int sqrtMax = 1 + (int)Math.sqrt(n);
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= sqrtMax && j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares o = new PerfectSquares();
        System.out.println(o.numSquares(12));
    }
}
