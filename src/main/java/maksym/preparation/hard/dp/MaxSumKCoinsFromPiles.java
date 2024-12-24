package maksym.preparation.hard.dp;

import java.util.List;

public class MaxSumKCoinsFromPiles {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] dp = new int[k + 1];
        int[] pdp = new int[k + 1];

        for (List<Integer> pile : piles) {
            for (int kk = 1; kk <= k; kk++) {
                int sum = 0;
                dp[kk] = pdp[kk];

                for (int i = 0; i < Math.min(pile.size(), kk); i++) {
                    sum += pile.get(i);
                    dp[kk] = Math.max(sum + pdp[kk - i - 1], dp[kk]);
                }
            }
            System.arraycopy(dp, 0, pdp, 0, dp.length);
        }
        return dp[k];
    }

    public static void main(String[] args) {
        MaxSumKCoinsFromPiles o = new MaxSumKCoinsFromPiles();
        List<List<Integer>> piles = List.of(List.of(1, 100, 3), List.of(7, 8, 9));
        System.out.println(o.maxValueOfCoins(piles, 2));
    }
}
