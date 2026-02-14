package maksym.preparation.medium.graph;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var edges = new HashMap<Integer, List<Integer>>();

        for (int[] edge : prerequisites) {
            final var start = edge[1];
            final var end = edge[0];
            edges.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
        }

        var visited = new boolean[numCourses];

        for (int node = 0; node < numCourses; node++) {
            var noLoop = detectLoop(node, edges, visited, new boolean[numCourses]);

            if (!noLoop) {
                return false;
            }
        }
        return true;
    }

    private boolean detectLoop(int node, HashMap<Integer, List<Integer>> edges, boolean[] visited, boolean[] branchVisited) {
        if (branchVisited[node]) {
            return false;
        }
        if (visited[node]) {
            return true;
        }

        visited[node] = true;
        branchVisited[node] = true;

        var refs = edges.getOrDefault(node, Collections.emptyList());
        for (var next : refs) {
            var noLoop = detectLoop(next, edges, visited, branchVisited);

            if (!noLoop) {
                return false;
            }
        }

        branchVisited[node] = false;

        return true;
    }

    public static void main(String[] args) {
        final var o = new CourseSchedule();
        System.out.println(o.canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}}));
        System.out.println(o.canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}, {1, 3}}));
    }
}
