package maksym.preparation.medium.graph;

import java.util.*;

public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    extractIsland(i, j, grid, q);
                    i = m;
                    j = n;
                }
            }
        }

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int c = 0; c < size; c++) {
                int[] p = q.poll();
                assert p != null;
                int i = p[0];
                int j = p[1];

                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x >= 0 && y >= 0 && x < m && y < n) {
                        if (grid[x][y] == 0) {
                            grid[x][y] = -1;
                            q.add(new int[]{x, y});
                        } else if (grid[x][y] == 1) {
                            q.clear();
                            c = size;
                            break;
                        }
                    }
                }
            }

            if (!q.isEmpty())
                dist++;
        }
        return dist;
    }

    private void extractIsland(int i, int j, int[][] g, Queue<int[]> acc) {
        final int m = g.length;
        final int n = g[0].length;

        if (i >= 0 && j >= 0 && i < m && j < n && g[i][j] == 1) {
            acc.add(new int[]{i, j});
            g[i][j] = -1;

            extractIsland(i + 1, j, g, acc);
            extractIsland(i, j + 1, g, acc);
            extractIsland(i - 1, j, g, acc);
            extractIsland(i, j - 1, g, acc);
        }
    }

    public static void main(String[] args) {
        ShortestBridge o = new ShortestBridge();
        int[][] m = new int[][]{
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0}
        };

        System.out.println(o.shortestBridge(m));
    }
}
