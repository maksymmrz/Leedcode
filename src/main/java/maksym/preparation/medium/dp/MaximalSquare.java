package maksym.preparation.medium.dp;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        final int M = matrix.length;
        final int N = matrix[0].length;

        int[][] dp = new int[M + 1][N + 1];
        var maxH = 0;

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
                maxH = Math.max(dp[i][j], maxH);
            }
        }

        return maxH * maxH;
    }

    public static void main(String[] args) {
        MaximalSquare o = new MaximalSquare();
        char[][] m = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(o.maximalSquare(m));
    }
}
