package maksym.preparation.medium.graph;

import java.util.*;

public class MinimumTimeToReachDestinationInDirGraph {
    public int minTime(int n, int[][] edges) {
        var adj = new HashMap<Integer, List<int[]>>();
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});

        for (int[] e : edges) {
            int n1 = e[0];
            int n2 = e[1];
            int from = e[2];
            int to = e[3];

            if (n1 == 0) {
                pq.offer(new int[]{n2, from + 1});
            }

            adj.computeIfAbsent(n1, k -> new ArrayList<>()).add(new int[]{n2, from, to});
        }

        var visited = new boolean[n];

        while (!pq.isEmpty()) {
            var curr = pq.poll();
            var node = curr[0];
            var time = curr[1];

            if (!visited[node]) {
                visited[node] = true;

                if (node == n - 1) {
                    return time;
                }

                for (var next : adj.getOrDefault(node, Collections.emptyList())) {
                    var nextNode = next[0];
                    var nextFrom = next[1];
                    var nextTo = next[2];

                    if (time <= nextTo) {
                        var nextTime = Math.max(time, nextFrom) + 1;
                        pq.offer(new int[]{nextNode, nextTime});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        var o = new MinimumTimeToReachDestinationInDirGraph();
        System.out.println(o.minTime(3, new int[][]{{0, 1, 0, 1}, {1, 2, 2, 5}}));
        System.out.println(o.minTime(4, new int[][]{{0, 1, 0, 3}, {1, 3, 7, 8}, {0, 2, 1, 5}, {2, 3, 4, 7}}));
    }
}
