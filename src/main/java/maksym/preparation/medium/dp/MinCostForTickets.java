package maksym.preparation.medium.dp;

public class MinCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        int i = 0;

        for (int j = 1; j < dp.length; j++) {
            if (i < days.length && j == days[i]) {
                int dayT = costs[0] + dp[j - 1];
                int weekT = costs[1] + (j >= 7 ? + dp[j - 7] : 0);
                int monthT = costs[2] + (j >= 30 ? + dp[j - 30] : 0);

                dp[j] = Math.min(dayT, Math.min(weekT, monthT));
                i++;
            } else {
                dp[j] = dp[j - 1];
            }
        }
        return dp[365];
    }

    public static void main(String[] args) {
        MinCostForTickets o = new MinCostForTickets();
        System.out.println(o.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        System.out.println(o.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{7, 2, 15}));
    }
}
