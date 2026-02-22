package maksym.preparation.hard.dp;

public class NumberOfWaysForGivenDictionary {
    public int numWays(String[] words, String target) {
        final int MOD = 1000_000_007;
        final int W = words[0].length();
        final int T = target.length();

        long[][] freqOnPos = new long[W + 1][26];

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                freqOnPos[i + 1][ch - 'a']++;
            }
        }

        long[][] dp = new long[T + 1][W + 1];
        for (int j = 0; j < W; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= W; j++) {
                dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;

                int chPos = target.charAt(i - 1) - 'a';

                dp[i][j] = (dp[i][j] + freqOnPos[j][chPos] * dp[i - 1][j - 1]) % MOD;
            }
        }

        return (int) dp[T][W];
    }

    public static void main(String[] args) {
        var o = new NumberOfWaysForGivenDictionary();

        System.out.println(o.numWays(new String[]{"abba","baab"}, "bab"));
        System.out.println(o.numWays(new String[]{"abbc", "cbrc"}, "abc"));
    }
}
