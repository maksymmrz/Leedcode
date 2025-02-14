package maksym.preparation.hard;

import java.util.*;

public class MakingLargeIsland {
    public int largestIsland(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        int[] areas = new int[m * n / 2 + 5];
        int marker = 2;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    areas[marker] = areaWithMark(i, j, marker, grid);
                    marker++;
                }
            }
        }

        int maxArea = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    maxArea = Math.max(1 + areaIfBridge(i, j, grid, areas), maxArea);
                }
            }
        }

        int biggestIsland = Arrays.stream(areas, 2, marker).max().orElse(0);

        return Math.max(biggestIsland, maxArea);
    }

    private final int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private int areaIfBridge(int i, int j, int[][] g, int[] areas) {
        final int m = g.length;
        final int n = g[0].length;

        Set<Integer> markers = new HashSet<>();

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < m && y >= 0 && y < n && g[x][y] != g[i][j]) {
                markers.add(g[x][y]);
            }
        }

        int area = 0;

        for (Integer marker : markers) {
            area += areas[marker];
        }
        return area;
    }

    private int areaWithMark(int i, int j, int marker, int[][] g) {
        final int m = g.length;
        final int n = g[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j});
        g[i][j] = marker;

        int area = 1;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];

            for (int[] dir : dirs) {
                int a = x + dir[0];
                int b = y + dir[1];

                if (a >= 0 && b >= 0 && a < m && b < n && g[a][b] == 1) {
                    g[a][b] = marker;
                    area++;
                    q.add(new int[]{a, b});
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        MakingLargeIsland o = new MakingLargeIsland();

        int[][] m = new int[][]{
                {1, 0},
                {0, 1}
        };
        System.out.println(o.largestIsland(m));

        int[][] m1 = new int[][]{
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1},
        };
        System.out.println(o.largestIsland(m1));
    }
}
