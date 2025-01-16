package maksym.preparation.medium;

public class PathWithMinEffort {
    public int minimumEffortPath(int[][] heights) {
        final int m = heights.length;
        final int n = heights[0].length;

        int right = 0;
        for (int[] hs : heights) {
            for (int h : hs) {
                right = Math.max(h, right);
            }
        }
        int left = 0;

        while (left < right) {
            int med = (left + right) / 2;
            if (isSolution(heights, 0, 0, med, new boolean[m][n])) right = med;
            else left = med + 1;
        }
        return left;
    }

    private boolean isSolution(int[][] hs, int i, int j, int maxEffort, boolean[][] visited) {
        final int m = hs.length;
        final int n = hs[0].length;
        final int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean res = false;

        visited[i][j] = true;

        if (i == m - 1 && j == n - 1) {
            return true;
        }

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
                int effort = Math.abs(hs[i][j] - hs[x][y]);
                if (effort <= maxEffort) {
                    res |= isSolution(hs, x, y, maxEffort, visited);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PathWithMinEffort o = new PathWithMinEffort();
        int[][] hs0 = new int[][]{{1, 10, 6, 7, 9, 10, 4, 9}};
        System.out.println(o.minimumEffortPath(hs0));

        int[][] hs1 = new int[][]{
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println(o.minimumEffortPath(hs1));

        int[][] hs2 = new int[][]{
                {1, 2, 1, 1, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 1, 1, 2, 1}
        };
        System.out.println(o.minimumEffortPath(hs2));
    }
}
