package maksym.preparation.medium.dp;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int[] p = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tail = 0;
                if (i != 0 || j != 0)  {
                    int upper = i > 0 ? p[j] : Integer.MAX_VALUE;
                    int left = j > 0 ? p[j - 1] : Integer.MAX_VALUE;

                    tail = Math.min(upper, left);
                }
                p[j] = grid[i][j] + tail;
            }
        }
        return p[n - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum instance = new MinimumPathSum();

        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(instance.minPathSum(grid));
    }
}
