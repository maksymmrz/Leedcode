package maksym.preparation.medium.dp;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (i >= coin && dp[i - coin] >= 0) {
                    dp[i] = Math.min(dp[i - coin], dp[i]);
                }
            }

            if (dp[i] != Integer.MAX_VALUE) dp[i]++;
            else dp[i] = -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange o = new CoinChange();
        System.out.println(o.coinChange(new int[]{1, 2, 5}, 11));
    }
}
