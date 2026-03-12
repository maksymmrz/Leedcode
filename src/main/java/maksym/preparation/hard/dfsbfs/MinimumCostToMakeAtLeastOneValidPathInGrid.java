package maksym.preparation.hard.dfsbfs;

import java.util.Arrays;
import java.util.LinkedList;

public class MinimumCostToMakeAtLeastOneValidPathInGrid {
    private final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        final int M = grid.length;
        final int N = grid[0].length;

        var minCost = new int[M][N];
        for (int[] arr : minCost) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        minCost[0][0] = 0;

        var deque = new LinkedList<int[]>(); // [x, y, cost]
        deque.offer(new int[]{0, 0});

        while (!deque.isEmpty()) {
            var record = deque.poll();
            var i = record[0];
            var j = record[1];
            var cost = minCost[i][j];
            var greenDir = grid[i][j];

            for (int d = 1; d <= dirs.length; d++) {
                int x = i + dirs[d - 1][0];
                int y = j + dirs[d - 1][1];
                var nextCost = d == greenDir ? cost : cost + 1;

                if (x < M && x >= 0 && y < N && y >= 0 && nextCost < minCost[x][y]) {
                    minCost[x][y] = nextCost;

                    if (d == greenDir) {
                        deque.offerFirst(new int[]{x, y, nextCost});
                    } else {
                        deque.offerLast(new int[]{x, y, nextCost});
                    }
                }
            }
        }

        return minCost[M - 1][N - 1];
    }

    public static void main(String[] args) {
        var o = new MinimumCostToMakeAtLeastOneValidPathInGrid();

        var m1 = new int[][]{{2, 2, 2}, {2, 2, 2}};
        System.out.println(o.minCost(m1));

        var m2 = new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}};
        System.out.println(o.minCost(m2));
    }
}
