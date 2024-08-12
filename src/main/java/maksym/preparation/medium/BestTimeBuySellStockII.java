package maksym.preparation.medium;

public class BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int price : prices) {
            if (price <= min) min = price;
            else {
                sum += price - min;
                min = price;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        BestTimeBuySellStockII instance = new BestTimeBuySellStockII();
        System.out.println(instance.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
