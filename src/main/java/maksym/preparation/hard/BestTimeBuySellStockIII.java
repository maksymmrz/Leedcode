package maksym.preparation.hard;

public class BestTimeBuySellStockIII {
    public int maxProfit(int[] prices) {
        int[] left = new int[prices.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            int prev = i == 0 ? Integer.MIN_VALUE : left[i - 1];
            left[i] = Math.max(prices[i] - min, prev);
        }
        int[] right = new int[prices.length];
        int max = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (max < prices[i]) {
                max = prices[i];
            }
            int prev = i == prices.length - 1 ? Integer.MIN_VALUE : right[i + 1];
            right[i] = Math.max(max - prices[i], prev);
        }
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            int two = left[i] + right[i];
            int oneOrTwo = Math.max(two, left[i]);
            sum = Math.max(oneOrTwo, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        BestTimeBuySellStockIII instance = new BestTimeBuySellStockIII();
        System.out.println(instance.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
