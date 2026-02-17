package maksym.preparation.medium.graph;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var adj = new HashMap<Integer, List<Integer>>();
        var indegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            var from = edge[1];
            var to = edge[0];
            adj.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            indegree[to]++;
        }

        var q = new LinkedList<Integer>();

        for (int n = 0; n < numCourses; n++) {
            if (indegree[n] == 0) {
                q.add(n);
            }
        }

        var orderedCount = 0;

        while (!q.isEmpty()) {
            orderedCount++;

            var n = q.poll();
            var descendants = adj.getOrDefault(n, Collections.emptyList());

            for (var descendant : descendants) {
                indegree[descendant]--;

                if (indegree[descendant] == 0) {
                    q.add(descendant);
                }
            }
        }

        return orderedCount == numCourses;
    }

    public static void main(String[] args) {
        final var o = new CourseSchedule();
        System.out.println(o.canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}}));
        System.out.println(o.canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}, {1, 3}}));
    }
}
