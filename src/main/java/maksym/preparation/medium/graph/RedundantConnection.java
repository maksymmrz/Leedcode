package maksym.preparation.medium.graph;

import maksym.preparation.util.Util;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        var adj = new HashMap<Integer, List<Integer>>();

        for (int[] e : edges) {
            var n1 = e[0];
            var n2 = e[1];

            adj.computeIfAbsent(n1, k -> new ArrayList<>()).add(n2);
            adj.computeIfAbsent(n2, k -> new ArrayList<>()).add(n1);
        }

        var parents = new HashMap<Integer, Integer>();
        var visited = new HashSet<Integer>();
        var cycleStart = new AtomicInteger(-1);

        for (int[] e : edges) {
            var n1 = e[0];
            var n2 = e[1];

            if (dfs(n1, n2, adj, visited, parents, cycleStart)) {
                break;
            }
        }

        var cycleNodes = new HashSet<Integer>();
        var curr = cycleStart.get();
        do {
            cycleNodes.add(curr);
            curr = parents.get(curr);
        } while (curr != cycleStart.get());

        for (int i = edges.length - 1; i >= 0; i--) {
            var n1 = edges[i][0];
            var n2 = edges[i][1];

            if (cycleNodes.contains(n1) && cycleNodes.contains(n2)) {
                return edges[i];
            }
        }


        return new int[]{-1, -1};
    }

    private boolean dfs(
            int curr,
            int prev,
            Map<Integer, List<Integer>> adj,
            Set<Integer> visited,
            Map<Integer, Integer> parents,
            AtomicInteger cycleStart
    ) {
        visited.add(curr);

        for (int next : adj.getOrDefault(curr, Collections.emptyList())) {
            if (!visited.contains(next)) {
                parents.put(next, curr);
                if (dfs(next, curr, adj, visited, parents, cycleStart)) {
                    return true;
                }
            } else if (next != prev) {
                cycleStart.set(next);
                parents.put(next, curr);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        var o = new RedundantConnection();
        var g = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        Util.show(o.findRedundantConnection(g));
    }
}
