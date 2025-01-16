package maksym.preparation.medium;

import maksym.preparation.util.Util;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        final int m = mat.length;
        final int n = mat[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int left = j > 0 ? dp[i][j - 1] : m * n;
                    int upper = i > 0 ? dp[i - 1][j] : m * n;

                    dp[i][j] = 1 + Math.min(left, upper);
                }

            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int right = j < n - 1 ? dp[i][j + 1] : m * n;
                    int down = i < m - 1 ? dp[i + 1][j] : m * n;

                    dp[i][j] = Math.min(Math.min(right, down) + 1, dp[i][j]);
                }

            }
        }
        return dp;
    }

    public static void main(String[] args) {
        Matrix01 o = new Matrix01();
        int[][] m = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        Util.show2d(o.updateMatrix(m));
    }
}
