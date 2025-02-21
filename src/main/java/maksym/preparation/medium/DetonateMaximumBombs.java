package maksym.preparation.medium;

import java.util.*;

public class DetonateMaximumBombs {
    public int maximumDetonation(int[][] bombs) {
        final int n = bombs.length;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (isReachable(bombs, i, j)) {
                        graph.get(i).add(j);
                    }
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = dfsCount(graph, i, new boolean[n]);
            max = Math.max(num, max);
        }
        return max;
    }

    private int dfsCount(List<List<Integer>> graph, int n, boolean[] v) {
        if (v[n]) {
            return 0;
        } else {
            v[n] = true;

            int countNext = graph.get(n)
                    .stream()
                    .map(node -> dfsCount(graph, node, v))
                    .reduce(0, Integer::sum);

            return 1 + countNext;
        }
    }

    private boolean isReachable(int[][] bombs, int from, int to) {
        double x1 = bombs[from][0];
        double y1 = bombs[from][1];
        double r = bombs[from][2];

        double x2 = bombs[to][0];
        double y2 = bombs[to][1];

        double dist = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

        return dist <= r;
    }

    public static void main(String[] args) {
        DetonateMaximumBombs o = new DetonateMaximumBombs();

        System.out.println(o.maximumDetonation(new int[][]{{1, 1, 5}, {10, 10, 5}}));

        int[][] bombs = new int[][]{
                {1, 2, 3},
                {2, 3, 1},
                {3, 4, 2},
                {4, 5, 3},
                {5, 6, 4}
        };
        System.out.println(o.maximumDetonation(bombs));
    }
}
