package maksym.preparation.medium;

import maksym.preparation.util.Util;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        final int m = mat.length;
        final int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int count = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int[][] rm = new int[m][n];

        while (!q.isEmpty()) {
            int size = q.size();

            for (int c = 0; c < size; c++) {
                int[] p = q.poll();
                assert p != null;
                int i = p[0];
                int j = p[1];

                rm[i][j] = count;

                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }
            }
            count++;
        }
        return rm;
    }

    public static void main(String[] args) {
        Matrix01 o = new Matrix01();
        int[][] m = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        Util.show2d(o.updateMatrix(m));
    }
}
