package maksym.preparation.medium.dp;

public class BuySellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int open = Integer.MIN_VALUE;
        int closed = 0;

        for (int price : prices) {
            int closedPrev = closed;

            closed = Math.max(price + open, closed);
            open = Math.max(-price + closedPrev - fee, open);
        }
        return closed;
    }

    public static void main(String[] args) {
        BuySellStockWithTransactionFee o = new BuySellStockWithTransactionFee();
        System.out.println(o.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
        System.out.println(o.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
