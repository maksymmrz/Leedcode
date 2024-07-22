package maksym.preparation.medium;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    removeIsland(grid, i, j);
                }
            }
        }
        return islands;
    }

    public void removeIsland(char[][] grid, int i, int j) {
        final int m = grid.length;
        final int n = grid[0].length;

        if (i < m && j < n && i >= 0 && j >= 0 && grid[i][j] == '1') {
            grid[i][j] = '0';
            removeIsland(grid, i - 1, j);
            removeIsland(grid, i + 1, j);
            removeIsland(grid, i, j - 1);
            removeIsland(grid, i, j + 1);
        }
    }

    public void removeIslandBFS(char[][] grid, int i, int j) {
        final int m = grid.length;
        final int n = grid[0].length;

        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(Map.entry(i, j));

        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> point = queue.poll();
            int x = point.getKey();
            int y = point.getValue();
            grid[x][y] = '0';

            x = point.getKey() + 1;
            if (x < m && grid[x][y] == '1') {
                queue.offer(Map.entry(x, y));
                grid[x][y] = '0';
            }

            x = point.getKey() - 1;
            if (x >= 0 && grid[x][y] == '1') {
                queue.offer(Map.entry(x, y));
                grid[x][y] = '0';
            }

            x = point.getKey();
            y = point.getValue() + 1;
            if (y < n && grid[x][y] == '1') {
                queue.offer(Map.entry(x, y));
                grid[x][y] = '0';
            }

            y = point.getValue() - 1;
            if (y >= 0 && grid[x][y] == '1') {
                queue.offer(Map.entry(x, y));
                grid[x][y] = '0';
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslands instance = new NumberOfIslands();

        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(instance.numIslands(grid));

    }
}
