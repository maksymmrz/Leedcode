package maksym.preparation.medium.graph;

import maksym.preparation.util.Util;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        final int m = rooms.length;
        final int n = rooms[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                    v[i][j] = true;
                }

        int dist = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int c = 0; c < size; c++) {
                int[] p = q.poll();
                assert p != null;
                int i = p[0];
                int j = p[1];

                rooms[i][j] = dist;

                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x >= 0 && y >= 0 && x < m && y < n && !v[x][y] && rooms[x][y] > 0) {
                        q.add(new int[]{x, y});
                        v[x][y] = true;
                    }
                }
            }
            dist++;
        }
    }

    public static void main(String[] args) {
        WallsAndGates o = new WallsAndGates();
        int[][] m = new int[][]{
                {9, -1, 0, 9},
                {9, 9, 9, -1},
                {9, -1, 9, -1},
                {0, -1, 9, 9}
        };
        o.wallsAndGates(m);
        Util.show2d(m);
    }
}
