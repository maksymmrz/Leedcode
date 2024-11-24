package maksym.preparation.medium.dp;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int n = 1; n <= target; n++) {
            for (int num : nums) {
                if (num <= n) {
                    dp[n] += dp[n - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIV o = new CombinationSumIV();
        System.out.println(o.combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
