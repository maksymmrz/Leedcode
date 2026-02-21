package maksym.preparation.hard.bsearch;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        final int M = grid.length;
        final int N = grid[0].length;

        var pq = new PriorityQueue<Map.Entry<Integer, int[]>>(Comparator.comparingInt(Map.Entry::getKey));
        var visited = new boolean[M][N];

        pq.add(Map.entry(grid[0][0], new int[]{0, 0}));

        var dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        var maxH = 0;

        while (!pq.isEmpty()) {
            var point = pq.poll().getValue();
            var i = point[0];
            var j = point[1];

            maxH = Math.max(grid[i][j], maxH);

            if (i == M - 1 && j == N - 1) {
                break;
            }

            for (int[] dir : dirs) {
                var x = i + dir[0];
                var y = j + dir[1];

                if (x >= 0 && x < M && y >= 0 && y < N && !visited[x][y]) {
                    pq.offer(Map.entry(grid[x][y], new int[]{x, y}));
                    visited[x][y] = true;
                }
            }
        }

        return maxH;
    }

    public static void main(String[] args) {
        var o = new SwimInRisingWater();
        var m = new int[][]{
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };
        System.out.println(o.swimInWater(m));
    }
}
