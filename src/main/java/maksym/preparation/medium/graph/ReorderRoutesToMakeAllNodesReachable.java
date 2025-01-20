package maksym.preparation.medium.graph;

import java.util.*;

public class ReorderRoutesToMakeAllNodesReachable {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] conn : connections) {
            int from = conn[0];
            int to = conn[1];

            graph.get(from).add(new int[]{to, 1});
            graph.get(to).add(new int[]{from, 0});
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;

        int counter = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int[] edge : graph.get(node)) {
                int to = edge[0];
                int weight = edge[1];

                if (!visited[to]) {
                    visited[to] = true;
                    q.add(to);
                    counter += weight;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        ReorderRoutesToMakeAllNodesReachable o = new ReorderRoutesToMakeAllNodesReachable();
        int[][] cons = new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(o.minReorder(6, cons));
    }
}
