package maksym.preparation.hard.dp;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        final var M = s.length() + 1;
        final var N = p.length() + 1;

        var dp = new boolean[M][N];
        dp[0][0] = true;
        for (int j = 1; j < N; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                var x = i - 1;
                var y = j - 1;

                if (p.charAt(y) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(y) == '*') {

                    if (p.charAt(y - 1) == '.') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        if (s.charAt(x) == p.charAt(y - 1)) {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                        } else {
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                } else {
                    dp[i][j] = s.charAt(x) == p.charAt(y) && dp[i - 1][j - 1];
                }
            }
        }

        return dp[M - 1][N - 1];
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("aaa", "ab*a*c*a"));
        System.out.println(new RegularExpressionMatching().isMatch("a", ".*."));
    }
}
