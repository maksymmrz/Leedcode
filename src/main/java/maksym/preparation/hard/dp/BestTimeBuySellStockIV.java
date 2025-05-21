package maksym.preparation.hard.dp;

import java.util.Arrays;

public class BestTimeBuySellStockIV {
    public int maxProfit(int k, int[] prices) {
        final int N = prices.length;

        int[][] closed = new int[k + 1][N + 1];
        int[][] open = new int[k + 1][N + 1];

        Arrays.fill(open[0], Integer.MIN_VALUE);


        for (int kk = 1; kk <= k; kk++) {
            open[kk][0] = Integer.MIN_VALUE;

            for (int i = 1; i <= N; i++) {
                int p = prices[i - 1];

                open[kk][i] = Math.max(-p + closed[kk - 1][i - 1], open[kk][i - 1]);

                closed[kk][i] = Math.max(p + open[kk][i - 1], closed[kk][i - 1]);
            }
        }

        return closed[k][N];
    }

    public static void main(String[] args) {
        BestTimeBuySellStockIV instance = new BestTimeBuySellStockIV();
        System.out.println(instance.maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(instance.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
