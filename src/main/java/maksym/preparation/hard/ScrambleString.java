package maksym.preparation.hard;


public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        final int n = s1.length();
        boolean[][][] dp = new boolean[n + 1][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                for (int j = 0; j <= n - l; j++) {
                    for (int ll = 1; ll < l; ll++) {
                        boolean swapped = dp[ll][i][j + l - ll] && dp[l - ll][i + ll][j];
                        boolean notSwapped = dp[ll][i][j] && dp[l - ll][i + ll][j + ll];

                        dp[l][i][j] |= swapped || notSwapped;
                    }
                }
            }
        }
        return dp[n][0][0];
    }

    public static void main(String[] args) {
        ScrambleString instance = new ScrambleString();
        System.out.println(instance.isScramble("abab", "aabb"));
        System.out.println(instance.isScramble("abb", "bba"));
        System.out.println(instance.isScramble("abcd", "badc"));
        System.out.println(instance.isScramble("pknsvxobynprj", "kobvyxnjrppsn"));
    }
}
