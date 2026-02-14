package maksym.preparation.medium.graph;

import maksym.preparation.util.Util;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var graph = new HashMap<Integer, List<Integer>>();

        for (int[] edge : prerequisites) {
            var n1 = edge[1];
            var n2 = edge[0];
            graph.computeIfAbsent(n1, n -> new ArrayList<>()).add(n2);
        }

        var ordered = new LinkedList<Integer>();

        var visited = new HashSet<Integer>();

        var noLoops = true;

        for (int node = 0; node < numCourses; node++) {
            noLoops &= dfs(node, graph, visited, ordered, new HashSet<>());
        }

        if (!noLoops) {
            return new int[0];
        }

        return ordered.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(
            int node,
            Map<Integer, List<Integer>> graph,
            Set<Integer> visited,
            Deque<Integer> accumulator,
            Set<Integer> branch
    ) {
        if (branch.add(node)) {
            var noLoops = true;
            if (visited.add(node)) {
                var children = graph.getOrDefault(node, Collections.emptyList());

                for (Integer child : children) {
                    noLoops &= dfs(child, graph, visited, accumulator, branch);
                }

                accumulator.push(node);
            }

            branch.remove(node);
            return noLoops;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        var o = new CourseScheduleII();

        Util.show(o.findOrder(3, new int[][]{{1, 0}, {1, 2}, {0, 1}}));
        Util.show(o.findOrder(3, new int[][]{{2, 0}, {2, 1}}));
        Util.show(o.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
        Util.show(o.findOrder(2, new int[][]{{1, 0}, {0, 1}}));
        Util.show(o.findOrder(2, new int[][]{{1, 0}}));

    }
}