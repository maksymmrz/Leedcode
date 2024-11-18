package maksym.preparation.hard;

public class BestTimeBuySellStockIII {
    public int maxProfit(int[] prices) {
        final int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int min = Integer.MAX_VALUE;
        int prev = 0;

        for (int i = 0; i < prices.length; i++) {
            left[i] = Math.max(prices[i] - min, prev);
            prev = left[i];
            min = Math.min(prices[i], min);
        }

        int max = 0;
        prev = 0;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = Math.max(max - prices[i], prev);
            prev = right[i];
            max = Math.max(prices[i], max);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = Math.max(left[i] + right[i], sum);
        }

        return sum;
    }

    public static void main(String[] args) {
        BestTimeBuySellStockIII instance = new BestTimeBuySellStockIII();
        System.out.println(instance.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
