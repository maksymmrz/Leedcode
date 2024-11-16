package maksym.preparation.hard;

public class StepsToMakeStringPalindrome {
    public int minInsertions(String s) {
        final int n = s.length();
        String r = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[2][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == r.charAt(j - 1)) {
                    dp[1][j] = dp[0][j - 1] + 1;
                } else {
                    dp[1][j] = Math.max(dp[0][j], dp[1][j - 1]);
                }
            }
            System.arraycopy(dp[1], 0, dp[0], 0, n + 1);
        }
        return s.length() - dp[1][n];
    }

    public static void main(String[] args) {
        StepsToMakeStringPalindrome o = new StepsToMakeStringPalindrome();
        System.out.println(o.minInsertions("mbadm"));
    }
}
