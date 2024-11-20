package maksym.preparation.hard.dp;

public class BestTimeBuySellStockIV {
    public int maxProfit(int k, int[] prices) {
        final int n = prices.length;

        int profit = 0;

        int[][] b = new int[k + 1][n + 1];
        int[][] s = new int[k + 1][n + 1];

        for (int kk = 1; kk <= k; kk++) {
            b[kk][0] = Integer.MIN_VALUE;

            for (int i = 1; i <= n; i++) {
                s[kk][i] = Math.max(prices[i - 1] + b[kk][i - 1], s[kk][i - 1]);
                b[kk][i] = Math.max(-prices[i - 1] + s[kk - 1][i - 1], b[kk][i - 1]);
            }
            profit = Math.max(s[kk][n], profit);
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeBuySellStockIV instance = new BestTimeBuySellStockIV();
        System.out.println(instance.maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(instance.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
