package maksym.preparation.medium.backtracking;

public class KnightDialer {
    private static final int MOD = 1_000_000_007;

    private final int[][] m = new int[][]{
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1},
            {-1, 1, -1}
    };
    private final int[][] dirs = new int[][]{
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1},
            {1, 2},
            {1, -2},
            {-1, 2},
            {-1, -2},
    };

    public int knightDialer(int n) {
        var count = 0;
        var cache = new int[m.length][m[0].length][n + 1];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                count = (count + dfs(i, j, n, cache)) % MOD;
            }
        }

        return count;
    }

    private int dfs(int i, int j, int n, int[][][] cache) {
        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length || n == 0 || m[i][j] == -1) return 0;
        if (n == 1) return 1;

        if (cache[i][j][n] > 0) return cache[i][j][n];

        int sum = 0;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            sum = (sum + dfs(x, y, n - 1, cache)) % MOD;
        }

        cache[i][j][n] = sum;

        return sum;
    }

    public static void main(String[] args) {
        var o = new KnightDialer();
        System.out.println(o.knightDialer(20));
    }
}
