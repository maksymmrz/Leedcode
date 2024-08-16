package maksym.preparation.hard;

public class BestTimeBuySellStockIV {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[2][k + 1][prices.length + 1];

        for (int kk = 1; kk <= k; kk++) {
            for (int i = prices.length - 1; i >= 0; i--) {
                int sell = prices[i] + dp[0][kk - 1][i + 1];
                int buy = -prices[i] + dp[1][kk][i + 1];

                dp[0][kk][i] = Math.max(buy, dp[0][kk][i + 1]);
                dp[1][kk][i] = Math.max(sell, dp[1][kk][i + 1]);
            }
        }
        return dp[0][k][0];
    }

    public static void main(String[] args) {
        BestTimeBuySellStockIV instance = new BestTimeBuySellStockIV();
        System.out.println(instance.maxProfit(11, new int[]{48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94}));
    }
}
