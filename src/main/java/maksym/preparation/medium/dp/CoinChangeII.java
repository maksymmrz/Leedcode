package maksym.preparation.medium.dp;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {

            for (int n = 1; n <= amount; n++) {
                if (coin <= n) {
                    dp[n] += dp[n - coin];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeII o = new CoinChangeII();
        System.out.println(o.change(5, new int[]{1, 2, 5}));
    }
}
