package maksym.preparation.medium.dp;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int m = obstacleGrid.length;
        final int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    int upper = 0;
                    int left = 0;
                    if (i > 0 && obstacleGrid[i - 1][j] == 0) {
                        upper = dp[j];
                    }
                    if (j > 0 && obstacleGrid[i][j - 1] == 0) {
                        left = dp[j - 1];
                    }
                    int one = i == 0 && j == 0 ? 1 : 0;
                    dp[j] = one + upper + left;
                } else {
                    dp[j] = 0;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        UniquePathsII instance = new UniquePathsII();

        int[][] grid1 = new int[][]{
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };

        System.out.println(instance.uniquePathsWithObstacles(grid1));
    }
}
