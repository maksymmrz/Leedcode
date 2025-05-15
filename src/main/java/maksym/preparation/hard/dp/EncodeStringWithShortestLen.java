package maksym.preparation.hard.dp;

public class EncodeStringWithShortestLen {

    public String encode(String s) {
        final int N = s.length();

        String[][] dp = new String[N][N];

        for (int l = 1; l <= N; l++) {

            for (int i = 0; i <= N - l; i++) {
                int j = i + l - 1;

                String substring = s.substring(i, i + l);
                dp[i][j] = substring;

                if (l >= 4) {
                    for (int m = i; m < j; m++) {
                        String s1 = dp[i][m];
                        String s2 = dp[m + 1][j];

                        if (s1.length() + s2.length() < dp[i][j].length()) {
                            dp[i][j] = s1 + s2;
                        }
                    }

                    for (int len = 1; len <= l / 2; len++) {
                        if (l % len == 0) {
                            String p = s.substring(i, i + len);
                            String replaced = substring.replaceAll(p, "");

                            if (replaced.isEmpty()) {
                                int count = l / len;

                                int encodedLen = String.valueOf(count).length() + 2 + p.length();

                                if (encodedLen < dp[i][j].length()) {
                                    String encodedPattern = dp[i][i + len - 1];
                                    String encoded = String.format("%1$s[%2$s]", count, encodedPattern);
                                    dp[i][j] = encoded;
                                }
                            }
                        }
                    }
                }
            }
        }

        return dp[0][N - 1];
    }

    public static void main(String[] args) {
        var o = new EncodeStringWithShortestLen();

        System.out.println(o.encode("bbbbbaaaaab"));
        System.out.println(o.encode("abbbabbbcabbbabbbc"));
    }
}
