package maksym.preparation.hard.dfsbfs;

import java.util.Arrays;
import java.util.LinkedList;

public class ShortestPathInGridWithObstaclesElimination {
    private final int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int shortestPath(int[][] grid, int k) {
        final int M = grid.length;
        final int N = grid[0].length;

        var best = new int[M][N];
        for (int[] arr : best) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        best[0][0] = k - grid[0][0];

        var q = new LinkedList<int[]>();
        q.offer(new int[]{0, 0, 0, k - grid[0][0] });

        while (!q.isEmpty()) {
            var record = q.poll();
            var i = record[0];
            var j = record[1];
            var currPath = record[2];
            var currSkipRemained = record[3];

            if (i == M - 1 && j == N - 1) {
                return currPath;
            }

            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];

                if (x < M && x >= 0 && y >= 0 && y < N) {
                    var nextSkipRemained = currSkipRemained - grid[x][y];

                    if (nextSkipRemained >= 0 && nextSkipRemained > best[x][y]) {
                        best[x][y] = nextSkipRemained;
                        q.offer(new int[]{x, y, currPath + 1, nextSkipRemained});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        var o = new ShortestPathInGridWithObstaclesElimination();
        var m = new int[][]{
                {0, 0},
                {1, 1}
        };

        System.out.println(o.shortestPath(m, 1));
        var m1 = new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };

        System.out.println(o.shortestPath(m1, 1));
    }
}
