package maksym.preparation.medium.dp;

public class TradeStockWithCooldown {
    public int maxProfit(int[] prices) {
        int neutral = 0;
        int sold = Integer.MIN_VALUE;
        int bought = Integer.MIN_VALUE;

        for (int price : prices) {
            int prevSold = sold;

            sold = price + bought;
            bought = Math.max(-price + neutral, bought);
            neutral = Math.max(prevSold, neutral);
        }
        return Math.max(sold, neutral);
    }

    public static void main(String[] args) {
        TradeStockWithCooldown o = new TradeStockWithCooldown();
        System.out.println(o.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
