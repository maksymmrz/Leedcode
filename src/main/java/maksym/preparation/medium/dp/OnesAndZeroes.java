package maksym.preparation.medium.dp;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int[][] dpp = new int[m + 1][n + 1];

        for (String str : strs) {
            int zs = (int) str.chars().filter(ch -> ch == '0').count();
            int os = str.length() - zs;

            for (int mm = 0; mm <= m; mm++) {
                for (int nn = 0; nn <= n; nn++) {
                    if (zs <= mm && os <= nn) {
                        dp[mm][nn] = Math.max(dpp[mm - zs][nn - os] + 1, dp[mm][nn]);
                    }
                }
            }
            for (int k = 0; k <= m; k++) {
                System.arraycopy(dp[k], 0, dpp[k], 0, n + 1);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        OnesAndZeroes o = new OnesAndZeroes();
        System.out.println(o.findMaxForm(new String[] {"10","0","1"}, 1, 1));
        System.out.println(o.findMaxForm(new String[] {"10","0001","111001","1","0"}, 5, 3));
    }
}
