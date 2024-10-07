package maksym.preparation.hard;

public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        Integer[][][] memo = new Integer[m][n][m];
        int cherries = dfs(grid, 0, 0, 0, 0, memo);
        return Math.max(cherries, 0);
    }

    public int dfs(int[][] g, int x1, int y1, int x2, int y2, Integer[][][] memo) {
        final int m = g.length;
        final int n = g[0].length;

        if (x1 >= m || x2 >= m || y1 >= n || y2 >= n) return Integer.MIN_VALUE;
        else if (g[x1][y1] < 0 || g[x2][y2] < 0) return Integer.MIN_VALUE;
        else {
            if (memo[x1][y1][x2] != null) return memo[x1][y1][x2];
            int cherries = g[x1][y1];

            if (x1 != x2 || y1 != y2) {
                cherries += g[x2][y2];
            }
            if (x1 == m - 1 && y1 == n - 1) return cherries;

            int p1 = dfs(g, x1 + 1, y1, x2 + 1, y2, memo);
            int p2 = dfs(g, x1 + 1, y1, x2, y2 + 1, memo);
            int p3 = dfs(g, x1, y1 + 1, x2 + 1, y2, memo);
            int p4 = dfs(g, x1, y1 + 1, x2, y2 + 1, memo);

            int path = cherries + Math.max(Math.max(p1, p2), Math.max(p3, p4));

            memo[x1][y1][x2] = path;
            return path;
        }
    }

    public static void main(String[] args) {
        CherryPickup instance = new CherryPickup();
        int[][] matrix = new int[][]{
                {1, 1, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 1, 1}
        };
        System.out.println(instance.cherryPickup(matrix));
    }
}
