package maksym.preparation.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        final int m = grid.length;
        final int n = m > 0 ? grid[0].length : -1;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;

        if (n > 0 && grid[0][0] == 0) {
            queue.add(new int[]{0, 0});
            visited[0][0] = true;
        }

        while (!queue.isEmpty()) {
            count++;
            if (visited[m - 1][n - 1]) queue.clear();
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] point = queue.poll();
                int i = point[0];
                int j = point[1];

                addPoint(grid, visited, queue, i - 1, j - 1);
                addPoint(grid, visited, queue, i, j - 1);
                addPoint(grid, visited, queue, i + 1, j - 1);
                addPoint(grid, visited, queue, i + 1, j);
                addPoint(grid, visited, queue, i + 1, j + 1);
                addPoint(grid, visited, queue, i, j + 1);
                addPoint(grid, visited, queue, i - 1, j + 1);
                addPoint(grid, visited, queue, i - 1, j);
            }
        }

        return visited[m - 1][n - 1] ? count : -1;
    }

    public void addPoint(int[][] grid, boolean[][] visited, Queue<int[]> queue, int i, int j) {
        final int m = grid.length;
        final int n = grid[0].length;

        if (i < m && j < n && i >= 0 && j >= 0 && !visited[i][j] && grid[i][j] == 0) {
            queue.add(new int[]{i, j});
            visited[i][j] = true;
        }
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix instance = new ShortestPathInBinaryMatrix();

        int[][] grid1 = new int[][]{
                {0, 0, 1, 0},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {0, 0, 0, 0}
        };

        System.out.println(instance.shortestPathBinaryMatrix(grid1));
    }
}
