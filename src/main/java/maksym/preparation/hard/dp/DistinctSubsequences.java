package maksym.preparation.hard.dp;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j <= s.length(); j++) dp[0][j] = 1;

        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                dp[i][j] = dp[i][j - 1];
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] += dp[i - 1][j - 1];
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        DistinctSubsequences instance = new DistinctSubsequences();
        System.out.println(instance.numDistinct("rabbbit", "rabbit"));
        System.out.println(instance.numDistinct("babgbag", "bag"));
    }
}
