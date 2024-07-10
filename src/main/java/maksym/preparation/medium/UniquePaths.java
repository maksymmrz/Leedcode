package maksym.preparation.medium;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 || j != 0) {
                    int upper = i != 0 ? dp[j] : 0;
                    int left = j != 0 ? dp[j - 1] : 0;
                    dp[j] = upper + left;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        UniquePaths instance = new UniquePaths();

        System.out.println(instance.uniquePaths(3, 7));
    }
}
