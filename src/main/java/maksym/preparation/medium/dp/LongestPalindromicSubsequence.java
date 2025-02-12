package maksym.preparation.medium.dp;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        final int n = s.length();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) dp[i][i] = 1;

        for (int l = 1; l < n; l++) {
            for (int i = 0; i < n - l; i++) {
                int j = i + l;

                int odd = Math.max(dp[i + 1][j], dp[i][j - 1]);
                int even = 0;

                if (s.charAt(i) == s.charAt(j)) {
                    int prev = l > 1 ? dp[i + 1][j - 1] : 0;
                    even = 2 + prev;
                }

                dp[i][j] = Math.max(odd, even);
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence o = new LongestPalindromicSubsequence();
        System.out.println(o.longestPalindromeSubseq("bbbacab"));
    }
}
